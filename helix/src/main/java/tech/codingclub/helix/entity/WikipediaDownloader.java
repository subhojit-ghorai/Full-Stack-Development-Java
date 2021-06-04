package tech.codingclub.helix.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tech.codingclub.helix.global.HttpURLConnectionExample;

public class WikipediaDownloader {

    private String keyword;

    public WikipediaDownloader(String keyword) {
        this.keyword = keyword;
    }

    private String getWikipediaURLforQuery(String keyword) {
        return "https://en.wikipedia.org/wiki/"+keyword;
    }

    public WikiResult getResult() {
        //Get clean keyword
        //develop URL using clean keyword for wikipedia
        //make get request to wikipedia
        //Parsing the useful results using JSOUP library
        //display result

        if(keyword == null || keyword.length()==0)
        {
            return null;
        }

        //Step 1
        keyword = keyword.trim().replaceAll("[ ]+","_");    //replace all space in keyword by underscore

        //Step 2
        String wikiURL = getWikipediaURLforQuery(keyword);
        String response = "";
        String imgURL = "";

        try {
            //Step 3
            String wikipediaResponseHTML = HttpURLConnectionExample.sendGet(wikiURL);
            //System.out.println(wikipediaResponseHTML);

            //Step 4
            Document document = Jsoup.parse(wikipediaResponseHTML,"https://en.wikipedia.org");

            Elements mainElement = document.body().select(".mw-parser-output > *");

            //getting the text data;
            int state = 0;
            for(Element childElement : mainElement)
            {
                if(state == 0)
                {
                    if(childElement.tagName().equals("table"))
                    {
                        state = 1;
                    }
                }
                else if(state==1)
                {
                    if(childElement.tagName().equals("p"))
                    {
                        response = childElement.text();
                        break;
                    }
                }
            }

            //getting an image data
            imgURL = document.body().select(".infobox img").get(0).attr("src");

        } catch (Exception e) {
            e.printStackTrace();
        }

        WikiResult wikiResult = new WikiResult(keyword,response,imgURL);

        //PUSH data into database after converting the result into json string

        //System.out.println(new Gson().toJson(wikiResult));
                //or to print json in pretty way
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(wikiResult);

        return wikiResult;
    }

}
