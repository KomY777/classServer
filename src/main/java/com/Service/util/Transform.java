package com.Service.util;


/**
 *
 * 将时间戳转换为32进制字符
 * @author Kom
 * @date  2023/6/8
 *
 *
 */
public class Transform {
    public static final int RADIX = 36;
    private static final char[] DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String fromDecimal(long num) {
        num = Long.parseLong(reverse(String.valueOf((num))));
        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        while (num >= RADIX) {
            buf[charPos--] = DIGITS[(int) (num % RADIX)];
            num = num / RADIX;
        }
        buf[charPos] = DIGITS[(int) num];

        if (negative) {
            buf[--charPos] = '-';
        }
        return new String(buf, charPos, (65 - charPos));
    }

    public static String reverse(String str) {
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }

}
