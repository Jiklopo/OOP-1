package student;
	public class Student {
		String name, id;
		int year;
		Student(String name, String id){
			this.name = name;
			this.id = id;
			year = 1;
		}
		
		public void incYear() {
			year++;
		}
	}
