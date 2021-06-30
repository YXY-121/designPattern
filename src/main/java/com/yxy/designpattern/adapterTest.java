package com.yxy.designpattern;

import java.util.HashMap;

/**
 * @author: yxy
 * Date: 2021/4/30
 * Time: 20:12
 * 描述:
 */
public class adapterTest {
    public static  void main(String args[]){
        DataOperation adapter=new adapter(new QuickSort(),new BinarySearch());
        int []a={1};
        adapter.search(a,1);
        adapter.sort(a);

    }
}

interface  DataOperation{
   public void sort(int[] a);
    public boolean search(int[]a, int b);
}
class adapter implements DataOperation{
    QuickSort quickSort;
    BinarySearch binarySearch;
    adapter(QuickSort quickSort,BinarySearch binarySearch){
        this.binarySearch=binarySearch;
        this.quickSort=quickSort;
    }
    @Override
    public void sort(int[] a) {
        quickSort.quickSort(a);
    }

    @Override
    public boolean search(int[] a, int b) {

        return binarySearch.binarySearch(a,b);
    }
}

class QuickSort{
   public void quickSort(int[] a){
        System.out.println("我是快速排序方法");
    }
}
class BinarySearch {
   public boolean binarySearch(int[]a, int b){
       System.out.println("我是二分查找算法");
       return true;

   }
}