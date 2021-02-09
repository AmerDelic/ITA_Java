package exercises.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* Exercise 3:
 * 
 * Write a web crawler which takes a Url string, parses the web site for links
 * and returns all links in a List.
 * 
 *  */

public class WebCrawler {
	private String startUrl;

	public WebCrawler(String startUrl) {
		this.startUrl = startUrl;
	}

	public List<String> getAllLinks() {
		List<String> initialList = parse(startUrl);
		return initialList;
	}

	private String retrievePage(String url) {
		URL page = null;
		try {
			page = new URL(url);
		} catch (MalformedURLException e) {
			e.getMessage();
		}

		try (BufferedReader in = new BufferedReader(new InputStreamReader(page.openStream()))) {
			StringBuffer sbfr = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
				sbfr.append(line + "\n");
			}
			return sbfr.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String parseHlink(String page, int pos) {
		StringBuilder sb = new StringBuilder();
		pos += 6;
		char c;
		while ((c = page.charAt(pos++)) != '"') {
			sb.append(c);
		}
		return sb.toString();
	}

	private List<String> parse(String url) {
		List<String> pages = new ArrayList<String>();
		String page = retrievePage(url);
		int lastPos = page.length() - 1;
		while (lastPos != -1) {
			lastPos = page.lastIndexOf("href", lastPos - 1);
			if (lastPos == -1)
				break;
			String link = parseHlink(page, lastPos);
			if (!(link.contains("http")))
				continue;
			pages.add(link);
		}
		return pages;
	}

}
