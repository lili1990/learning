package com.lili.nio.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lili
 * @date 2018/6/26
 * @description
 */
public class FileUtil {


    public static void main(String[] args) throws Exception{
        File srcFile = new File("/Users/lili/Downloads/test.sql");
        File destFile = new File("/Users/lili/Downloads/1.sql/");
        long start = System.currentTimeMillis();
        fileCopyNormal(srcFile,destFile);
        System.out.println(System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        fileCopyWithFileChannel(srcFile,new File("/Users/lili/Downloads/2.sql"));
        System.out.println(System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        fileCopyWithBuffer(srcFile,new File("/Users/lili/Downloads/3.sql"));
        System.out.println(System.currentTimeMillis()-start);


    }

    /**
     * 普通的文件复制方法
     *
     * @param fromFile 源文件
     * @param toFile   目标文件
     * @throws FileNotFoundException 未找到文件异常
     */
    public static void fileCopyNormal(File fromFile, File toFile) throws FileNotFoundException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(fromFile));
            outputStream = new BufferedOutputStream(new FileOutputStream(toFile));
            byte[] bytes = new byte[1024];
            int i;
            //读取到输入流数据，然后写入到输出流中去，实现复制
            while ((i = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeCloseable(inputStream);
                closeCloseable(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用read方法从通道读取数据到缓冲区，使用write将缓冲区的数据写入到通道中
     * @param fromFile
     * @param toFile
     */
    public static void fileCopyWithBuffer(File fromFile, File toFile) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannelInput = null;
        FileChannel fileChannelOutput = null;
        try{

            fileInputStream = new FileInputStream(fromFile);
            fileOutputStream = new FileOutputStream(toFile);
            //得到fileInputStream的文件通道
            fileChannelInput = fileInputStream.getChannel();
            //得到fileOutputStream的文件通道
            fileChannelOutput = fileOutputStream.getChannel();

            //分配buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (fileChannelInput.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    fileChannelOutput.write(buffer);
                }
                buffer.clear();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                closeCloseable(fileInputStream,fileOutputStream,fileChannelInput,fileChannelOutput);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 用filechannel进行文件复制
     *
     * @param fromFile 源文件
     * @param toFile   目标文件
     */
    public static void fileCopyWithFileChannel(File fromFile, File toFile) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannelInput = null;
        FileChannel fileChannelOutput = null;
        try {
            fileInputStream = new FileInputStream(fromFile);
            fileOutputStream = new FileOutputStream(toFile);
            //得到fileInputStream的文件通道
            fileChannelInput = fileInputStream.getChannel();
            //得到fileOutputStream的文件通道
            fileChannelOutput = fileOutputStream.getChannel();
            //将fileChannelInput通道的数据，写入到fileChannelOutput通道
            fileChannelInput.transferTo(0, fileChannelInput.size(), fileChannelOutput);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                closeCloseable(fileInputStream,fileOutputStream,fileChannelInput,fileChannelOutput);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeCloseable(Closeable... closeableArray) throws IOException {
        for(Closeable closeable :closeableArray) {
            if (closeable != null) {
                closeable.close();
            }
        }

    }
}
