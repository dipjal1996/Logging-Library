package com.interview.test.logginglibrary.dto;


import com.interview.test.logginglibrary.exception.LoggerException;
import com.interview.test.logginglibrary.exception.SinkException;
import com.interview.test.logginglibrary.exception.SinkFactoryException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.interview.test.logginglibrary.utils.LoggingUtils.getCurrentTimeStamp;

public class Logger {

    private Map<Level, ISink> levelToSinkMap;

    public Logger(List<Configuration> loggerConfig) throws LoggerException, SinkFactoryException, SinkException  {
        levelToSinkMap = new HashMap<Level, ISink>();
        for(Configuration configuration : loggerConfig) {
            Level level = configuration.getLevel();
            ISink sink = SinkFactory.getSink(configuration.getSinkType());
            sink.init(configuration.getConfig());
            levelToSinkMap.put(level, sink);
        }
    }

    private void log(String messageContent, Level level, String namespace) throws LoggerException, SinkException {
        if(!levelToSinkMap.containsKey(level)) {
            throw new LoggerException("Sink not found for the given logging level.");
        }
        ISink sink = levelToSinkMap.get(level);
        Message message = new Message();
        message.setContent(messageContent);
        message.setLevel(level);
        message.setNamespace(namespace);
        message.setTimeStamp(getCurrentTimeStamp());
        sink.emit(message);
    }

    public void debug(String messageContent, String namespace) throws LoggerException, SinkException {
        log(messageContent, Level.DEBUG, namespace);
    }

    public void info(String messageContent, String namespace) throws LoggerException, SinkException {
        log(messageContent, Level.INFO, namespace);
    }

    public void warn(String messageContent, String namespace) throws LoggerException, SinkException {
        log(messageContent, Level.WARN, namespace);
    }

    public void error(String messageContent, String namespace) throws LoggerException, SinkException {
        log(messageContent, Level.ERROR, namespace);
    }

    public void fatal(String messageContent, String namespace) throws LoggerException, SinkException {
        log(messageContent, Level.FATAL, namespace);
    }

    public void close() throws SinkException {
        for(Map.Entry<Level, ISink> entry : levelToSinkMap.entrySet()) {
            entry.getValue().close();
        }
    }
}
