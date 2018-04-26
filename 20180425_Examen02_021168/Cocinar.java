import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cocinar implements Tarea{
	String tarea;
	Writer output;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public void done(int i){
		Date date = new Date();
		tarea = String.format("Robot %d: Cocinar %s%n", i, dateFormat.format(date));
		try{
			FileWriter fw = new FileWriter("log.csv",true);
	        fw.write(tarea);
    		fw.close();
    	}catch(Exception e){
    		// throw FileNotFoundException;
    	 System.out.println(e);
    	}
	}
}