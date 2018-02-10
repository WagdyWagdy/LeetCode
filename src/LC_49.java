import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class LC_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(input);
		List<List<String>> list = new ArrayList<List<String>>();
		Collections.sort(result,new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				
				return o1.get(0).compareTo(o2.get(0));
			}
		});
		System.out.println(result.size());
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			String sortedStr = new String(charArray);
			if(map.containsKey(sortedStr))
			{
				result.get(map.get(sortedStr)).add(strs[i]);
			}else{
				List list = new ArrayList<String>();
				list.add(strs[i]);
				result.add(list);
				map.put(sortedStr, result.size()-1);
			}
		}
		return result;
	}
}
