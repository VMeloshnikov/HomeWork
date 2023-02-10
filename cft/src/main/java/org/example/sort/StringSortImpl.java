package org.example.sort;

import org.example.utils.FileUtil;

import java.io.File;
import java.util.List;

public class StringSortImpl implements MergeSort {


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
            String one = FileUtil.getLine(fileA, i);
            String two = FileUtil.getLine(fileB, j);
            if (one.compareTo(two) < 0) {
                if (!one.contains(" ")) {
                    FileUtil.writeData(one);
                }
                k++;
                i++;
            } else {
                if (!two.contains(" ")) {
                    FileUtil.writeData(two);
                }
                k++;
                j++;
            }
        }

        if (i == countFildFile1) {

            while (j < countFildFile2) {
                String two = FileUtil.getLine(fileB, j);
                if (!two.contains(" ")) {
                    FileUtil.writeData(two);
                }
                k++;
                j++;
            }
        }

        if (j == countFildFile2) {

            while (i < countFildFile1) {
                String one = FileUtil.getLine(fileA, i);

                if (!one.contains(" ")) {
                    FileUtil.writeData(one);
                }
                k++;
                i++;
            }
        }

        FileUtil.closeWriter();

    }

}
