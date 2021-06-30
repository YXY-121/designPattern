package com.yxy.designpattern;

/**
 * @author: yxy
 * Date: 2021/4/30
 * Time: 16:00
 * 描述:
 */
public class AbstractFactoryTest {
    public static void main(String args[]){
        AbstractFactory factory=new computerComponentFactory();
        Cpu cpu1 = factory.produceCpu("Pc", "cpu");
        RAM ram1= factory.produceRam("Pc","ram");
        Cpu cpu2 = factory.produceCpu("Mac", "cpu");
        RAM ram2= factory.produceRam("Mac","ram");

        factory.produce(ram1,cpu1);
        factory.produce(ram2,cpu1);
        factory.produce(ram1,cpu2);

    }
}
abstract  class AbstractFactory{
    public abstract RAM produceRam(String RAMName,String id);
    public abstract Cpu produceCpu(String CpuName,String id);
    public abstract  void produce(RAM Ram,Cpu cpu);

}
class computerComponentFactory extends  AbstractFactory{
    RAM Ram;
    Cpu cpu;

    @Override
    public RAM produceRam(String RAMName, String id) {
        return new RAM(RAMName,id);

    }

    @Override
    public Cpu produceCpu(String CpuName, String id) {
        return new Cpu(CpuName,id);
    }

    public void produce(RAM Ram, Cpu cpu){
        System.out.println("组装"+Ram.getRAMName()+Ram.getId()+"的RAM和"+cpu.getCpuName()+cpu.getId()+"的cpu");
    }
}

class RAM{

    String RAMName;

    public String getRAMName() {
        return RAMName;
    }

    public void setRAMName(String RAMName) {
        this.RAMName = RAMName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;
    RAM(String RAMName, String id){
        this.id=id;
        this.RAMName=RAMName;
    }
}
class Cpu{
    String CpuName;

    String id;
    Cpu(String CpuName, String id){
        this.id=id;
        this.CpuName=CpuName;
    }
    public String getCpuName() {
        return CpuName;
    }

    public void setCpuName(String cpuName) {
        CpuName = cpuName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}