package io.github.mouday.javanet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class JavaNet {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机地址
        InetAddress localHost1 = InetAddress.getLocalHost();
        System.out.println(localHost1);
        // MacBook-Pro.local/192.168.0.105

        // 获取回环地址
        InetAddress localHost2 = InetAddress.getLoopbackAddress();
        System.out.println(localHost2);
        // localhost/127.0.0.1

        // 根据主机名获取 InetAddress
        InetAddress localHost3 = InetAddress.getByName("www.baidu.com");
        System.out.println(localHost3);
        // www.baidu.com/39.156.66.18

        // 获取主机名
        String hostName = localHost3.getHostName();
        System.out.println(hostName);
        // www.baidu.com

        // 获取主机地址
        String hostAddress = localHost3.getHostAddress();
        System.out.println(hostAddress);
        // 39.156.66.18

    }
}
