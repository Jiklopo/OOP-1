
public class Temperature {
	private double value;//значение температуры
	private char scale;	//единица измерени€
	
	
	public Temperature() {
		scale = 'C';
		value = 0;//ѕустой конструктор нужен
	}
	
	public Temperature(double value) {//только, чтобы задать значение, ÷ельсий по умолчанию
		this.value = value;
		scale = 'C';
	}
	
	public Temperature(char scale) {
		setScale(scale);
		value = 0;
	}
	
	public Temperature(double value, char scale) {
		this(scale);
		this.value = value;
		
	}
	
	
	
	public double degreesC() {
		if(scale == 'C')
			return value;
		else
			return (value - 32)*5/9;
	}
	
	public double degreesF() {
		if(scale == 'F')
			return value;
		else
			return ((value * 9) / 5) + 32;
	}
	
	public void setScale(char scale) {
		if(scale == 'C' || scale == 'F')
			this.scale = scale;
		else
			this.scale = 'C';
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setScaleValue(double value, char scale) {
		setValue(value);
		setScale(scale);
	}
	
	public char getScale() {
		return scale;//ѕросто получить единицу измерени€
	}
	
	public double getValue() {
		return value;
	}
}
