import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;
import java.io.*;


public class HangmanGame {

    //the random word
    String word;
    //used for building the attempt
    char[] attemptAry;
    //represents the users current attempt
    String attempt;
    //used for tracking letters allready provided by the use
    ArrayList<Character> letters;
    //used for comparing specigic user input to individual characters of the word
    ArrayList<Character> wordLetters;
    int hp;
    int prg;



    public HangmanGame()
    {
        SetInitValues();
    }

    void SetWordChars()
    {
        for(int i = 0; i < word.length(); i++)
        {
          wordLetters.add(word.charAt(i));
        }
    }

    //sets the starting values for the game
    void SetInitValues()
    {
        word = RandomWord();
        hp = 6;
        prg = 0;
        letters = new ArrayList<Character>();
        wordLetters = new ArrayList<Character>();
        SetWordChars();
        attemptAry = new char[word.length()];
        attempt = "";
    }

    //returns a random word from an array of words
    String RandomWord()
    {

        try {
            File file = new File("data\\words.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            ArrayList<String> wordFile = new ArrayList<String>();
            while (true)
            {
                String word = br.readLine();

                if(word != null) {
                    wordFile.add(word);
                }
                else
                {
                    break;
                }
            }

            String[] rwords = new String[wordFile.size()];
            wordFile.toArray(rwords);

            Random rand = new Random(); int value = rand.nextInt(rwords.length);
            for(int i = 0; i< rwords.length; i++)
            {
                rwords[i] = rwords[i].toLowerCase();
            }
            return  rwords[value];

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.exit(99);
        return  null;

    }

    //starts the program
    void Init()
    {
        System.out.println("Welcome to the hang man game, enter the word or, guess a letter to reveal portions ");
        ResolveAttempt();
        Prompt();
    }

    void Prompt()
    {
        Scanner in = new Scanner(System.in);

        String input = in.next();

        input = input.toLowerCase();

        if(input.length() == 1)
        {
            boolean flag = true;
            if(letters.contains(input.charAt(0)))
            {
                System.out.println("You you already entered a '" + input + "' before");
                flag = false;
            }
            else if(wordLetters.contains(new Character(input.charAt(0))))
            {
                //System.out.println("match found| Input: [" + input + "] word [" + word +"]");
                letters.add(input.charAt(0));
                flag = false;
            }
            if(!word.contains(input) && flag == true)
            {
                letters.add(input.charAt(0));
                System.out.println("-1 point");
                hp--;
            }
            ResolveAttempt();
        }
        else
        {
            if(input.equals(word))
            {
                attempt = word;
            }
            else
            {
                System.out.println("Wrong, -1 point");
                hp--;
                ResolveAttempt();
            }
        }
        CheckStatus();
    }

    //Checks progress to solving the word based on letters provided by the user
    public void ResolveAttempt()
    {
        attempt = "";
        for(int i = 0; i <word.length(); i++)
        {
            Character tmp = word.charAt(i);
            if(letters.contains(tmp))
            {
                attemptAry[i] = tmp;
            }
            else
            {
                attemptAry[i] = '*';
            }
            attempt += attemptAry[i];
        }


        String resOut = "Word: " + attempt + "    Chances left: " + hp + "    Attempted letters: ";

        for(int i = 0; i < letters.size(); i++)
        {
           resOut +=  letters.get(i);
           resOut += ' ';
        }

        System.out.println(resOut);

    }
    void CheckStatus()
    {
        // if we have run out of attempts the game is over
        if(hp <= 0)
        {
            System.out.println("Game over, you lose");
            EndOrReplay();
            return;
        }

        //if our attempt is the same as our word then we won
        if(attempt.equals(word))
        {
            System.out.println("You win");
            EndOrReplay();
            return;
        }

        //If we still have attempts and we have not found the word we should Prompt the user for another attempt
        Prompt();
    }
    void EndOrReplay()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Play again? y/n");
        String input = in.next();

        if(input.toLowerCase().equals("y"))
        {
            SetInitValues();
            Init();
        }
        else
        {
            System.out.println("Thank you for playing!");
            return;
        }
    }
}
