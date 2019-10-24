import java.io.IOException;

import CourseConstructor.CourseConstructor;
public class Application {

	public static void main(String[] args) 
	{
		CourseConstructor courseConstructor = new CourseConstructor();
		try {
			courseConstructor.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
