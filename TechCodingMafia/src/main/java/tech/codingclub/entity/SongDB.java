package tech.codingclub.entity;

public class SongDB {

    public String album_name;
    public String album_image_link;
    public String cast;
    public String music_composer;
    public String song_name;
    public String song_download_link;

    public SongDB() {
    }

    public SongDB(String album_name, String album_image_link, String cast, String music_composer, String song_name, String song_download_link) {
        this.album_name = album_name;
        this.album_image_link = album_image_link;
        this.cast = cast;
        this.music_composer = music_composer;
        this.song_name = song_name;
        this.song_download_link = song_download_link;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public String getAlbum_image_link() {
        return album_image_link;
    }

    public String getCast() {
        return cast;
    }

    public String getMusic_composer() {
        return music_composer;
    }

    public String getSong_name() {
        return song_name;
    }

    public String getSong_download_link() {
        return song_download_link;
    }
}
