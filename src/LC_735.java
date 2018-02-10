import java.util.Stack;

public class LC_735 {

	public static void main(String[] args) {
		int [] ass = {-2,-2,1,-2};
		int [] res = asteroidCollision(ass);
		System.out.print("[");
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " , ");
		}
		System.out.print("]");
	}

	public static int[] asteroidCollision(int[] asteroids) {
		
		if (asteroids.length == 0)
			return asteroids;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < asteroids.length; i++) {
			if (stack.isEmpty())
				stack.push(asteroids[i]);
			else {
				if (stack.peek() > 0 && asteroids[i] < 0) {
					boolean collision = true;
					while (collision) {
						if(stack.peek() * asteroids[i] > 0) {
							stack.push(asteroids[i]);
							collision = false;
						}
						else if (stack.peek() > asteroids[i] * -1)
							collision = false;
						else if (stack.peek() < asteroids[i] * -1) {
							stack.pop();
							if (stack.isEmpty()) {
								stack.push(asteroids[i]);
								collision = false;
							}
						} else {
							stack.pop();
							collision = false;
						}
					}
				}else
					stack.push(asteroids[i]);
			}
		}
		if (stack.isEmpty())
			return new int[0];
		int[] a = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			a[i] = stack.pop();
		}
		return a;
	}
}
