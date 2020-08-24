package codingInterviews;

/*0. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 * 
 */
public class Coding66 {

	// 主要采用对称遍历的思想，
	// 把B[i]{i=0,...,n-1}的组合看成一个矩阵，对角线为1
	// B[i]看成A[0]+A[1]+...+A[i-1]和A[i+1]+..+A[n-1]的乘积，
	// C[i] = A[0]+A[1]+...+A[i-1]可以通过从上向下计算(从小到大)，即C[i] = C [i-1] * A[i-1]
	// D[i] = A[i+1]+..+A[n-1] 可以通过从上向上计算(从大到小)，即D[i] = D[i+1] * A[i+1]
	// 最终的结果B[i] = C[i] * D[i]

	public void multiply(int[] A, int[] B) {

		if (A.length != B.length && A.length <= 0) {
			B = new int[] { 0 };
		}

		// 先计算下三角部分,使用B[i]直接计算
		B[0] = 1;
		for (int i = 1; i < B.length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		// 再计算上三角部分，使用tmp作为遍历上一阶段值的记录
		int tmp = 1;
		for (int i = B.length - 2; i >= 0; i--) {
			tmp = tmp * A[i + 1];
			B[i] = tmp * B[i];
		}

	}

}
