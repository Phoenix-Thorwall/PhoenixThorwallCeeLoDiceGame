import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);

        int answer = 1;
        Ceelo game = new Ceelo();

        System.out.println("Welcome to our totally legal game of Ceelo! Here you 3 will test your skills against our top Banker C-Low");
        System.out.println("But before we begin, we should get acquainted with one another. If you want to keep your anonymity then we will generate a placeholder name");
        System.out.println("");


        while(answer != 3)
        {

            game.play();
            System.out.println("Well that sure was fun!\n");
            System.out.println("Would you like to\n1) Play Again\n2) View the Top Score\n3) Quit");
            answer = scan.nextInt();
            if (answer == 2)
            {
                System.out.println("The top score is " + game.getTopScore());
                System.out.println("Would you like to\n1) Play Again\n2) View the Top Score\n3) Quit");
                answer = scan.nextInt();
            }
        }
        System.out.println("Thank you so much for playing!");


    }
}
