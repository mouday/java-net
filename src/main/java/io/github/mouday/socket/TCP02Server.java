package io.github.mouday.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP02Server {
    public static void main(String[] args) throws IOException {

        // 监听
        ServerSocket serverSocket = new ServerSocket(9999);

        // 连接
        Socket socket = serverSocket.accept();

        // IO读取
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len;

        while ((len = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        // IO写入
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client".getBytes());

        // 结束写入
        socket.shutdownOutput();

        // 关闭
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
