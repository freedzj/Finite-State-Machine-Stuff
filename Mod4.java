import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Mod4
{
    private BufferedReader in;
	  
    private final static int[][] STATE_TABLE = 
    {
        {3, 1, 4}, //state 0
        {0, 2, 4}, //state 1
        {1, 3, 4}, //state 2
        {2, 0, 4}, //state 3
        {4, 4, 4} //trap state
    };

    public Mod4()
    {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException
    {
        char ch;
        int state;

        for(;;)
        {
            System.out.print("Enter your string: ");
            ch = (char) in.read();
            state = 0;

            while(ch != '\n')
            {
                state = STATE_TABLE[state][charToColumn(ch)];
                ch = (char) in.read();
            }

            if (state == 0)
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
        int column = 2;

        switch(ch)
        {
            case 'a':
                column = 0;
                break;
            case 'b':
                column = 1;
                break;
        }

        return column;
    }

    public static void main(String[] args)
    {
        try
        {
            Mod4 m4 = new Mod4();
            m4.run();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}

