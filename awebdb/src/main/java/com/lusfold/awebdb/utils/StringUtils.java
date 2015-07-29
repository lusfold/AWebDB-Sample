package com.lusfold.awebdb.utils;

/**
 * @author <a href="http://www.lusfold.com" target="_blank">Lusfold</a>
 */
public class StringUtils {
    /**
     * @param str
     * @return if string is null or it's length equals 0 except space,return true,else return false.
     */
    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * @param str
     * @return if string is not null and it's length do not equals 0 except space,return true,else return false.
     */
    public static boolean isNotBlank(String str) {
        return !(str == null || str.trim().length() == 0);
    }

    /**
     * @param str
     * @return if string is  null or it's length equals 0,return true,else return false.
     */
    public static boolean isEmpty(CharSequence str) {
        return (str == null || str.length() == 0);
    }

    /**
     * @param str
     * @return if string is not null and it's length do not equals 0,return true,else return false.
     */
    public static boolean isNotEmpty(CharSequence str) {
        return !(str == null || str.length() == 0);
    }

    /**
     * @param str
     * @return if sql string is not empty and starts with select.
     */
    public static boolean isSelectStr(String str) {
        return (isNotEmpty(str) && str.toUpperCase().startsWith("SELECT"));
    }
}
