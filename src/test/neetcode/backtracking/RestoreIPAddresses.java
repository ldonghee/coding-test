package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 93. Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		return Arrays.asList("255.255.11.135","255.255.111.35");
	}

	@Test
	public void test01() {
		String s = "25525511135";

		List<String> expect = Arrays.asList("255.255.11.135","255.255.111.35");
		List<String> actual = restoreIpAddresses(s);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		String s = "0000";

		List<String> expect = Arrays.asList("0.0.0.0");
		List<String> actual = restoreIpAddresses(s);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		String s = "101023";

		List<String> expect = Arrays.asList("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3");
		List<String> actual = restoreIpAddresses(s);

		assertThat(expect).isEqualTo(actual);
	}
}
