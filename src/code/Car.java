package code;

public class Car 
{
	private String CarRegNo;
	private String CarColor;
	private String CarColor1;
	
	
	public Car(String a_CarNo, String a_CarColor) 
	{
		this.CarRegNo = a_CarNo;
		this.CarColor = a_CarColor;
	}
	
	public String getColor() 
	{
		return this.CarColor;
	}
	
	public String getRegNumber() 
	{
		return this.CarRegNo;
	}
}
