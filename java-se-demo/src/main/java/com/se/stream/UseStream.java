package com.se.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class UseStream {

    public static void main(String[] args) {

        /**
         * Stream流的中间操作
         */
        //使用方式一：筛选与切片
        //使用数组获取流
//        Stream<Integer> stream = Stream.of(1,1,2,2,3,4,5,6,7,8,9);
//        //中间操作
//        Stream<Integer> newStream = stream.filter(s -> s<7) //11223456
//                                          .distinct() //123456
//                                          .skip(2)  //3456
//                                          .limit(3); //345
//        //终止操作
//        newStream.forEach(System.out::println);

        //使用方式二：映射
        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        //使用map()：将每个元素转成一个新的且不带逗号的流
        Stream<String> stream = list.stream().map(s -> s.replaceAll(",",""));
        stream.forEach(System.out::println);
        //使用flatMap()
        Stream<String> stream1 = list.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> stream2 = Arrays.stream(split);
            return stream2;
        });
        stream1.forEach(System.out::println);



    }
}
