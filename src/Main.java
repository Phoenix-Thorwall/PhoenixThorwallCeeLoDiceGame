import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);


        Ceelo game = new Ceelo();

        System.out.println("Welcome to our totally legal game of Ceelo! Here you 3 will test your skills against our top Banker C-Low");
        System.out.println("But before we begin, we should get acquainted with one another. If you want to keep your anonymity then we will generate a placeholder");
        System.out.println("");


        game.play();
    }
}
