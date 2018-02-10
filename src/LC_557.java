
public class LC_557 {

	public static void main(String[] args) {
		System.out.println(reverseWords("let's go shit the pants"));

	}

	public static String reverseWords(String s) {
		String[] words = s.split(" ");
		char[] resultArray = new char[s.length()];
		int charIndex = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				resultArray[charIndex] = words[i].charAt(words[i].length() - j - 1);
				charIndex++;
			}
			if (i != words.length - 1) {
				resultArray[charIndex] = ' ';
				charIndex++;
			}
		}
		return new String(resultArray);
	}
}
