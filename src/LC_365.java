import java.util.HashSet;

public class LC_365 {

	public static void main(String[] args) {
		int x = 34;
		int y = 5;
		int z = 6;
		System.out.println(canMeasureWater(x, y, z));

	}

	public static boolean canMeasureWater(int x, int y, int z) {
		if (z > x + y)
			return false;
		if (x == 0)
		    return z == y;
		if (y == 0)
		    return z == x;  
		int Y = Math.max(y, x);
		int X = Math.min(y, x);
		int mult = (int)(Y*1.0 / X*1.0);
		HashSet<Integer> map = new HashSet<Integer>();
		map.add(X);
		map.add(Y);
		map.add(X + Y);
		map.add(Y - X);
		map.add(2 * Y - 2 * X);
		map.add(2 * Y - X);
		map.add(2 * Y - 3 * X);
		map.add(3 * Y - 3 * X);
		for (int i = 1; i <= mult; i++) {
			if (i * X < Y) {
				map.add(i * X);
				map.add(i * X + X);
			}
			if(Y - i*X > 0)
			{
				map.add(Y - i*X);
				map.add(2*Y - i*X);
			}
		}
		if(map.contains(z))
			return true;
		return false;
	}
}
