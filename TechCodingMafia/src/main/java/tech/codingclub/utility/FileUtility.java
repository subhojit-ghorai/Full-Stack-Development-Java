package tech.codingclub.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileUtility {
    public static boolean createFile(String fileNameWithPath)
    {
        File file = new File(fileNameWithPath);
        boolean fileCreated = false;
        try {
            fileCreated = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileCreated;
    }

    public static ArrayList<String> readAndPrintFile(String fileNameWithPath) {
        Scanner sc = null;
        ArrayList<String> arr = new ArrayList<String>();
        try
        {
            File file = new File(fileNameWithPath);
            sc = new Scanner(file);

            while(sc.hasNext())
            {
                String line = sc.nextLine();
                arr.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(sc!=null)
            {
                sc.close();
            }
        }
        return arr;
    }

    public static boolean writeToFile(String fileNameWithPath,String content)
    {
        File file = new File(fileNameWithPath);
        if(!file.exists())
        {
            createFile(fileNameWithPath);
        }
        try{
            FileWriter fw = new FileWriter(fileNameWithPath,true);
            fw.write(content);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean appendToFile(String fileNameWithPath,String content)
    {
        try{
            FileWriter fw = new FileWriter(fileNameWithPath,true);
            fw.append(content);
            fw.append("\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("File Creation running at :"+ new Date().toString());

        String nameoffile = "D:\\subhojit\\Coding_club_java\\try1\\TechCodingMafia\\data\\practice\\file\\" + "create_file.txt";
        boolean created = createFile(nameoffile);
        System.out.println("File Created : "+ created);

        ArrayList<String> stringArr = readAndPrintFile(nameoffile);

        for(String x:stringArr)
        {
            System.out.println(x);
        }

        String nameofwritefile = "D:\\subhojit\\Coding_club_java\\try1\\TechCodingMafia\\data\\practice\\file\\" + "create_file.txt";

        boolean writetofile = FileUtility.writeToFile(nameofwritefile,"Hi this is ####");

        for(int i=0;i<100;i++)
        {
            String st = i + "";
            boolean x = appendToFile(nameofwritefile,st);
        }
    }
}
