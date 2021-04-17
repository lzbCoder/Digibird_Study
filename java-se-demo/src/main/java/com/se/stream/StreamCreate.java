package com.se.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamCreate {

    public static void main(String[] args) throws FileNotFoundException {

        /*
          创建流的方式
         */
        //方式一：使用Collection下的stream()和parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        //方式二：使用Arrays 中的 stream() 方法，将数组转成流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //方式三：使用Stream中的静态方法：of()、iterate()、generate()
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
        Stream stream3 = Stream.iterate(0, (x) -> x+2).limit(6);
        stream3.forEach(System.out::println); //0,2,4,6,8,10
        Stream<Double> stream4 = Stream.generate(Math :: random).limit(2);
        stream4.forEach(System.out::println);

        //方式四：使用 BufferedReader.lines() 方法，将每行内容转成流
        BufferedReader reader = new BufferedReader(new FileReader("G:\\text.txt"));
        Stream<String> lineStream = reader.lines();
        lineStream.forEach(System.out::println);

        //方式五：使用 Pattern.splitAsStream() 方法，将字符串分隔成流
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("e,t,y,q");
        stringStream.forEach(System.out::println);

    }
}
