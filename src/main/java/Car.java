public class Car
{
	private String m_reg_No;
	private String m_carColor;
	public Car(String a_car_reg_No, String a_carColor)
	{
		if (a_car_reg_No == null || a_car_reg_No.trim().length() == 0 
				|| a_carColor == null || a_carColor.trim().length() == 0)
		{
			throw new RuntimeException("Car details are not valid..");
		}
		else
		{
			this.m_reg_No = a_car_reg_No;
			this.m_carColor = a_carColor;
		}
	}
	public String getRegistrationNo()
	{
		return this.m_reg_No;
	}
	public String getColor()
	{	
		return this.m_carColor;
	}
}
