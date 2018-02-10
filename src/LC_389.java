import java.util.Arrays;
import java.util.HashSet;

public class LC_389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getch("abcd","bceda"));
	}
	public static char getch(String s, String t){
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		Arrays.sort(ss);
		Arrays.sort(tt);
		
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]!=tt[i])
				return tt[i];
		}
		return tt[tt.length-1];
	}

}
