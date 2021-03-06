// CSD feb 2013 Juansa Sendra

public class Pool4 extends Pool3{ //max capacity
	int KI, CAP;
	int instructoresEsperando = 0;
    public void init(int ki, int cap)           {
    	KI=ki; CAP=cap;
    	}
    public synchronized void kidSwims() throws InterruptedException{
    	while((instructoresNadando*KI < niņosNadando+1)||(niņosNadando+1+instructoresNadando>=CAP)||(instructoresEsperando>0)) {
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
    		instructoresEsperando++;
    		wait();
    	}
    	instructoresNadando--;
    	log.resting(); 
    	notifyAll();
    }
}
