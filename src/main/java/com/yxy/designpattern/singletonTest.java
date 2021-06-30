package com.yxy.designpattern;

/**
 * @author: yxy
 * Date: 2021/4/30
 * Time: 15:02
 * 描述:
 */
public class singletonTest {
    public static void main(String args[]){
    new singleton().getInstance();
        new singleton().getInstance();

    }
}
class singleton{
    static Object s;
    public Object getInstance(){
        if(s==null){
            s=new Object();
            System.out.println("程序第一次初始化");

        }else{
            System.out.println("程序已运行");
        }
        return s;

    }
}
