import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_637 {

	public static void main(String[] args) {
		//TreeNode n1 = new TreeNode(15);
		//TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(Integer.MAX_VALUE);
		TreeNode n4 = new TreeNode(Integer.MAX_VALUE);
		TreeNode n5 = new TreeNode(Integer.MAX_VALUE);

		//n3.left = n1;
		//n3.right = n2;
		n5.left = n4;
		n5.right = n3;

		List<Double> res = averageOfLevels(n5);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Queue<TreeNode>> qs = new ArrayList<Queue<TreeNode>>();
		qs.add(new LinkedList<TreeNode>());
		qs.add(new LinkedList<TreeNode>());
		int parentQIndex = 0;
		int childQIndex = 1;
		int temp;
		List<Double> result = new ArrayList<Double>();
		result.add(root.val * 1.0);
		qs.get(parentQIndex).add(root);
		while (!qs.get(parentQIndex).isEmpty()) {
			while (!qs.get(parentQIndex).isEmpty()) {
				TreeNode node = qs.get(parentQIndex).poll();
				if (node.left != null) {
					qs.get(childQIndex).add(node.left);
				}
				if (node.right != null) {
					qs.get(childQIndex).add(node.right);
				}
			}
			double avg = 0.0;
			if (qs.get(childQIndex).size() != 0) {
				ArrayList<TreeNode> list = new ArrayList<TreeNode>(qs.get(childQIndex));

				for (int i = 0; i < list.size(); i++) {
					avg += list.get(i).val * 1.0 / list.size() * 1.0;
				}
				result.add(avg);
			}
			temp = parentQIndex;
			parentQIndex = childQIndex;
			childQIndex = temp;
		}
		return result;
	}
}
