package com.yxy.designpattern.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author: yxy
 * Date: 2021/5/11test
 * Time: 17:21
 * 描述:
 */
class  test {
    public static void main(String args[]){
        Observer observer1=new MyObserver("1号");
        Observer observer2=new MyObserver("2号");
        Target  publish=new MyTarget();
        publish.register(observer1);
        publish.register(observer2);
        publish.publish("啦啦啦啦啦");
        publish.publish("111");

    }
}
abstract class Observer{
    abstract void getMsg(String s);
}
abstract class Target{
    List<Observer> list=new ArrayList<>();
    public abstract void publish(String s) ;
    public void register(Observer observer){
        list.add(observer);
    }

}

class MyObserver extends  Observer{
    String name;
    MyObserver(String name){
        this.name=name;
    }
    @Override
    void getMsg(String s) {
        System.out.println(name+s);
    }
}
class MyTarget extends Target{
    @Override
    public void publish(String s) {
        for(Observer o:list){
            o.getMsg(s);
        }
    }
}