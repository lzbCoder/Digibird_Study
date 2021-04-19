package com.spring.test;

import com.spring.controller.AopController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 该类用于对{@code spring}中{@code AOP}思想进行演示
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/19
 */
public class SpringAOPDemo {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext*.xml");
        AopController controller = (AopController) factory.getBean("aopController");
        controller.test();
    }

    /*
      try{
        前置通知；
        环绕通知前；
        目标；
        环绕通知后
        后置通知；
      }catch(Exception e){
        异常通知；
      }finally{
        最终通知；
      }
     */

}
