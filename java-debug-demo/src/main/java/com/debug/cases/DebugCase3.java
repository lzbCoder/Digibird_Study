package com.debug.cases;

/**
 * @program: Digibird_Study
 * @description: 条件断点：右键单击断点处，可以设置进入断点的条件i=300，然后
 *                       点击最左边的(Resume Program F9)，
 *                       让重新开始运行(跳到下一个断点)，
 *                       就可以看到循环直接到i=300处的位置。
 *                      作用：通过设置断点条件，在满足条件时，才停在断点处，否则直接运行
 * @author: lzb
 * @create: 2021-03-28 16:53
 **/
public class DebugCase3 {

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            execute(i);
        }
    }

    private static void execute(int num){
        int rs = ((num + 3) * 5 + 9) / num;
        System.out.println(rs);
    }
}
