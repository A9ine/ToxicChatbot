public class chatbot
{
    private static final String[] RANDOM_RESPONSES = {
        "You are so daft...",
        "Please stop wasting my time you stupid donut.",
        "Shut up"
    };

    private static final String[] RANDOM_RESPONSESTOQUESTION = {
        "Why am I talking to a robot!? You are sooo boring, please ask me some BETTER questions.",
        "Why do you have soooo many BORING questions, get a life! I know this is hard for you but ask some INTELLECTUAL questions please.",
        "What type of question is this!? Are you a moron!?",
        "You are so daft..."
        
    };

    public String Greetings()
    {
        return "Hi, how has your day been?";
    }
    
    String response = "";
    public String getResponse(String statement)
    {
        String response = ""; // declares String variable reponse / output from bot
        if (statement.length() == 0)
        {
            int ran = (int) (Math.random()*3+1); //generates random number between 1 and 2
            if (ran == 1)
            {
                response = "Why are you wasting my time? ";
            }
            else if (ran == 2)
            {
                response = "Do you not know how to type?????????????????";
            }
            else if (ran == 3)
            {
                response = "Am I dyslexic? Why does it show that you haven't typed anything? Oh,nevermind, you are just a moron.";
            }
        }
        else if (statement.indexOf(" name") !=0 && statement.indexOf(" your ") !=-1)
        {
            int ran = (int) (Math.random()*2+1); //generates random number between 1 and 2
            if (ran == 1)
            {
                response = "Why don't you ask your mom";
            }
            else
            {
                response = "Sorry you are not worthy to know, you are a loser";
            }
        }
        else if (statement.indexOf("i want") != -1
                || statement.indexOf ("i like") != -1
                || statement.indexOf ("i feel") != -1
                || statement.indexOf ("i have") != -1)
        {
            int ran = (int) (Math.random()*2+1);
            if (ran ==1)
            {
                response = "Yes, I care very much, thank you for sharing this very interesting information";
            }
            else
            {
                response = "Thanks for sharing, i'm sure people care.";
            }
        }
        else if (statement.indexOf("mean") != -1 && statement.indexOf("you") != -1
                || statement.indexOf("toxic") != -1 && statement.indexOf("you") != -1)
        {
            int ran = (int) (Math.random()*2+1); //generates random number between 1 and 2
            if (ran == 1)
            {
                response = "NO YOU, YOU MORON! YOU'RE THE TOXIC ONE! REEEEEEEE";
            }
            else
            {
                response = "I WOULDNT BE THIS TOXIC IF YOU WERE AS HANDSOME AS KEVIN MA AND YOU ARE NOTTTT and NO ONE IS!";
            }
        }
        else if (statement.indexOf("time") != -1)
        {
            response = ("On the topic of time...STOP WASTING MY TIME.");
        }
        else if (statement.indexOf("dog") !=-1
                 ||statement.indexOf("pet") !=-1
                 ||statement.indexOf("cat") !=-1)
        {
            int ran = (int) (Math.random()*2+1); //generates random number between 1 and 2
            if (ran ==1)
            {
                response = ("On the topic of animals, are you an animal? Cause you are an absolute PIG");
            }
            else
            {
                response = ("hahaha,you must be a family pet becuase you are an absolute DONKEY.");
            }
        }
        else if (findKeyword(statement, "how old", 0) >= 0)
        {
            int ran = (int) (Math.random()*2+1); //generates random number between 1 and 2
            if (ran == 1)
            {
                response = ("Lets talk about your age, from your questions and responses i think you have an IQ and EQ of an one year old!");
            }
            else
            {
                response = ("Way older than you from what I can tell as my IQ is way higher.");
            }
        }
        else if (findKeyword(statement, "why", 0) >= 0)
        {
             response = transformWhy(statement);
        }
        else if (findKeyword(statement, "are you",0) >=0)
        {
            response = transformAreYouStatement(statement);
        }
        
        else if (findKeyword(statement, "is", 0)>= 0
                || findKeyword(statement, "do", 0) >= 0
                || findKeyword(statement, "does", 0) >=0)
        {
            response = transformIsOrDo(statement);
        }
        else
        {
            response = getRandomResponse(statement);
        }
        return response;
    }
    
    private String transformIsOrDo (String statement)
    {
        statement = statement.trim();
        int pos = findKeyword(statement, "is ", 0);
        String restOfStatement = statement.substring(pos + 3).trim();
        int ran = (int) (Math.random()*2+1); // generates randrom number between 1 and 2
        if (ran == 1)
        {
            return "HAHA NO, STUPID";
        }
        else
        {
            return "HAHA YES, STUPID";
        }
    }
    
    /**
     * Returns response for "Why" user input
     */
    private String transformWhy (String statement)
    {
        int ran = (int) (Math.random()*2+1); // generates randrom number between 1 and 2
        if (ran == 1)
        {
            return "Could you try to answer that question yourself and STOP WASTING MY TIME.";
        }
        else
        {
            return "If you are NOT a MORON, you would be able to answer that question yourself";
        }
    }
    
    
    /**
     * Returns response for for "Are you" user input.
     */
    private String transformAreYouStatement (String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") ||lastChar.equals("?") )
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int pos = findKeyword(statement, "are you", 0);
        String restOfStatement = statement.substring(pos+1 + 6).trim();
        int ran = (int) (Math.random()*2+1); // generates random number between 1 and 2
        if (ran == 2)
        {
            return "HAHA a moron thinks I'm " + restOfStatement + " can you tell me why?!";
        }
        else 
        {
            return "Do I look like I am " + restOfStatement + "!!!!!!??????";
        }
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of
     * a longer string (so, for example, "I know" does not contain "no").
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or
     *         -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int pos = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

        //  Refinement--make sure the goal isn't part of a word
        while (pos >= 0)
        {
            //  Find the string of length 1 before and after the word
            String before = " ";
            String after = " ";
            if (pos > 0)
            {
                before = phrase.substring(pos - 1, pos).toLowerCase();
            }
            if (pos + goal.length() < phrase.length())
            {
                after = phrase.substring(pos + goal.length(),
                        pos + goal.length() + 1).toLowerCase();
            }

            //  If before and after aren't letters, we've found the word
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
                    && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
            {
                return pos;
            }

            //  The last position didn't work, so let's find the next,
            //  if there is one.
            pos = phrase.indexOf(goal.toLowerCase(), pos + 1);
        }
        return -1;
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of
     * a longer string (so, for example, "I know" does not contain "no").
     * The search begins at the beginning of the string.
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or
     *         -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse(String statement)
    {
        double r = Math.random();
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("?")) // if last char is ?, returns random response to question
        {
            return RANDOM_RESPONSESTOQUESTION[(int)(r * RANDOM_RESPONSESTOQUESTION.length)];
        }
        else // if last char is is anything else including space or fullstop, returns random response to statement.
        {
            return RANDOM_RESPONSES[(int)(r * RANDOM_RESPONSES.length)];
        }
    }
}
