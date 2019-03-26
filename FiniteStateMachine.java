import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FiniteStateMachine
{
    private final static int[][] STATE_TABLE = 
    {
        {1, 5, 0, 11}, {2, 3, 0, 11},
        {2, 3, 4, 11}, {1, 5, 6, 11},
        {4, 4, 4, 11}, {1, 5, 7, 11},
        {1, 10, 8, 11}, {1, 9, 0, 11},
        {8, 8, 8, 11}, {9, 9, 9, 11},
        {1, 9, 6, 11}, {11, 11, 11, 11}
    };
    private BufferedReader in;

    public FiniteStateMachine()
    {
        in = new BufferedReader(new InputStreamReader(System.in));
    }
    public void run() throws IOException
    {
        char ch;
        int state;

        for (;;)
        {
            System.out.print("Enter your string: ");
            ch = (char) in.read();
            state = 0;

            while(ch != '\n')
            {
                state = STATE_TABLE[state][charToColumn(ch)];
                ch = (char) in.read();
            }
            if (state == 4 || state == 8 || state == 9 )
            {
                System.out.println("Yes\n");
            }
            else
            {
                System.out.println("No\n");
            }
        }
    }
    public int charToColumn(char ch)
    {
        int column = 3;
        switch(ch)
        {
            case 'a':
            column = 0;
            break;
            case 'b':
            column = 1;
            break;
            case 'c':
            column = 2;
            break;
        }
        return column;
    }

    public static void main(String[] args)
    {
        try
        {
            FiniteStateMachine fsm = new FiniteStateMachine();
            fsm.run();
        }
        catch (IOException x)
        {
            x.printStackTrace();
            System.exit(0);
        }
    }

}





































