import java.util.*;

public class mainFlame {
    //Members
    //Pecaoco, Jules Alfonz R.
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nOne, nTwo;

        System.out.println("__________FLAMES CANDLE__________\n");
        System.out.print("Input Name #1: ");
        nOne = sc.nextLine();
        System.out.print("Input Name #2: ");
        nTwo = sc.nextLine();
        System.out.println("____________________");
        printOut(nOne,nTwo);

    }




    //prints Out input names, scores and interpreted score
    public static void printOut(String nOne, String nTwo){
        nOne = reSpace(nOne);
        nTwo = reSpace(nTwo);
        System.out.println("Similar Letters: "+similarLetters(nOne,nTwo));
        System.out.println(nOne+" = "+ countSimilar(nTwo,nOne)+" - "+ conditionFlames(countSimilar(nTwo,nOne)));
        System.out.println(nTwo+" = "+ countSimilar(nOne,nTwo)+" - "+ conditionFlames(countSimilar(nOne,nTwo)));
        System.out.println("Total = "+sumBoth(nOne,nTwo)+" - "+ conditionFlames(sumBoth(nOne,nTwo)));
    }


    //remove space between names
    public static String reSpace(String x){
        return x.replaceAll("\\s","").toLowerCase();
    }


    //count the number of same letters of x to y and vice versa
    public static int countSimilar(String nOne, String nTwo){
        int count =0;
        for (int i = 0; i < nTwo.length(); i++) {
            for(int k =0;k<nOne.length();k++){
                if(nOne.charAt(k)==nTwo.charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    //returns allocated memory for similar letters
    public static int lessThan(String nOne, String nTwo){
        int a = countSimilar(nOne ,nTwo),b = countSimilar(nTwo,nOne);
        if(a>b) return b;
        else return a;
    }


    //add similar letters of nOne and nTwo and filter similar letter inside array
    public static String similarLetters(String nOne, String nTwo) {
        char[] sameLet = new char[lessThan(nOne, nTwo)];
        int d=0;
        for (int i = 0; i < nTwo.length(); i++) {
            boolean f = false;
            for (int k = 0; k < nOne.length(); k++) {
                if (nOne.charAt(k) == nTwo.charAt(i)) {
                    for (char c : sameLet) {
                        if (c == nTwo.charAt(i)) {
                            f = true;
                            break;
                        }
                    }
                    if(!f){
                        sameLet[d] = nTwo.charAt(i);
                        d++;
                        break;
                    }
                }
            }
        }
        return Arrays.toString(sameLet);
    }


        //returns the sum of both names (x+y)
    public static int sumBoth(String nOne, String nTwo){
        return countSimilar(nOne,nTwo)+ countSimilar(nTwo,nOne);
    }


    //returns interpreted score
    public static String conditionFlames(int sumBoth){
        String a ="";
        while(sumBoth>12){
            sumBoth-=12;
        }
        switch (sumBoth){
            case 0 -> a = "NOT COMPATIBLE 0% CHANCE";
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
