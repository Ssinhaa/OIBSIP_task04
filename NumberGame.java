import java.util.*;
class First
{
    public void ready()
    {
        Random r = new Random();
        Scanner obj = new Scanner(System.in);
        int value = r.nextInt(101);
        System.out.println("The Number is Generated:");
        System.out.println("Enter Your Guess:");
        int number = obj.nextInt();
        while(number>9)
        {
            System.out.println("You have finished your gusses");
            number = obj.nextInt();
        }
        System.out.println("You have only" +number+ "chances left!");
        int fscore = 100, k = 0;
        for(k = 0; k<number; k++)
        {
            System.out.println("Enter your Guess: You are currently on"+(k+1));
            int num = obj.nextInt();
            if(num == value)
            {
                System.out.println("Congratulations!! You Win!!");
                System.out.println("Your Score is:"+fscore);
                break;
            }
            else if(num>value)
            {
                System.out.println("Your Guess is Greater...Please Try Again!");
            }
            else
            {
                System.out.println("Your Guess is Lesser...Please Try Again!");
            }
            fscore-=10;
        }
        if(k>=number)
        {
            System.out.println("Your Chances are over...You Lost!");
            System.out.println("The Number was :"+value);
        }
    }
}

class NumberGame
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Number Guessing Game!!");
        Scanner obj = new Scanner(System.in);
        First f = new First();
        System.out.println("Let Us Begin...Sure/No");
        String str = obj.nextLine();
        while(str.equalsIgnoreCase("Sure")||str.equalsIgnoreCase("s"))
        {
            f.ready();
            System.out.println("Are you ready??...Yes/No");
            str = obj.nextLine();
        }
        System.out.println("The End!!");
    }
}
