package com.debug.cases;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: Digibird_Study
 * @description: 调试案例：并发修改异常
 *               回退断点(Drop Frame)：
 *                     回退到当前方法的调用处，当想重新查看该方法的执行过程时，
 *                     不用重新启动Debug，可以使用回退断点方法。
 *               运行到光标处(Run to Cursor Alt+F9)：
 *                     使程序运行到光标处，而无需设置断点
 * @author: lzb
 * @create: 2021-03-28 15:22
 **/
public class DebugCase1 {

    public static void main(String[] args) {
        System.out.println("begin...");
        operatorList();
        System.out.println("end...");
    }

    private static void operatorList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("zs1");
        list.add("zs2");
        list.add("zs3");
        list.add("zs4");
        //获取集合迭代器
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            if(name.equals("zs3")){
                //改变集合元素个数
                list.add("ls3");
            }
        }
    }

}
