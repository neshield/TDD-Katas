package stringcalc.splitter;

public class StringSplitter {	
	public String[] processAndSplitString(String s){
		String delimeter = getDelimeter(s);
		s = removeDelimeterLine(s, delimeter);
		
		return splitString(s, delimeter);
	}
	
	public String[] splitString(String s, String delimeter){
		if(s.equals("")){
			return new String[]{""};
		} else {
			s = s.replace("\n", delimeter);
			return s.split(delimeter);
		}
	}
	
	public String getDelimeter(String s){
		String d = ",";
		if(s.startsWith("//")){
			d = String.valueOf(s.charAt(2));
		}
		return d;
	}
	
	private String removeDelimeterLine(String s, String delimeter){
		if(s.startsWith("//"+delimeter+"\n")){
			return s.substring(4);
		} else {
			return s;
		}
	}
}
