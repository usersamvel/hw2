package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CloneFile {
    static final int FOUR = 4;
    static final String COPY = " - копия.txt";
    static final String COPYD = " - копия (%d).txt";

    void cloneFile(Path path) throws IOException {
        String pathString = String.valueOf(path);
        String pathStr = pathString.substring(0, pathString.length() - FOUR);
        String[] array = String.valueOf(path).split("\\\\");
        if (new File(pathStr + COPY).exists()) {
            int n = 2;
            while (new File(String.format(pathStr + COPYD, n)).exists()) {
                ++n;
            }
            Path newPath = Path.of(String.format(pathStr + COPYD, n));
            Files.copy(path, newPath);
        } else {
            Path newPath = Path.of(pathStr + COPY);
            Files.copy(path, newPath);
        }
    }
}
