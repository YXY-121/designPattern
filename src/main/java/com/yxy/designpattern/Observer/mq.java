package com.yxy.designpattern.Observer;

import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yxy
 * Date: 2021/5/11
 * Time: 15:59
 * 描述:
 */
public class mq {
    public static void main(String args[]){
        Subscriber subcriber1=new MySubscriber("1号");
        Subscriber subcriber2=new MySubscriber("2号");
        Publisher publisher=new MyPublisher();
        Channel channel=new Channel();
        channel.addSubscriber(subcriber1);
        channel.addSubscriber(subcriber2);

        publisher.publish(channel,"哈哈哈哈");
        publisher.publish(channel,"11111");

    }
}

class Channel{
   Publisher publisher = null;
    List<Subscriber> list=new ArrayList<>();

    public void pushMessage(String msg){
            for (Subscriber s:list){
                s.update(msg);
            }
    }
    public void setPublisher(Publisher publisher){
        this.publisher=publisher;
    }
    public void addSubscriber(Subscriber subscriber){
        list.add(subscriber);
    }

}

interface  Subscriber{
    public void update(String msg);
}

interface  Publisher{
    public void publish(Channel mq,String msg);
}


class MyPublisher implements  Publisher{

    @Override
    public void publish(Channel mq, String msg) {
        System.out.println("发布者我，发布了"+msg);
        mq.pushMessage(msg);

    }
}

class MySubscriber implements Subscriber{
    String name;
    MySubscriber(String name){
        this.name=name;
    }
    @Override
    public void update(String msg) {
        System.out.println(name +"收到了消息队列的信息"+msg);
    }
}


