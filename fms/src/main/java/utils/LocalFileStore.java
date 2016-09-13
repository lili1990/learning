package utils;


import java.io.File;
import java.io.IOException;

import app.main.Configure;
import org.apache.commons.io.FileUtils;
/**
 * Created by lili19289 on 2016/8/31.
 */
public class LocalFileStore implements FileStore{

    private static final String BASE_PIC_DIR = Configure.configuration.getProperty(
            "application.fileStore", "/data/fileStore");
    private static LocalFileStore instance = new LocalFileStore();

    private LocalFileStore() {
    }

    public  LocalFileStore getInstance() {
        return instance;
    }

    public void upload(String bucketName, String fileName, File src)
            throws IOException {
        File saveFile = new File(BASE_PIC_DIR + bucketName, fileName);
        FileUtils.copyFile(src, saveFile);
    }

    public void uploadImage(String bucketName, String fileName, File src)
            throws IOException {
        File saveFile = new File(BASE_PIC_DIR + bucketName + "/image/",
                fileName);
        FileUtils.copyFile(src, saveFile);
    }

    public void uploadAudio(String bucketName, String fileName, File src)
            throws IOException {
        File saveFile = new File(BASE_PIC_DIR + bucketName + "/audio/",
                fileName);
        FileUtils.copyFile(src, saveFile);
    }

    public void uploadFile(String bucketName, String fileName, File src)
            throws IOException {
        File saveFile = new File(BASE_PIC_DIR + bucketName + "/file/", fileName);
        FileUtils.copyFile(src, saveFile);
    }

    public String getImageUrl(String bucketName, String fileName) {
        return Configure.configuration.getProperty("application.baseUrl") + "fms/"
                + bucketName + "/image/" + fileName;
    }

    public String getAudioUrl(String bucketName, String fileName) {
        return Configure.configuration.getProperty("application.baseUrl") + "fms/"
                + bucketName + "/audio/" + fileName;
    }

    public String getFileUrl(String bucketName, String fileName) {
        return Configure.configuration.getProperty("application.baseUrl") + "fms/"
                + bucketName + "/file/" + fileName;
    }

    public String getPath(String bucketName, String fileName) {
        return Configure.configuration.getProperty("application.baseDIR") + "/"
                + bucketName + "/" + fileName;
    }
}
