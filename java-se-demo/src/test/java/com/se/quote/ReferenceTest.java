package com.se.quote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.ref.*;

/**
 * 对 "引用类型" 进行测试
 *
 * @author: lzb
 * @data: 2021-04-04 09:32
 **/
public class ReferenceTest {


    /**
     * 强引用
     */
    @Test
    public void strong(){
        MyObject mo = new MyObject();
        Assertions.assertNotNull(mo,"回收前");
        //引用断开
        mo = null;
        //调用gc()来回收对象
        System.gc();
        Assertions.assertNull(mo,"回收后");
    }

    /**
     * 软引用：非常适合缓存使用
     */
    @Test
    public void soft1(){
        //new MyObject()在堆内存中开辟空间
        //栈内存中的变量mo指向堆内存的空间
        MyObject mo = new MyObject();
        SoftReference softReference = new SoftReference(mo);
        //mo赋为null，表示不指向堆内存中MyObject对象空间，该对象变为"垃圾"
        mo = null;
        System.gc();
        Assertions.assertNotNull(softReference.get(),"没有被回收");
        //创建一个大容量数组，占用堆内存，当堆内存紧张时，调用gc，将会回收软引用
        byte[] bytes = new byte[1024*100];
        System.gc();
//        Assert.assertNull("被回收", softReference.get());
        Assertions.assertNotNull(softReference.get(),"被回收");
    }

    @Test
    public void soft2() throws InterruptedException {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        //m = null;
        System.out.println(m.get());
        System.gc();
        //主线程等待500毫秒，让gc线程运行
        Thread.sleep(500);
        Assertions.assertNotNull(m.get(),"未被回收");

        //再分配一个数组，heap将装不下，这时系统会垃圾回收，先回收一次，
        //如果不够，会把软引用干掉
        byte[] b = new byte[1024*1024*15];
        Assertions.assertNull(m.get(),"已被回收");
    }

    /**
     * 弱引用
     */
    @Test
    public void weak1(){
        MyObject mo = new MyObject();
        WeakReference wr = new WeakReference(mo);
        Assertions.assertNotNull(wr.get(),"未回收");
        System.gc();
        Assertions.assertNotNull(wr.get(),"未回收");
    }

    @Test
    public void weak2(){
        MyObject mo = new MyObject();
        WeakReference wr = new WeakReference(mo);
        mo = null;
        Assertions.assertNotNull(wr.get(),"未回收");
        System.gc();
        Assertions.assertNull(wr.get(),"已回收");
    }

    @Test
    public void weak3(){
        WeakReference<MyObject> wr = new WeakReference<>(new MyObject());
        Assertions.assertNotNull(wr.get(),"未回收");
        System.gc();
        Assertions.assertNull(wr.get(),"已回收");
    }

    /**
     * 虚引用
     */
    @Test
    public void phantom(){
        MyObject mo = new MyObject();
        //创建引用队列
        ReferenceQueue rq = new ReferenceQueue();
        //创建虚引用
        PhantomReference pr = new PhantomReference(mo,rq);
        mo = null;
        //虚引用无法通过pr.get()获取对象
        Assertions.assertNull(pr.get());
        System.gc();
        Assertions.assertNull(pr.get());
    }

}
