package com.yxy.designpattern;

import java.util.Map;

/**
 * @author: yxy
 * Date: 2021/7/1
 * Time: 0:23
 * 描述:
 */
public class milkTeaShop {
    peiliao p;
    public void getMikeTeaDesire(){
            
    }

}
 class peiliao{
     public static Map<String, Integer> getA() {
         return a;
     }

     public static void setA(Map<String, Integer> a) {
         peiliao.a = a;
     }

     static Map<String,Integer> a;//名字+价格
     public void addPeilliaoKind(String name,int price){
         a.put(name,price);
     }
     public void updatePeiliaoPrice(String name,int price){
         a.put(name,price);

     }

}
class milkTea{
     int basicPrice;
     Map<String,Integer> peiliao;
     public milkTea generateMilkTea(int basicPrice,Map<String,Integer> peiliao){
         milkTea t=new milkTea();
         t.setBasicPrice(basicPrice);
         t.setPeiliao(peiliao);
         return t;
     }
     public int getMoney(int basicPrice,Map<String,Integer> peiliao){
         int count=0;
         for (String s:peiliao.keySet()){
             count+=peiliao.get(s);
         }
         return count+basicPrice;
     }

    public int getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(int basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Map<String, Integer> getPeiliao() {
        return peiliao;
    }

    public void setPeiliao(Map<String, Integer> peiliao) {
        this.peiliao = peiliao;
    }
}
