
public class LC_383 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canConstruct("aa", "ab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] lettersInMag = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			lettersInMag[(int) (magazine.charAt(i) - 97)]++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (lettersInMag[(int) (ransomNote.charAt(i) - 97)] == 0)
				return false;
			lettersInMag[(int) (ransomNote.charAt(i) - 97)]--;
		}
		return true;
	}
}
