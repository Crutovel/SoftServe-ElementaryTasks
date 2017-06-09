package com.softserve.edu.task4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStrReplacer extends FileParser {
    private static final String CHARSET = "cp1251";
    private Path filePath;

    public FileStrReplacer(String path) throws FileNotFoundException, IOException {
        super(path);
        filePath = Paths.get(path);
    }

    public boolean replace(String src, String repl) throws IOException {
        Charset charset = Charset.forName(CHARSET);
        Files.write(filePath, new String(Files.readAllBytes(filePath), charset).replace(src, repl).getBytes(charset));
        return true;
    }
}
