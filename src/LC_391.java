import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public final class LC_391 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
		System.out.println(isRectangleCover(input));
	}

	public static boolean isRectangleCover(int[][] rectangles) {
		sortRectangles(rectangles);
		HashSet<Point> pointMap = new HashSet<Point>();
		int min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE, max_x = Integer.MIN_VALUE, max_y = Integer.MIN_VALUE;
		int area = 0;
		int i = 0;
		min_x = Math.min(min_x, rectangles[i][0]);
		min_y = Math.min(min_y, rectangles[i][1]);
		max_x = Math.max(max_x, rectangles[i][2]);
		max_y = Math.max(max_y, rectangles[i][3]);
		area += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
		Point p00, p01, p10, p11;
		p00 = new Point(rectangles[i][0], rectangles[i][1]);
		p01 = new Point(rectangles[i][0], rectangles[i][3]);
		p10 = new Point(rectangles[i][2], rectangles[i][1]);
		p11 = new Point(rectangles[i][2], rectangles[i][3]);
		pointMap.add(p00);
		pointMap.add(p10);
		pointMap.add(p01);
		pointMap.add(p11);
		for (i = 1; i < rectangles.length; i++) {
			min_x = Math.min(min_x, rectangles[i][0]);
			min_y = Math.min(min_y, rectangles[i][1]);
			max_x = Math.max(max_x, rectangles[i][2]);
			max_y = Math.max(max_y, rectangles[i][3]);
			area += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
			p00 = new Point(rectangles[i][0], rectangles[i][1]);
			p01 = new Point(rectangles[i][0], rectangles[i][3]);
			p10 = new Point(rectangles[i][2], rectangles[i][1]);
			p11 = new Point(rectangles[i][2], rectangles[i][3]);

			if (!pointMap.contains(p00))
				return false;
			pointMap.remove(p00);

			if (pointMap.contains(p01))
				pointMap.remove(p01);
			else
				pointMap.add(p01);

			if (pointMap.contains(p10))
				pointMap.remove(p10);
			else
				pointMap.add(p10);

			if (pointMap.contains(p11))
				pointMap.remove(p11);
			else
				pointMap.add(p11);
		}
		int bigArea = (max_x - min_x) * (max_y - min_y);
		return pointMap.size() == 4 && area == bigArea;
	}

	private static void sortRectangles(int[][] rectangles) {
		Arrays.sort(rectangles, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[0]!= b[0])
					return Integer.compare(a[0], b[0]);
				return Integer.compare(a[1], b[1]);
			}
		});

	}
}
