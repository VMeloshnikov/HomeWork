package org.example;

import org.example.sort.IntSortImpl;
import org.example.sort.MergeSort;
import org.example.sort.StringSortImpl;
import org.example.utils.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<File> files = new ArrayList<>();
        String param = "i";
        MergeSort sort;
        //тип данных
        if (Arrays.stream(args).skip(0).findFirst().get().equalsIgnoreCase("-i")) {
            sort = new IntSortImpl();
        } else {
            sort = new StringSortImpl();
        }
        FileUtil.resultFileName = (Arrays.stream(args).skip(1).findFirst().get().substring(1));
        files.add(new File(Arrays.stream(args).skip(2).findFirst().get().substring(1)));
        files.add(new File(Arrays.stream(args).skip(3).findFirst().get().substring(1)));

        sort.mergeSort(files);
    }
}