/*
TASK 2

Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get theaverage percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user */

import java.util.*;
class task2
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no.of Subjects");
		int n=s.nextInt();
		double marks=0,total_marks=0;
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter marks of Subject"+i);
			marks=s.nextDouble();
			total_marks+=marks;
		}
			
		double Average_percentage=total_marks/(n);
		System.out.println("Total Marks Obtained :"+total_marks);
		System.out.println("Average_percentage :"+Average_percentage);
		if(Average_percentage>=90)
		{
			System.out.println("A-grade");
		}
		else if(Average_percentage>=80 && Average_percentage<=89)
		{
			System.out.println("B-grade");
		}
		else if(Average_percentage>=70 && Average_percentage<=79)
		{
			System.out.println("C-grade");
		}
		else if(Average_percentage>=60 && Average_percentage<=69)
		{
			System.out.println("D-grade");
		}
		else if(Average_percentage>=50 && Average_percentage<=59)
		{
			System.out.println("E-grade");
		}

		else
		{
			System.out.println("FAIL");
		}
	}
}
		
		
