package g1;

import java.util.*;

public class ThreadGrocery {



    Map<Integer, String> grocery = new HashMap<>();

    public void listAll() {
        System.out.println("你有" + grocery.size() + "件商品！！");
        for (Object key : grocery.keySet()) {
            System.out.print(key+"  ");
            System.out.println(grocery.get(key));
        }

    }

    public void addItem(Integer key, String item) {
        grocery.put(key, item);
        System.out.println(item+"已添加！");
    }

    public void delItemkey(Integer key) {

        String r = grocery.get(key);
        grocery.remove(key);
        System.out.println(r + "已删除！");
    }

    public void delItemvalue(String value) {
        int flag = 0;

        List al = new ArrayList();

        for (Integer key : grocery.keySet()) {

            if ( (grocery.get(key)).equals(value) ) {
                flag = 1;
                al.add(key);
                // grocery.remove(key);  在迭代器里面修改，会出现并发异常！！！！！！！！！！！！
            }
        }
        if ( flag == 1 ) {
            for (int i=0;i<al.size();i++) {
                String d = grocery.get(al.get(i));
                grocery.remove(al.get(i));
                System.out.println( d+"被删除！");
            }
        }
        else
            System.out.println("没有删除什么！");


    }

    public void modifyItemKey(Integer key, String value) {

        for (Integer id : grocery.keySet()) {

            if ( id.equals(key) ) {
                System.out.println(grocery.get(id) + "被修改!");
                grocery.replace(id,value);
            }
            else
                System.out.println("没有修改成功。。。。");


        }
    }


    public void modifyItemValue(String value){
        for (Integer id:grocery.keySet()){
            if(grocery.get(id).equals(value) ){
                Scanner in = new Scanner(System.in);
                System.out.println("请输入新的名称");
                String newName = in.nextLine();
                grocery.replace(id,newName);

                System.out.println(grocery.get(id)+"被修改！");

            }
        }
    }


    public String find(String value) {
        int flag = 0;
        for (Integer key : grocery.keySet()) {
            if ( grocery.get(key).equals(value) ) {
                System.out.println(grocery.get(key) + "找到了！");
                flag = 1;
            }
        }
        if ( flag == 0 ) {

            return "没有找到该商品!";
        }
        return "";
    }

    public String find(Integer key) {
        int flag = 0;
        for (Integer keys : grocery.keySet()) {
            if ( key.equals(keys) ) {
                System.out.println(grocery.get(key) + "有找到！");
                flag = 1;
            } else
                continue;
        }
        if ( flag == 0 ) {

            return "没有找到该商品！";
        }
        return "";
    }

    public int total() {
        return grocery.size();
    }


    @Override
    public String toString() {
        return "Grocery1{" +
                "grocery=" + grocery +
                '}';
    }
}