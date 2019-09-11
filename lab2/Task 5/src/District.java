
public class District {
	private String name;
	private int residentsAmount;
	districtType type;
	private final String index;
	private static int districtsAmount;
	
	enum districtType{
		sleepingQuarter,
		scienctific,
		blatnoy
	}
	
	
	
	{
		districtsAmount++;
	}
	
	
	
	
	public District(){
		index = "000000";
	}
	
	public District(String index) {
		this.index = index;
	}
	
	public District(String index, String name) {
		this(index);
		this.name = name;
	}
	
	public District(String index, String name, districtType type) {
		this(index, name);
		this.type = type;
	}
	
	public District(String index, String name, districtType type, int residentsAmount) {
		this(index, name, type);
		this.residentsAmount = residentsAmount;
	}
	
	
	
	
	public void addResidents() {
		residentsAmount++;
	}
	
	public void addResidents(int amount){
		residentsAmount += amount;
	}
	
	public int getResidentsAmount() {
		return residentsAmount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIndex() {
		return index;
	}
	
	public int getDistrictsAmount() {
		return districtsAmount;
	}
}
