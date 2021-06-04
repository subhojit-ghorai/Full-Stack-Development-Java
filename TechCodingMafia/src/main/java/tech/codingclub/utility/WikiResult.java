package tech.codingclub.utility;

public class WikiResult {

    private String query;
    private String text_result;
    private String img_URL;

    public WikiResult(String query, String text_result, String img_URL) {
        this.query = query;
        this.text_result = text_result;
        this.img_URL = img_URL;
    }
}
