package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class CloneFile {
    public static void cloneFile(Path path) throws IOException {
        String pathString = String.valueOf(path);
        String pathStr = pathString.substring(0, pathString.length() - 4);
        String[] array = String.valueOf(path).split("\\\\");
        if (new File(pathStr + " - копия.txt").exists()) {
            int n = 2;
            while (new File(String.format(pathStr + " - копия (%d).txt", n)).exists()) {
                ++n;
            }
            Path newPath = Path.of(String.format(pathStr + " - копия (%d).txt", n));
            Files.copy(path, newPath);
        } else {
            Path newPath = Path.of(pathStr + " - копия.txt");
            Files.copy(path, newPath);
        }
    }
}
