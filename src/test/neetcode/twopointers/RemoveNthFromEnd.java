package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.Test;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNthFromEnd {
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

		public String getLinkedSumValue() {
			StringBuilder buffer = new StringBuilder();

			buffer.append(val);

			while (!Objects.isNull(next)) {
				buffer.append(next.val);
				next = next.next;
			}

			return buffer.toString();
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		return null;
	}

	@Test
	public void test01() {
		ListNode a5 = new ListNode(5);
		ListNode a4 = new ListNode(4, a5);
		ListNode a3 = new ListNode(3, a4);
		ListNode a2 = new ListNode(2, a3);
		ListNode a1 = new ListNode(1, a2);

		ListNode e4 = new ListNode(5);
		ListNode e3 = new ListNode(3, e4);
		ListNode e2 = new ListNode(2, e3);
		ListNode e1 = new ListNode(1, e2);

		ListNode expect = e1;
		ListNode actual = removeNthFromEnd(a1, 2);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}

	@Test
	public void test02() {
		ListNode a1 = new ListNode(1);

		ListNode expect = null;
		ListNode actual = removeNthFromEnd(a1, 1);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}

	@Test
	public void test03() {
		ListNode a2 = new ListNode(2);
		ListNode a1 = new ListNode(1, a2);

		ListNode expect = new ListNode(1);
		ListNode actual = removeNthFromEnd(a1, 1);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}

}
