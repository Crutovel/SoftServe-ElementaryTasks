package com.softserve.edu.task4;

public abstract class FileParser {
    protected String path;

    protected FileParser(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
