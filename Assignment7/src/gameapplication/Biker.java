package gameapplication;

public class Biker implements Runnable{
	private String name;
	private long startTime;
	private long endTime;
	private long timeTaken ;
	public Biker(String name) {
		this.name = name;
	}
	public String getName() {
        return this.name;
    }
    public long getStartTime() {
        return this.startTime;
    }
    public long getEndTime() {
        return this.endTime;
    }
    public long getTimeTaken() {
        return this.timeTaken;
    }
    public void run() {
        this.startTime = System.currentTimeMillis();
        
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(20 * ((int) (Math.random()*10) % 10));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        this.endTime = System.currentTimeMillis();
        
        this.timeTaken = endTime - startTime;
    }

}
