package tech.codingclub;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance(90);
        Singleton obj2 = Singleton.getInstance(56);

        obj1.data = 90;
        obj2.data = 56;

        System.out.println(obj1.data +" "+ obj2.data);
    }
}
