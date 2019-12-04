import java.io.IOException;

import skynet.SkynetConsole;
public class SkynetConsoleTest {

	public static void main(String[] args) {
		SkynetConsole skynet = new SkynetConsole("src\\resources\\");
		try {
			skynet.startSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
