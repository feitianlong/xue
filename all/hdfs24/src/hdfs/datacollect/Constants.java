package hdfs.datacollect;

public class Constants {
	
	
	// 这些常量被定义到类中可以避免常用的字符串常量拼写错误
	/**
	 * 	日志源路径
	 */
	public static final String LOG_SOURCE_DIR = "LOG_SOURCE_DIR";
	/**
	 * 	待上传临时目录
	 */
	public static final String LOG_TOUPLOAD_DIR = "LOG_TOUPLOAD_DIR";
	/**
	 * 	备份目录
	 */
	public static final String LOG_BACKUP_BASE_DIR = "LOG_BACKUP_BASE_DIR";
	/**
	 * 	备份日志持续时间
	 */
	public static final String LOG_BACKUP_TIMEOUT = "LOG_BACKUP_TIMEOUT";
	/**
	 * 	日志的合法前缀
	 */
	public static final String LOG_LEGAL_PREFIX = "LOG_LEGAL_PREFIX";
	/**
	 * HDFS的链接
	 */
	public static final String HDFS_URI = "HDFS_URI";
	/**
	 * HDFS的接受目录
	 */
	public static final String HDFS_DEST_BASE_DIR = "HDFS_DEST_BASE_DIR";
	/**
	 * HDFS的文件前缀
	 */
	public static final String HDFS_FILE_PREFIX = "HDFS_FILE_PREFIX";
	/**
	 * HDFS的文件后缀
	 */
	public static final String HDFS_FILE_SUFFIX = "HDFS_FILE_SUFFIX";

}
