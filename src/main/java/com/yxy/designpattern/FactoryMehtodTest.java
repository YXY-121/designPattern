package com.yxy.designpattern;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 * @author: yxy
 * Date: 2021/4/30
 * Time: 16:00
 * 描述:
 */
public class FactoryMehtodTest {
    public static void main(String args[]){
        factory Meidifactory=new Meidi("美的");
        factory Haierfactory=new Meidi("海尔");
        Meidifactory.produceAirCondition();
        Haierfactory.produceAirCondition();

    }
}

 abstract  class factory{
    String name;
    factory(String name){
        this.name=name;
    }
    public  abstract  void produceAirCondition();
}
class Meidi extends factory{

    Meidi(String name) {
        super(name);
    }

    @Override
    public void produceAirCondition() {
        System.out.println(name+"工厂生产空调");
    }
}
class Haier extends factory{

    Haier(String name) {
        super(name);
    }

    @Override
    public void produceAirCondition() {
        System.out.println(name+"工厂生产空调");
    }
}