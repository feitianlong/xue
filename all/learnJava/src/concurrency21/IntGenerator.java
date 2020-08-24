package concurrency21;

public abstract class IntGenerator {
	private volatile boolean canceled = false;

	// 这里不实现Generator接口的原因是：泛型不支持基本类型的参数，而这里它必须产生一个int
	public abstract int next();
	
	public void cancel() {
		canceled = true;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
}
