package tech.codingclub;

public class Singleton {
    public int data;
    private static Singleton ss;

    private Singleton(int data)
    {
        this.data = data;
        System.out.println("Constructor called at : "+ data );
    }

    public static Singleton getInstance(int data)
    {
        if(ss == null)
        {
            ss = new Singleton(data);
        }
        return ss;
    }
}
