package ClassLPU;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("ClassLPU//message");
        System.out.println(bundle.getString("greetings"));

        bundle = ResourceBundle.getBundle("message", Locale.FRENCH);
        System.out.println(bundle.getString("greetings") + "(" + Locale.FRENCH + ")");

        bundle = ResourceBundle.getBundle("message", Locale.GERMANY);
        System.out.println(bundle.getString("greetings") + "(" + Locale.GERMANY + ")");

        bundle = ResourceBundle.getBundle("message", Locale.CHINA);
        System.out.println(bundle.getString("greetings") + "(" + Locale.CHINA + ")");
    }

}
