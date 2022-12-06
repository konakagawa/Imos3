
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

		in.inputln("2");
		in.inputln("1 1 1 4 4 4");
		in.inputln("2 2 2 5 5 5");

		Main.main(null);
		StringBuffer sb = new StringBuffer();

		sb.append("4");

		assertEquals(sb.toString(), outContent.toString());
	}

}
