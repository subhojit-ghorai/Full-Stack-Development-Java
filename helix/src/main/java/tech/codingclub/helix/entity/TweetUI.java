package tech.codingclub.helix.entity;

public class TweetUI extends Tweet{

    public String author_name;
    public String author_email;

    public TweetUI(Tweet tweet,Member member) {
        super(tweet.message, tweet.id, tweet.created_at, tweet.author_id);
        this.author_email = member.email;
        this.author_name = member.name;
    }
}
