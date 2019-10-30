public class NestingLoops
{
    public static void main( String[] args )
    {
        // this is #1 - I'll call it "CN"
        for ( int n=1; n <= 3; n++ )
        {
            for ( char c='A'; c <= 'E'; c++ )
            {
                System.out.print( c + " " + n );
            }
        }

        System.out.println("\n");

        // this is #2 - I'll call it "AB"
        for ( int a=1; a <= 3; a++ )
        {
            for ( int b=1; b <= 3; b++ )
            {
                System.out.println( a + "-" + b + " " );
            }
            // * You will add a line of code here.
            System.out.println("test");
        }

        System.out.println("\n");

    }

//    Look at the first set of nested loops ("CN"). Which variable changes faster? Is it the variable controlled by the outer loop (c) or the variable controlled by the inner loop (n)? Answer in a comment.
    // C changes faster.

//    Change the order of the loops so that the "c" loop is on the inside and the "n" loop is on the outside. How does the output change?
    /*A 1
    B 1
    C 1
    D 1
    E 1
    A 2
    B 2
    C 2
    D 2
    E 2
    A 3
    B 3
    C 3
    D 3
    E 3*/
    //this is the new output. The C changes every time; iterating through its loops. The N changes only after C has fully iterated through its loops.

//    Look at the second set of nested loops ("AB"). Change the print() statement to println(). How does the output change? (Then change it back to print().)
    //changing it to println makes each printed output print on it's own line:
           /* 1-1
            1-2
            1-3
            2-1
            2-2
            2-3
            3-1
            3-2
            3-3*/

//    Add a System.out.println() statement after the close brace of the inner loop (the "b" loop), but still inside the outer loop. How does the output change?
    //The added line prints after the total completion of the b loop's 1-3. This way it print out my line every 4 lines.
}