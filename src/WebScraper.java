import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args){
        System.out.println(wordCount("http://erdani.com/tdpl/hamlet.txt", "hamlet"));
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
            } catch (IOException e) {
                return "";
            }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        System.out.println(contents);
        return contents;
    }
    public static int wordCount(final String url, final String word){
        int count;
        String contents = urlToString(url);
        String newWord = word.toLowerCase();
        contents = contents.toLowerCase();
        String[] wordSplit = contents.split(newWord);
        count = wordSplit.length;
        return count;
    }
}