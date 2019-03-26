// Finite State Machine
// Counts the number of occurrences of 4 word: 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class newFSM {

   private static final int leapAccept = 4;  
   private static final int pleaseAccept = 10;  
   private static final int appleAccept = 12;  
   private static final int paperAccept = 11;  

   //   P  A  N   C  K   E  ?
   private static final int[][] STATE_TABLE = {
       {5, 1, 0, 16, 0, 0, 0}, // state 0
       {5, 1, 2, 16, 0, 0, 0}, // state 1: start to pancake
       {5, 1, 0, 3, 0, 0, 0}, // state 2
       {4, 1, 0, 16, 0,  0, 0}, // state 3
       {15, 6, 0, 16, 0, 0, 0}, // state 4
       {5, 6, 0, 18, 0,  0, 0}, // state 5
       {5, 1, 7, 16, 0, 0, 0}, // state 6
       {5, 1, 0, 8, 0, 0, 0}, // state 7
       {4, 1, 0, 16, 9, 0, 0},// state 8 
       {5, 1, 10, 16, 0, 0, 0}, // state 9
       {5, 1, 0, 16, 0, 0, 0}, // state 10
       {5, 1, 0, 16, 0, 0, 0}, // state 11
       {5, 1, 0,  3, 0, 0, 0}, // state 12 
       {5, 1, 12, 3, 0, 0, 0}, // state 13 
       {5, 1, 0, 16, 0, 11, 0}, // state 14 
       {5, 13, 0, 16, 0, 0, 0},  // state 15 
       {17, 1, 0, 16, 0, 0, 0}, // state 16 
       {15, 1, 0, 16, 0, 0, 0}, // state 17 
       {19, 6, 0, 16, 0, 0, 0}, //state 18
       {15, 1, 14, 14, 0, 0, 0}// state 19 
   };

    private BufferedReader in;
    private int pleaseCount; 
    private int leapCount;
    private int appleCount;
    private int paperCount;


    public newFSM(String filename) throws IOException {
        in = new BufferedReader(
                 new FileReader(filename));
       leapCount = 0; 
       pleaseCount = 0;
       paperCount = 0;
       appleCount = 0;
    }


    public void run() throws IOException {
        char ch;
        int unicode;
        int state = 0;

        unicode = in.read();
        while (unicode != -1) {
           ch    = (char) unicode;
           state = STATE_TABLE[state][charToColumn(ch)];
           if (state == leapAccept) {
              leapCount++;
           }
           if (state == pleaseAccept) { 
              pleaseCount++;
           }
           if (state == paperAccept) 
              paperCount++;
           if (state == appleAccept) 
              appleCount++;
           unicode = in.read();
        }
        System.out.println( "Occurrence counts: ");
        System.out.println( "please count is " + pleaseCount);
        System.out.println( "leap   count is " + leapCount);
        System.out.println( "paper  count is " + paperCount);
        System.out.println( "apple  count is " + appleCount);
    }



    public int charToColumn(char ch) {
        if (ch == 'P' || ch == 'p') 
           return 0;
        if (ch == 'L' || ch == 'l') 
           return 1;
        if (ch == 'E' || ch == 'e') 
           return 2;
        if (ch == 'A' || ch == 'a') 
           return 3;
        if (ch == 'S' || ch == 's') 
           return 4;
        if (ch == 'R' || ch == 'r') 
           return 5;
        return 6;
    }

    public static void main(String[] args) {
        if (args.length < 1)
           System.out.println 
                ("Run again, entering a filename at the commandline");
        else {
           try {
               newFSM fsm = new newFSM(args[0]);
               fsm.run();
           } catch (IOException ex) {
               ex.printStackTrace();
               System.exit(1);
           }
       }
    }
}
