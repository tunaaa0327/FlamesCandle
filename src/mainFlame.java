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
        int total = countSimilar(nOne,nTwo)+countSimilar(nTwo,nOne);

        System.out.println(nOne+" = "+ countSimilar(nTwo,nOne)+" : "+notSimilarLetters(nTwo,nOne));
        System.out.println(nTwo+" = "+ countSimilar(nOne,nTwo)+" : "+notSimilarLetters(nOne,nTwo));
        System.out.println("Total = "+total+" - "+ conditionFlames(total));
    }


    //remove space between names
    public static String reSpace(String x){
        return x.replaceAll("\\s","").toLowerCase();
    }


    //count the number of same letters of x to y and vice versa
    public static int countSimilar(String nOne, String nTwo){
        int count =0;
        for (int i = 0; i < nTwo.length(); i++) {
            boolean a = true;
            for(int k =0;k<nOne.length();k++){
                if(nOne.charAt(k)==nTwo.charAt(i)){
                    a = false;
                    break;
                }
            }
            if(a) count++;
        }
        return count;
    }


    //add similar letters of nOne and nTwo and filter similar letter inside array
    public static String notSimilarLetters(String nOne, String nTwo) {
        char [] notSame = new char[countSimilar(nOne,nTwo)];
        int d=0;
        for (int i = 0; i < nTwo.length(); i++) {
            boolean a = true;
            for(int k =0;k<nOne.length();k++){
                if(nOne.charAt(k)==nTwo.charAt(i)){
                    a = false;
                    break;
                }
            }
            if(a) notSame[d++]=nTwo.charAt(i);
        }
        return Arrays.toString(notSame);
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
