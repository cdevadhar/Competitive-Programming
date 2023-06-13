package labs_projects;

/**
 * FindKeywordTrace.java
 * This program is used to trace findKeyword method to understand
 * how a keyword is found.
 *
 * KC 11/07/2020 modified from findKeyword method
 */ 
public class FindKeywordTrace
{
   public static void main(String[] args)
   {
      int psn;
       
      // This is a sample test.  You can replace your own sentence
      // and keyword here in order to trace the program.
      psn = findKeyword("I know nothing about snow plows. ", "no", 0);
      if (psn >= 0)
      {
         System.out.println("Found keyword at position: " + psn);
      }
      else
      {
         System.out.println("Didn't find the keyword in the sentence.");
      }
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
         System.out.println(psn + before+ " " + after);
         // The last position didn't work, so let's find the next,
         // if there is one.
         psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
         counter++;
      }
      
      // Can't find matching keyword
      return -1;
   }
}
