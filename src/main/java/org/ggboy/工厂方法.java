package org.ggboy;

/**
 * 名称工厂方法
 * 描述
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2022-11-01 20:15
 */

interface Product{
    public void excute();
}

class ConcreteProduct implements Product{
    @Override
    public void excute() {

    }
}
abstract class Creator{
    protected abstract Product factoryMethod();
    public void oprete(){
        Product product=factoryMethod();
    }
}

class ConcreteCreator extends Creator{
    @Override
    protected Product factoryMethod() {
        return new ConcreteProduct();
    }
}

public class 工厂方法 {
    public static void main(String[] args) {

    }
}
