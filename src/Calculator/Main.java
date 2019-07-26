package Calculator;

public class Main {
	
	
	private static String OS = System.getProperty("os.name").toLowerCase();
   
	public static boolean isWindows() {
		return (OS.indexOf("win")>=0);
	}
	
	public static void main(String[] args) {

		System.out.println(OS);
//		
//		if(isWindows()) {
//			GUIw cal = new GUIw();
//		     cal.init();
//		}
//		else
		{
    	GUI cal = new GUI();
        	cal.init();
		}
 

    }

}
