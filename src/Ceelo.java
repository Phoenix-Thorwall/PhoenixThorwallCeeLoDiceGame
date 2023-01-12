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

        int rounds = 0;
        while (!bankBreak || !playersLose)
        {
            System.out.println("Round " + rounds + ": C-Low Goes First!");
            System.out.println("But before we begin, you guys will have to make a wager with your chips!");
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
            //I want to roll the dice but I should add them to a list in order to compare them to one another to determine the outcome
            for (int i = 0; i < 2; i++)
            {

            }




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

}
