package com.ajavac.util;

import org.joda.time.DateTime;

import java.util.Random;

public final class FileName {

    private static final Random random = new Random();

    private static final String separator = "_";

    private static final String COMMON_DATE = "yyyyMMddHHmmssSSS";

    private FileName() {}

    public static String random(String head, String extension) {
        return head + separator + random(extension);
    }

    public static String random(String extension) {
        return timeStamp() + separator + nextInt() + extension;
    }


    private static String nextInt() {
        return random.nextInt(999) + "";
    }

    private static String timeStamp() {
        return DateTime.now().toString(COMMON_DATE);
    }

}
