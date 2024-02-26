package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode result = node;
		int sum = 0;

		while(l1 != null || l2 != null) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			node.next = new ListNode(sum % 10);

			sum = sum/10;
			node = node.next;
		}
		if (sum == 1) {
			node.next = new ListNode(sum % 10);
		}
		return result.next;

	}
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int value) {
			this.val = value;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}


		public String getLinkedSumValue() {
			StringBuilder buffer = new StringBuilder();

			buffer.append(val);

			while(!Objects.isNull(next)) {
				buffer.append(next.val);
				next = next.next;
			}

			return buffer.toString();
		}
	};

	@Test
	public void test01() {
		ListNode a3 = new ListNode(3);
		ListNode a2 = new ListNode(4, a3);
		ListNode a1 = new ListNode(2, a2);

		ListNode b3 = new ListNode(4);
		ListNode b2 = new ListNode(6, b3);
		ListNode b1 = new ListNode(5, b2);

		ListNode e3 = new ListNode(8);
		ListNode e2 = new ListNode(0, e3);
		ListNode e1 = new ListNode(7, e2);

		ListNode expect = e1;
		ListNode actual = addTwoNumbers(a1, b1);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}

	@Test
	public void test02() {
		ListNode a1 = new ListNode(0);
		ListNode b1 = new ListNode(0);
		ListNode e1 = new ListNode(0);

		ListNode expect = e1;
		ListNode actual = addTwoNumbers(a1, b1);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}

	@Test
	public void test03() {
		ListNode a7 = new ListNode(9);
		ListNode a6 = new ListNode(9, a7);
		ListNode a5 = new ListNode(9, a6);
		ListNode a4 = new ListNode(9, a5);
		ListNode a3 = new ListNode(9, a4);
		ListNode a2 = new ListNode(9, a3);
		ListNode a1 = new ListNode(9, a2);

		ListNode b4 = new ListNode(9);
		ListNode b3 = new ListNode(9, b4);
		ListNode b2 = new ListNode(9, b3);
		ListNode b1 = new ListNode(9, b2);

		ListNode e8 = new ListNode(1);
		ListNode e7 = new ListNode(0, e8);
		ListNode e6 = new ListNode(0, e7);
		ListNode e5 = new ListNode(0, e6);
		ListNode e4 = new ListNode(9, e5);
		ListNode e3 = new ListNode(9, e4);
		ListNode e2 = new ListNode(9, e3);
		ListNode e1 = new ListNode(8, e2);

		ListNode expect = e1;
		ListNode actual = addTwoNumbers(a1, b1);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}


	@Test
	public void test04() {
		ListNode a3 = new ListNode(9);
		ListNode a2 = new ListNode(4, a3);
		ListNode a1 = new ListNode(2, a2);

		ListNode b4 = new ListNode(9);
		ListNode b3 = new ListNode(4, b4);
		ListNode b2 = new ListNode(6, b3);
		ListNode b1 = new ListNode(5, b2);

		ListNode e5 = new ListNode(1);
		ListNode e4 = new ListNode(0, e5);
		ListNode e3 = new ListNode(4, e4);
		ListNode e2 = new ListNode(0, e3);
		ListNode e1 = new ListNode(7, e2);

		ListNode expect = e1;
		ListNode actual = addTwoNumbers(a1, b1);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}

	@Test
	public void test05() {
		ListNode a1 = new ListNode(9);

		ListNode b11 = new ListNode(9);
		ListNode b10 = new ListNode(9, b11);
		ListNode b9 = new ListNode(9, b10);
		ListNode b8 = new ListNode(9, b9);
		ListNode b7 = new ListNode(9, b8);
		ListNode b6 = new ListNode(9, b7);
		ListNode b5 = new ListNode(9, b6);
		ListNode b4 = new ListNode(9, b5);
		ListNode b3 = new ListNode(9, b4);
		ListNode b2 = new ListNode(9, b3);
		ListNode b1 = new ListNode(1, b2);

		ListNode e12 = new ListNode(1);
		ListNode e11 = new ListNode(0, e12);
		ListNode e10 = new ListNode(0, e11);
		ListNode e9 = new ListNode(0, e10);
		ListNode e8 = new ListNode(0, e9);
		ListNode e7 = new ListNode(0, e8);
		ListNode e6 = new ListNode(0, e7);
		ListNode e5 = new ListNode(0, e6);
		ListNode e4 = new ListNode(0, e5);
		ListNode e3 = new ListNode(0, e4);
		ListNode e2 = new ListNode(0, e3);
		ListNode e1 = new ListNode(0, e2);

		ListNode expect = e1;
		ListNode actual = addTwoNumbers(a1, b1);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}

	@Test
	public void test06() {
		ListNode a3 = new ListNode(4);
		ListNode a2 = new ListNode(6, a3);
		ListNode a1 = new ListNode(5, a2);

		ListNode b31 = new ListNode(1);
		ListNode b30 = new ListNode(0, b31);
		ListNode b29 = new ListNode(0, b30);
		ListNode b28 = new ListNode(0, b29);
		ListNode b27 = new ListNode(0, b28);
		ListNode b26 = new ListNode(0, b27);
		ListNode b25 = new ListNode(0, b26);
		ListNode b24 = new ListNode(0, b25);
		ListNode b23 = new ListNode(0, b24);
		ListNode b22 = new ListNode(0, b23);
		ListNode b21 = new ListNode(0, b22);
		ListNode b20 = new ListNode(0, b21);
		ListNode b19 = new ListNode(0, b20);
		ListNode b18 = new ListNode(0, b19);
		ListNode b17 = new ListNode(0, b18);
		ListNode b16 = new ListNode(0, b17);
		ListNode b15 = new ListNode(0, b16);
		ListNode b14 = new ListNode(0, b15);
		ListNode b13 = new ListNode(0, b14);
		ListNode b12 = new ListNode(0, b13);
		ListNode b11 = new ListNode(0, b12);
		ListNode b10 = new ListNode(0, b11);
		ListNode b9 = new ListNode(0, b10);
		ListNode b8 = new ListNode(0, b9);
		ListNode b7 = new ListNode(0, b8);
		ListNode b6 = new ListNode(0, b7);
		ListNode b5 = new ListNode(0, b6);
		ListNode b4 = new ListNode(0, b5);
		ListNode b3 = new ListNode(0, b4);
		ListNode b2 = new ListNode(0, b3);
		ListNode b1 = new ListNode(1, b2);

		ListNode e12 = new ListNode(1);
		ListNode e11 = new ListNode(0, e12);
		ListNode e10 = new ListNode(0, e11);
		ListNode e9 = new ListNode(0, e10);
		ListNode e8 = new ListNode(0, e9);
		ListNode e7 = new ListNode(0, e8);
		ListNode e6 = new ListNode(0, e7);
		ListNode e5 = new ListNode(0, e6);
		ListNode e4 = new ListNode(0, e5);
		ListNode e3 = new ListNode(0, e4);
		ListNode e2 = new ListNode(0, e3);
		ListNode e1 = new ListNode(0, e2);

		ListNode expect = e1;
		ListNode actual = addTwoNumbers(b1, a1);
		assertThat(actual.getLinkedSumValue()).isEqualTo(expect.getLinkedSumValue());
	}



}
