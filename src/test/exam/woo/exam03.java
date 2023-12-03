package test.exam.woo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class exam03 {
	/**
	 * productInfo 문자열로 이루어진 상품정보의 집합을 의미
	 * 하나의 문자열에 상품 하나의 정보가 들어있고, 상품 정보는 상품 ID(문자열), 상품명, 개당 판매가격이 쉼표(,)로 구분되어 텍스트로 저장되어 있는 것을 가정
	 * 예) ["123456789,유기농쌀 4kg,5000", "234578882,배달이캐릭터숟가락,3000"]
	 *
	 * dailyProductSales 는 상품의 일자별 판매량 정보가 저장된 문자열의 집합
	 * 하나의 문자열에 상품 하나의 일자별 판매량 정보가 들어 있고, 이는 "YYYYMMDD"형식의 날짜, 상품ID(문자열), 판매수량이 쉼표(,)로 구분되어 저장되어 있어.
	 * 예) ["20220810,12345679,5", "20220810,234578882,30","20220811,123456789,7"]
	 *
	 * dailyProductSales 에 저장된 순서대로 읽어서 YYYYMMDD 형식의 날짜, 상품ID, 상품명, 일일판매금액 형식으로 이루어진 문자열 배열을 리턴하도록 메서드 완성
	 * 예) ["20220810,12345679,유기농쌀 4kg,25000", 20220810,234578882,배달이캐릭터숟가락,90000, "20220811,123456789,유기농쌀 4kg,35000"]
	 */
	class Solution {
		public String[] solution(String[] productInfo, String[] dailyProductSales) {
			Map<String, String[]> productMap = Arrays.stream(productInfo)
													 .map(info -> info.split(","))
													 .collect(Collectors.toMap(info -> info[0], info -> new String[] {info[1], info[2]}));

//
//			String[] result = new String[dailyProductSales.length];
//
//			for (int i = 0; i < dailyProductSales.length; i++) {
//				String[] sale = dailyProductSales[i].split(",");
//				String[] product = productMap.get(sale[1]);
//				int total = Integer.parseInt(product[1]) * Integer.parseInt(sale[2]);
//				result[i] = String.join(",", sale[0], sale[1], product[0], String.valueOf(total));
//			}
//
//			return result;

			return Arrays.stream(dailyProductSales)
						 .map(sale -> {
							 String[] saleInfo = sale.split(",");
							 String[] product = productMap.get(saleInfo[1]);
							 int total = Integer.parseInt(product[1]) * Integer.parseInt(saleInfo[2]);
							 return String.join(",", saleInfo[0], saleInfo[1], product[0], String.valueOf(total));
						 })
						 .toArray(String[]::new);
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test() {
		String[] productInfo = {"123456789,유기농쌀 4kg,5000", "234578882,배달이캐릭터숟가락,3000"};
		String[] dailyProductSales = {"20220810,123456789,5", "20220810,234578882,30","20220811,123456789,7"};

		String[] expect = {"20220810,123456789,유기농쌀 4kg,25000", "20220810,234578882,배달이캐릭터숟가락,90000", "20220811,123456789,유기농쌀 4kg,35000"};
		String[] actual = solution.solution(productInfo, dailyProductSales);

		assertThat(actual).isEqualTo(expect);
	}
}
