package com.interview.test.logginglibrary.dto;

import com.interview.test.logginglibrary.exception.SinkException;

import java.io.IOException;
import java.util.Map;

//To be implemented
public class DatabaseSink implements ISink {

    public void init(Map<String, String> config) {
    }

    public void emit(Message message) throws SinkException {
    }

    public void close() throws SinkException {
    }
}
