package app.utils;

/**
 * Created by lili19289 on 2016/8/15.
 */
public class EnvivironmentUtil {

    public static boolean isOnWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.indexOf("win") >= 0;
    }

    public static String getClassPath(){
        return  Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    public static String getSystemPath(){
        return System.getProperty("user.dir");
    }
}
