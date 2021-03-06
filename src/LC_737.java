import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LC_737 {

	public static void main(String[] args) {
		String[] words1 = { "1", "2", "3", "4", "5", "6", "7", "8", "1", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "2", "18", "19", "20", "21", "22", "23", "24", "22", "25", "12", "11", "26", "17", "27", "28",
				"29", "30", "31", "3", "32", "2", "33", "8", "8", "34", "35", "36", "37", "38", "39", "18", "28", "40",
				"25", "41", "42", "7", "5", "43", "44", "12", "45", "46", "36", "40", "47", "3", "19", "24", "2", "38",
				"48", "15", "49", "50", "51", "18", "52", "53", "54", "55", "56", "57", "42", "20", "12", "24", "26",
				"47", "15", "8", "1", "58", "36", "2", "45", "59", "30", "9", "12", "12" };
		String[] words2 = { "1", "2", "3", "4", "11", "30", "60", "61", "46", "9", "62", "5", "12", "13", "2", "15",
				"16", "63", "2", "18", "64", "65", "53", "29", "13", "66", "22", "55", "12", "5", "42", "31", "34",
				"28", "32", "30", "50", "67", "22", "2", "34", "61", "61", "34", "68", "40", "37", "69", "23", "18",
				"28", "40", "70", "66", "42", "7", "54", "71", "44", "12", "45", "1", "40", "40", "47", "67", "72",
				"41", "2", "73", "74", "44", "49", "31", "57", "75", "52", "53", "5", "70", "56", "30", "76", "20",
				"12", "66", "26", "47", "36", "8", "1", "58", "15", "2", "56", "77", "6", "9", "12", "12" };
		String[][] pairs = { { "61", "61" }, { "8", "8" }, { "8", "8" }, { "61", "61" }, { "72", "72" }, { "65", "65" },
				{ "19", "19" }, { "64", "64" }, { "20", "20" }, { "72", "72" }, { "19", "72" }, { "65", "72" },
				{ "64", "64" }, { "20", "64" }, { "53", "53" }, { "78", "78" }, { "49", "49" }, { "21", "53" },
				{ "78", "78" }, { "49", "78" }, { "53", "53" }, { "21", "53" }, { "46", "79" }, { "1", "1" },
				{ "46", "46" }, { "79", "46" }, { "1", "1" }, { "70", "70" }, { "55", "80" }, { "80", "81" },
				{ "25", "70" }, { "81", "81" }, { "80", "81" }, { "55", "81" }, { "70", "70" }, { "25", "70" },
				{ "43", "29" }, { "22", "71" }, { "29", "32" }, { "43", "43" }, { "32", "43" }, { "29", "43" },
				{ "71", "71" }, { "22", "71" }, { "82", "82" }, { "83", "83" }, { "76", "76" }, { "42", "42" },
				{ "42", "26" }, { "26", "26" }, { "76", "26" }, { "42", "26" }, { "82", "82" }, { "83", "82" },
				{ "5", "5" }, { "11", "11" }, { "54", "5" }, { "5", "5" }, { "54", "5" }, { "11", "11" },
				{ "35", "84" }, { "68", "68" }, { "59", "59" }, { "68", "77" }, { "77", "77" }, { "68", "77" },
				{ "59", "77" }, { "84", "84" }, { "35", "84" }, { "44", "15" }, { "40", "36" }, { "15", "15" },
				{ "44", "15" }, { "36", "36" }, { "40", "36" }, { "63", "85" }, { "50", "50" }, { "86", "85" },
				{ "31", "31" }, { "17", "17" }, { "50", "17" }, { "17", "17" }, { "31", "17" }, { "63", "63" },
				{ "85", "63" }, { "86", "63" }, { "10", "87" }, { "88", "10" }, { "89", "89" }, { "58", "58" },
				{ "62", "90" }, { "90", "91" }, { "10", "88" }, { "88", "88" }, { "87", "88" }, { "58", "88" },
				{ "62", "90" }, { "90", "90" }, { "91", "90" }, { "89", "90" }, { "4", "4" }, { "92", "92" },
				{ "93", "93" }, { "4", "4" }, { "92", "4" }, { "93", "93" }, { "23", "23" }, { "13", "23" },
				{ "39", "94" }, { "39", "39" }, { "94", "39" }, { "23", "23" }, { "13", "23" }, { "69", "69" },
				{ "73", "69" }, { "95", "69" }, { "74", "74" }, { "38", "48" }, { "69", "73" }, { "73", "73" },
				{ "95", "73" }, { "38", "38" }, { "74", "38" }, { "48", "38" }, { "45", "45" }, { "56", "56" },
				{ "56", "56" }, { "45", "45" }, { "14", "14" }, { "2", "2" }, { "14", "14" }, { "2", "2" },
				{ "96", "96" }, { "96", "67" }, { "97", "97" }, { "3", "3" }, { "67", "67" }, { "96", "67" },
				{ "97", "97" }, { "3", "97" }, { "98", "98" }, { "16", "16" }, { "99", "99" }, { "98", "98" },
				{ "16", "98" }, { "99", "99" }, { "28", "28" }, { "60", "60" }, { "7", "7" }, { "7", "7" },
				{ "60", "7" }, { "28", "28" }, { "18", "18" }, { "75", "75" }, { "52", "18" }, { "18", "18" },
				{ "52", "18" }, { "75", "75" }, { "37", "37" }, { "47", "37" }, { "9", "9" }, { "37", "37" },
				{ "47", "37" }, { "9", "9" }, { "6", "30" }, { "57", "57" }, { "51", "51" }, { "51", "51" },
				{ "57", "51" }, { "30", "30" }, { "6", "30" }, { "41", "41" }, { "24", "24" }, { "41", "66" },
				{ "41", "41" }, { "66", "41" }, { "24", "24" }, { "34", "34" }, { "100", "100" }, { "27", "27" },
				{ "33", "33" }, { "100", "100" }, { "34", "100" }, { "27", "27" }, { "33", "27" }, { "61", "8" },
				{ "20", "65" }, { "53", "49" }, { "79", "1" }, { "25", "55" }, { "43", "22" }, { "82", "42" },
				{ "5", "11" }, { "77", "35" }, { "40", "44" }, { "50", "86" }, { "87", "89" }, { "93", "92" },
				{ "39", "13" }, { "95", "48" }, { "56", "45" }, { "14", "2" }, { "97", "96" }, { "98", "99" },
				{ "28", "60" }, { "75", "52" }, { "37", "9" }, { "51", "6" }, { "24", "66" }, { "33", "34" } };
		System.out.println(areSentencesSimilarTwo(words1, words2, pairs));
	}

	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;
		ArrayList<HashSet<String>> setArray = new ArrayList<HashSet<String>>();
		HashMap<String, Integer> pairWordMap = new HashMap<String, Integer>();
		for (int i = 0; i < pairs.length; i++) {
			System.out.println(pairs[i][0] + " , " + pairs[i][1]);
			if (!pairWordMap.containsKey(pairs[i][0]) && !pairWordMap.containsKey(pairs[i][1])) {
				HashSet<String> temp = new HashSet<String>();
				temp.add(pairs[i][0]);
				temp.add(pairs[i][1]);
				setArray.add(temp);
				pairWordMap.put(pairs[i][0], setArray.size() - 1);
				pairWordMap.put(pairs[i][1], setArray.size() - 1);
			} else if (pairWordMap.containsKey(pairs[i][0]) && pairWordMap.containsKey(pairs[i][1])) {
				int p1Set = pairWordMap.get(pairs[i][0]);
				int p2Set = pairWordMap.get(pairs[i][1]);
				for(int j = 0; j < setArray.get(p2Set).size(); j++) {
					String word = (String) setArray.get(p2Set).toArray()[j];
					pairWordMap.remove(word);
					pairWordMap.put(word, p1Set);
					setArray.get(p1Set).add(word);
				}
			} else if (pairWordMap.containsKey(pairs[i][0]) && !pairWordMap.containsKey(pairs[i][1])) {
				setArray.get(pairWordMap.get(pairs[i][0])).add(pairs[i][1]);
				pairWordMap.put(pairs[i][1], pairWordMap.get(pairs[i][0]));
			} else if (!pairWordMap.containsKey(pairs[i][0]) && pairWordMap.containsKey(pairs[i][1])) {
				setArray.get(pairWordMap.get(pairs[i][1])).add(pairs[i][0]);
				pairWordMap.put(pairs[i][0], pairWordMap.get(pairs[i][1]));
			}
		}
		for (int i = 0; i < setArray.size(); i++) {
			for (int j = 0; j < setArray.get(i).size(); j++) {
				System.out.print(setArray.get(i).toArray()[j] + " , ");
			}
			System.out.println("");
		}
		for (int i = 0; i < words1.length; i++) {
			System.out.println(words1[i] + " , " + words2[i]);
			if (words1[i].equals(words2[i]))
				continue;
			if (!(pairWordMap.containsKey(words1[i]) && pairWordMap.containsKey(words2[i]))) {
				return false;
			}
			if (!setArray.get(pairWordMap.get(words1[i])).contains(words2[i]))
				return false;
		}
		return true;
	}
}
