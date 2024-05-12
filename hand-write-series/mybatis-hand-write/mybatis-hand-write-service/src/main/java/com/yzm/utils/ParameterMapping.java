package com.yzm.utils;

public class ParameterMapping {

    private String content;

    private ParameterMapping() {
    }

    public ParameterMapping(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
