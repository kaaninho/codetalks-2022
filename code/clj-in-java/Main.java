import clj.stuff;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World from Java!");

        String transformResult = clj.stuff.transform("hello world");

        System.out.println(transformResult);
    }
}
