import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParse {
	static FeedMessage f = new FeedMessage();

	static ArrayList<FeedMessage> list = new ArrayList<FeedMessage>();

	public ArrayList<FeedMessage> getlist(String urlAddress) {

		try {
			Document doc;
			list = new ArrayList<FeedMessage>();

			doc = Jsoup.connect(urlAddress).get();

			String title = doc.title();

			Elements times = doc.getElementsByClass("time");

			Elements links = doc.select("a[href]");

			for (int i = 0; i < times.size(); i++) {

				Element link = links.get(i);
				Element time = times.get(i);

				if (link.text().length() > 20) {

					f = new FeedMessage();
					f.title = time.text() + " |  " + link.text();
					f.href = link.attr("href");

					list.add(f);

				}

			}
			return list;

		} catch (IOException e) {
			e.printStackTrace();
			new Disconect();
		}
		return null;

	}

	public static String getweb() {
		FeedMessage a = list.get(PopupMenu.labelNumber);
		String b = a.href;
		System.out.println(b);
		return b;

	}
}
