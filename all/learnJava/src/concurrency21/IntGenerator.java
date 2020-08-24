package concurrency21;

public abstract class IntGenerator {
	private volatile boolean canceled = false;

	// ���ﲻʵ��Generator�ӿڵ�ԭ���ǣ����Ͳ�֧�ֻ������͵Ĳ��������������������һ��int
	public abstract int next();
	
	public void cancel() {
		canceled = true;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
}
