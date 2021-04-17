package com.se.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {

    public static void main(String[] args) throws IOException {

        //Channel中有基于文件的通道(FileChannel)、
        //基于网络传输的通道(ServerSocketChannel)、
        //基于UDP协议的通道(DatagramChannel)等。

        //以最常用的基于文件的通道FileChannel为例，实现文件拷贝
        //文件拷贝方式：直接内存拷贝、通道传输、分散和聚集、截断、加锁
        copy1();
    }


    /**
     * 文件拷贝
     * @throws FileNotFoundException
     */
    public static void copy1() throws IOException {
        FileInputStream fis = new FileInputStream("G:\\test.txt");
        FileOutputStream fos = new FileOutputStream("Q:\\test1.txt");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        //通道本身是不能做数据的传输，需要结合buffer
        //定义一个1024字节的缓冲区
        ByteBuffer buff = ByteBuffer.allocate(1024);

        //将inChannel中的数据读取到缓冲区中,如果缓冲区中一直有数据，那么就写到outChannel中
        //此时buff是写模式
        while (inChannel.read(buff) != -1){
            //切换buff模式，切换成读模式
            buff.flip();
            //将buff中的数据写入到outChannel中
            outChannel.write(buff);
            //每次清空buff中的数据
            buff.clear();
        }
        //关闭流
        fis.close();
        fos.close();
        inChannel.close();
        outChannel.close();
    }



}
