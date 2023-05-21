package test.exam.today;


import java.util.ArrayList;
import java.util.List;

class System {
	List<Reserve> reserveList = new ArrayList<>();
	List<Reserve> duplicateReserveList = new ArrayList<>();

	public System() {
	}
	public boolean book(int start, int end) {
		for (Reserve r : duplicateReserveList) {
			if (r.start <= start && start < r.end) {
				return false;
			}
		}

		for (Reserve r : reserveList) {
			if (start <= r.start && r.start < end) {
				duplicateReserveList.add(new Reserve(Math.max(start, r.start), Math.min(end, r.end)));
			}
		}

		reserveList.add(new Reserve(start, end));
		return true;
	}

	class Reserve {
		int start;
		int end;

		public Reserve(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}


}
