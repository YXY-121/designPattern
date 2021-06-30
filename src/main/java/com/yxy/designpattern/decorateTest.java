package com.yxy.designpattern;

/**
 * @author: yxy
 * Date: 2021/4/30
 * Time: 15:33
 * 描述:
 */
public class decorateTest {
    public static  void main(String args[]){
        book book=new book();

        book book1= new bookDecorate1(book);
        book book2= new bookDecorate2(book1);
        book2.returnBook();
        book2.borrowBook();
        ((bookDecorate1)book1).freeze();
        ((bookDecorate2)book2).lose();


    }
}
class book{
    public void borrowBook(){
        System.out.println("我能借书");

    }
    public void returnBook(){
        System.out.println("我能还书");
    }
}

class bookDecorate1 extends  book{
    book book;
    bookDecorate1(book book){
        this.book=book;
    }
    public void freeze(){
        System.out.println("我能冻结");
    }
}
class bookDecorate2 extends  book{
    book book;
    bookDecorate2(book book){
        this.book=book;
    }
    public void lose(){
        System.out.println("我能遗失");

    }
}
