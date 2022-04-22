package Assignment1;

import java.util.Scanner;

class ScanToken{

    
    public static void main(String[] args) {

        String digitalStringtoken="";
        //Declaring an instance of the scanner class
        Scanner in = new Scanner(System.in);
        
        
        while(true){
            int tokenSum = 0;
            int tokenProduct = 1;
            //Ask user to enter token.
            System.out.println(
                    "Enter numeric tokens containing at most, a single space between values \n E.g :100 8985 34 4");
            System.out.println(
                    "Enter goodbye to exit");
            digitalStringtoken = in.nextLine();
            String[] splitToken = digitalStringtoken.split(" ");
            

            if (digitalStringtoken.equals("Goodbye") || digitalStringtoken.equals("goodbye")) {
                return;
            }
            System.out.println(
                    "Split numbers from Tokens are : ");
            for (int ii = 0; ii < splitToken.length; ii++) {
                
                System.out.println(splitToken[ii]);
                tokenSum += Integer.parseInt(splitToken[ii]);
                tokenProduct *= Integer.parseInt(splitToken[ii]);
            }

            System.out.println(
                    "Sum of Token Is : "+ tokenSum);
            System.out.println(
                    "Product of Token is : "+ tokenProduct);

            System.out.println();
            System.out.println();
        }
    }
}