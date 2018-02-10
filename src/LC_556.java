import java.util.ArrayList;
import java.util.Arrays;

public class LC_556 {

	public static void main(String[] args) {
		System.out.println(nextGreaterElement(1200000));
	}

	public static int nextGreaterElement(int n) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		String s = "";
		int temp = n;
		do {
			s += temp % 10;
			temp /= 10;
		} while (temp > 0);
		s = new StringBuffer(s).reverse().toString();
		for (int i = 0; i < s.length(); i++) {
			digits.add(Integer.parseInt("" + s.charAt(i)));
		}
		int[] smallerDigits = null;
		int i;
		boolean found = false;
		loop1: for (i = digits.size() - 2; i >= 0; i--) {
			for (int j = i + 1; j < digits.size(); j++) {
				if (digits.get(j) > digits.get(i)) {
					found = true;
					smallerDigits = new int[digits.size() - i];
					for (int ii = i; ii < digits.size(); ii++) {
						smallerDigits[ii - i] = digits.get(ii);
					}
					Arrays.sort(smallerDigits);
					for (int ii = 0; ii < smallerDigits.length; ii++) {
						if (smallerDigits[ii] > digits.get(i)) {
							temp = smallerDigits[ii];
							smallerDigits[ii] = smallerDigits[0];
							smallerDigits[0] = temp;
							break loop1;
						}
					}
					
				}
			}
		}
		if (found) {
			Arrays.sort(smallerDigits,1,smallerDigits.length);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb.append(digits.get(j));
			}
			for (int j = 0; j < smallerDigits.length; j++) {
				sb.append(smallerDigits[j]);
			}
			return Long.parseLong(sb.toString()) <= Integer.MAX_VALUE ? Integer.parseInt(sb.toString()) : -1;
		} else
			return -1;
	}
}
