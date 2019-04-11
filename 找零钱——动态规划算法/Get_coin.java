package Coin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// 使用一维数组
public class Get_coin {
    public ArrayList<Integer> money_kind;
    public Get_coin(){
        money_kind = new ArrayList<>();
    }
    public void read(){
        try{
            FileReader fr = new FileReader("src/Coin/input.txt");
            BufferedReader bf = new BufferedReader(fr);
            String str =  bf.readLine();
            bf.close();
            fr.close();
            String[] temp = str.split(",");
            for(int i=0;i<temp.length;i++){
                money_kind.add(Integer.parseInt(temp[i]));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void change_money(int money){
        int cunchu[] = new int[money + 1];
        for(int kind=0;kind<money_kind.size();kind++){// 对钱的种类进行遍历
            for(int cents=0;cents<=money;cents++){//对钱数进行遍历，钱数为cents+1
                if(kind == 0)
                    cunchu[cents] = cents;
                else {
                    if(money_kind.get(kind) > cents){
                        continue;
                    }
                    else {
                        cunchu[cents] = cunchu[cents-money_kind.get(kind)] + 1;
                    }
                }
            }
        }
        System.out.println("这是结果");
        System.out.println(cunchu[money]);
    }
    public static void main(String[] args) {
        Get_coin c = new Get_coin();
        c.read();
        c.change_money(23);
    }
}
