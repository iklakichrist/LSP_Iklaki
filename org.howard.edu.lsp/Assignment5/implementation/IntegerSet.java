package implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** This is the class that implements methods for manipulating a mathematical set*/
public class IntegerSet {


    /** the Main set to be manipulated */
    private static ArrayList<Integer> set = new ArrayList<Integer>();
    private static ArrayList<Integer> setB =  new ArrayList<Integer>();

    /**Constructor Method */
    public IntegerSet() {
        super();
    }

    /** Method to return the largest integer in the set.
     * @return int
    */
    public int largest(){
            return Collections.max(set);
    }

    /** Method returns smallest integer in the set
     * @return int
     */
    public int smallest() {
        
            
                return Collections.min(set);
            
        }

        /**Method to remove an integer from the set 
         * @param  i integer
        */
    public void remove(Integer i){
        System.out.println("About to remove " + i + " from the below set");
        System.out.println(this.toString());
            if (!set.contains(i)) {
                System.out.println(i +" does not exist");
            } else {
                set.remove(i);
                System.out.println(i + " removed");
                System.out.println("The set after removing "+i+" Looks like this \n: "+this.toString());
            }
    }

    /** Method to add items to the integer set 
     * @param item item to be inserted
    */
    public  void addItem(Integer item){
        if(item == null){
            item = 0;
        }
        if(set.isEmpty()){
            System.out.println("Welcome to the set filling Process. \n Although duplicate inputs will be TRASHED , you can help your self by not inputing duplicates, \n Thanks ");
        }
        int tempItem = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Please Insert an Integer");
        if(item == 0){
            item = in.nextInt();
        }

        if(set.contains(item)){
            System.out.println("Alert!! :: Duplicate Found,\n Alert!! : DUplicate Trashed");
            System.out.println(item +" Trashed!");
        }
        else{
            set.add(item);
        }
        
    }

    /** Method to return the lenght of the set 
     * @return int
    */
    public int length(){
        return set.size();
    }

    /**Method to remove all items from the list 
    */
    public void clear(){
        System.out.println("CLearing Set.. ... ...");
        set.clear();
    }

    /** Method to test 2 sets of equality 
     * @param b Set to compare with the main set agains equality
     * @return boolean
    */
    public boolean equal(ArrayList<Integer> b){

        Scanner in = new Scanner(System.in);
        System.out.println("Test For Equality");
        int newLength = 0;
        int counter = 0;
       // System.out.println("The content of the main List are : " + toString(this.set));
        if(b.isEmpty() && setB.isEmpty()){
             final ArrayList<Integer> g = new ArrayList<Integer>(this.set);
           
            System.out.println("The content of the main List are : " + toString(g));
            this.clear();
            System.out.println("Enter the numbers of items you wish present in your new list");
            newLength = in.nextInt();
            
            System.out.println("Thanks, Your set will be controlled to contain just " + newLength + " items");
            System.out.println(
                    "Assuming you had arleady inserted values into set A (The original Set), \n insert values into the second set (SetB), \n Enter ");
                   
            while (counter < newLength) {
                addItem(0);
                counter++;
                if (counter == newLength && (this.length() < newLength)) {
                    counter--;
                }
            }    
            this.setB = this.set;
            System.out.println("The content of your newly created Set are : " + toString(setB));
            final ArrayList<Integer> a = new ArrayList<Integer>(this.setB) ;
            this.clear();
            this.set = g;
            this.setB = a;
            if(!g.isEmpty()){
                System.out.println("The content of the main List are : " + toString(g));
                //return g.equals(setB);
            }
            if(set.containsAll(a)==true && (this.length() == this.setB.size())){
                return true;
            }else{
                return false;
            }
        }
        else if(!setB.isEmpty() && b.isEmpty()){
            System.out.println("Do you want to compare set one to new values (as setB), or use setB's old values for the comparism \n 1. for New values, and 2 for Old values");
            int option = in.nextInt();
            if(option == 1){
                final ArrayList<Integer> g = new ArrayList<Integer>(this.set);

                System.out.println("The content of the main List are : " + toString(g));
                this.clear();
                System.out.println("Enter the numbers of items you wish present in your new list");
                newLength = in.nextInt();

                System.out.println("Thanks, Your set will be controlled to contain just " + newLength + " items");
                System.out.println(
                        "Assuming you had arleady inserted values into set A (The original Set), \n insert values into the second set (SetB), \n Enter ");

                while (counter < newLength) {
                    addItem(0);
                    counter++;
                    if (counter == newLength && (this.length() < newLength)) {
                        counter--;
                    }
                }
                this.setB = this.set;
                System.out.println("The content of your newly created Set are : " + toString(setB));
                final ArrayList<Integer> a = new ArrayList<Integer>(this.setB);
                this.clear();
                this.set = g;
                this.setB = a;
                if (!g.isEmpty()) {
                    System.out.println("The content of the main List are : " + toString(g));
                    // return g.equals(setB);
                }
                Boolean p = set.containsAll(a);
                return p;
            }
            else if(option == 2){
                System.out.println("The content of the main List are : " + toString(this.set));
                System.out.println("The content of the new List are : " + toString(setB));
                Boolean p = set.containsAll(setB);
                return p;
            }
        }
        else if(!b.isEmpty()){
            return set.equals(b);
        }
        
         return false;
    }

