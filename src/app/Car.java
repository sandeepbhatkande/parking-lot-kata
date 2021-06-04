package app;

public class Car {
	
	private String car_Number;
	private String car_color;
	
	public Car(String No, String color) {
		car_Number = No;
		car_color = color;
	}
	
	public String getColor() {
		return car_color;
	}
	
	public String getNumber() {
		return car_Number;
	}
}
