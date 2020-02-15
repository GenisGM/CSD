// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool2{ //max capacity
	int KI, CAP;
    public void init(int ki, int cap)           {
    	KI=ki; CAP=cap;
    	}
    public synchronized void kidSwims() throws InterruptedException{
    	while((instructoresNadando*KI < ni�osNadando+1)||(ni�osNadando+1+instructoresNadando>=CAP)) {
    		log.waitingToSwim();
    		wait();
    	}
    	ni�osNadando++;
    	log.swimming();
    	notifyAll();
    }
    public synchronized void kidRests()      {
    	ni�osNadando--;
    	log.resting();
    	notifyAll();
    }
    public synchronized void instructorSwims() throws InterruptedException{
    	while(ni�osNadando+instructoresNadando+1>=CAP) {
    		log.waitingToSwim();
    		wait();
    	}
    	instructoresNadando++;
    	log.swimming();
    	notifyAll();
    }
    public synchronized void instructorRests() throws InterruptedException{
    	while((instructoresNadando-1)*KI < ni�osNadando) {
    		log.waitingToRest();
    		wait();
    	}
    	instructoresNadando--;
    	log.resting(); 
    	notifyAll();
    }
}
