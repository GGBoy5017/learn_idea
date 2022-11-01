package org.example;

import java.util.*;
/**
 * 名称A2018上生成器
 * 描述
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2022-11-01 16:27
 */

class Product{
    private String partA;
    private String partB;
    public Product(){}

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }
}

interface Builder{
    public void buildPartA();
    public void buildPartB();
    public Product getResult();
}

class ConcreteBuilder1 implements Builder{

    private Product product;
    @Override
    public void buildPartA() {

    }

    @Override
    public void buildPartB() {

    }

    @Override
    public Product getResult() {
        return product;
    }
}

class ConcreteBuilder2 implements Builder{

    private Product product;
    @Override
    public void buildPartA() {

    }

    @Override
    public void buildPartB() {

    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Director{
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }
    public void construct(){
        builder.buildPartA();
        builder.buildPartB();
        Product product=builder.getResult();
    }
}

public class A2018上生成器 {
    public static void main(String[] args) {
        Director director=new Director(new ConcreteBuilder1());
        director.construct();
    }
}
