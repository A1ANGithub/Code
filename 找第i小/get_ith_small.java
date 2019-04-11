package get_ith_small;

import java.util.ArrayList;

public class get_ith_small {
    public ArrayList<Integer> list = new ArrayList<Integer>();
    private int aa = 1;
    public get_ith_small(){
        list.add(4);
        list.add(1);
        list.add(10);
        list.add(9);
        list.add(7);
        list.add(12);
        list.add(8);
        list.add(2);
        list.add(15);
    }
    public int Randomizedpartition(int pre, int last,int index){
        int mid = list.get(pre);
        for (int i=pre;i<=last;i++){
            if(list.get(i)<mid){//把小于mid的放前面
                int swap = list.get(i);
                list.remove(i);
                list.add(pre, swap);
            }
        }
        if(list.indexOf(mid) == index){
            System.out.println("第" + index + "小的数值为:" + mid);
            return mid;
        }
        else if(list.indexOf(mid)>index){
            Randomizedpartition(pre, list.indexOf(mid)-1, index);
        }
        else
            Randomizedpartition(list.indexOf(mid)+1, last, index);
        return -1;
    }
    public static void main(String[] args) {
        int index = 3;  // 想要搜索第i小的索引，从0开始的
        new get_ith_small().Randomizedpartition(0, 8,index);
    }
}
