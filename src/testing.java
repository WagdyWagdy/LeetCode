import java.util.HashSet;
import java.util.LinkedHashSet;

public class testing {

	public static void main(String[] args) {
		int a1[] = { 23, 34, 56, 78, 99 };
		int a2[] = { 11, 25, 44, 56, 111 };
		int i = 0;
		int j = 0;
		int minDiff = Integer.MAX_VALUE;
		int min1 = 0;
		int min2 = 0;
		int diff;
		while (i != a1.length-1 && j != a2.length-1) {
			if ((diff = Math.abs(a1[i] - a2[j])) < minDiff) {
				minDiff = diff;
				min1 = i;
				min2 = j;
			}
			if (minDiff == 0)
				break;
			if(a1[i] > a2[j] && j!= a2.length-1)
				j++;
			else if(a1[i] < a2[j] && i!= a1.length-1)
				i++;
		}
		System.out.println("("+a1[min1]+" , "+a2[min2]+") = "+minDiff);
	}

	public static void bolla() {
		System.out.println("bolla");
	}
}