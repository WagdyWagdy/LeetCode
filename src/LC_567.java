import java.util.Arrays;

public class LC_567 {

	public static void main(String[] args) {
		String s1 = "dc";
		String s2 = "abcde";
		System.out.println(checkInclusion(s1, s2));
	}
	public static boolean checkInclusion(String s1, String s2) {
        int k = s2.length() - s1.length() + 1;
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
		for(int i = 0; i < k; i++){
        	int start = i;
        	int end = start + s1.length();
        	char [] temp = s2.substring(start, end).toCharArray();
        	Arrays.sort(temp);
        	if(String.valueOf(temp).equals(String.valueOf(c1)))
        		return true;
        }
		return false;
    }
}
