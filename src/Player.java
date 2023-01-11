public class Player {
    private String name;
    private int chips;
    private int score;

    public Player(String name, int chips, int score)
    {
       this.name = name;
       this.chips = chips;
       this.score = score;
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
}
