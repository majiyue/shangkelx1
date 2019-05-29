package g1;

import java.util.ArrayList;
import java.util.List;

public class Grocery {

    List<String > grocery = new ArrayList<>();

    public void listAll() {
        System.out.println("You have "+grocery.size()+" items currently");

        for (String item:grocery){
            System.out.println(item);
        }

    }

    public void addItem(String item){
        grocery.add(item);
        System.out.println(item+" add");
    }
    public void delItemPosition(int position){
        System.out.println(grocery.get(position)+"  remove");
        grocery.remove(position);
    }
    public void delItemByvalu(String item){
        grocery.remove(item);
        System.out.println(item+" remove");
    }

    public void modifyItem(int position,String item){          //改
        System.out.println(grocery.get(position)+" modified to "+item);
        grocery.set(position,item);
    }

    public String find(String item){                          //查
        if ( grocery.contains(item) ){
            int position = grocery.indexOf(item);
            System.out.println(item+" found ");
            System.out.print(position+"  ");
            return grocery.get(position);
        }
        System.out.println(item+"  not found");
        return null;

    }

    public int total(){
        return grocery.size();
    }

    @Override
    public String toString() {
        return grocery.toString();
    }
}
