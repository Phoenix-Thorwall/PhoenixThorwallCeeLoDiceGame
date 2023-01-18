public class Player {
    private String name;
    private int chips;
    private int score;
    private int wager;

    public Player(String name, int chips, int score, int wager)
    {
       this.name = name;
       this.chips = chips;
       this.score = score;
       this.wager = wager;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String change)
    {
        name = change;
    }

    public int getChips()
    {
        return chips;
    }

    public int getScore()
    {
        return score;
    }

    public int getWager()
    {
        return wager;
    }

    public void setWager(int change)
    {
        wager = change;
    }

    public void setScore(int value)
    {
        score = value;
    }

    public void setChips(int value)
    {
        chips += value;
    }
}
