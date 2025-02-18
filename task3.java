import java.util.Scanner;
class t3
{
	public static void main(String[] args)
	{
		double total;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the total amount in the account");
		total=sc.nextDouble();
while(true)
{
		
		System.out.println("Select the option: \n1.withdrawl\n2.deposit\n3.check balance\n4.Exit");
		int r=sc.nextInt();
			if (r==1)
			{

			System.out.println("Enter amount to withdraw:");
			int withdrawl=sc.nextInt();
					if(total>withdrawl)
					{	total=total-withdrawl;
						System.out.println(total);
					}
					else
					{
						System.out.println("Specified amount is not anailable in your account");}
			}
			else if(r==2)
			{
				
					System.out.println("Enter the amount to be deposited");
					int val=sc.nextInt();
					total=total+val;
					System.out.println("the total amount in the account is:"+total);
			}
			else if(r==3)
			{
				System.out.println("the total amount in the account is"+total);
			}
			else
			{
				System.exit(0);
			}
}
	}
}	