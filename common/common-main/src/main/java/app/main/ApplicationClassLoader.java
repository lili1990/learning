package app.main;

import app.utils.EnvironmentUtil;

import java.io.File;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by lili19289 on 2016/9/13.
 */
public class ApplicationClassLoader extends ClassLoader {

    static List<Class> allClasses = null;

    /**
     * Try to load all .java files found.
     * @return The list of well defined Class
     */
    public static List<Class> getAllClasses() {
        if (allClasses == null) {
            allClasses = new ArrayList<Class>();
        }
        try {
            String classPath = EnvironmentUtil.getClassPath();
            allClasses = getAllClasses(classPath);
        }catch (Exception e){
            Logger.error("get all classes failed.....",e);
            return null;
        }
        return allClasses;
    }



    static List<Class> getAllClasses(String basePackage) throws ClassNotFoundException{
        List<Class> classes = new ArrayList<Class>();
        File file = new File(basePackage);
        for (File childrenFile : file.listFiles()) {
            scan(classes, basePackage, childrenFile);
        }
        return classes;
    }

   static void scan(List<Class> classes, String packageName, File current) throws ClassNotFoundException {
        if (!current.isDirectory()) {
            String fileName = current.getPath();
            String classname="";
            if (fileName.endsWith(".class") && !fileName.startsWith(".")) {
                classname = fileName.substring(fileName.indexOf("classes")+8, fileName.length() - 6);
                classname = classname.replace("\\.class", "").replace("\\", ".").replaceAll("/",".");
                Class<?> classObject = Class.forName(classname);
                classes.add(Class.forName(classname));
            }
        } else {
            for (File file : current.listFiles()) {
                scan(classes, packageName + current.getName() + ".", file);
            }
        }
    }

    public static void main(String[] args) {
        getAllClasses();
    }

}