    /**boolean method to check if an integer in a member of the set 
     * @param val Value to check against
     * @return int 
    */
    public boolean contains(int val) {  
        if (set == null){
            return false;
        }
        
        if(set.contains(val)){
            return true;
        }
        else{
            return false;
        }
        
    }

    /**Takes a list and unites it with anotherlist 
     * @param b Which is an arraylst to unite with the original set
    */
    public void union(ArrayList<Integer> b){

        System.out.println("Union of 2 sets ...");
        Scanner in = new Scanner(System.in);
        
        Set<Integer> newSet = new HashSet<Integer>();
        int newLength = 0;
        int counter = 0;
        if (b.isEmpty() && setB.isEmpty()) {
            
            final ArrayList<Integer> g = new ArrayList<Integer>(this.set);
            set.clear();
            System.out.println("Enter the numbers of items you wish present in your new list");
            newLength = in.nextInt();
            System.out.println("Thanks, Your set will be controlled to contain just " + newLength + " items");
            System.out.println(
                    "Assuming you had arleady inserted values into set A (The original Set), \n insert values into the second set (SetB), \n Enter ");
            while (counter < newLength) {
                addItem(0);
                counter++;
                if (counter == newLength && (this.length() < newLength)) {
                    counter--;
                }
            }
            setB = set;
            final ArrayList<Integer> a = new ArrayList<Integer>(this.setB);
            this.clear();
            this.set = g;
            this.setB = a;
             newSet.addAll(setB);
             newSet.addAll(set);
             System.out.println("The content of setA are : " + toString(set));
             System.out.println("The content of SetB are : " + toString(setB));
            System.out.println("The Union Of The 2 sets are: ");
            ArrayList<Integer> unionSet = new ArrayList<Integer>(newSet); 
            for(Integer s : unionSet){
                System.out.println(s);
            }
        } else if (!setB.isEmpty()) {
            final ArrayList<Integer> g = new ArrayList<Integer>(this.set);
            this.clear();
            System.out.println(
                    "Do you want to unite set one to new values (as setB), or use setB's old values for the union \n 1. for new values, and 2 for new values");
            int option = in.nextInt();
            if (option == 1) {
                System.out.println("Enter the numbers of items you wish present in your new set");
                newLength = in.nextInt();
                System.out.println("Thanks, Your set will be controlled to contain just " + newLength + " items");
                System.out.println(
                        "Assuming you had arleady inserted values into set A (The original Set), \n insert values into the second set (SetB), \n Enter ");
                while (counter < newLength) {
                    addItem(0);
                    counter++;
                    if (counter == newLength && (this.length() < newLength)) {
                        counter--;
                    }
                }
                setB = set;
                final ArrayList<Integer> a = new ArrayList<Integer>(this.setB);
                set.clear();
                this.set = g;
                this.setB = a;
                System.out.println("The content of setA are : " + toString(set));
                System.out.println("The content of SetB are : " + toString(setB));
                newSet.addAll(setB);
                newSet.addAll(set);

                System.out.println("The Union Of The 2 sets are: ");
                ArrayList<Integer> unionSet = new ArrayList<Integer>(newSet);
                for (Integer s : unionSet) {
                    System.out.println(s);
                }
            } else if (option == 2) {

                System.out.println("Value(s) in SetA :" + this.toString());
                System.out.println("Value(s) in SetB :" + this.toString(setB));
                newSet.addAll(setB);
                newSet.addAll(set);

                System.out.println("The Union Of The 2 sets are: ");
                ArrayList<Integer> unionSet = new ArrayList<Integer>(newSet);
                for (Integer s : unionSet) {
                    System.out.print(s+ " ");
                }
            }
        }
    }

