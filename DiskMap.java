package edu.hw6;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiskMap implements Map<String, String> {
    Map<String, String> dm;
    String name;
    Path path;

    public DiskMap(String name) throws IOException {
        this.name = name;
        path = Files.createFile(Paths.get("C:\\" + name + ".txt"));
        this.dm = new HashMap<>();
    }

    @Override
    public int size() {
        return dm.size();
    }

    @Override
    public boolean isEmpty() {
        return dm.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return dm.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return dm.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return dm.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        dm.put(key, value);
        List<String> keyValue = new ArrayList<>();
        keyValue.add(key + " : " + value);
        try {
            Files.write(path, keyValue, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String remove(Object key) {
        dm.remove(key);
        BufferedReader b = null;
        try {
            b = new BufferedReader(new FileReader(String.valueOf(path)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Path pathTemp = Files.createFile(Paths.get("C:\\" + name + "Temp" + ".txt"));
            try {
                String line = b.readLine();
                Pattern format = Pattern.compile("^" + key + " : ");
                while (line != null) {
                    Matcher matcher = format.matcher(line);
                    if (!matcher.find()) {
                        System.out.println(line);
                        ArrayList<String> Line = new ArrayList<>();
                        Line.add(line);
                        Files.write(pathTemp, Line, StandardOpenOption.APPEND);
                    }
                    line = b.readLine();
                }
                b.close();
                Files.move(
                    pathTemp,
                    path,
                    StandardCopyOption.REPLACE_EXISTING
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        for (String key : m.keySet()) {
            this.put(key, m.get(key));
        }
    }

    @Override
    public void clear() {
        this.dm.clear();
        try {
            Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return dm.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return dm.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return dm.entrySet();
    }
}
