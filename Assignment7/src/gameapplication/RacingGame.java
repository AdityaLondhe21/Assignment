package gameapplication;

public class RacingGame {

    private Biker[] bikers = new Biker[10];

    public RacingGame() {
        for (int i = 0; i < 10; i++) {
            bikers[i] = new Biker("Biker " + (i+1));
        }
    }

    private void displayResults() {
        System.out.println("Race Results: (Time in milliseconds)");
        for (int i = 0; i < 10; i++) {
            Biker biker = bikers[i];
            System.out.println((i+1)+" : "+biker.getName()+
            		" ->\t Start Time : "+ biker.getStartTime()+
            		" ,End Time : "+ biker.getEndTime()+
            		" ,Time Taken : "+ biker.getTimeTaken());       
        }
    }
    public void startRace() throws Exception {
        System.out.println("Race starting in:");
        for (int i = 10; i > 0; i--) {
            System.out.print(i+" ");
            Thread.sleep(1000);
        }
        System.out.println("Go!");

        Thread[] threads = new Thread[10];
        for (int i=0 ; i<10 ;i++) {
            threads[i] = new Thread(bikers[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        //bubble sort
        for (int i = 0; i < bikers.length - 1; i++) {
            for (int j = 0; j < bikers.length - i - 1; j++) {
                if (bikers[j].getEndTime() > bikers[j + 1].getEndTime()) {
                    Biker temp = bikers[j];
                    bikers[j] = bikers[j + 1];
                    bikers[j + 1] = temp;
                }
            }
        }
        displayResults();
    }
  
	public static void main(String[] args) {
        try {
            RacingGame race = new RacingGame();
            race.startRace();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
