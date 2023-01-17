import java.util.Scanner;
public class Ceelo {

    Scanner scan = new Scanner(System.in);
    public Ceelo()
    {
    }

    public Die die = new Die();


    Banker CLow = new Banker ("C-Low", 1000, 0);
    private boolean bankBreak = CLow.getChips() < 0;

    Player ALow = new Player("A-Low", 100, 0, 0);
    Player BLow = new Player("B-Low", 100, 0, 0);
    Player DLow = new Player("D-Low", 100, 0, 0);

    private boolean playersLose = ALow.getChips() < 0 && BLow.getChips() < 0 && DLow.getChips() < 0;
    private boolean passRound = false;

    private boolean valid = false;

    int[] rollCollection = new int[3];
    private int firstRoll = 0;
    private int secondRoll = 0;
    private int thirdRoll = 0;

    public void play()
    {
        System.out.print("Player 1 name [ENTER to skip]: ");
        String answer = scan.nextLine();
        if (!(answer.equals("")))
        {
            ALow.setName(answer);
        }
        System.out.println("");
        System.out.print("Player 2 name [ENTER to skip]: ");
        answer = scan.nextLine();
        if (!(answer.equals("")))
        {
            BLow.setName(answer);
        }
        System.out.println("");
        System.out.print("Player 3 name [ENTER to skip]: ");
        answer = scan.nextLine();
        if (!(answer.equals("")))
        {
            DLow.setName(answer);
        }
        System.out.println("");

        int rounds = 1;
        while (!bankBreak || !playersLose)
        {
            System.out.println("Round " + rounds + ": C-Low Goes First!");
            System.out.println("But before we begin, you guys will have to make a wager with your chips! Players start with 100 each");
            //Checks before round begins
            if (ALow.getChips() > 0)
            {
                System.out.println("How much are you betting " + ALow.getName() + "?");
                ALow.setWager(scan.nextInt());
            }

            if (BLow.getChips() > 0)
            {
                System.out.println("How much are you betting " + BLow.getName() + "?");
                BLow.setWager(scan.nextInt());
            }

            if (DLow.getChips() > 0)
            {
                System.out.println("How much are you betting " + DLow.getName() + "?");
                DLow.setWager(scan.nextInt());
            }
            //Round finally begins!
            System.out.println("Here are C-Low's Rolls:");
            //I want to roll the dice, but I should add them to a list in order to compare them to one another to determine the outcome...
            //While(!valid)
            playerRoll();
            //Now I have to actually check the contents of the list to determine what condition is triggered
            determineOutcome();




            if (passRound)
            {
                if (ALow.getChips() > 0)
                {
                    System.out.println(ALow.getName() + "'s turn!");
                }

                if (BLow.getChips() > 0)
                {
                    System.out.println(BLow.getName() + "'s turn!");
                }

                if (DLow.getChips() > 0)
                {
                    System.out.println(DLow.getName() + "'s turn!");
                }
            }


        rounds++;
        }
    }


    private void playerRoll()
    {
        for (int i = 0; i < 3; i++)
        {
            rollCollection[i] = die.rollDice();
            System.out.println(rollCollection[i]);
        }
    }

    private void determineOutcome()
    {
//IDK HOW TO USE THESE YET :(
//firstRoll = rollCollection[0];
//secondRoll = rollCollection[1];
//thirdRoll = rollCollection[2];

        if (is4() && is5() && is6())
        {
            //implement a win
            //valid = true
        }
        else if (is1() && is2() && is3())
        {
            //implement a loss
            //valid = true
        }
        //Figure out how to check for doubles (then make valid true)
        //Maybe if nothing else happens, then we make a variable equal to false. And on the outside where this gets called, dice rolls and determine conditions continue happening until the variable is set to true

    }


    private boolean is1 ()
    {
        for (int roll : rollCollection)
        {
            if (roll == 1)
            {
                return true;
            }
        }
        return false;
    }

    private boolean is2 ()
    {
        for (int roll : rollCollection)
        {
            if (roll == 2)
            {
                return true;
            }
        }
        return false;
    }


    private boolean is3 ()
    {
        for (int roll : rollCollection)
        {
            if (roll == 3)
            {
                return true;
            }
        }
        return false;
    }


    private boolean is4 ()
    {
        for (int roll : rollCollection)
        {
            if (roll == 4)
            {
                return true;
            }
        }
        return false;
    }


    private boolean is5 ()
    {
        for (int roll : rollCollection)
        {
            if (roll == 5)
            {
                return true;
            }
        }
        return false;
    }


    private boolean is6 ()
    {
        for (int roll : rollCollection)
        {
            if (roll == 6)
            {
                return true;
            }
        }
        return false;
    }


}
