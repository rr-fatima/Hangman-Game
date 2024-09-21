/*Name: Ruqia Fatima
Date: June 1 2022
Description: The program has 10 words from which it randomly selects one. The user is asked to guess the word by guessing one letter at a time. The user have 6 lives. The letters that the user guessed correct will be shown on the screen along with the dashes for letters that are not yet guessed. A wrong guess will result in one getting substacted form the lives. The program ends when the user guesses all the letters before their lives becomes zero or when the user lives becomes zero.
*/

import java.util.Random;
import java.util.Scanner;

class HangmanGame{

  /** getWord method to randomnly select a word *
   *  from 10 words, that the user will guess   *
   *  @return a string of the word selected     *
   */
  public static String getWord(){
    
    // creates a string array that has the 10 words from which the computer will randomnly select
    String[] words = { "science" ,"chocolate" ,"highway" ,"department" ,"scratch" ,"robotics" ,"knowledge" ,"peruse" ,"frequency" ,"python" };
    // randomnly selects a word and then return the string to the main method
    Random rand = new Random();
    int choice = rand.nextInt(9);
    return(words[choice]);
    
  }

  /** printArray method to print the array to   *
   *  the screen                                *
   *  @param char[] print - the array that will *
   *         print                              *
   */
  public static void printArray(char[] print){

    // use a for loop to print all the characters in the array
    for(int i=0; i<print.length; i++){
      System.out.print(print[i] + " ");
    }
    System.out.println(" ");
    
  }

  /** getLetter method to get the letter guess  *
   *  of the user                               *  
   *  @return a char of the letter guessed by   *
   *          the user                          *
   */
  public static char getLetter(){
    
    // asks the user for the letter guessed. So that the program do not show error when more then one letter is inputted, it stores the input as a string and then consider the first character of the string as the letter guessed. It then returns the character to the main method.
    Scanner Input = new Scanner(System.in);
    System.out.print("Enter your letter guess: ");
    String guess =Input.nextLine();
    char letter = (guess.toLowerCase()).charAt(0);
    return(letter);
    
  }

  /** checkDone method to check if there are    *
   *  dashes present in a char array            *
   *  @param char[] result - the array that will*
   *         be checked                         *
   *  @return a boolean that tells whether array*
   *          was filled with letters or not    *
   */
  public static boolean checkDone(char[] result){
    
    boolean filled = true; // stores the status of whether the array was filled with letters
    //checks if there are any dashes left in the array anf if there are than it make filled boolean false
    for(int i=0; i<result.length; i++){ 
      if('_' == result[i]){
        filled = false;
      }
    }
    return(filled); // return the boolean filled to the main method
    
  }

  /** endMessage method to print the messaga at *
   *  the end of program dependinng on whether  *
   *  the user guessed the word or not          *
   *  @param boolean correct - variable that will*
   *           tell the method if the user was  *
   *           able to guess the word correctly *
   */
  public static void endMessage(boolean correct){

    System.out.println(" ");
    if(correct == true){ // if the user guessed the word correctly the following message will print
      System.out.println("You got the word!");
    } else{ // if the user failed to guess the word correctly the following message will print
      System.out.println("Sorry you did not get the word!");
    }
    
  }

  /** main method                               *
   */
  public static void main(String[]args){

    // variables
    int lives = 6; // stores the amount of lives user have
    boolean right = false; // stores the status of whether the letter guessed by the user was right
    boolean done; // stores the status of whether the user was able to guess the whole wprd right in the given amount of lives or not

    // calls the method getWord and stores the string retuened as word. It then converts the string to  char array named wordArray
    String word = getWord();
    char[] wordArray = word.toCharArray();

    // makes a char array named answerArray, of the length of the wordArray. This array stores the progress of the user by storing the letters the user guessed correct in the game
    char[] answerArray = new char[wordArray.length];
    
    // makes use of a for loop to fill the answerArray with dashes
    for(int i = 0; i<answerArray.length; i++){
      answerArray[i] = '_' ;
    }

    // occurs repeatedly until the user has no lives left or the user has completed the game
    do{
     
      printArray(answerArray); // calls the printArray method to print the answerArray to the screen
      System.out.println("You have " + lives + " lives available!");
      char letter = getLetter(); // calls the method getLetter and stores the character returned as the letter guess of the user

      // makes use of a for loop to  check if the letter guessed by the user is in the wordArray
      for(int i=0; i<wordArray.length; i++){
        if(letter == wordArray[i]){ // if the letter is in the specific index of the wordArray
          right = true; // makes the right boolean true
          answerArray[i] = letter; // stores the letter in the aswerArray at the same index the  letter was at in the wordArray
        }
      }

      // checks if the user was able to get the letter right and if he did not, one life is substracted from the total lives the user have. If the user did get it right it makes the right boolean statement false so that it can be turned true again if the next letter guess was right
      if(right == false){
        lives--;
      } else{
        right = false;
      }

      // calls the checkDone method to check whether the user have completed the guess or not and then stores the boolean returned in the done variable
      done = checkDone(answerArray);
      
    } while(done == false && lives != 0);

    // calls the endMessage method which outputs the message depending on whether the user completed the game or not
    endMessage(done);
    System.out.println("The word was: " + word);
    System.out.println("Thank you for playing!");
    
  }
  
}