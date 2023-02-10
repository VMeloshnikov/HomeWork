package org.example.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {
    public static String resultFileName;
    private final static String DIR = "data";
    private static FileWriter writer;

    public static long countLines(File filePath) {
        long countLine;
        try (Stream<String> lines = Files.lines(filePath.toPath())) {
            countLine = lines.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countLine;
    }

    public static String getLine(File file, long index) {
        String extractedLine;
        try (Stream<String> lines = Files.lines(file.toPath())) {
            extractedLine = lines.skip(index).findFirst().get();
//            System.out.println(extractedLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return extractedLine;
    }


    public static void openWriter() {
        try {
            File file = new File(resultFileName);
            file.createNewFile();
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeData(String data) {
        try {
//            System.out.println(data);
            writer.write(data + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeWriter() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
