package io.github.mouday.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        // 读取图片字节数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        // 保存图片
        String outFilePath = "./img/target.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFilePath));
        bos.write(bytes);

        // 关闭流
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();

    }
}
