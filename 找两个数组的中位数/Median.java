package Median;

import java.io.*;
import java.util.ArrayList;

public class Median {
    ArrayList<Integer> x;
    ArrayList<Integer> y;
    ArrayList<String> list;
    public Median(){
        x = new ArrayList<Integer>();
        y = new ArrayList<Integer>();
        list = new ArrayList<String>();
    }
    public ArrayList<Integer> getX(){
        return this.x;
    }
    public ArrayList<Integer> getY(){
        return this.y;
    }
    public void read(){
        try{
            FileReader fr = new FileReader("src/Median/input.txt");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            int i=0;
            while ((str = bf.readLine()) != null) {
                list.add(str);
            }
            bf.close();
            fr.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        String[] x_temp = list.get(0).split(",");
        String[] y_temp = list.get(1).split(",");
        for(int i=0;i<x_temp.length;i++){
            x.add(Integer.parseInt(x_temp[i]));
            y.add(Integer.parseInt(y_temp[i]));
        }
        System.out.println(x);
        System.out.println(y);
    }

    public void write(int median){
        try {
            FileWriter fw = new FileWriter("src/Median/ouput.txt");
            fw.write(String.valueOf(median));
            fw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("存储成功");
    }

    public void get_medain(ArrayList<Integer> x, ArrayList<Integer> y, int k){
        int temp;
        if(k == 1){
            if(x.get(0) < y.get(0)){
                System.out.println(x.get(0));
                write(x.get(0));
            }
            else {
                System.out.println(y.get(0));
                write(y.get(0));
            }
            return;
        }
        if(k%2 == 1) { // 是奇数
            temp = k/2 + 1;
        }
        else // 是偶数
            temp = k/2;
        if(x.get(temp-1)>y.get(temp-1)){  // 若x的大于y的
            if(temp == 1){
                y.remove(0);
                k--;
            }
            for(int i=0;i<temp-1;i++){
                y.remove(0);
                k--;
            }
        }
        else{  // y的大于x的
            if(temp == 1){
                x.remove(0);
                k--;
            }
            for(int i=0;i<temp-1;i++){
                x.remove(0);
                k--;
            }
        }
        get_medain(x, y, k);
    }
    public static void main(String[] args) {
        Median median = new Median();
        median.read();
        median.get_medain(median.getX(), median.getY(), median.getX().size());
    }
}
