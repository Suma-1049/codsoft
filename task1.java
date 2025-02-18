import java.util.Random;
import java.util.Scanner;
class task1
{
	public static void main(String[] args)
	{
		int c,score=0,randnum,total_attempts,guess;
		do {
			
			Random r=new Random();
			randnum=r.nextInt(1,100);
			total_attempts=0;
			Scanner s=new Scanner(System.in);
			System.out.println("guess the number between 1 and 100:");
			guess=s.nextInt();
			while(total_attempts<10)
			{
				total_attempts+=1;
				if(total_attempts>=10)
				{
			     		System.out.println("You Lost the total chances to guess");
					
					break;
				}
				
				if(guess==randnum)
				{
					System.out.println("correct guess");
					score=score+1;
					break;
				}
				else if(guess>randnum)
				{
					System.out.println("guess is too high");
				}
				else if(guess<randnum)
				{
					System.out.println("guess is too low");
				}
				System.out.println("guess the number between 1 and 100:");
				guess=s.nextInt();
				
			}
			
			System.out.println("Do You Want to conntinue! if yes enter ('1') else ('0')");
			c=s.nextInt();
		} while(c!=0);
		System.out.println("Total rounds won:"+score);


	}
}


