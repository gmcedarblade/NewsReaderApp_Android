package edu.cvtc.android.newsreaderapp;

import android.content.Context;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Greg on 5/8/2017.
 */

public class FileIO {

    private final String URL_STRING = "http://rss.cnn.com/rss/cnn_tech.rss";
    private final String FILENAME = "new_feed.xml";

    public FileIO (Context context) { this.context = context; }

    public void downloadFile() {

        try {

            // get the URL
            URL url = new URL(URL_STRING);

            // get the input stream
            InputStream inputStream = url.openStream();

            // get the output stream
            FileOutputStream outputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);

            // read input and write output
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            while (bytesRead != -1) {

                outputStream.write(buffer, 0 , bytesRead);
                bytesRead = inputStream.read(buffer);

            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {

            Log.e("News reader", e.toString());

        }

    }

    public RSSFeed readFile() {

        try {

            // get the XML reader
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlReader = parser.getXMLReader();

            // set content handler
            RSSFeedHandler theRssHandler = New RSSFeedHandler();
            xlmReader.setContentHandler(theRssHandler);

            // read the file from internal storage
            FileInputStream inputStream = context.openFileInput(FILENAME);

            // parse the data
            InputSource inputSource = new InputSource(inputStream);
            xmlReader.parse(inputSource);

            // set the feed in the activity
            RSSFeed feed = theRssHandler.getFeed();
            return feed;

        } catch (Exception e) {

            Log.e("News reader", e.toString());
            return null;

        }

    }


}
