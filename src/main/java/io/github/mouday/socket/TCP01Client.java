package io.github.mouday.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCP01Client {
    public static void main(String[] args) throws IOException {
        // 连接
        Socket socket = new Socket("127.0.0.1", 9999);

        // 写入
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello".getBytes());

        // 关闭
        outputStream.close();
        socket.close();

    }
}
