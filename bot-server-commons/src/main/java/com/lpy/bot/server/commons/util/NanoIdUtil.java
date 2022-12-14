package com.lpy.bot.server.commons.util;

import java.security.SecureRandom;
import java.util.Random;

public final class NanoIdUtil {
    private static final SecureRandom DEFAULT_NUMBER_GENERATOR = new SecureRandom();

    private static final char[] DEFAULT_ALPHABET = "0123456789".toCharArray();

    private static final int DEFAULT_SIZE = 20;

    private NanoIdUtil() {

    }

    /**
     * 默认生成NanoId 二十位纯数字
     * @return 20位纯数字NanoId
     */
    public static String randomNanoId() {
        return randomNanoId(DEFAULT_NUMBER_GENERATOR, DEFAULT_ALPHABET, DEFAULT_SIZE);
    }

    /**
     *
     * @param random 随机random
     * @param alphabet 字符集
     * @param size 长度
     * @return 指定的NanoId
     */
    public static String randomNanoId(Random random, char[] alphabet, int size) {
        if (random == null) {
            throw new IllegalArgumentException("random cannot be null");
        }
        if (alphabet == null) {
            throw new IllegalArgumentException("alphabet cannot be null");
        }
        if (alphabet.length != 0 && alphabet.length < 256) {
            if (size <= 0) {
                throw new IllegalArgumentException("size cannot be less then 0");
            } else {
                int mask = (2 << (int) Math.floor(Math.log((double) (alphabet.length - 1)) / Math.log(2.0D))) - 1;
                int step = (int) Math.ceil(1.6D * (double) mask * (double) size / (double) alphabet.length);
                StringBuilder idBuilder = new StringBuilder();

                while (true) {
                    byte[] bytes = new byte[step];
                    random.nextBytes(bytes);

                    for (int i = 0; i < step; ++i) {
                        int alphabetIndex = bytes[i] & mask;
                        if (alphabetIndex < alphabet.length) {
                            idBuilder.append(alphabet[alphabetIndex]);
                            if (idBuilder.length() == size) {
                                return idBuilder.toString();
                            }
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("size must between 1 and 256");
        }
    }
}
