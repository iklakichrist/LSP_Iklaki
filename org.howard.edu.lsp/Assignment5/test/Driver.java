package test;

import java.util.ArrayList;
import java.util.Scanner;

import implementation.IntegerSet;
import implementation.IntegerSetException;
/**This is the class that actually Test the implementations of the IntegerSet class */
public class Driver {
private static IntegerSet se = new IntegerSet();
    public Driver() {
        super();
    }

    /** The application entry point. */
    public static void main(String[] args) {
        ArrayList<Integer> emptyArray = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);

        p("Welcome to the driver interactive program \n I am Christ your tour bot.");
        p("note, I recomend you start by filling in the set. that should be option 1");
        p("Please select from the list of options, which operation you wish to peform");
        while(true){
            
            p("1 : Add to Set\n 2 : Clear Set \n 3 : Equality Test \n 4 : Check if a value is in a set \n5 : Check"+
            " for intercection between 2 sets \n 6 : Print Set \n 7 : Remove a value from the set\n 8 : Retrive biggest value in set"+
            "\n 9: Get smallest value in the set \n 10 : Get how many items are in the set \n 11 : See the Union of 2 sets \n 12 : Calculatte the diffrence between 2 sets"
            );
            int option = in.nextInt();
            if(option == 1){
                insertHandler();
            }
            if(option == 3){
                Boolean x = se.equal(emptyArray);
                if(x){
                    System.out.println(": The sets are Equal");
                }
                else{
                    System.out.println( ": The sets are Not Equal");
                }
            }
            if(option == 4){
                p("Check if a value is in A set. \n Enter the Value to check for : ");
                var i =in.nextInt();
                boolean x = se.contains(i);
                if(x) {
                    System.out.println(i+": is contained in the set");
                } else {
                    System.out.println(i +": is not a member of the set");
                }
                p("Exiting Check ......\n\n");
            }
            if(option ==5){
                se.intersect(emptyArray);
                p("\n");
            }
            if(option == 2){
                p("Clearing main set .  .  .");
                se.clear();
            }
            if(option == 6){
                p("Printing Set");
                String set = se.toString();
                p(set);
                p("\n");
            }
            if(option == 7){
                try{
                    
                    if(se.length()<1){
                        throw new IntegerSetException("The main set is Empty");
                    }else{
                        p("Remove value from Set. \n Enter the Value to remove : ");
                        var i = in.nextInt();
                        se.remove(i);
                    }
                    p("\n");
                }
                catch(IntegerSetException e){
                    p(e.getMessage());
                }
            }
            if(option == 8){
                try {
                    p("Getting largest number from set ... ... ...");
                    if (se.length() == 0) {
                        throw new IntegerSetException("The main set is Empty");
                       
                    } else {
                        System.out.println("Value(s) in The Set :" + se.toString());
                        p("The Largest value in the List is "+se.largest());
                        p("\n");
                    }
                } catch (IntegerSetException e) {
                    p(e.getMessage());
                }

            }
            if (option == 9) {
                try {
                    p("Getting smallest number from set .. .. ..");
                    if (se.length() == 0) {
                        throw new IntegerSetException("The main set is Empty");
                    }else{
                        System.out.println("Value(s) in The Set :" + se.toString());
                        p("The smallest value in the List is " + se.smallest());
                        p("\n");
                    }
                } catch (IntegerSetException e) {
                    //TODO: handle exception
                    p(e.getMessage());
                    p("\n");
                }
                
                
            }
            if (option == 10) {
                p("The numbers of items in the set is " + se.length());
                p("\n");
            }
            if(option == 11){
                se.union(emptyArray);
                p("\n");
            }
            if (option == 12) {
                se.diffrence(emptyArray);
                p("\n");
            }
        }
    }

    static void p (String p){
        System.out.println(p);
    }
/** Interactive method to help the insert process  */
    public static void insertHandler(){
        Scanner in = new Scanner(System.in);
        int itemsCount=0;
        p("How many Items do you want in your Set ? :");
        itemsCount = in.nextInt();
        int i=0;

        while(i<itemsCount){
            se.addItem(0);
            i++;
            if(i==itemsCount && (se.length()<itemsCount)){
                i--;
            }
        }
        p("\nThe content of SetA are  :\n "+ se.toString() +"\n");
    }


}
