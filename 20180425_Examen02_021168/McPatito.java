import java.io.*;
import java.util.*;

public class McPatito{
	public static void main(String[] args) {
		ArrayList<Tarea> queue = new ArrayList<>();
		int n = 5;
		Robot[] workers = new Robot[n];


		Tarea r1 = new Reparar();
		queue.add(r1);
		Tarea r2 = new Reparar();
		queue.add(r2);
		Tarea r3 = new Reparar();
		queue.add(r3);
		Tarea r4 = new Reparar();
		queue.add(r4);
		Tarea r5 = new Reparar();
		queue.add(r5);
		Tarea r6 = new Cocinar();
		queue.add(r6);
		Tarea r7 = new Cocinar();
		queue.add(r7);
		Tarea r8 = new Cocinar();
		queue.add(r8);

		int length = 0;
		String line;
		try {BufferedReader br = new BufferedReader(new FileReader("log.csv"));
			while ((line = br.readLine()) != null) {
		        length += 1;
		    }
		} catch (Exception e) {
			e.printStackTrace();
 		}

 		if (length >= queue.size()){
 			try{
	 			FileWriter fw = new FileWriter("log.csv",false);
	 			fw.write("");
 				fw.close();
 				length = 0;
 			} catch (Exception e) {System.out.println(e);}
 		} else {
	 		while (length > 0){
 				queue.remove(0);
 				length--;
		 	}
 		}


		for (int i = 0; i < n; i++) {
			workers[i] = new Robot(i);
		}

		while(!queue.isEmpty()){
			for (Robot r: workers) {
				if (!r.busy && !queue.isEmpty()){
					r.setTarea(queue.get(0));
					queue.remove(0);
				}
			}
		}

		//terminacion antes de tiempo (correr una vez sin comentar y volver a correrlo comentado para probar recuperacion, terminar task manualmente despues de eso)
		// System.exit(0);

		//leer log.csv
		try {BufferedReader br = new BufferedReader(new FileReader("log.csv"));
			while ((line = br.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (Exception e) {
			e.printStackTrace();
 		}
	}
}