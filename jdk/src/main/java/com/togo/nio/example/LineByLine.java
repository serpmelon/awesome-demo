package com.togo.nio.example;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : taiyn
 * Date    : 2021/3/2
 * Time    : 8:52 上午
 * ---------------------------------------
 * Desc    :
 */
public class LineByLine {

    public static void main(String[] args) {

        Path path = Paths.get("./jdk/src/main/resources", "test.txt");
        System.out.println(path.toAbsolutePath());

        try(Stream<String> lines = Files.lines(path)) {
            List<String> list = lines.collect(Collectors.toList());
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
