
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {
	private static String crlf = System.getProperty("line.separator");

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final StandardInputSnatcher in = new StandardInputSnatcher();

	@BeforeClass
	public static void setUpString() {

	}

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		System.setIn(in);
	}

	@After
	public void cleanUpStreams() {
		System.setOut(System.out);
		System.setErr(System.err);
		System.setIn(System.in);
	}

	@Test
	public void test1() throws IOException {

	in.inputln("09012345678");











	Main.main(null);
	StringBuffer sb = new StringBuffer();

	sb.append("819012345678");

	assertEquals(sb.toString(), outContent.toString());
	}

	@Test
	public void test2() throws IOException {

	in.inputln("09000000000");











	Main.main(null);
	StringBuffer sb = new StringBuffer();

	sb.append("819000000000");

	assertEquals(sb.toString(), outContent.toString());
	}


	/*
		@Test
		public void test2() throws IOException {
			in.inputln("8 9");
			in.inputln("3 1 4 1 5 9 2 6");

			Main.main(null);

			StringBuffer sb = new StringBuffer();

			sb.append("0");
			assertEquals(sb.toString(), outContent.toString());

		}

		@Test
		public void test3() throws IOException {
			in.inputln("10 314");
			in.inputln("159 265 358 979 323 846 264 338 327 950");

			Main.main(null);

			StringBuffer sb = new StringBuffer();

			sb.append("1923");
			assertEquals(sb.toString(), outContent.toString());

		}

		@Test
		public void test4() throws IOException {
			in.inputln("200000 0");

			in.inputln(str);
			Main.main(null);

			StringBuffer sb2 = new StringBuffer();

			sb2.append("20000000000");
			assertEquals(sb2.toString(), outContent.toString());

		}
	*/
}