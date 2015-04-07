import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Parse {
	public ArrayList<FeedMessage> getlist(String urlAddress) {
		try {
			URL realUrl = new URL(urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					realUrl.openStream()));

			ArrayList<FeedMessage> list = new ArrayList<FeedMessage>();
			String line;
			String temp = "";
			while ((line = in.readLine()) != null) {
				if (line.contains("<title><![CDATA[")) {
					int firstPos = line.indexOf("<title><![CDATA[");
					temp = line.substring(firstPos);
					temp = temp.replace("<title><![CDATA[", "");
					int lastPos = temp.indexOf("]]>");
					temp = temp.substring(0, lastPos);
					FeedMessage f = new FeedMessage();
					f.title = temp;
					list.add(f);
				}
			}
			in.close();
			return list;
			
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return null;
	}
}