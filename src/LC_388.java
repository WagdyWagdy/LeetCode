import java.util.ArrayList;

public class LC_388 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "a.txt";
		String[] files = input.split("\n");
		ArrayList<Integer> levelsCount = new ArrayList<Integer>();
		int max = 0;
		for (int i = 0; i < files.length; i++) {
			int level = getLevel(files[i]);
			if (files[i].contains(".")) {
				int sum = getSize(files[i]);
				for (int j = 0; j < level; j++) {
					sum += levelsCount.get(j);
				}
				max = Math.max(max, sum + level);
			} else {
				levelsCount.add(level, getSize(files[i]));
			}
		}
		System.out.println(max);
	}

	public static int getSize(String s) {
		return s.length() - s.lastIndexOf('\t') - 1;
	}

	public static int getLevel(String s) {
		return s.lastIndexOf('\t') + 1;
	}
}
