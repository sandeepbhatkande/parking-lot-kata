public class Car
{
	private String m_registrationNo;
	private String m_color;
	public Car(String a_registrationNo, String a_color)
	{
		if (a_registrationNo == null || a_registrationNo.trim().length() == 0 
				|| a_color == null || a_color.trim().length() == 0)
		{
			throw new RuntimeException("Car details are not valid..");
		}
		else
		{
			this.m_registrationNo = a_registrationNo;
			this.m_color = a_color;
		}
	}
	public String getRegistrationNo()
	{
		return this.m_registrationNo;
	}
	public String getColor()
	{	
		return this.m_color;
	}
}	