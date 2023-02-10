package org.example.sort;

import org.example.utils.FileUtil;

import java.io.File;
import java.util.List;

public class IntSortImpl implements MergeSort {
    private String regex = "\\d+";

    public void mergeSort(List<File> files) {
        File fileA = files.get(0);
        File fileB = files.get(1);
        long countFildFile1 = FileUtil.countLines(fileA);
        long countFildFile2 = FileUtil.countLines(fileB);
        int i = 0;
        int j = 0;
        int k = 0;
        FileUtil.openWriter();
        while (i < countFildFile1 && j < countFildFile2) {
            Integer one = parseInt(FileUtil.getLine(fileA, i));
            Integer two = parseInt(FileUtil.getLine(fileB, j));

            if (one != null & two != null) {
                if (one.compareTo(two) < 0) {
                    FileUtil.writeData(one.toString());
                    k++;
                    i++;
                } else {
                    FileUtil.writeData(two.toString());
                    k++;
                    j++;
                }
            } else if (one == null & two != null) {
                k++;
                i++;
            } else if (one != null & two == null) {
                k++;
                j++;
            }
        }

        if (i == countFildFile1) {
            while (j < countFildFile2) {
                Integer two = parseInt(FileUtil.getLine(fileB, j));
                if (two != null) {
                    FileUtil.writeData(two.toString());
                }
                k++;
                j++;
            }
        }

        if (j == countFildFile2) {

            while (i < countFildFile1) {
                Integer one = parseInt(FileUtil.getLine(fileA, j));
                if (one != null) {
                    FileUtil.writeData(one.toString());
                }
                k++;
                i++;
            }
        }
        FileUtil.closeWriter();
    }

    private Integer parseInt(String string) {
        Integer rezult = null;
        if (string.matches(regex) & !string.contains(" ")) {
            rezult = Integer.parseInt(string);
        }
        return rezult;
    }
}
