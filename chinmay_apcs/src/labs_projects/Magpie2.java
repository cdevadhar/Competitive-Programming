package labs_projects;

/**
 * Magpie2.java  
 * Thie magpie will take user input from keyboard.
 * 
 * KC 11/07/2020 modified from CSAwesome.
 *
 */ 
public class Magpie2
{
   // Greeting
   public String getGreeting()
   {
      return "Hello, let's talk. (Type [Bye] to end the program.)";
   }

   // Based on the statement, get some response  
   public String getResponse(String statement)
   {
      String response = "";
      if (statement.indexOf("no") >= 0)
      {
         response = "Why so negative?";
      } 
      else if (statement.indexOf("mother") >= 0
                 || statement.indexOf("father") >= 0
                 || statement.indexOf("sister") >= 0
                 || statement.indexOf("brother") >= 0)
      {
         response = "Tell me more about your family.";
      }
      else
      {
         response = getRandomResponse();
      }
      return response;
   }

   // Canned random responses if the program doesn't have a good response.
   private String getRandomResponse()
   {
      final int NUMBER_OF_RESPONSES = 4;
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
      return response;
   }
}
