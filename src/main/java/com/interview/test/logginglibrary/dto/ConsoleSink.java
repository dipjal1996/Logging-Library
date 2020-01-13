package com.interview.test.logginglibrary.dto;

import com.interview.test.logginglibrary.exception.SinkException;
import com.interview.test.logginglibrary.utils.LoggingUtils;

import java.util.Map;

public class ConsoleSink implements ISink {

    public void init(Map<String, String> config) {
    }

    public void emit(Message message) throws SinkException {
        System.out.println(LoggingUtils.getMessageContent(message));
    }

    public void close() throws SinkException {
    }
}
