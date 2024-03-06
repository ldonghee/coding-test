package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/
 * https://neetcode.io/roadmap
 */
public class PartitionList {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class Solution {
		public ListNode partition(ListNode head, int x) {

			// 1. 기준 값 왼쪽은 기준값 보다 작아 질 때 까지 찾는다
			// 2. 기준 값 오른쪽은 기준값 보다 커질때 까지 찾는다 (없으면 마지막 인덱스)
			// 3. 오른쪽 찾은 대상들을 왼쪽에 찾은 값 앞으로 이동 시킨다.
			// 4. 마지막 인덱스 까지 반복

			ListNode lessHead = new ListNode(-1);
			ListNode moreHead = new ListNode(-1);
			ListNode less = lessHead;
			ListNode more = moreHead;
			ListNode node = head;

			while (node != null) {
				if (node.val < x) {
					less.next = node;
					less = less.next;
				} else {
					more.next = node;
					more = more.next;
				}
				node = node.next;
			}

			more.next = null;
			less.next = moreHead.next;
			return lessHead.next;
		}
	}


	private final Solution solution = new Solution();

	@Test
	public void test01() {
		ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
		int x = 2;

		ListNode expect = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(5, null))))));
		ListNode actual = solution.partition(head, x);

		ListNode node = expect;
		while(node != null) {
			System.out.print(node.val);
			node = node.next;
		}
		System.out.println();
		ListNode node2 = actual;
		while(node2 != null) {
			System.out.print(node2.val);
			node2 = node2.next;
		}

	}
}
