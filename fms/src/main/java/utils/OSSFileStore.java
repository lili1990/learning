package utils;

import app.main.Configure;
import app.main.Logger;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import org.eclipse.jetty.http.MimeTypes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lili19289 on 2016/8/31.
 */
public class OSSFileStore implements FileStore{

    private static final String ALIYUN_ID = Configure.configuration
            .getProperty("aliyun.id");
    private static final String ALIYUN_SECRET = Configure.configuration
            .getProperty("aliyun.secret");
    private static OSSFileStore instance = new OSSFileStore();
    private static OSSClient ossClient;

    private OSSFileStore() {
        ossClient = new OSSClient("http://oss-cn-hangzhou.aliyuncs.com",
                ALIYUN_ID, ALIYUN_SECRET);
    }

    public  OSSFileStore getInstance() {
        return instance;
    }

    public void upload(String bucketName, String fileName, InputStream is,
                       long contentLength) {
        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentType("");
        objectMeta.setContentLength(contentLength);
        ossClient.putObject(bucketName, fileName, is, objectMeta);
    }

    public InputStream download(String bucketName, String fileName) {
        try {
            return ossClient.getObject(bucketName, fileName).getObjectContent();
        } catch (OSSException e) {
            Logger.error(e, e.toString());
        } catch (ClientException e) {
            Logger.error(e, e.toString());
        }
        return null;
    }


    @Override
    public void upload(String bucketName, String fileName, File src) throws IOException {

    }

    @Override
    public void uploadImage(String bucketName, String fileName, File src) throws IOException {

    }

    @Override
    public void uploadAudio(String bucketName, String fileName, File src) throws IOException {

    }

    @Override
    public void uploadFile(String bucketName, String fileName, File src) throws IOException {

    }

    @Override
    public String getImageUrl(String bucketName, String fileName) throws IOException {
        return null;
    }

    @Override
    public String getAudioUrl(String bucketName, String fileName) throws IOException {
        return null;
    }

    @Override
    public String getFileUrl(String bucketName, String fileName) throws IOException {
        return null;
    }

    @Override
    public String getPath(String bucketName, String fileName) throws IOException {
        return null;
    }
}
