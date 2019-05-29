package g1;

import java.util.Scanner;

public class Operator {

    private static Scanner scanner = new Scanner(System.in);

    private Grocery grocery;

    public Operator(Grocery grocery) {
        this.grocery = grocery;
    }

    public void printInstruction() {
        System.out.println("0, Instruction\n" +
                "1, ListItem\n" +
                "2, Add Item\n" +
                "3, Modify Item\n" +
                "4, Remove Item\n" +
                "5, Seacher Item\n" +
                "6, Quit");
    }


    public void run() {

        boolean quit = false;
        int chioce = 0;


        while (!quit) {
            System.out.println("Enter you  choice");
            chioce = scanner.nextInt();
            scanner.nextLine();

            switch (chioce) {
                case 0:
                    printInstruction();
                    break;

                case 1:
                    grocery.listAll();

                    break;

                case 2:
                    addItem();

                    break;


                case 3:
                    modifyItem();
                    break;

                case 4:
                    delete();
                    break;


                case 5:
                    findItem();
                    break;


                case 6:
                    quit = true;

                    break;
                default:
                    break;


            }


        }


    }

    private void findItem() {
        System.out.println("(Enter the Item to serch:) ");
        String item = scanner.nextLine();
        grocery.find(item);

    }

    private void delete() {
        System.out.println("(Enter position to remove:)");
        int position = scanner.nextInt();
        grocery.delItemPosition(position-1);


    }

    private void modifyItem() {
        System.out.println("(Enter position to modify:)");
        int position = scanner.nextInt();

        scanner.nextLine();
        if ( position > grocery.total() ) {
            System.out.println("position overflow");
        }

        System.out.println("(Enter new Item:)");
        String item = scanner.nextLine();
        grocery.modifyItem(position-1,item);


    }

    private void addItem() {

        System.out.println("(Enter the item:)");
        grocery.addItem(scanner.nextLine());
    }

    public static void main(String[] args) {
        Grocery grocery = new Grocery();
        Operator operato = new Operator(grocery);

        operato.printInstruction();
        operato.run();


    }


}



