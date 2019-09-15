package student;
	public class Student {
		public String name, id;
		int year;
		
		
		public Student() {
			year = 1;
			name = "";
			id = "";
		}
		
		public Student(String name) {
			this.name = name;
			year = 1;
		}
		
		public Student(String name, String id){
			this(name);
			this.id = id;
		}
		
		public void incYear() {
			year++;
			
		}
		
		public String toString() {
			return id + " " + name;
		}
	}
