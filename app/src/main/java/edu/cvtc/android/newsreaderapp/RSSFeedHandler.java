package edu.cvtc.android.newsreaderapp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Greg on 5/8/2017.
 */

public class RSSFeedHandler extends DefaultHandler {

    RSSFeed feed;
    RSSItem item;

    boolean feedTitleHasBeenRead = false;
    boolean feedPubDateHasBeenRead = false;

    boolean isTitle = false;
    boolean isDescription = false;
    boolean isLink = false;
    boolean isPubDate = false;

    RSSFeedHandler() {}

    public RSSFeed getFeed() { return feed; }

    public void startDocument() throws SAXException {

        feed = new RSSFeed();
        item = new RSSItem(); // an item to temp store feed data

    }

    public void endDocument() throws SAXException { }

    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes attributes) throws SAXException {

        if (qName.equals("item")) {

            // create new item
            item = new RSSItem();
            return;

        } else if (qName.equals("title")) {

            isTitle = true;
            return;

        } else if (qName.equals("description")) {

            isDescription = true;
            return;

        } else if (qName.equals("link")) {

            isLink = true;
            return;

        } else if (qName.equals("pubDate")) {

            isPubDate = true;
            return;

        }

    }

    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException {

        if (qName.equals("item")) {

            feed.addItem(item);
            return;

        }

    }

    public void characters(char ch[], int start, int length) {

        String string = new String(ch, start,length);

        if (isTitle) {

            if (feedTitleHasBeenRead == false) {

                feed.setTitle(string);
                feedTitleHasBeenRead = true;

            } else {

                item.setTitle(string);

            }

            isTitle = false;

        } else if (isLink) {

            item.setLink(string);
            isLink = false;

        } else if (isDescription) {

            if (string.startsWith("<")) {

                item.setDescription("No description available.");

            } else {

                item.setDescription(string);

            }

            isDescription = false;

        } else if (isPubDate) {

            if (feedPubDateHasBeenRead == false) {

                feed.setPubDate(string);
                feedPubDateHasBeenRead = true;

            } else {

                item.setPubDate(string);

            }

            isPubDate = false;

        }

    }

}
