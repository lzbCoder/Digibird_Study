package com.se.nio;

import java.nio.*;
public class BufferDemo {

    //Buffer的类型：ByteBuffer、ShortBuffer、IntBuffer、LongBuffer、
    // FloatBuffer、DoubleBuffer、CharBuffer、...

    public static void main(String[] args) {
        //Buffer缓冲区能读能写
        //创建一个字符串，将该字符串写入ByteBuffer缓冲区中
        String data = "hello123";
        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //向缓冲区中写数据(将data中数据写入)
        byteBuffer.put(data.getBytes());

        //写数据
        // 查看byteBuffer的三个属性方法：limit()、capacity()、position()
        //在写数据时：limit和capacity一样，position当前写入数据的位置
        System.out.println("[write] limit = " + byteBuffer.limit()); //1024
        //向缓冲区中写8个字节，position为8，表示该缓冲区写到了第8的字节的位置
        System.out.println("[write] position = " + byteBuffer.position()); //8
        System.out.println("[write] capacity = " + byteBuffer.capacity()); //1024

        //切换模式：读模式
        // limit 能读的数据长度大小
        // position 默认是0的位置开始读
        // capacity 缓冲区容量，不变
        byteBuffer.flip();

        System.out.println("[read] limit = " + byteBuffer.limit()); //8
        System.out.println("[read] position = " + byteBuffer.position()); //0
        System.out.println("[read] capacity = " + byteBuffer.capacity()); //1024

        //将缓冲区中的数据读出来，需要放置到一个容器
        //由于上面定义的是byte缓冲区，因此定义一个byte数组来存放读出来的数据
        int limit = byteBuffer.limit();
        byte[] buff = new byte[limit];

        //开始读数据
        //方式一：按顺序将缓冲区中所有字符读出
//        byteBuffer.get(buff);
//        System.out.println(new String(buff));
        //方式二：读取缓冲区的字符，从第1个字符开始，读取3个字符
        byteBuffer.get(buff,0,3);
        System.out.println("[0-3] = " + new String(buff));

        System.out.println("[read] limit = " + limit); //8
        System.out.println("[read] capacity = " + byteBuffer.capacity()); //1024
        System.out.println("[read] position = " + byteBuffer.position()); //3

        buff = new byte[limit];
        //mark()方法：标记
        byteBuffer.mark();
        //上面已经读到了0-3字符，因此该标记是指在0-3处打的标记
        byteBuffer.get(buff,3,2);
        System.out.println("[3-2] = " + new String(buff));

        System.out.println("[read] limit = " + limit); //8
        System.out.println("[read] capacity = " + byteBuffer.capacity()); //1024
        System.out.println("[read] position = " + byteBuffer.position()); //5

        //表示回到被标记的位置
        byteBuffer.reset();

        System.out.println("[read] limit = " + limit); //8
        System.out.println("[read] capacity = " + byteBuffer.capacity()); //1024
        System.out.println("[read] position = " + byteBuffer.position()); //3

    }
}
