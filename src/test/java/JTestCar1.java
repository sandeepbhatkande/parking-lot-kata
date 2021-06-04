import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class JTestCar1 {
	
	@Test
    public void testValidCarDetails()
    {
        Car c = new Car("123", "White");
		assertEquals(c.getRegistrationNo(), "123");
    }
	
	@Test
    public void testInvalidCarDetailsNull()
    {
		try
		{
			Car c = new Car(null, null);
			
		}
		catch (Exception a_ex)
		{
			assertEquals(a_ex.getMessage(), "Car details are not valid..");
		}
    }
	
	@Test
    public void testInvalidCarDetailsBlank()
    {
		try
		{
			Car c = new Car("123", "");
			
		}
		catch (Exception a_ex)
		{
			assertEquals(a_ex.getMessage(), "Car details are not valid..");
		}
    }
}