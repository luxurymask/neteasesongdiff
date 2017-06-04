package neteasesongdiff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ResolveSongList {
	public static List<String> getListOnNetease() {
		List<String> resultList = new ArrayList<String>();
		String html = "";
		BufferedReader reader;
		String s;
		File input = new File("/Users/liuxl/Desktop/test.html");
		try {
			reader = new BufferedReader(new FileReader(new File("/Users/liuxl/Desktop/test.html")));
			while ((s = reader.readLine()) != null) {
				html += s;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		Document doc;
		try {
			doc = Jsoup.parse(input, "UTF-8", "");
			Elements spans = doc.select("span.icn-share");
			for (Element element : spans) {
				String name = element.attr("data-res-name");
				String singer = element.attr("data-res-author");
				if (name != null && singer != null)
					resultList.add(singer + " - " + name + ".mp3");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	public static List<String> getListOnPhone() {
		List<String> resultList = new ArrayList<String>();
		File folder = new File("/Users/liuxl/Desktop/smartisan/Music");
		File[] files = folder.listFiles();
		for (File f : files) {
			String path = f.getAbsolutePath();
			String name = f.getName();
			resultList.add(name);
		}
		return resultList;
	}

	public static void main(String[] args) {
		List<String> listOfNetease = getListOnNetease();
		List<String> listOfPhone = getListOnPhone();
		for(String s : listOfPhone){
			if(!listOfNetease.contains(s)){
				System.out.println(s);
			}
		}
	}
}
