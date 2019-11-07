package common.helpers;

public class StringHelper {

    //notes: this checks a string if it is null or empty returns true.
    //otherwise returns false
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    //new helper methods here
    public static boolean isEmail(String s){return s.contains("@") && s.contains(".com");}

    public static boolean isVINlongEnough(String s){return s.length() == 17;}

}
