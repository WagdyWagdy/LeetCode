import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_554 {

	public static void main(String[] args) {
		
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean xam = true;
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		List<Integer> row = new ArrayList<Integer>();
		int[] rowArray = { 1, 2, 2, 1 };
		for (int i = 0; i < rowArray.length; i++) {
			row.add(rowArray[i]);
		}
		wall.add(row);
		row = new ArrayList<Integer>();
		rowArray = new int[] { 3, 1, 2 };
		for (int i = 0; i < rowArray.length; i++) {
			row.add(rowArray[i]);
		}
		wall.add(row);
		row = new ArrayList<Integer>();
		rowArray = new int[] { 1, 3, 2 };
		for (int i = 0; i < rowArray.length; i++) {
			row.add(rowArray[i]);
		}
		wall.add(row);
		row = new ArrayList<Integer>();
		rowArray = new int[] { 2, 4 };
		for (int i = 0; i < rowArray.length; i++) {
			row.add(rowArray[i]);
		}
		wall.add(row);
		row = new ArrayList<Integer>();
		rowArray = new int[] { 3, 1, 2 };
		for (int i = 0; i < rowArray.length; i++) {
			row.add(rowArray[i]);
		}
		wall.add(row);
		row = new ArrayList<Integer>();
		rowArray = new int[] { 1, 3, 1, 1 };
		for (int i = 0; i < rowArray.length; i++) {
			row.add(rowArray[i]);
		}
		wall.add(row);
		System.out.println(leastBricks(wall));
	}

	public static int leastBricks(List<List<Integer>> wall) {
		HashMap<Integer, Integer> wallMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < wall.size(); i++) {
			int edge = 0;
			for (int j = 0; j < wall.get(i).size() - 1; j++) {
				edge += wall.get(i).get(j);
				if (wallMap.containsKey(edge)) {
					wallMap.put(edge, wallMap.get(edge) + 1);
				} else {
					wallMap.put(edge, 1);
				}
			}
		}
		if (wallMap.size() == 0)
			return wall.size();
		Map.Entry<Integer, Integer> maxEntry = null;

		for (Map.Entry<Integer, Integer> entry : wallMap.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
		return wall.size() - maxEntry.getValue();
	}
}
