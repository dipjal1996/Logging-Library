package com.interview.test.logginglibrary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.interview.test.logginglibrary.dto.Configuration;
import com.interview.test.logginglibrary.dto.Logger;
import com.interview.test.logginglibrary.exception.LoggerException;
import com.interview.test.logginglibrary.exception.SinkException;
import com.interview.test.logginglibrary.exception.SinkFactoryException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainApplication {

    private Logger initializeLogger(String resourceFilePath) throws SinkFactoryException, SinkException, LoggerException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<Configuration>> typeRef = new TypeReference<List<Configuration>>() {};
        List<Configuration> loggerConfigs = new ArrayList<Configuration>();
        try {
            loggerConfigs = objectMapper.readValue(new File(ClassLoader.getSystemClassLoader().getResource(resourceFilePath).getFile()), typeRef);
        } catch (IOException jpe) {
            throw new RuntimeException("Error while parsing the configuration.yaml file.");
        }
        return new Logger(loggerConfigs);
    }

    private void testLoggerLibrary(String resourceFilePath) throws SinkFactoryException, SinkException, LoggerException {
        Logger logger = initializeLogger(resourceFilePath);
        logger.info("this is a test info log message", this.getClass().getCanonicalName());
        logger.debug("this is a test debug log message", this.getClass().getCanonicalName());
        logger.warn("this is a test warn log message", this.getClass().getCanonicalName());
        logger.error("this is a test error log message", this.getClass().getCanonicalName());
        logger.fatal("this is a test fatal log message", this.getClass().getCanonicalName());
        logger.close();
    }

    public static void main(String[] args) throws LoggerException, SinkFactoryException, SinkException {
        if(args.length < 1) {
            throw new RuntimeException("Configuration yaml file path must provided.");
        }
        new MainApplication().testLoggerLibrary(args[0]);
    }
}
