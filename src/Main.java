
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		System.out.print("81"+ line.substring(1));

	}

	private static int[] parseIntArray(String str) {
		String[] strs = str.split(" ");
		int[] ints = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		return ints;
	}

	private static long[] parseLongArray(String str) {
		String[] strs = str.split(" ");
		long[] ints = Arrays.stream(strs).mapToLong(Long::parseLong).toArray();
		return ints;
	}
}
