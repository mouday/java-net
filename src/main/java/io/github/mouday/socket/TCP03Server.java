package io.github.mouday.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP03Server {
    public static void main(String[] args) throws IOException {

        // 监听
        ServerSocket serverSocket = new ServerSocket(9999);

        // 连接
        Socket socket = serverSocket.accept();

        // IO读取
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String message = bufferedReader.readLine();
        System.out.println(message);

        // IO写入
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello Client");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        // 关闭流
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
