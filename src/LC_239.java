import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class LC_239 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(maxSlidingWindow(nums, 3).toString());
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(k < 2)
			return nums;
		int numOfWindows = nums.length - k + 1;
		int [] result = new int[numOfWindows];
		int index  = 0;
		for (int i = 0; i < numOfWindows; i++) {
			int start = i;
			int end = start + k - 1;
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			for(int j = start; j <= end; j++){
				pq.add(nums[j]);
			}
			result[index] = pq.peek();
			index++;
		}
		return result;
	}
}
