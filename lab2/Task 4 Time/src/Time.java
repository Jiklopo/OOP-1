
public class Time {
	private int hour, min, sec;
	
	Time (int hour, int min, int sec){
		this.hour = hour % 24;
		this.min = min % 60;
		hour += min/60;
		this.sec = sec % 60;
		min += sec/60;
	}
	
	public void set(int hour, int min, int sec){
		if(hour <= 24 && min < 60 && sec < 60) {			
			this.hour = hour;
			this.min = min;
			this.sec = sec;
		}
		else System.out.println("Wrong format!");
	}
	
	public String toUniversal() {
		return addZero(hour) + ":" + addZero(min) + ":" + addZero(sec);
	}
	
	public String toStandart() {
		String amOrPm = " ";
		if(hour / 12 == 1) {
			amOrPm += "PM";
		}
		else amOrPm += "AM";
		return addZero(hour % 12) + ":" + addZero(min) + ":" + addZero(sec) + amOrPm;
	}
	
	public void addTime(Time t) {
		sec = sec + t.sec;
		min += sec / 60;
		min = min + t.min;
		hour += min / 60;
		hour = (hour + t.hour) % 24;
		min %= 60;
		sec %= 60;
	}
	
	public String addZero(int i) {
		if(i < 10)
			return "0" + i;
		return i + "";
	}
}
