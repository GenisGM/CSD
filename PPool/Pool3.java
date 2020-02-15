// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool2{ //max capacity
	int KI, CAP;
    public void init(int ki, int cap)           {
    	KI=ki; CAP=cap;
    	}
    public synchronized void kidSwims() throws InterruptedException{
    	while((instructoresNadando*KI < niñosNadando+1)||(niñosNadando+1+instructoresNadando>=CAP)) {
    		log.waitingToSwim();
    		wait();
    	}
    	niñosNadando++;
    	log.swimming();
    	notifyAll();
    }
    public synchronized void kidRests()      {
    	niñosNadando--;
    	log.resting();
    	notifyAll();
    }
    public synchronized void instructorSwims() throws InterruptedException{
    	while(niñosNadando+instructoresNadando+1>=CAP) {
    		log.waitingToSwim();
    		wait();
    	}
    	instructoresNadando++;
    	log.swimming();
    	notifyAll();
    }
    public synchronized void instructorRests() throws InterruptedException{
    	while((instructoresNadando-1)*KI < niñosNadando) {
    		log.waitingToRest();
    		wait();
    	}
    	instructoresNadando--;
    	log.resting(); 
    	notifyAll();
    }
}
