import java.util.*;

public class Robot{
	Tarea tarea;
	Boolean busy;
	int t = 2;
	int n;
	Timer timer = new Timer();

	public Robot(int i){
		n = i;
		busy = false;
	}

	public void setTarea(Tarea tarea){
		busy = true;
		this.tarea = tarea;
		System.out.println("asignada");
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tarea.done(n);
				busy = false;
			}
		}, t*1000);
	}
}