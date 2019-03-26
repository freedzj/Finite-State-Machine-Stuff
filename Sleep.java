

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Sleep
{
    private final static int[][] STATE_TABLE =
    {
        {1, 2, 3}, 
        {1, 3, 2}, 
        {3, 2, 1}, 
        {2, 1, 3}  
    };

    private BufferedReader in;

    public Sleep()
    {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException
    {
        char next;
        int x;

        for (;;)
        {
            System.out.print("Enter String: ");
            next = (char) in.read();
            x = 0;

            while(next == '1' || next == '4' || next == '9')
            {
                x = STATE_TABLE[x][charToColumn(next)];
                next = (char) in.read();
            }

            if(x == 1)
            {
                System.out.println(x);
            }
            if(x == 2)
            {
                System.out.println(4);
            }
            if(x == 3)
            {
                System.out.println(9);
            }
        }
    }

    public int charToColumn(char ch)
    {

        int column = 3;

        switch(ch)
        {
            case '1':
                column = 0;
                break;
            case '4':
                column = 1;
                break;
            case '9':
                column = 2;
                break;
        }
        return column;
    }
    
    public static void main(String[] args)
    {
        try
        {
            Sleep test = new Sleep();
            test.run();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
