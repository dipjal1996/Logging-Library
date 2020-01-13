package com.interview.test.logginglibrary.dto;

import com.interview.test.logginglibrary.exception.SinkException;
import com.interview.test.logginglibrary.utils.LoggingUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static com.interview.test.logginglibrary.dto.Constants.FILE_LOCATION_LABEL;

public class FileSink implements ISink {

    FileWriter fileWriter;

    public void init(Map<String, String> config) throws SinkException {
        try {
            fileWriter = new FileWriter(config.get(FILE_LOCATION_LABEL));
        } catch (IOException e) {
            throw new SinkException(e.getMessage());
        }
    }

    public void emit(Message message) throws SinkException {
        try {
            fileWriter.write(LoggingUtils.getMessageContent(message));
            fileWriter.write("\n");
        } catch (IOException e) {
            throw new SinkException(e.getMessage());
        }
    }

    public void close() throws SinkException {
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new SinkException(e.getMessage());
        }
    }
}
