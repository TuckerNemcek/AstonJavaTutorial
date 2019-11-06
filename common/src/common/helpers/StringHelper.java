package common.helpers;

public class StringHelper {

    //notes: this checks a string if it is null or empty returns true.
    //otherwise returns false
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

}
