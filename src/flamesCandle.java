import java.util.*;

public class flamesCandle{
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
        int a = countDiffLetters(nTwo,nOne);
        int b = countDiffLetters(nOne,nTwo);

        System.out.println("Similar Letters: "+arraySimLetters(nOne,nTwo));
        System.out.println(nOne+" = "+ a+" : "+ arrayDiffLetters(nTwo,nOne));
        System.out.println(nTwo+" = "+ b+" : "+ arrayDiffLetters(nOne,nTwo));
        System.out.println("Total = "+(a+b)+" - "+ conditionFlames(a+b));
    }


    //remove space between names
    public static String reSpace(String x){
        return x.replaceAll("\\s","").toLowerCase();
    }


    //returns number of different letters of nOne and nTwo vice versa
    public static int countDiffLetters(String nOne, String nTwo){
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


    //returns array of different character of nOne and nTwo vice versa
    public static String arrayDiffLetters(String nOne, String nTwo) {
        char [] notSame = new char[countDiffLetters(nOne,nTwo)];
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

    //returns array of similar letters
    public static String arraySimLetters(String nOne, String nTwo) {
        ArrayList<Character> notSame = new ArrayList<>();
        for (int i = 0; i < nTwo.length(); i++) {
            for(int k =0;k<nOne.length();k++){
                if(nOne.charAt(k)==nTwo.charAt(i)){
                    if(!notSame.contains(nTwo.charAt(i))){
                        notSame.add(nTwo.charAt(i));
                    }
                }
            }
        }
        return String.valueOf(notSame);
    }



    //returns interpreted score
    public static String conditionFlames(int sumBoth){
        while(sumBoth>6){
            sumBoth -= 6;
        }
        String a ="";
        switch (sumBoth){
            case 0 -> a = "NOT COMPATIBLE 0% CHANCE";
            case 1 -> a = "FRIENDS";
            case 2 -> a = "LOVERS";
            case 3 -> a = "ADMIRER";
            case 4 -> a = "MARRIAGE";
            case 5 -> a = "ENEMY";
            case 6 -> a = "SOULMATE";
        }
        return a;
    }

}