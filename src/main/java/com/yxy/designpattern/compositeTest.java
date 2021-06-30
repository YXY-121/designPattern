package com.yxy.designpattern;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yxy
 * Date: 2021/4/30
 * Time: 15:07
 * 描述:
 */
public class compositeTest {
    public static void main(String args[]){
        List<AntiVirus> container1=new ArrayList<>();
        container1.add(new type("音频视频文件MediaFile"));
        container1.add(new type("图片文件ImageFile"));

        List<AntiVirus> container2=new ArrayList<>();
        container2.add(new type("文本文件TextFile1"));
        container2.add(new type("文本文件TextFile2"));
        AntiVirus planet2=new planet(container2);

        AntiVirus planet1=new planet(container1,planet2);
        planet1.killVirus();

    }
}
abstract class AntiVirus{
    public abstract  void killVirus();
}
class planet extends  AntiVirus{
    List<AntiVirus> documentList;
    AntiVirus planet;
    planet(List<AntiVirus> documentList,AntiVirus planet){
        this.documentList=documentList;
        this.planet=planet;
    }
    planet(List<AntiVirus> documentList){
        this.documentList=documentList;
    }
    @Override
    public void killVirus() {
        for(int i=0;i<documentList.size();i++)
            documentList.get(i).killVirus();
        if(planet!=null)
        planet.killVirus();
    }
}
class type extends AntiVirus{
    String name;

    type(String name){
        this.name=name;
    }
    @Override
    public void killVirus() {
        System.out.println("给"+name+"杀毒");
    }


}