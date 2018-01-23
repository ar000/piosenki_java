package piosenki;

public class Stoper {

	private long start, stop;
	public Stoper(){
		
	}
	public void Start(){
		start = System.currentTimeMillis();
	}
	public void Stop(String co){
		stop = System.currentTimeMillis();
		long tt = stop - start;
		System.out.println(co + " - "+String.valueOf(tt)+"ms.");
	}
}
