package io.github.mouday.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP01Server {
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

        // 关闭
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
