
public class LC_2 {

	public static void main(String[] args) {
		int[] n1 = { 1, 8 };
		int[] n2 = { 0 };
		ListNode l1 = null;
		ListNode l2 = null;
		ListNode lastNode = null;
		for (int i = 0; i < n1.length; i++) {
			if (l1 == null) {
				l1 = new ListNode(n1[i]);
				lastNode = l1;
			} else {
				lastNode.next = new ListNode(n1[i]);
				lastNode = lastNode.next;
			}
		}
		for (int i = 0; i < n2.length; i++) {
			if (l2 == null) {
				l2 = new ListNode(n2[i]);
				lastNode = l2;
			} else {
				lastNode.next = new ListNode(n2[i]);
				lastNode = lastNode.next;
			}
		}
		ListNode ans = addTwoNumbers(l1, l2);
		while (true) {
			if (ans == null)
				break;
			System.out.print(ans.val);
			ans = ans.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		int carry = 0;
		ListNode ans = null;
		ListNode temp = null;
		ListNode lastNode = null;
		while (l1 != null || l2 != null) {
			sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
			carry = 0;
			if (sum >= 10) {
				sum = sum - 10;
				carry = 1;
			}
			temp = new ListNode(sum);
			if (ans == null) {
				ans = temp;
				lastNode = ans;
			} else {
				lastNode.next = temp;
				lastNode = lastNode.next;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		return ans;
	}
}
