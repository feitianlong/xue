package datacollect;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimerTask;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CollectTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/**
		 * 启动一个定时任务： ——定时探测日志源目录 ——获取需要采集的文件 ——移动这些文件到一个待上传临时目录
		 * ——遍历待上传目录中各文件，逐一传输到HDFS的目标路径，同时将传输完成的文件移动到备份目录
		 */

		// 构造一个log4j日志对象
		Logger logger = Logger.getLogger("logRollingFile");

		// 获取本次采集文件数据的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-HH");
		String day = sdf.format(new Date());

		File srcDir = new File("d:/pics2/logs/accesslog");
		// 列出日志源目录中需要采集的文件,并过滤获取符合规定的文件
		File[] listFiles = srcDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if (name.startsWith("access.log")) {
					return true;
				}
				return false;
			}
		});

		// 记录日志
		logger.info("探测到如下文件信息需要采集：" + Arrays.toString(listFiles));

		try {
			// 将要采集的文件移动到待上传临时目录
			File toUploadDir = new File("d:/pics2/logs/toUpload/");
			for (File file : listFiles) {
				FileUtils.moveFileToDirectory(file, toUploadDir, true);

			}

			// 记录日志
			logger.info("文件信息被上传到如下目录：" + toUploadDir.getAbsolutePath());

			// 构造一个HDFS的客户端对象

			FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:50070"), new Configuration(), "root");
			File[] toUploadFiles = toUploadDir.listFiles();

			// 检查中HDFS的日期目录是否存在，如果不存在，则创建目录
			Path hdfsDesPath = new Path("/log/" + day);
			if (!fs.exists(hdfsDesPath)) {
				fs.mkdirs(hdfsDesPath);
			}

			// 检查本地的备份目录是否存在，如果不存在，则创建
			File backupDir = new File("d:/pics2/logs/backup" + day + "/");
			// 获取本地的备份目录是否存在,util
			if (!backupDir.exists()) {
				backupDir.mkdirs();
			}

			for (File file : toUploadFiles) {

				// 传输文件到hdfs 并改名access_log\
				Path desPath = new Path(hdfsDesPath + "/access_log_" + UUID.randomUUID() + ".log");
				fs.copyFromLocalFile(new Path(file.getAbsolutePath()), desPath);

				// 记录日志
				logger.info("文件信息被上传到了hdfs完成：" + file.getAbsolutePath() + desPath);

				// 把文件传到备份目录
				FileUtils.moveFileToDirectory(file, backupDir, true);

				// 记录日志
				logger.info("文件信息被备份完成：" + file.getAbsolutePath() + "--->" + backupDir);

			}
		} catch (IOException | InterruptedException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
