package labs_projects;
public class Magpie5
{
    public String getGreeting()
   {
      return "Hello, let's talk. (Type [Bye] to end the program.)";
   }

   // Based on the statement, get some response  
   public String getResponse(String statement)
   {
	  System.out.println("called getResponse");
      String response = "";
      if (findKeyword(statement, "no", 0) >= 0 || findKeyword(statement, "not", 0) >= 0)
      {
         response = "Why so negative?";
      }
      //Anything with keyword "no" will return why so negative.
      else if (findKeyword(statement, "mother", 0) >= 0
                 || findKeyword(statement, "father", 0) >= 0
                 || findKeyword(statement, "sister", 0) >= 0
                 || findKeyword(statement, "brother", 0) >= 0 || findKeyword(statement, "grandma", 0) >= 0 || findKeyword(statement, "grandpa", 0) >= 0)
      {//anything with the above keywords will return the family response
         response = "Tell me more about your family.";
      }
      else if (findKeyword(statement, "cat", 0) >= 0 || findKeyword(statement, "dog", 0) >= 0)
      {
          response = "Tell me more about your pet."; //detects pet keywords
     
      }
      else if (findKeyword(statement, "sunny", 0) >= 0 || findKeyword(statement, "rainy", 0) >= 0)
      {
          response = "Tell me more about the weather."; //detects weather related keywords
      }
      else if (findKeyword(statement, "English", 0) >= 0 || findKeyword(statement, "math", 0) >= 0)
      {
          response = "Tell me more about school."; //detects school subject related keywords
      }
      else if (findKeyword(statement, "basketball", 0) >= 0 || findKeyword(statement, "baseball", 0) >= 0)
      {
          response = "Tell me more about that sport."; // detects sport related keywords
      }
      else if (findKeyword(statement, "", 0) >= 0)
      {
          response = "Say something, please";
      }
      else
      {
    	 System.out.println("Will generate random string");
         response = getRandomResponse();
      }
      return response;
   }

   // Canned random responses if the program doesn't have a good response.
   private String getRandomResponse()
   {
	  System.out.println("Called method");
      final int NUMBER_OF_RESPONSES = 10; //set number to 10 to gain 6 new noncommital responses
      int randomNum = (int)(Math.random() * NUMBER_OF_RESPONSES);
      String response = "";

      if (randomNum == 0)
      {
         response = "Interesting, tell me more.";
      }
      else if (randomNum == 1)
      {
         response = "Hmmm.";
      }
      else if (randomNum == 2)
      {
         response = "Do you really think so?";
      }
      else if (randomNum == 3)
      {
         response = "You don't say.";
      }
      else if (randomNum == 4)
      {
          response = "Ok and?";
        }
    else if (randomNum == 5)
    {
        response = "I do not care";
    }
    else if (randomNum == 6)
    {
        response = "Thanks for telling me that!";
    }
    else if (randomNum ==7)
    {
        response = "Did I ask?";
    }
    else if (randomNum == 8)
    {
        response = "Don't say that please!";
    }
    else if (randomNum == 9)
    {
        response = "That was very hurtful!";
    }
    else if (randomNum == 10)
    {
        response = "Hope I was fun to talk with!";
    }
      return response;
   }
   private static int findKeyword(String statement, String goal, int startPos)
   {
      // trim() will trim off leading and trailing blanks.
      String phrase = statement.trim();
      int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
      // counter is used to keep track how many times we need to go through
      // the while loop before we find the matching keyword.
      int counter = 1;

      // Refinement--make sure the keyword isn't part of a word
      while (psn >= 0) // Find keyword
      {
         String before = " ", after = " ";
         if (psn > 0)
         {
            // before will hold the char before the keyword
            before = phrase.substring(psn - 1, psn).toLowerCase();
         }
         if (psn + goal.length() < phrase.length())
         {
            // after will hold the char after the keyword
            after = phrase.substring(psn + goal.length(),
                                     psn + goal.length() + 1).toLowerCase();
         }
         
         // determine the values of psn, before, and after at this point
         // Add your print statement here for counter, psn, before and after
          
         // If before and after aren't letters, we've found the word!
         if (((before.compareTo("a") < 0) ||(before.compareTo("z") > 0)) 
            && ((after.compareTo("a") < 0) ||(after.compareTo("z") > 0)))
         {
            return psn;
         }

         // The last position didn't work, so let's find the next,
         // if there is one.
         psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
         counter++;
      }
      
      // Can't find matching keyword
      return -1;
   }
}
