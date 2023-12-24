package io.github.mouday.upload;

import java.io.*;
import java.net.Socket;

public class UploadClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);

        // 读取图片为字节流
        String sourceFilePath = "./img/source.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        // 输出图片
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);

        // 结束输出
        socket.shutdownOutput();

        // 关闭资源
        bos.close();
        bis.close();
        socket.close();

    }
}
