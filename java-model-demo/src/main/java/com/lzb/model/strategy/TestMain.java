package com.lzb.model.strategy;

public class TestMain {

    public static void main(String[] args) {
        //1.定义一个策略
        Strategy strategyA = new ConcreteStrategyA();
        //2.定义一个环境，使用上面的策略
        Context context = new Context(strategyA);
        //3.调用方法
        context.strategyMethod();
    }
}
