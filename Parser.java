import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Parser
{
    private BufferedReader in;
    char curr;
    
    public Parser()
    {
        in = new BufferedReader(
            new InputStreamReader(System.in));
    }

    public static void main(String[] args)
    {
        try {
            Parser recursiveDecentParser = new Parser();
            recursiveDecentParser.parse();
        }catch (IOException ex){
            ex.printStackTrace();
            System.exit(1);
        }

    }

    public char readChar() throws IOException
    {
        char ch;
        do{
            ch = (char) in.read();
        }while(ch<= ' ' && ch!= '\n');
        return ch;
    }

    public void parse() throws IOException
    {
        System.out.println("Enter a string for parsing: ");
        curr = readChar();
        Expr();
        if(curr == '\n')
        {
            System.out.println("String is in the language.");
        }
        else
        {
            error();
        }
    }

    public void match(char lookahead) throws IOException
    {
        if(curr == lookahead)
        {
            curr = readChar();
        }
        else
        {
            error();
        }
    }

    public void error()
    {
        System.out.println("syntax error");
        System.exit(1);
    }


    public void Expr() throws IOException
    {
        F();
        Term();
        G();
    }

    public void F() throws IOException
    {
        if( curr == '+' || curr == '-')
        {
            AddOp();
        }
    }

    public void G() throws IOException
    {
        if(curr == '+' || curr == '-')
        {
            AddOp();
            Term();
            G();
        }
    }

    public void Term() throws IOException
    {
        if (curr == '*')
        {
            match('*');
        }
        Factor();
        H();
    }

    public void H() throws IOException
    {
        if( curr == '*' || curr == '/')
        {
            MulOp();
            Factor();
            H();
        }
    }

    public void Factor() throws IOException
    {
        if(isDigit(curr))
        {
            Number();
        }
        else if(curr == '(')
        {
            match('(');
            Expr();
            match(')');
        }
    }

    public void AddOp() throws IOException
    {
        if(curr == '+' || curr == '-')
        {
            match(curr);
        }
    }

    public void MulOp() throws IOException
    {
        if(curr == '*' || curr == '/')
        {
            match(curr);
        }
    }
    
    public void Number() throws IOException
    {
        if(isDigit(curr))
        {
            Digit();
            I();
        }
    }

    public void I() throws IOException
    {
        if(isDigit(curr))
        {
            Digit();
            I();
        }
    }

    public void Digit() throws IOException
    {
        if(isDigit(curr))
        {
            match(curr);
        }
    }

    public boolean isDigit(char c)
    {
        if(c >= '0' && c <= '9')
        {
            return true;
        }
        return false;
    }
}

