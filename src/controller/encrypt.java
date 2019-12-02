package controller;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class encrypt {

    /**

    * ����char����,16���ƶ�Ӧ�Ļ����ַ�

    */

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',

        'e', 'f' };

 

    /**

    * md5����

    * @param str ��Ҫ���ܵ�����

    * @return ���ܽ��

    * @author sucb

    * @date 2017��7��26������5:12:16

    */

    public static String getMD5String(String str) {

        MessageDigest messageDigest = null;

        try {

            messageDigest = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

            return null;

        }

        messageDigest.update(str.getBytes());

        return byteArray2HexString(messageDigest.digest());

    }

 

    /**

    * MD5���ܽ������byteת����String��

    * @param bytes md5���ܺ�õ�������

    * @return md5���ܽ��

    * @author sucb

    * @date 2017��7��26������5:12:09

    */

    private static String byteArray2HexString(byte[] bytes) {

        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {

            sb.append(HEX_DIGITS[(b & 0xf0) >> 4]).append(HEX_DIGITS[(b & 0x0f)]);

        }

        return sb.toString();

    }

 

    /**

    * ���Է���

    * @param args

    * @author sucb

    * @date 2017��7��26������5:11:50

    */

}