    /**First overload method that prints the set main set  
     * @return String
    */
    public String toString(){
        String list = "";
            if(this.set.isEmpty()){
                return "No Item in set to print";
            }
            for (Integer s : set) {
                list += s.toString() + " \t";
            }
            return list;
           
        
    }

    /**Second overload to print any set
     * @param l Set to print
     */
    public String toString(ArrayList<Integer> l){
        String list = "";
        if (this.set.isEmpty()) {
            return "No Item in set to print";
        }
        for (Integer li : l) {
            list += li.toString() + " \t";
        }
        return list;
    }

    /**Method that intersects two sets 
     * @param b Set to intersect with the original set
    */
    public void intersect(ArrayList<Integer> b) {
        
        
        System.out.println("intersection of 2 sets ...");
        Scanner in = new Scanner(System.in);

        String stringList = "";
        int newLength = 0;
        int counter = 0;
        if (b.isEmpty() && setB.isEmpty()) {
            final ArrayList<Integer> g = new ArrayList<Integer>(this.set);
            set.clear();
            System.out.println("Enter the numbers of items you wish present in your new set");
            newLength = in.nextInt();
            System.out.println("Thanks, Your set will be controlled to contain just " + newLength + " items");
            System.out.println(
                    "Assuming you had arleady inserted values into set A (The original Set), \n insert values into the second set (SetB), \n Enter ");
            while (counter < newLength) {
                addItem(0);
                counter++;
                if (counter == newLength && (this.length() < newLength)) {
                    counter--;
                }
            }
            this.setB = this.set;
            final ArrayList<Integer> a = new ArrayList<Integer>(this.setB);
            System.out.println("The content of setB are : " + this.toString(a));
            this.clear();
            this.setB = a;
            this.set = g;
            System.out.println("The content of setA are : " + this.toString(set));
          

            System.out.println("The Intersect of  setA and B are: ");
           
            for (Integer s : setB) {
                if(this.contains(s)){
                    stringList += s.toString() + "\t";
                    
                }
            }
            System.out.println(stringList);
        } else if (!setB.isEmpty()) {
            System.out.println(
                    "Do you want to compare set one to new values (as setB), or use setB's old values for the comparism \n 1. for new values, and 2 for Old values");
            int option = in.nextInt();
            if (option == 1) {
                final ArrayList<Integer> g = new ArrayList<Integer>(this.set);
                this.clear();
                System.out.println("Enter the numbers of items you wish present in your new set");
                newLength = in.nextInt();
                System.out.println("Thanks, Your set will be controlled to contain just " + newLength + " items");
                System.out.println(
                        "Assuming you had arleady inserted values into set A (The original Set), \n insert values into the second set (SetB), \n Enter ");
                while (counter < newLength) {
                    addItem(0);
                    counter++;
                    if (counter == newLength && (this.length() < newLength)) {
                        counter--;
                    }
                }
                setB = set;
                final ArrayList<Integer> a = new ArrayList<Integer>(this.setB);
                set.clear();
                this.set = g;
                this.setB =a;
                System.out.println("The content of setA are : " + toString(this.set));
                System.out.println("The content of SetB are : " + toString(this.setB));

                System.out.println("The Intersect of  setA and B are: ");
                for (Integer s : setB) {
                    if (this.contains(s)) {
                        stringList += s.toString() + "\t";
                    }
                }
                System.out.println(stringList);
                
            } else if (option == 2) {
                System.out.println("The Intersect of  setA and B are: ");
                for (Integer s : setB) {
                    if (this.contains(s)) {
                        stringList += s.toString() + "\t";
                    }
                }
                System.out.println(stringList);
            }
        }
    }

