package com.lakeholmz.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class BasicWebCrawler {

  private HashSet<String> links;

  public BasicWebCrawler() {
    links = new HashSet<String>();
  }

  public void getPageLinks(String URL) {

    try {
      Document document = Jsoup.connect(URL).get();
      System.out.println(document);

      Elements linksOnPage = document.select("a[href]");

      for(Element link : linksOnPage) {
        System.out.println(link);    
      }
    } catch (IOException e) {
      System.err.println("For '" + URL + "': " + e.getMessage());
    }
}    

    public static void main(String[] args) {
      new BasicWebCrawler().getPageLinks("http://www.mkyong.com/");
    }
  }
