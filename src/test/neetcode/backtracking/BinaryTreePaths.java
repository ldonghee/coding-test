package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> answers = new ArrayList<>();
		dfs(answers, root, "");
		return answers;
	}

	private void dfs(List<String> answers, TreeNode node, String path) {
		if (node.left == null && node.right == null) {
			answers.add(path + node.val);
		}
		if (node.left != null) {
			dfs(answers, node.left, path + node.val + "->");
		}
		if (node.right != null) {
			dfs(answers, node.right, path + node.val + "->");
		}
	}

	@Test
	void test1() {
		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5, null, null)), new TreeNode(3, null, null));

		List<String> expect = Arrays.asList("1->2->5", "1->3");
		List<String> actual = binaryTreePaths(root);

		assertThat(actual).isEqualTo(actual);
	}

	@Test
	void test2() {
		TreeNode root = new TreeNode(1, null, null);

		List<String> expect = Arrays.asList("1");
		List<String> actual = binaryTreePaths(root);

		assertThat(actual).isEqualTo(actual);
	}
}
