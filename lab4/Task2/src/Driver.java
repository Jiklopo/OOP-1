import java.io.*;
public class Driver {

	

	public static void main(String[] args) 
	{
		
		
	}

	
	public void adminLogin()
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		BufferedWriter logs = new BufferedWriter(new FileWriter("src\\logs.txt", true));
		String choice;
		try {choice = in.readLine();}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {choice = null;}
		
		String greeting = "1 to add Textbook\n"
				+ "2 to add Instructor";
		while(choice != null)
		{
			out.println();
			if(choice.equals("1"))
			{
				out.println("Enter isbn, title and author on different lines");
				try {
					String isbn = in.readLine();
					String title = in.readLine();
					String author = in.readLine();
				} catch (IOException e) {
					out.println("File does not exist or damaged");
					continue;
				}
			}
			
			else if (choice.equals("2"));
			{
				out.println("Enter first name, last name, deparment and email on different lines!");
				try
				{
					String firstName = in.readLine();
					String lastName = in.readLine();
					String department = in.readLine();
					String email = in.readLine();
				}
				catch(IOException e)
				{
					out.println("File does not exist or damaged");
					logs.write("Admin tried to add Instructor");
					continue;
				}
			}
		}
	}
}
