package tech.codingclub.utility;

import org.jooq.util.derby.sys.Sys;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tech.codingclub.database.GenericDB;
import tech.codingclub.entity.SongDB;
import tech.codingclub.tables.Songdb;

import java.util.ArrayList;
import java.util.Date;

import static tech.codingclub.utility.FileUtility.readAndPrintFile;

public class SongDownloader implements Runnable{

    private String album_URL;

    public SongDownloader(String album_URL) {
        this.album_URL = album_URL;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            String albumResponseHTML = HttpURLConnectionExample.sendGet(album_URL);

            Document document = Jsoup.parse(albumResponseHTML,"https://www.songspk2.info");

            Elements mainElement = document.body().select("#album-double > *");

            for(Element ele : mainElement)
            {
                String album_name = "";
                String album_image_link = "";
                String cast = "";
                String music_composer = "";
                String song_name = "";
                String song_download_link = "";

                String insideAlbumURL = ele.child(1).attr("href");
                String insideAlbumResponseHTML = HttpURLConnectionExample.sendGet(insideAlbumURL);
                Document document1 = Jsoup.parse(insideAlbumResponseHTML,"https://www.songspk2.info");

                Elements mainElement1 = document1.body().select(".col-sm-6.col-md-9 > *");

                for(Element ele1 : mainElement1)
                {
                    if(ele1.tagName().equals("h5"))
                    {
                        album_name = ele1.child(0).text();
                    }
                    else if(ele1.tagName().equals("div"))
                    {
                        if(ele1.child(0).text().equals("Cast:"))
                        {
                            cast = ele1.text();
                        }
                        else if(ele1.child(0).text().equals("Music Composer:"))
                        {
                            music_composer = ele1.text();
                        }
                    }
                }

                album_image_link = document1.body().select(".view.view-sixth img").attr("src").toString();

                Elements mainElement2 = document1.body().select(".b-table-primary.f-table-primary.f-left.songs-list tbody tr td");

                ArrayList<String> song_name_list = new ArrayList<>();
                ArrayList<String> song_link_list = new ArrayList<>();

                for(Element ele2 : mainElement2)
                {
                    if (ele2.attr("class").equals("songs-bitrate-1"))
                    {
                        song_name_list.add(ele2.child(1).text());
                    }
                    else if (ele2.attr("class").equals("songs-bitrate-3"))
                    {
                        song_link_list.add(ele2.child(0).attr("href"));
                    }
                }
                for(int i=0;i<song_name_list.size();i++)
                {
                    SongDB sdb = new SongDB(album_name, album_image_link, cast, music_composer, song_name_list.get(i), song_link_list.get(i));
                    new GenericDB<SongDB>().addRow(Songdb.SONGDB,sdb);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("This is Subhojit Ghorai");
        System.out.println("Song DB running at :"+ new Date().toString());

        String nameoffile = "D:\\subhojit\\Coding_club_java\\try1\\TechCodingMafia\\data\\practice\\file\\songlist.txt";
        ArrayList<String> stringArr = readAndPrintFile(nameoffile);

        TaskManager tsk = new TaskManager(100);

        for(String x : stringArr)
        {
            tsk.waitTillqueueIsFreethenadd(new SongDownloader(x));
        }
    }
}
