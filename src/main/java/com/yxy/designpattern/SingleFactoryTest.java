package com.yxy.designpattern;

/**
 * @author: yxy
 * Date: 2021/4/30
 * Time: 15:59
 * 描述:
 */
public class SingleFactoryTest {
    public static void main(String args[]){
        Nvwa nvwa=new Nvwa();
        People m = nvwa.makePeople("M");
        People w = nvwa.makePeople("W");
        People r = nvwa.makePeople("R");

        System.out.println(m);
        System.out.println(w);
        System.out.println(r);
    }
}
class Nvwa{
public People makePeople(String s){
    if(s=="M")return new Man();
    if(s=="W")return new Woman();
    if(s=="R")return new Robot();
    return null;
}
}
abstract class  People{

}
class Man extends People{
    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                '}';
    }

    String name="man";

}
class Woman extends People{
    String name="Woman";

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Robot extends People{
    String name="Robot";

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}



