/******************************************************************************
 *  Compilation:  javac CommentStripper.java
 *  Execution:    java CommentStripper < source.java
 *  Dependencies: StdIn.java
 *  
 *  Reads in a Java program and removes all of the comments using a 5
 *  state finite state automaton.
 * 
 *  Known issues
 *  ------------
 *   - not designed to handle quoted strings, e.g., s = "/***//*"
 *   - assumes lines end with '\n' - can be OS dependent
 *
 *******************************************************************************/

public class CommentStripper
{ 
    public static void main(String[] args)
    {
        final int CODE  = 0;   
        final int SLASH = 1;  
        final int BLOCK = 2;   
        final int LINE  = 3;   
        final int STAR  = 4;   
        final int QUOTE = 5;   
  
        int state = CODE;     

        while(!StdIn.isEmpty())
        {
            char c = StdIn.readChar();
            switch(state)
            {
                case CODE: 
                     if (c == '/')
                     {
                          state = SLASH;                  
                     }
                     else if (c == '"')
                     {
                          state = QUOTE;
                          StdOut.print(c);
                     }
                     else           
                     {
                          StdOut.print(c);   
                     }
                     break;

                case SLASH:
                     if (c == '*') 
                     {
                          state = BLOCK;                
                     }
                     else if (c == '/') 
                     {
                          state = LINE;    
                     }
                     else      
                     {
                          state = CODE;
                          StdOut.print("/" + c);
                     }
                     break;

                case BLOCK:
                     if (c == '*') 
                     {
                          state = STAR;               
                     }
                     break;

                case STAR:
                     if (c == '/') 
                     {
                          state = CODE;
                          StdOut.print(" "); 
                     }
                     else if (c == '*') 
                     {
                          state = STAR;                
                     }
                     else  
                     {
                          state = BLOCK;          
                     }
                     break;

                case LINE: 
                     if (c == '\n')
                     {
                          state = CODE;
                          StdOut.println();   
                     }
                     break;

               case QUOTE:
                     if (c == '"')
                     {
                          state = CODE;
                          StdOut.print(c); 
                     }
                     else
                     {
                          StdOut.print(c);
                     }
                     break;

            }
        }
    }
}

