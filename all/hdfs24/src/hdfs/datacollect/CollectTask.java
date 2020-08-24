package hdfs.datacollect;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
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
		 * ����һ����ʱ���� ������ʱ̽����־ԴĿ¼ ������ȡ��Ҫ�ɼ����ļ� �����ƶ���Щ�ļ���һ�����ϴ���ʱĿ¼
		 * �����������ϴ�Ŀ¼�и��ļ�����һ���䵽HDFS��Ŀ��·����ͬʱ��������ɵ��ļ��ƶ�������Ŀ¼
		 */
		try {
			// ����һ��log4j��־����
			Logger logger = Logger.getLogger("logRollingFile");

			Properties props = new PropertiesHolderLazy().getProp();

			// ��ȡ���βɼ��ļ����ݵ�����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
			String day = sdf.format(new Date());

			File srcDir = new File(props.getProperty(Constants.LOG_SOURCE_DIR));
			// �г���־ԴĿ¼����Ҫ�ɼ����ļ�,�����˻�ȡ���Ϲ涨���ļ�
			File[] listFiles = srcDir.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					if (name.startsWith(props.getProperty(Constants.LOG_LEGAL_PREFIX))) {
						return true;
					}
					return false;
				}
			});

			// ��¼��־
			logger.info("̽�⵽�����ļ���Ϣ��Ҫ�ɼ���" + Arrays.toString(listFiles));

			// ��Ҫ�ɼ����ļ��ƶ������ϴ���ʱĿ¼
			File toUploadDir = new File(props.getProperty(Constants.LOG_TOUPLOAD_DIR));
			for (File file : listFiles) {
				FileUtils.moveFileToDirectory(file, toUploadDir, true);

			}

			// ��¼��־
			logger.info("�ļ���Ϣ���ϴ�������Ŀ¼��" + toUploadDir.getAbsolutePath());

			// ����һ��HDFS�Ŀͻ��˶���

			FileSystem fs = FileSystem.get(new URI(props.getProperty(Constants.HDFS_URI)), new Configuration(), "root");
			File[] toUploadFiles = toUploadDir.listFiles();

			// �����HDFS������Ŀ¼�Ƿ���ڣ���������ڣ��򴴽�Ŀ¼
			Path hdfsDesPath = new Path(props.getProperty(Constants.HDFS_DEST_BASE_DIR) + day);
			if (!fs.exists(hdfsDesPath)) {
				fs.mkdirs(hdfsDesPath);
				
			}

			// ��鱾�صı���Ŀ¼�Ƿ���ڣ���������ڣ��򴴽�
			File backupDir = new File(props.getProperty(Constants.LOG_BACKUP_BASE_DIR) + day + "/");
			// ��ȡ���صı���Ŀ¼�Ƿ����,util
			if (!backupDir.exists()) {
				backupDir.mkdirs();
			}

			for (File file : toUploadFiles) {

				// �����ļ���hdfs ������access_log\
				Path desPath = new Path(hdfsDesPath + props.getProperty(Constants.HDFS_FILE_PREFIX) + UUID.randomUUID()
						+ props.getProperty(Constants.HDFS_FILE_SUFFIX));
				fs.copyFromLocalFile(new Path(file.getAbsolutePath()), desPath);

				// ��¼��־
				logger.info("�ļ���Ϣ���ϴ�����hdfs��ɣ�" + "----->" + file.getAbsolutePath() + desPath);

				// ���ļ���������Ŀ¼
				FileUtils.moveFileToDirectory(file, backupDir, true);

				// ��¼��־
				logger.info("�ļ���Ϣ��������ɣ�" + file.getAbsolutePath() + "--->" + backupDir);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
