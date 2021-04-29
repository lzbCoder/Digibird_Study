package com.lzb.model.simplefactory;

/**
 * 该类用于测试简单工厂模式
 *
 * @author lzb
 * @version 1.0
 * @since 2021/4/19
 */
public class TestMain {

    public static void main(String[] args) {
        /**
         * 方式一：当只有烧烤店A和烧烤店B时，用户选择其中一个
         *        缺点：多个烧烤店不易管理，如，烧烤店A挂着烧烤店的牌子，但里面却买鸡肉。
         *             如果这样的话，造成用户去买烤肉时出现差错。
         *        改进(方式二)：让每个烧烤店都有一个营业执照，目的是让烧烤店只能卖烧烤。
         *        实现的方式是父类引用指向子类对象。
         */
//        BarbecueShopA shopA = new BarbecueShopA();
//        shopA.saleKebab();
//        BarbecueShopB shopB = new BarbecueShopB();
//        shopB.saleKebab();
        /**
         * 方式二：缺点，虽然让两个烧烤店都有了卖烧烤的"营业执照"，但当用户调用时，不但
         *            知道了接口(规则)，同时还暴露了具体的实现类，按照之前的设计原则，
         *            违背了一个封装隔离的思想。
         *       改进(方式三)：想要把用户和真实的店隔离开，用户应该可以看见接口(规则),
         *                   但不应该知道是哪个具体类实现的。按照这种封装隔离的思想，
         *                   将具体的类包装起来，需要中间单独设置一个类，该类就是
         *                   Factory。
         */
//        Barbecue shopA = new BarbecueShopA();
//        shopA.saleKebab();
//        Barbecue shopB = new BarbecueShopB();
//        shopB.saleKebab();

        /**
         * 方式三：简单工厂方式(静态工厂方法)。想要什么对象，只需要向工厂要，
         * 就会返回一个烧烤店，该烧烤店是一个接口，用户并不知道是哪个具体的烧烤店。
         */
        Barbecue shopA = BarbecueFactory.getBarbecue("烧烤店A");
        shopA.saleKebab();
        Barbecue shopB = BarbecueFactory.getBarbecue("烧烤店B");
        shopB.saleKebab();
    }
}
