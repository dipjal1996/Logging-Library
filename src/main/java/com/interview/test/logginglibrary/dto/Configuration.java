package com.interview.test.logginglibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Configuration {
    private String timestampFormat;
    private Level level;
    private SinkType sinkType;
    private ThreadModel threadModel;
    private WriteMode writeMode;

    Map<String, String> config;

    //ThreadModel and WriteModel fields are optional, so added this partial parameterized constructor.
    public Configuration(String timestampFormat, Level level, SinkType sinkType) {
        this.timestampFormat = timestampFormat;
        this.level = level;
        this.sinkType = sinkType;
        this.threadModel = ThreadModel.SINGLE;
        this.writeMode = WriteMode.SYNC;
        this.config = new HashMap<String, String>();
    }
}
