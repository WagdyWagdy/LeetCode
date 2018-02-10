import java.util.Arrays;
import java.util.HashSet;

public class LC_378 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest(matrix, 8));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		int[] a = new int[matrix.length * matrix.length];
		int x = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				a[x] = matrix[i][j];
				x++;
			}
		}
		Arrays.sort(a);
		return a[k-1];
}}
