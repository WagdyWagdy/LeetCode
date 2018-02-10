import java.util.TreeSet;

public class LC_363 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{5,-4,3},{-3, -4, 4},{5, 1, 5}};
		System.out.println(maxSumSubmatrix(matrix, 10));
	}

	public static int maxSumSubmatrix(int[][] matrix, int k) {
		int result = Integer.MIN_VALUE;
		int m = matrix.length, n = 0;
        if (m > 0) n = matrix[0].length;
        if (m * n == 0) return 0;
        
        int M = Math.max(m, n);
        int N = Math.min(m, n);
        
        int ans = Integer.MIN_VALUE;
        for (int x = 0; x < N; x++) {
            int sums[] = new int[M];
            for (int y = x; y < N; y++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                int num = 0;
                for (int z = 0; z < M; z++) {
                    sums[z] += m > n ? matrix[z][y] : matrix[y][z];
                    num += sums[z];
                    if (num <= k) ans = Math.max(ans, num);
                    Integer i = set.ceiling(num - k);
                    if (i != null) ans = Math.max(ans, num - i);
                    set.add(num);
                }
            }
        }
        return ans;
    }

	public static int getSum(int[][] matrix, int s1, int s2, int e1, int e2) {
		int sum = 0;
		for (int i = s1; i <= e1; i++) {
			for (int j = s2; j <= e2; j++) {
				sum += matrix[i][j];
			}
		}
		return sum;
	}
}
