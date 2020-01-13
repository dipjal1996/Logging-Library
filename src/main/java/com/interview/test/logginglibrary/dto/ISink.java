package com.interview.test.logginglibrary.dto;

import com.interview.test.logginglibrary.exception.SinkException;

import java.util.Map;

public interface ISink {

    void init(Map<String, String> config) throws SinkException;

    void emit(Message message) throws SinkException;

    void close() throws SinkException;
}
