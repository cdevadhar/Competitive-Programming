package labs_projects;
/**
 * Magpie4.java
 * @author - Chinmay Devadhar, Mehul Nair
 * @author - Period 3
 * @author - Id 10022320
 *
 */ 
public class Magpie4
{
   // Greeting when program starts
   public String getGreeting()
   {
      return "Hello, let's talk. (Type [Bye] to end the program.)";
   }

   // Based on the statement, get some response  
   public String getResponse(String statement)
   {
	  // Remove leading and trailing spaces.
	  statement = statement.trim();
	  String response = "";
	  // Check if the input is an empty string - if it is, tell the user to say something, please.
	  if (statement.length()==0) {
		  response = "Say something, please.";
	  }
	  // Check if the input contains "I like <something>"; call the transformILike method if it does
	  else if (findKeyword(statement, "I like", 0)>=0) {
		  response = transformILike(statement);
	  }
	  // Check if the input contains "I want <something>"; call the transformIWant method if it does
	  else if (findKeyword(statement, "I want", 0)>=0) {
		  response = transformIWant(statement);
	  }
	  // Check for the keyword "no", if the input contains it return "Don't be so negative"
	  else if (findKeyword(statement, "no", 0)>=0 || findKeyword(statement, "not", 0)>=0) {
		  response = "Don't be so negative.";
	  }
	  // Check if the user mentions "sunny" or "rainy", if it does then talk about the weather
	  else if (findKeyword(statement, "sunny", 0)>=0 || findKeyword(statement, "rainy", 0)>=0) {
		  response = "The weather is nice where I am.";
	  }
	  // Check if the user mentions English or math, if it does then talk about school
	  else if (findKeyword(statement, "English", 0)>=0 || findKeyword(statement, "math", 0)>=0) {
		  response = "I never went to school.";
	  }
	  // Check if the user mentions sports, if it does then talk about sports
	  else if (findKeyword(statement, "baseball", 0)>=0 || findKeyword(statement, "basketball", 0)>=0) {
		  response = "I hate that sport.";
	  }
	  // Check if the user talks about a cat or a dog, if it does then talk about pets
	  else if (findKeyword(statement, "dog", 0)>=0 || findKeyword(statement, "cat", 0)>=0) {
		  response = "Tell me more about your pet.";
	  }
	  // Check if the user talks about their family members, if it does then talk about their family
      else if (findKeyword(statement, "mother", 0) >= 0
                 || findKeyword(statement, "father", 0) >= 0
                 || findKeyword(statement, "sister", 0) >= 0
                 || findKeyword(statement, "brother", 0) >= 0)
      {
         response = "Tell me more about your family.";
      }
	  // If none of the keywords are detected, call getRandomResponse to store a random noncommittal response in response
      else
      {
         response = getRandomResponse();
      }
      return response;
   }

   // Canned random responses if the program doesn't have a good response.
   private String getRandomResponse()
   {
      final int NUMBER_OF_RESPONSES = 10;
      // Generate a random number from 0 to NUMBER_OF_RESPONSES - 1
      int randomNum = (int)(Math.random() * NUMBER_OF_RESPONSES);
      String response = "";
      // These conditional statements assign a value to response based on the value of the random number
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
         response = "Interesting information.";
      }
      else if (randomNum == 5)
      {
         response = "That's cool.";
      }
      else if (randomNum == 6)
      {
         response = "Wow.";
      }
      else if (randomNum == 7)
      {
         response = "I didn't know that.";
      }
      else if (randomNum == 8)
      {
         response = "Strong message.";
      }
      else if (randomNum == 9)
      {
         response = "Factual statement.";
      }
      return response;
   }
   
   // Call this method if the user entered something of the form "I like <something>"
   // It will return a response "What do you like about <something>?"
   private String transformILike(String statement) {
	   // First trim the leading and trailing spaces from the input
	   statement = statement.trim();
	   // Check if the last character in the string is a period
	   String lastChar = statement.substring(statement
	                                            .length() - 1);
	   // If it is, remove the period because we don't want extra punctuation
	   if (lastChar.equals(".")) {
		   statement = statement.substring(0, statement
	                                            .length() - 1);
	   }
	   // Find the index of "I like" in the statement
	   int psn = findKeyword (statement, "I like", 0);
	   // Trim spaces in the rest of the statement - this is the <something> that the user said they liked
	   String restOfStatement = statement.substring(psn + 6).trim();
	   // Return the response
	   return "What do you like about " + restOfStatement + "?";
   }
   // Call this method if the user entered something of the form "I want <something>"
   // It will return a response "Would you really be happy if you had <something>?"
   private String transformIWant(String statement) {
	   //First trim leading and trailing spaces from the input
	   statement = statement.trim();
	   // Check if the last character is a period
	   String lastChar = statement.substring(statement
	                                            .length() - 1);
	   // If it is, remove the period to prevent punctuation errors
	   if (lastChar.equals(".")) {
		   statement = statement.substring(0, statement
	                                            .length() - 1);
	   }
	   // Find the index of "I want" in the input
	   int psn = findKeyword (statement, "I want", 0);
	   // Trim spaces in the rest of the statement - this is the <something> that the user said they liked
	   String restOfStatement = statement.substring(psn + 6).trim();
	   // Return the response
	   return "Would you really be happy if you had " + restOfStatement + "?";
   }
   
   /**
    * Search for one word in phrase. The search is not case
    * sensitive. This method will check that the given goal
    * is not a substring of a longer string (so, for example, "I know" does not contain "no").
    *
    * @param statement: the string to search
    * @param goal: the string to search for
    * @param startPos: the character of the string to begin the search at
    * @return the index of the first occurrence of goal in statement
    * or -1 if it's not found
    */
    
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
