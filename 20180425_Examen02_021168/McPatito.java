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

		//leer numero de objetos en csv y restarlos de la lista de tareas

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

		//leer log.csv
	}
}