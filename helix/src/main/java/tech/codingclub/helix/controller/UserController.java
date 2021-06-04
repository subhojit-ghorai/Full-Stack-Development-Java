package tech.codingclub.helix.controller;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.jooq.Condition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.codingclub.helix.database.GenericDB;
import tech.codingclub.helix.entity.*;
import tech.codingclub.helix.global.SysProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * User: rishabh
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static Logger logger = Logger.getLogger(UserController.class);


    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String userWelcome(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Member x = ControllerUtils.getCurrentMember(request);

        return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/public-tweet/{id}")
    public
    @ResponseBody
    List<TweetUI> fetchTweet(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {

        //Condition to fetch those tweets which has id less than last tweet
        Condition condition1 = tech.codingclub.helix.tables.Tweet.TWEET.ID.lessThan(id);
        //fetching data from tweet table, 3 at a time
        List<Tweet> data = (List<Tweet>) GenericDB.getRows(tech.codingclub.helix.tables.Tweet.TWEET,Tweet.class,condition1,3, tech.codingclub.helix.tables.Tweet.TWEET.ID.desc());

        Set<Long> memberIds = new HashSet<Long>();
        for(Tweet tweet : data)
        {
            memberIds.add(tweet.author_id);
        }

        Condition condition2 = tech.codingclub.helix.tables.Member.MEMBER.ID.in(memberIds);
        List<Member> members = (List<Member>) GenericDB.getRows(tech.codingclub.helix.tables.Member.MEMBER,Member.class,condition2,null);

        HashMap<Long,Member> id_member_map = new HashMap<Long, Member>();
        for(Member m:members)
        {
            id_member_map.put(m.id,m);
        }

        ArrayList<TweetUI> tui = new ArrayList<TweetUI>();

        for(Tweet tweet : data)
        {
            Member m = id_member_map.get(tweet.author_id);
            TweetUI tweetUI = new TweetUI(tweet,m);
            tui.add(tweetUI);
        }
        return tui;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create-post")
    public
    @ResponseBody
    String createTweet(@RequestBody String data, HttpServletRequest request, HttpServletResponse response) {

        Tweet tweet = new Tweet(data,null,new Date().getTime(),ControllerUtils.getUserId(request));
        new GenericDB<Tweet>().addRow(tech.codingclub.helix.tables.Tweet.TWEET,tweet);
        return "Posted Successfully";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/follow-member")
    public
    @ResponseBody
    String followingPeople(@RequestBody Long following_id, HttpServletRequest request, HttpServletResponse response) {
        Long current_user_id = ControllerUtils.getUserId(request);

        if(current_user_id!=null && following_id!=null && !current_user_id.equals(following_id))
        {
            Follower following = new Follower(current_user_id,following_id);
            new GenericDB<Follower>().addRow(tech.codingclub.helix.tables.Follower.FOLLOWER,following);
            return "Followed Successfully";
        }
        else
        {
            return "Following him/her not permitted";
        }

    }
    @RequestMapping(method = RequestMethod.POST, value = "/un-follow-member")
    public
    @ResponseBody
    String unFollowingPeople(@RequestBody Long following_id, HttpServletRequest request, HttpServletResponse response) {
        Long current_user_id = ControllerUtils.getUserId(request);

        if(current_user_id!=null && following_id!=null && !current_user_id.equals(following_id))
        {
            Condition condition1 = tech.codingclub.helix.tables.Follower.FOLLOWER.USER_ID.eq(current_user_id).and(tech.codingclub.helix.tables.Follower.FOLLOWER.FOLLOWING_ID.eq(following_id));
            boolean isdeleted = GenericDB.deleteRows(tech.codingclub.helix.tables.Follower.FOLLOWER,condition1);

            if(isdeleted)
            {
                return "Row deleted successfully";
            }
            else
            {
                return "Row NOT deleted successfully";
            }
        }
        else
        {
            return "Backend-error in un-follow-member";
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/recommendation")
    public String createRecommendation(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Member member = ControllerUtils.getCurrentMember(request);
        Long currentUserId = ControllerUtils.getUserId(request);

        Condition condition1 = tech.codingclub.helix.tables.Follower.FOLLOWER.USER_ID.eq(currentUserId);
        List<Long> followingIDs = new GenericDB<Long>().getColumnRows(tech.codingclub.helix.tables.Follower.FOLLOWER.FOLLOWING_ID, tech.codingclub.helix.tables.Follower.FOLLOWER,Long.class,condition1,100);

        List<Member> members = (List<Member>) GenericDB.getRows(tech.codingclub.helix.tables.Member.MEMBER,Member.class,null,10, tech.codingclub.helix.tables.Member.MEMBER.ID.desc());

        for(Member m:members)
        {
            if(followingIDs.contains(m.id))
            {
                m.is_followed = true;
            }
        }

        preLoadVariables(modelMap,currentUserId);
        modelMap.addAttribute("NAME",member.name);
        modelMap.addAttribute("RECOMMENDATIONS",members);

        return "recommendation";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/followed")
    public String followed(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Long currentUserId = ControllerUtils.getUserId(request);

        Condition condition1 = tech.codingclub.helix.tables.Follower.FOLLOWER.USER_ID.eq(currentUserId);
        List<Long> followingIDs = new GenericDB<Long>().getColumnRows(tech.codingclub.helix.tables.Follower.FOLLOWER.FOLLOWING_ID, tech.codingclub.helix.tables.Follower.FOLLOWER,Long.class,condition1,100);

        Condition condition2 = tech.codingclub.helix.tables.Member.MEMBER.ID.in(followingIDs);
        List<Member> followingMembers = (List<Member>) GenericDB.getRows(tech.codingclub.helix.tables.Member.MEMBER,Member.class,condition2,10);

        //modelMap.addAttribute("USER_IMAGE","/images/profile-image/"+currentUserId+".jpeg");
        preLoadVariables(modelMap,currentUserId);
        modelMap.addAttribute("FOLLOWED",followingMembers);

        return "followed";
    }

    private void preLoadVariables(ModelMap modelMap, Long memberID) {
        modelMap.addAttribute("USER_IMAGE","/images/profile-image/"+memberID+".jpeg");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public String updateUser(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {

        return "updateuser";
    }

    private static String saveUploadedFile( MultipartFile file, Long userId){
        try {
            String path = SysProperties.getBaseDir()+"/images/profile-image/"+userId+".jpeg";
            file.transferTo( new File(path));
            return "/images/profile-image/"+userId+".jpeg";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/profile-image/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile uploadfile, HttpServletRequest request) {
        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }
        String path = "";
        try {
            Long currentMemberId = ControllerUtils.getUserId(request);
            path = saveUploadedFile(uploadfile,currentMemberId);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(path, new HttpHeaders(), HttpStatus.OK);
    }
}