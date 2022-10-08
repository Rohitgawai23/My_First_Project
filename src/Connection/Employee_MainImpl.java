package Connection;
import java.sql.*;
import java.util.*;
public class Employee_MainImpl implements Employee_Main
{
	Connection con=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Scanner sc=new Scanner(System.in);
	Employee_MainImpl()
	{
		con=Connectionclass.getConnection();
		
	}
	@Override
	public void insert() {
		System.out.print("\n\n\tEnter Id          : ");
		int id=sc.nextInt();
		System.out.print("\tEnter Name        : ");
		sc.nextLine();
		String nm=sc.nextLine();
		System.out.print("\tEnter Email_id    : ");
		String ei=sc.nextLine();
		System.out.print("\tEnter City        : ");
		String ct=sc.nextLine();
		System.out.print("\tEnter Salary      : ");
		String sl=sc.nextLine();
		System.out.print("\tEnter Mobile No   : ");
		String mo=sc.nextLine();

		
		String query="insert into employeedetails values(?,?,?,?,?,?)";
	
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, nm);
			ps.setString(3, ei);
			ps.setString(4,ct);
			ps.setString(5, sl);
			ps.setString(6,mo);
			ps.executeUpdate();
			System.out.println("\n\tRecord Inserted SuccessFully !!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("\t--------------------------------------------");
	}

	@Override
	public void delete() {
		System.out.print("\t\n\nEnter id for Delete the record : ");
		int id=sc.nextInt();
		 String Query="delete from employeedetails where id=?";
		  try {
			ps=con.prepareStatement(Query);
			ps.setInt(1, id);
			if(ps.execute())
			{
				System.out.println("\tRecord deleted Sucessfully.");
			}
			else
			{
				System.out.println("\tTechnical Error.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		  System.out.println("\t--------------------------------------------");
	}

	@Override
	public void update() {

		System.out.print("\n\n\tEnter id for Update record          : ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("\tEnter which column Name for Update  : ");
		String col=sc.nextLine();
		System.out.print("\tEnter the Data                      : ");
		String data=sc.nextLine();
		
		String query="Update employeedetails set "+col+"=? where id=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, data);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("\n\tRecord Updated SuccessFully !!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("\t--------------------------------------------");
	}

	@Override
	public void search() {
		System.out.print("\n\n\tEnter id for Search the record : ");
		int id=sc.nextInt();
		System.out.println("\n\n\t********* EMPLOYEE DETAILS *********");
		 String Query="Select * from employeedetails where id=?";
		  try {
				ps=con.prepareStatement(Query);
				ps.setInt(1, id);
				
				rs=ps.executeQuery();
				System.out.println();
			  System.out.printf("\t%-7s %-24s %-30s %-20s %-16s %-23s","ID","Name","Email_id","City","Salary","Mobile");
			   System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------");
			   while(rs.next()) {

				   System.out.format("\t%-7s %-24s %-30s %-20s %-16s %-23s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				   
			   }
			   System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
	@Override
	public void showAll() {
		
		try {
				st=con.createStatement();
				rs=st.executeQuery("select * from employeedetails");
				System.out.printf("\t%-7s %-24s %-30s %-20s %-16s %-23s","ID","Name","Email_id","City","Salary","Mobile");
				System.out.println();
			   System.out.println("\t---------------------------------------------------------------------------------------------------------------------");
			   while(rs.next()) {
				   
				   System.out.format("\t%-7s %-24s %-30s %-20s %-16s %-23s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				   System.out.println();
			   }
			   System.out.println("\t---------------------------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
