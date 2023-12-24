package io.github.mouday.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCP02Client {
    public static void main(String[] args) throws IOException {
        // 连接
        Socket socket = new Socket("127.0.0.1", 9999);

        // 写入
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Server".getBytes());

        // 结束写入
        socket.shutdownOutput();

        // 读取
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len;

        while ((len = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        // 关闭
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
