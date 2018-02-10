import java.util.ArrayList;
import java.util.List;

public class LC_336 {

	public static void main(String[] args) {
		String[] input = { "ab","ba","abc","cba" };
		List<List<Integer>> result = palindromePairs(input);
		for (int i = 0; i < result.size(); i++) {
			System.out.println("[" + result.get(i).get(0) + " , " + result.get(i).get(1) + "]");
		}
	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		StringBuilder concatString = new StringBuilder();
		List<Integer> pair;
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				concatString = new StringBuilder();
				concatString.append(words[i]);
				concatString.append(words[j]);
				if (isPalindrome(concatString.toString())) {
					pair = new ArrayList<Integer>();
					pair.add(i);
					pair.add(j);
					result.add(pair);
					if (words[i].length() == words[j].length() || words[i].length() == 0 || words[j].length() == 0) {
						pair = new ArrayList<Integer>();
						pair.add(j);
						pair.add(i);
						result.add(pair);
						continue;
					}

				}
				concatString = new StringBuilder();
				concatString.append(words[j]);
				concatString.append(words[i]);
				if (isPalindrome(concatString.toString())) {
					pair = new ArrayList<Integer>();
					pair.add(j);
					pair.add(i);
					result.add(pair);
				}
			}
		}
		return result;
	}

	public static boolean isPalindrome(String word) {
		int i = 0;
		int j = word.length() - 1;
		while (j > i) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			++i;
			--j;
		}
		return true;
	}
}
