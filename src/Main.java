import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);

        Banker CLo = new Banker ("C-Low", 1000, 0);
        Ceelo game = new Ceelo();

        System.out.println("Welcome to our totally legal game of Ceelo! Here you 3 will test your skills against our top Banker C-Low");
        System.out.println("But before we begin, we should get acquainted with one another. If you want to keep your anonymity then we will generate a placeholder");
        System.out.println("");

        Player ALow = new Player("A-Low", 100, 0);
        Player BLow = new Player("B-Low", 100, 0);
        Player DLow = new Player("D-Low", 100, 0);

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




        game.play();
    }
}
