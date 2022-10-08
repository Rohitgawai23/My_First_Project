package Connection;

import java.util.Scanner;

public class Employee_Start {

	public void menus()
	{
		try {
			System.out.println("\n\t*********[ MENUS ]********");
			Thread.sleep(300);
			System.out.println("\t1] INSERT");
			Thread.sleep(300);
			System.out.println("\t2] UPDATE");
			Thread.sleep(300);
			System.out.println("\t3] DELETE");
			Thread.sleep(300);
			System.out.println("\t4] SEARCH");
			Thread.sleep(300);
			System.out.println("\t5] SHOW ALL");
			Thread.sleep(300);
			System.out.println("\t6] EXIT");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Employee_MainImpl em=new Employee_MainImpl();
		Employee_Start es=new Employee_Start();
		Scanner sc=new Scanner(System.in);
		int rotation=0;
		String s="\t***** WELCOME TO EMPLOYEE MANAGEMENT SYSTEM ******";
		try {
			for(int i=0;i<s.length();i++)
			{
				System.out.print(s.charAt(i));
				Thread.sleep(200);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println();

		do
		{
			es.menus();
			System.out.print("\n\tENTER YOUR CHOICE : ");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					int rt=0;
					do {
						em.insert();
						System.out.println("\n");
						System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR INSERT MORE RECORDS.");
						System.out.print("\t");
						rt=sc.nextInt();
					}while(rt!=0);
					
					break;
				}
				case 2:
				{
					int rt=0;
					do {
						em.update();
						System.out.println("\n");
						System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR UPDATE MORE RECORDS.");
						System.out.print("\t");
						rt=sc.nextInt();
					}while(rt!=0);
					
					break;
				}
				case 3:
				{
					int rt=0;
					do {
						em.delete();
						System.out.println("\n");
						System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR DELETE MORE RECORDS.");
						System.out.print("\t");
						rt=sc.nextInt();
					}while(rt!=0);
					
					break;
				}
				case 4:
				{
					int rt=0;
					do {
						em.search();
						System.out.println("\n");
						System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR SEARCH MORE RECORDS.");
						System.out.println("\n");
						System.out.print("\t");
						rt=sc.nextInt();
					}while(rt!=0);
					
					break;
				}
				case 5:
				{
					System.out.println("\n\n\t********* ALL EMPLOYEES DETAILS *********");
					System.out.println("\n\t-----------------------------------------------------------------------------------------------------------------------");
					em.showAll();
					System.out.println("\n");
					break;
				}
				default:
					System.out.println("\t\tCHOOSE VALID OPTION ??????");
					break;
			}
			System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR PERFORM MORE OPERATIONS.");
			System.out.print("\t");
			rotation=sc.nextInt();
			if(rotation==0)
			{
				System.out.println("\t\tTHANK YOU !!..  BYE.");
			}
		}while(rotation!=0);

	}

}
