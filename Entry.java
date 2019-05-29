package g1;

public class Entry {

    public static Grocery grocery = new Grocery();


    public static void main(String[] args) {
        grocery.addItem("huawei");
        grocery.addItem("desk");
        grocery.addItem("pic");
        grocery.addItem("pen");
        grocery.addItem("cherry");
        grocery.addItem("stramcheery");
        System.out.println();
        System.out.println("Total number of " +grocery.total());
        System.out.println();



        grocery.delItemPosition(4);
        grocery.delItemByvalu("cherry");


        grocery.modifyItem(0,"huawei p20");



        String pic = grocery.find("pen");
        System.out.println(pic);



    }
}
