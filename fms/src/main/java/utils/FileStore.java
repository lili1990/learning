package utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by lili19289 on 2016/8/31.
 */
public interface FileStore {

    public  FileStore getInstance();

    public void upload(String bucketName, String fileName, File src) throws IOException;

    public void uploadImage(String bucketName, String fileName, File src)throws IOException;

    public void uploadAudio(String bucketName, String fileName, File src)throws IOException;

    public void uploadFile(String bucketName, String fileName, File src)throws IOException;

    public String getImageUrl(String bucketName, String fileName)throws IOException;

    public String getAudioUrl(String bucketName, String fileName)throws IOException;

    public String getFileUrl(String bucketName, String fileName)throws IOException;

    public String getPath(String bucketName, String fileName)throws IOException;
}
