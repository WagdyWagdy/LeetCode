
public class LC_395 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "ac";
		System.out.println(lengthOfLongestSubstring(input));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() < 2)
			return s.length();
		int[] letterCount = new int[128];
		int longest = 0;
		int currentCount = 0;
		int start = 0;
		letterCount[s.charAt(start)]++;
		currentCount++;
		for (int i = 1; i < s.length(); i++) {
			letterCount[s.charAt(i)]++;
			currentCount++;
			if (letterCount[s.charAt(i)] != 1) {
				longest = Math.max(longest, currentCount - 1);
				while (start < i) {
					if (s.charAt(start) == s.charAt(i)) {
						break;
					}
					letterCount[s.charAt(start)]--;
					start++;
					currentCount--;
				}
				letterCount[s.charAt(start)]--;
				start++;
				currentCount--;
			}
		}
		return Math.max(longest, currentCount);
	}
}
