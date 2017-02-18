package com.example.sandbox.mains;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Gildur on 2016-11-30.
 */
public class JsoupExperiment {

    public static void main(String args[]) {
//        String html = "<html>Hej, detta är lite <b>bold text<b><br>Icke godkänd tagg <custy musty> Hej då</br><b></html>";
        String html = "";

        Document doc = Jsoup.parse(html);

        Elements elements = doc.getAllElements();

        for (Element element : elements) {
            if (element.tagName().contains("custy")) {
                System.out.println(element.tagName() + "\t| " + element.tag().isKnownTag());
                System.out.println(element.tag());
                System.out.println(element.tagName());
                System.out.println(element.unwrap().toString());
                System.out.println(element.cssSelector());
                System.out.println(element.html());
                System.out.println(element.id());
                System.out.println(element.nodeName());
                System.out.println(element.ownText());
                System.out.println(element.text());
                System.out.println(element.val());
            }

        }
    }
}
