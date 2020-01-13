package com.interview.test.logginglibrary.utils;

import com.interview.test.logginglibrary.dto.*;

import java.sql.Timestamp;
import java.util.Date;

public class LoggingUtils {

    public static String getMessageContent(Message message) {
        return message.getLevel().toString() + ": " + message.getNamespace() + ": " + message.getTimeStamp() + " " + message.getContent();
    }

    public static Timestamp getCurrentTimeStamp() {
        Date date = new Date();
        long time = date.getTime();
        return new Timestamp(time);
    }
}
