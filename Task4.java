package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;

public class Task4 {
    public void maim(String[] args) throws IOException {
        OutputStream stream = Files.newOutputStream(Path.of("C:\\Users\\Lenovo\\Desktop\\te.txt"));
        Checksum checksum = new CRC32();
        OutputStream stream1 = new CheckedOutputStream(stream, checksum);
        BufferedOutputStream stream2 = new BufferedOutputStream(stream1);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(stream2, StandardCharsets.UTF_8);
        PrintWriter printWriter = new PrintWriter(String.valueOf(stream2), StandardCharsets.UTF_8);
        printWriter.print("Programming is learned by writing programs. ― Brian Kernighan");
        printWriter.close();
    }
}
