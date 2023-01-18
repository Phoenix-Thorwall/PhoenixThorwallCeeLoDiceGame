public class Banker {
    private String name;
    private int chips;
    private int score;

    public Banker(String name, int chips, int score)
    {
        this.name = name;
        this.chips = chips;
        this.score = score;
    }
    public String getName()
    {
        return name;
    }

    public int getChips()
    {
        return chips;
    }

    public int getScore()
    {
        return score;
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

