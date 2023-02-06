import java.util.Scanner;

public class mainFlame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nOne, nTwo;

        System.out.print("Input Name #1: ");
        nOne = sc.nextLine();
        System.out.print("Input Name #2: ");
        nTwo = sc.nextLine();
        printOut(nOne,nTwo);

    }




    //prints Out input names, scores and interpreted score
    public static void printOut(String nOne, String nTwo){
        System.out.println(nOne+" = "+countCompare(nTwo,nOne)+" - "+conditionFlamesCandle(countCompare(nTwo,nOne)));
        System.out.println(nTwo+" = "+countCompare(nOne,nTwo)+" - "+conditionFlamesCandle(countCompare(nOne,nTwo)));
        System.out.println("Total = "+sumBoth(nOne,nTwo)+" - "+conditionFlamesCandle(sumBoth(nOne,nTwo)));
    }



    //remove space between names
    public static String reSpace(String x){
        return x.replaceAll("\\s","").toLowerCase();
    }

    //count the number of same letters from x to y and vice versa
    public static int countCompare(String nOne, String nTwo){
        nOne = reSpace(nOne);
        nTwo = reSpace(nTwo);
        int count =0;
        for (int i = 0; i < nTwo.length(); i++) {
            if(compare(nOne, nTwo.charAt(i))){
                count++;
            }
        }
        return count;
    }

    //returns true if x == y
    public static boolean compare(String nOne, char nTwo){
        for(int i = 0; i< nOne.length(); i++){
            if(nTwo == nOne.charAt(i)){
                return true;
            }
        }
        return false;
    }

    //returns the sum of both names (x+y)
    public static int sumBoth(String nOne, String nTwo){
        return countCompare(nOne,nTwo)+countCompare(nTwo,nOne);
    }




    //returns interpreted score
    public static String conditionFlamesCandle(int sumBoth){
        String a ="";
        while(sumBoth>12){
            sumBoth-=12;
        }
        switch (sumBoth){
            case 0 -> a = "NOT COMPATIBLE";
            case 1 -> a = "FRIENDS";
            case 2 -> a = "LOVERS";
            case 3 -> a = "ACCEPT";
            case 4 -> a = "MARRIAGE";
            case 5 -> a = "ENEMY";
            case 6 -> a = "SOULMATE";
            case 7 -> a = "CRUSH";
            case 8 -> a = "AFFECTION/ADMIRER";
            case 9 -> a = "NEVER";
            case 10 -> a = "DARLING";
            case 11 -> a = "LOVE OF MY LIFE";
            case 12 -> a = "ENEMIES";
        }
        return a;
    }



}
