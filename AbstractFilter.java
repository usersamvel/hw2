package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    class Readable implements AbstractFilter {

        @Override
        public boolean accept(Path entry) throws IOException {
            return Files.isReadable(entry);
        }

    }

    class Writable implements AbstractFilter {

        @Override
        public boolean accept(Path entry) throws IOException {
            return Files.isWritable(entry);
        }

    }

    class LargerThan implements AbstractFilter {
        long size;

        LargerThan(long s) {
            size = s;
        }

        @Override
        public boolean accept(Path entry) throws IOException {
            return Files.size(entry) > size;
        }
    }

    class Extension implements AbstractFilter {
        String extension;

        public Extension(String e) {
            extension = e;
        }

        @Override
        public boolean accept(Path entry) throws IOException {
            String entryString = String.valueOf(entry);
            return entryString.endsWith(extension);
        }
    }

    class regexContains implements AbstractFilter {
        String regex;

        public regexContains(String r) {
            regex = r;
        }

        @Override
        public boolean accept(Path entry) throws IOException {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(String.valueOf(entry));
            return matcher.find();
        }
    }

    class magicNumber implements AbstractFilter {
        String magic;

        public magicNumber(String r) {
            magic = r;
        }

        @Override
        public boolean accept(Path entry) throws IOException {
            return String.valueOf(entry).startsWith(magic);
        }
    }

    default public AbstractFilter and(AbstractFilter filter) {
        return path -> (this.accept(path) && filter.accept(path));
    }
}
