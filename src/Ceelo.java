public class Ceelo {
    private boolean bankBreak = false;
    private boolean playersLose = false;
    public Ceelo()
    {}

    public void play()
    {
        int rounds = 0;
        while (!bankBreak || !playersLose)
        {
            System.out.println("Round " + rounds + " C-Low Goes First!");
            // Do I want to print out a little visual menu displaying stats like
            // Current Player: C-Low
            // Chips: 1000
        }
    }

    private void currentPlayerBanker(Banker banker)
    {
        System.out.println("Current Player: " + banker.getName());
    }

    private void currentPlayerPlayer(Player player)
    {

    }
}
