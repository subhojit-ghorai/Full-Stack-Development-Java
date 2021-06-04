package tech.codingclub.helix.entity;

public class WikiResult {

    private String query;
    private String text_result;
    private String img_URL;

    public WikiResult(String query, String text_result, String img_URL) {
        this.query = query;
        this.text_result = text_result;
        this.img_URL = img_URL;
    }

    public String getQuery() {
        return query;
    }

    public String getText_result() {
        return text_result;
    }

    public String getImg_URL() {
        return img_URL;
    }
}
