
public class LC_583 {

	public static void main(String[] args) {
		System.out.println(minDistance("q", "f"));
	}
	public static int minDistance(String word1, String word2) {
		if(word1.length()*word2.length() == 0)
            return Math.max(word1.length(),word2.length());
        int[][] table = new int[word1.length()][word2.length()];
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++){
                int min;
                if(i == 0 && j == 0)
                    min = 1;
                else if(i == 0)
                    min = table[i][j - 1];
                else if(j == 0)
                    min = table[i - 1][j];
                else
                    min = Math.min(table[i][j-1],table[i-1][j]);
                if(word1.charAt(i) == word2.charAt(j))
                    table[i][j] = min  - 1;
                else
                    table[i][j] = min + 1;
            }
        }
        int ans = table[word1.length()-1][word2.length()-1];
        return ans;
    } 
}
