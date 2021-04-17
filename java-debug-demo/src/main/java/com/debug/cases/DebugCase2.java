package com.debug.cases;

import com.debug.entry.User;

/**
 * @program: Digibird_Study
 * @description: 计算表达式(Alt+F8)：设置变量，在计算表达式的框里，可以改变变量的值，
 *                                 这样有时候就能很方便我们去调试各种值的情况。
 * @author: lzb
 * @create: 2021-03-28 16:35
 **/
public class DebugCase2 {

    public static void main(String[] args) {
        User user = new User("张三", "123456", "超级管理员");
        login(user);
    }

    private static void login(User user){
        String userType = user.getUserType();
        switch (userType){
            case "超级管理员":
                System.out.println("超级管理员业务逻辑");
                break;
            case "董事长":
                System.out.println("董事长业务逻辑");
                break;
            case "经理":
                System.out.println("经理业务逻辑");
                break;
            case "员工":
                System.out.println("员工业务逻辑");
                break;
            default:
                System.out.println("角色不存在");
                break;

        }
    }
}
