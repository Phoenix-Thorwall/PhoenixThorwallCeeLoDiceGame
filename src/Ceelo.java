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

    private Player currentPlayer;

    private int theDouble;

    int[] rollCollection = new int[3];

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
            System.out.println("But before we begin, you guys will have to make a wager with your chips!");
            //Checks before round begins
            if (ALow.getChips() > 0)
            {
                System.out.println("How much are you betting " + ALow.getName() + "? (You currently have " + ALow.getChips() + " chips)");
                ALow.setWager(scan.nextInt());
            }

            if (BLow.getChips() > 0)
            {
                System.out.println("How much are you betting " + BLow.getName() + "? (You currently have " + BLow.getChips() + " chips)");
                BLow.setWager(scan.nextInt());
            }

            if (DLow.getChips() > 0)
            {
                System.out.println("How much are you betting " + DLow.getName() + "? (You currently have " + DLow.getChips() + " chips)");
                DLow.setWager(scan.nextInt());
            }
            //Round finally begins!
            System.out.println("Here are C-Low's Rolls:");
            //I want to roll the dice, but I should add them to a list in order to compare them to one another to determine the outcome...
            while(!valid)
            {
                roll();
                //Now I have to actually check the contents of the list to determine what condition is triggered
                determineOutcomeBANKER();
            }




            if (passRound)
            {
                if (ALow.getChips() > 0)
                {
                    System.out.println(ALow.getName() + "'s turn!");
                    valid = false;
                    currentPlayer = ALow;
                    while(!valid)
                    {
                        roll();
                        determineOutcomePLAYER();
                    }
                }

                if (BLow.getChips() > 0)
                {
                    System.out.println(BLow.getName() + "'s turn!");
                    valid = false;
                    currentPlayer = BLow;
                    while(!valid)
                    {
                        roll();
                        determineOutcomePLAYER();
                    }
                }

                if (DLow.getChips() > 0)
                {
                    System.out.println(DLow.getName() + "'s turn!");
                    valid = false;
                    currentPlayer = DLow;
                    while(!valid)
                    {
                        roll();
                        determineOutcomePLAYER();
                    }
                }
            }


        rounds++;
        valid = false;
        passRound = false;
        }
    }


    private void roll()
    {
        for (int i = 0; i < 3; i++)
        {
            rollCollection[i] = die.rollDice();
            System.out.println(rollCollection[i]);
        }
    }

    private void determineOutcomeBANKER()
    {
        if (rollCollection[0] == rollCollection[1] && rollCollection[0] == rollCollection[2])
        {
            System.out.println("\nTRIPLES!!!!!");
            bankerWin();
            valid = true;
        }
        else if (is4() && is5() && is6())
        {
            bankerWin();
            valid = true;
        }
        else if (is1() && is2() && is3())
        {
            bankerLose();
            valid = true;
        }
        //Figure out how to check for doubles (then make valid true)
        //Maybe if nothing else happens, then we make a variable equal to false. And on the outside where this gets called, dice rolls and determine conditions continue happening until the variable is set to true
        else if (rollCollection[0] == rollCollection[1] || rollCollection[0] == rollCollection[2] || rollCollection[1] == rollCollection[2])
        {
            for (int i = 0; i < rollCollection.length; i++)
            {
                for (int j = i + 1; j < rollCollection.length; j++)
                {
                    if (rollCollection[i] == rollCollection[j])
                    {
                        theDouble = rollCollection[j];
                        CLow.setScore(rollCollection[0] + rollCollection[1] + rollCollection[2] - (theDouble * 2));
                    }
                }
            }
            System.out.println("DOUBLES!!!! C-Low now has a score of " + CLow.getScore());
            valid = true;
            passRound = true;
        }
        else
        {
            System.out.println("Well that's a BUST... Let's try again!");
        }
    }

    private void determineOutcomePLAYER()
    {
        if (rollCollection[0] == rollCollection[1] && rollCollection[0] == rollCollection[2])
        {
            System.out.println("\nTRIPLES!!!!!");
            playerWin();
            valid = true;
        }
        else if (is4() && is5() && is6())
        {
            playerWin();
            valid = true;
        }
        else if (is1() && is2() && is3())
        {
            playerLose();
            valid = true;
        }
        else if (rollCollection[0] == rollCollection[1] || rollCollection[0] == rollCollection[2] || rollCollection[1] == rollCollection[2])
        {
            System.out.println("\nDOUBLES!!!!");
            playerDoubles();
            valid = true;
        }
        else
        {
            System.out.println("Well that's a BUST... Let's try again!");
        }
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

    private void bankerWin()
    {
        CLow.setChips(ALow.getWager() + BLow.getWager() + DLow.getWager());
        ALow.setChips(ALow.getWager() * -1);
        BLow.setChips(BLow.getWager() * -1);
        DLow.setChips(DLow.getWager() * -1);
        System.out.println("C-Low has done it again! He won the round and gets all the chips!");
        System.out.println("C-Low now has " + CLow.getChips() + " chips\n" + ALow.getName() + " now has "
                + ALow.getChips() + " chips\n" + BLow.getName() + " now has " + BLow.getChips() + " chips\n"
                + DLow.getName() + " now has " + DLow.getChips() + " chips");
    }

    private void bankerLose()
    {
        CLow.setChips((ALow.getWager() + BLow.getWager() + DLow.getWager()) * -1);
        ALow.setChips(ALow.getWager());
        BLow.setChips(BLow.getWager());
        DLow.setChips(DLow.getWager());
        System.out.println("I CANT BELIEVE C-LOW LOST. He owes you some chips...");
        System.out.println("C-Low now has " + CLow.getChips() + " chips\n" + ALow.getName() + " now has "
                + ALow.getChips() + " chips\n" + BLow.getName() + " now has " + BLow.getChips() + " chips\n"
                + DLow.getName() + " now has " + DLow.getChips() + " chips");
    }

    private void playerWin()
    {
        CLow.setChips(currentPlayer.getWager() * -1);
        currentPlayer.setChips(currentPlayer.getWager());
        System.out.println("CONGRATULATIONS " + currentPlayer.getName() + "! You bested C-Low and won "
                + currentPlayer.getWager() + " chips");
       System.out.println("C-Low now has " + CLow.getChips() + " chips\n" + currentPlayer.getName()
               + "now has " + currentPlayer.getChips() + " chips");
    }

    private void playerLose()
    {
        CLow.setChips(currentPlayer.getWager());
        currentPlayer.setChips(currentPlayer.getWager() * -1);
        System.out.println("OH NO!! Unfortunately, you lost and now owe C-Low "
                + currentPlayer.getWager() + " chips");
        System.out.println("C-Low now has " + CLow.getChips() + " chips\n" + currentPlayer.getName()
                + " now has " + currentPlayer.getChips() + " chips");
    }

    private void playerDoubles()
    {
        for (int i = 0; i < rollCollection.length; i++)
        {
            for (int j = i + 1; j < rollCollection.length; j++)
            {
                if (rollCollection[i] == rollCollection[j])
                {
                    theDouble = rollCollection[j];
                    currentPlayer.setScore(rollCollection[0] + rollCollection[1] + rollCollection[2] - (theDouble * 2));
                }
            }
        }
        if (currentPlayer.getScore() >= CLow.getScore())
        {
            System.out.println("Your score of " + currentPlayer.getScore() + " beats C-Low's score of " + CLow.getScore() + "!");
            playerWin();
        }
        else
        {
            System.out.println("C-Low's score of " + CLow.getScore() + " beats your score of " + currentPlayer.getScore() + " :(");
            playerLose();
        }
    }

}
