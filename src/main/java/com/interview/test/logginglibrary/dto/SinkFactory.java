package com.interview.test.logginglibrary.dto;

import com.interview.test.logginglibrary.exception.SinkFactoryException;

public class SinkFactory {

    public static ISink getSink(SinkType sinkType) throws SinkFactoryException {
        switch (sinkType) {
            case FILE:
                return new FileSink();
            case DB:
                return new DatabaseSink();
            case CONSOLE:
                return new ConsoleSink();
            default:
                throw new SinkFactoryException("Sink implementation not found for the given sink type.");
        }
    }
}