package io.github.mouday.upload;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于演示关于流的读写方法 *
 */
public class StreamUtils {
    /**
     * 功能:将输入流转换成 byte[] * @param is
     *
     * @return
     * @throws Exception
     */

    public static byte[] streamToByteArray(InputStream is) throws Exception {
        // 创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1) {
            bos.write(buf, 0, len);
        }

        byte[] array = bos.toByteArray();

        bos.close();

        return array;
    }

    /**
     * 功能:将 InputStream 转换成 String * @param is
     *
     * @return
     * @throws Exception
     */
    public static String streamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            //当读取到 null 时，就表示结束
            builder.append(line + "\r\n");
        }

        return builder.toString();
    }
}