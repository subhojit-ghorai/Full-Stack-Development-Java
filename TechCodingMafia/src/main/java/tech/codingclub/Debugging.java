package tech.codingclub;

import java.io.*;
import java.util.Date;

public class Debugging {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Debugging running at :"+ new Date().toString());
        int N = 10;
        int sum = 0;
        for(int i=0;i<N;i++)
        {
            sum += i;
        }
        Singleton ss1 = Singleton.getInstance(456);
        Singleton ss2 = Singleton.getInstance(108);

        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream("D:/Coding_Club_java/src/main/java/tech/codingclub/Debugging.java");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strline;

            while((strline = br.readLine()) != null)
            {
                System.out.println(strline);
            }
            fstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
