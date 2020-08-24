package hdfs.datacollect;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;

public class BackupCleanTask extends TimerTask {

	@Override
	public void run() {

		SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd-HH");
		long now = new Date().getTime();
		try {
			
			Properties props = new PropertiesHolderLazy().getProp();
			// ��ȡ���ر���Ŀ¼
			File backupBaseDir = new File(props.getProperty(Constants.LOG_BACKUP_BASE_DIR));
			File[] dayBackDir = backupBaseDir.listFiles();
		

			// �жϱ���Ŀ¼��Ŀ¼�Ƿ��ѳ�24Сʱ
			for (File dir : dayBackDir) {
				long time = sdr.parse(dir.getName()).getTime();
				if (now - time > 60 * 60 * 1000L) {
					FileUtils.deleteDirectory(dir);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
