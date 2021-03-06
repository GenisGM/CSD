// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool2{ //max capacity
	int KI, CAP;
    public void init(int ki, int cap)           {
    	KI=ki; CAP=cap;
    	}
    public synchronized void kidSwims() throws InterruptedException{
    	while((instructoresNadando*KI < niņosNadando+1)||(niņosNadando+1+instructoresNadando>=CAP)) {
    		log.waitingToSwim();
    		wait();
    	}
    	niņosNadando++;
    	log.swimming();
    	notifyAll();
    }
    public synchronized void kidRests()      {
    	niņosNadando--;
    	log.resting();
    	notifyAll();
    }
    public synchronized void instructorSwims() throws InterruptedException{
    	while(niņosNadando+instructoresNadando+1>=CAP) {
    		log.waitingToSwim();
    		wait();
    	}
    	instructoresNadando++;
    	log.swimming();
    	notifyAll();
    }
    public synchronized void instructorRests() throws InterruptedException{
    	while((instructoresNadando-1)*KI < niņosNadando) {
    		log.waitingToRest();
    		wait();
    	}
    	instructoresNadando--;
    	log.resting(); 
    	notifyAll();
    }
}
