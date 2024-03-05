package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/description/
 */
public class SortList {
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

	// 선택 정렬
	/*
	public ListNode sortList(ListNode head) {
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode cur = start;

		while(cur.next != null) {
			ListNode i = cur.next;
			ListNode j = cur.next.next;

			while(j != null) {
				if (i.val > j.val) {
					int temp = i.val;
					i.val = j.val;
					j.val = temp;
				}
				j = j.next;
			}
			cur = cur.next;
		}

		return start.next;
	}
	*/
	// 병합 정렬
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// step 1. cut the list to two halves
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// step 2. sort each half
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// step 3. merge l1 and l2
		return merge(l1, l2);
	}

	ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0), p = l;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if (l1 != null)
			p.next = l1;

		if (l2 != null)
			p.next = l2;

		return l.next;
	}

	@Test
	public void test01() {
		ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
		ListNode expect = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
		ListNode actual = sortList(head);

		StringBuilder expectBuilder = new StringBuilder();
		while (expect != null) {
			expectBuilder.append(expect.val);
			expect = expect.next;
		}

		StringBuilder actualBuilder = new StringBuilder();
		while (actual != null) {
			actualBuilder.append(actual.val);
			actual = actual.next;
		}

		assertThat(actualBuilder.toString()).isEqualTo(expectBuilder.toString());
	}

	@Test
	public void test02() {
		ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0, null)))));
		ListNode expect = new ListNode(-1, new ListNode(0, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
		ListNode actual = sortList(head);

		StringBuilder expectBuilder = new StringBuilder();
		while (expect != null) {
			expectBuilder.append(expect.val);
			expect = expect.next;
		}

		StringBuilder actualBuilder = new StringBuilder();
		while (actual != null) {
			actualBuilder.append(actual.val);
			actual = actual.next;
		}

		assertThat(actualBuilder.toString()).isEqualTo(expectBuilder.toString());
	}
}