    /**Method finds the diffrence between two sets 
     * @param b Set to find diffrnce against the original list
    */
    public void diffrence(ArrayList<Integer> b) {

        System.out.println("Diffrence of 2 sets ...");
        Scanner in = new Scanner(System.in);

        String stringList = "";
        int newLength = 0;
        int counter = 0;
        if (b.isEmpty() && setB.isEmpty()) {
            final ArrayList<Integer> g = new ArrayList<Integer>(this.set);
            set.clear();
            System.out.println("Enter the numbers of items you wish present in your new set");
            newLength = in.nextInt();
            System.out.println("Thanks, Your set will be controlled to contain just " + newLength + " items");
            System.out.println(
                    "Assuming you had arleady inserted values into set A (The original Set), \n insert values into the second set (SetB), \n Enter ");
            while (counter < newLength) {
                addItem(0);
                counter++;
                if (counter == newLength && (this.length() < newLength)) {
                    counter--;
                }
            }
            setB = set;
            final ArrayList<Integer> a = new ArrayList<Integer>(this.setB);
            System.out.println("The content of setB are : " + this.toString(a));
            set.clear();
            this.set = g;
            this.setB = a;
            System.out.println("The content of setA are : " + this.toString(set));
            ArrayList<Integer> p = new ArrayList<Integer>(g);
            System.out.println("The diffrence between  setA and B are: ");
            for (Integer s : setB) {
                if (p.contains(s)) {
                    p.remove(s);
                }
            }
            System.out.println(toString(p));
        } else if (!setB.isEmpty()) {
            System.out.println(
                    "Do you want to Subtract setA with new values (as setB), or use setB's old values for the comparism \n 1. for new values, and 2 for old values");
            int option = in.nextInt();
            if (option == 1) {
                final ArrayList<Integer> g = new ArrayList<Integer>(this.set);
                this.clear();
                System.out.println("Enter the numbers of items you wish present in your new set");
                newLength = in.nextInt();
                System.out.println("Thanks, Your set will be controlled to contain just " + newLength + " items");
                System.out.println(
                        "Assuming you had arleady inserted values into set A (The original Set), \n insert values into the second set (SetB), \n Enter ");
                while (counter < newLength) {
                    addItem(0);
                    counter++;
                    if (counter == newLength && (this.length() < newLength)) {
                        counter--;
                    }
                }
                setB = set;
                final ArrayList<Integer> a = new ArrayList<Integer>(this.setB);
                set.clear();
                set = g;
                setB=a;
                System.out.println("The content of setA are : " + toString(this.set));
                System.out.println("The content of SetB are : " + toString(this.setB));

                ArrayList<Integer> p = new ArrayList<Integer>(g);

                System.out.println("The diffrence between  setA and B are: ");
                for (Integer s : setB) {
                    if (p.contains(s)) {
                        p.remove(s);
                    }
                }
                System.out.println(this.toString(p));
            } else if (option == 2) {

                ArrayList<Integer> p = new ArrayList<Integer>(this.set);
                System.out.println("The diffrence between  setA and B are: ");
                for (Integer s : setB) {
                    if (p.contains(s)) {
                        set.remove(s);
                    }
                }
                System.out.println(this.toString(p));
            }
        }
    }
}