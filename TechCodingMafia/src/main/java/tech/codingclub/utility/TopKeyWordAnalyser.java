package tech.codingclub.utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TopKeyWordAnalyser implements Runnable {

    private String filePath;

    public TopKeyWordAnalyser(String filePath)
    {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        ArrayList<String> keyWordFileData = FileUtility.readAndPrintFile(filePath);

        HashMap<String,Integer> keyWordCounter = new HashMap<String,Integer>();

        for(String row : keyWordFileData)
        {
            String[] keywords = row.split(" ");

            for(String keyword : keywords)
            {
                String str = keyword.toLowerCase();

                if(!keyWordCounter.containsKey(str))
                {
                    keyWordCounter.put(str,1);
                }
                else
                {
                    int value = keyWordCounter.get(str);
                    keyWordCounter.put(str,value+1);
                }
            }
        }

        ArrayList<KeyWordCount> keyWordCountArrayList = new ArrayList<KeyWordCount>();

        for(String keyword : keyWordCounter.keySet())
        {
            KeyWordCount keyWC = new KeyWordCount(keyword,keyWordCounter.get(keyword));
            keyWordCountArrayList.add(keyWC);
        }

        Collections.sort(keyWordCountArrayList, new Comparator<KeyWordCount>() {
            @Override
            public int compare(KeyWordCount o1, KeyWordCount o2) {

                if(o1.count == o2.count)
                {
                    return o1.keyword.compareTo(o2.keyword);  // if diff words have same count then print in dictionary order
                }
                return o2.count-o1.count;
            }
        });

//        for(KeyWordCount keyword : keyWordCountArrayList)
//        {
//            System.out.println(keyword.keyword+" "+ keyword.count);
//        }

        String json = new Gson().toJson(keyWordCountArrayList);
        System.out.println(json);

        //JSON to object
        String convertJson = "{\"keyword\":\"Hello Gson\",\"count\":100}";
        KeyWordCount kwc = new Gson().fromJson(convertJson,KeyWordCount.class);
        System.out.println("Converted to object : "+kwc.keyword+" "+kwc.count);

        //JSON to Arraylist of Objects
        String convertJsonArray = "[{'keyword':'Hello Gson 1','count':1},{'keyword':'Hello Gson 2','count':100}]";
        ArrayList<KeyWordCount> convertedArray = new Gson().fromJson(convertJsonArray,new TypeToken<ArrayList<KeyWordCount>>(){}.getType());

        System.out.println("\nArraylist from JSON");
        for(KeyWordCount x : convertedArray)
        {
            System.out.println("Converted to object from json: "+x.keyword+" "+x.count);
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(1);
        taskManager.waitTillqueueIsFreethenadd(new TopKeyWordAnalyser("D:\\Anthem.txt"));
    }
}
