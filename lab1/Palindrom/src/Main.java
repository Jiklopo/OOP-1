
public class Main {

	public static boolean isPalindrom(String s) {//like we did on PP1
		for(int i = 0; i < s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - i - 1)) {//check last and first, then second one before the last and so on
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.print(isPalindrom("racecar"));
	}

}
