package com.interview.test.logginglibrary.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {

    private String content;

    private Level level;

    private String namespace;

    private Timestamp timeStamp;
}
