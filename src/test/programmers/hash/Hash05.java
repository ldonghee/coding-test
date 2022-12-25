package test.programmers.hash;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * 베스트앨범
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class Hash05 {
	class Solution {
		public int[] solution(String[] genres, int[] plays) {
			return IntStream.range(0, genres.length)
							.mapToObj(i -> new Music(genres[i], plays[i], i))
							.collect(Collectors.groupingBy(Music::getGenre))
							.entrySet().stream()
							.sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
							.flatMap(x -> x.getValue().stream().sorted().limit(2))
							.mapToInt(x -> x.id).toArray();
		}

		public class Music implements Comparable<Music>{
			private int played;
			private int id;
			private String genre;

			public Music(String genre, int played, int id) {
				this.genre = genre;
				this.played = played;
				this.id = id;
			}

			@Override
			public int compareTo(Music other) {
				if (this.played == other.played) {
					return this.id - other.id;
				}
				return other.played - this.played;
			}

			public String getGenre() {
				return genre;
			}
		}

		private int sum(List<Music> value) {
			int answer = 0;
			for (Music music : value) {
				answer += music.played;
			}
			return answer;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		int[] expect = {4, 1, 3, 0};
		int[] actual = solution.solution(genres, plays);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {150, 600, 150, 150, 2500};

		int[] expect = {4, 1, 0, 2};
		int[] actual = solution.solution(genres, plays);
		assertThat(actual).isEqualTo(expect);
	}
}
