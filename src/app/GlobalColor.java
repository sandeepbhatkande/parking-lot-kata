package app;

public class GlobalColor {

	private static final String[] ColorArray = {"RED", "BLUE", "GREY", "BLACK", "WHITE"};
	
	public boolean isValidColor(String a_color) {
		Boolean found = false;
		for(String x : ColorArray){
			if(x == a_color){
		        found = true;
		        break;
		    }
		}
		return found;
	}
}
