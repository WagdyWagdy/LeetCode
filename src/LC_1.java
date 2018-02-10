import java.util.Arrays;

public class LC_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 3, 2, 4 };
		input = twoSum(input, 6);
		System.out.println(input[0] + " , " + input[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] sortedNums = nums.clone();
		Arrays.sort(sortedNums);
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			if (sortedNums[i] + sortedNums[j] == target) {
				break;
			}
			if (sortedNums[i] + sortedNums[j] > target)
				j--;
			else
				i++;
		}
		int[] result = new int[2];
		int k = 0;
		int a = 0;
		while (k < nums.length && a < 2) {
			if (nums[k] == sortedNums[i] || nums[k] == sortedNums[j]) {
				result[a] = k;
				a++;
			}
			k++;
		}
		return result;
	}
}
