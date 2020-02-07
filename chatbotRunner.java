import java.util.*;
public class chatbotRunner 
{
    public static void main(String[] args)
    {
        Chatbot ToxicMale = new Chatbot();

        System.out.println(ToxicMale.Greetings());
        Scanner in = new Scanner(System.in);
        String statement = in.nextLine().toLowerCase();
        
        String [] input = new String[15]; // Chatbot will end after 15 inputs form user.
        int i = 0; // int variable for number of responses from bot
        int j = 0; // int variable to test for repeated input
        while (!statement.equals("bye"))
        {
            if (i == 0) // Only occurs doing first run
            {
                input [i] = statement;
                System.out.print ("IT DOESN'T MATTER HOW YOUR DAY'S BEEN! NO ONE CARES! HURRY UP SO I CAN LEAVE! ");
            }
            if (i!=0) // Linear searches through array for repeated user input
            {
                for (String x : input) // enhanced for loop to perform linear search.
                {
                    if (statement.equals(x))
                    {
                        j = 1;
                    }
                }
                input [i] = statement;
            }
            if (j == 1) // If user input is repeated
            {
                int ran = (int) (Math.random()*3+1); // generates num between 1-3
                if (ran == 1 && statement.indexOf("?") == statement.length()-1)
                {
                    System.out.println ("We already talked about this, stop wasting my time!");
                }
                else if (ran == 2 && statement.indexOf("?") == statement.length()-1)
                {
                    System.out.println ("You already asked me this. If you are not going to listen to me properly i might as well just leave!");
                }
                else if (ran == 3 && statement.indexOf("?") == statement.length()-1)
                {
                    System.out.println ("You think I want to be here? You've already asked me this. Stop wasting my time");
                }
                else if (ran ==1)
                {
                    System.out.println ("Do you have a stutter?.... you said the same thing");
                }
                else if (ran == 2)
                {
                    System.out.println ("incase you are blind, this is your second time saying the same thing.");
                }
                j = 0;
            }
            else if (i!=0)
            {   
                System.out.println(ToxicMale.getResponse(statement));
            }
            i++;
            if (i > 14) // if user enters too many inputs, toxic male gets annoyed and leaves
            {
                System.out.print("You have wasted too much of my precious time. Have a good life.");
            }
            statement = in.nextLine().toLowerCase(); // changes input to lowercase to avoid confusion between cases.
        }
        if (statement.equals("bye"))
        {
            System.out.println("This dreadful conversation is FINALLY over.");
            i = 20; // ends program as array length is only set to 15
        }
    }
}
