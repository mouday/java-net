package io.github.mouday.socket;

import java.io.*;
import java.net.Socket;

public class TCP03Client {
    public static void main(String[] args) throws IOException {
        // 连接
        Socket socket = new Socket("127.0.0.1", 9999);

        // 写入
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello Server");
        // 换行结束
        bufferedWriter.newLine();
        // 手动刷入数据
        bufferedWriter.flush();


        // 读取
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String message = bufferedReader.readLine();
        System.out.println(message);

        // 关闭外层流
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();

    }
}
