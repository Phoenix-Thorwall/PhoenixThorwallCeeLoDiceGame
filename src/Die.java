public class Die {
    private int rollVal = 0;
    public Die()
    {

    }

    public int rollDice()
    {
        rollVal = (int) (Math.random() * 6) + 1;
        return rollVal;
    }
}
