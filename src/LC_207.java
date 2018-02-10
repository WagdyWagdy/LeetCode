import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC_207 {

	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}};
		System.out.println(canFinish(2, prerequisites));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		int[] dependencies = new int[numCourses];
		for(int i = 0; i < prerequisites.length; i++)
		{
			matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
			dependencies[prerequisites[i][0]]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < dependencies.length; i++) {
			if(dependencies[i] == 0)
				q.add(i);
		}
		int coursesTaken = 0;
		while(!q.isEmpty()){
			int course = q.poll();
			coursesTaken++;
			for (int i = 0; i < matrix.length; i++) {
				if(matrix[course][i] == 1){
					if(--dependencies[i] == 0)
						q.add(i);
				}
			}
		}
		return coursesTaken == numCourses;
	}
}
