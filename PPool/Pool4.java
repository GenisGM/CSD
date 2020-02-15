// CSD feb 2013 Juansa Sendra

public class Pool4 extends Pool3{ //max capacity
	int KI, CAP;
	int instructoresEsperando = 0;
    public void init(int ki, int cap)           {
    	KI=ki; CAP=cap;
    	}
    public synchronized void kidSwims() throws InterruptedException{
    	while((instructoresNadando*KI < ni�osNadando+1)||(ni�osNadando+1+instructoresNadando>=CAP)||(instructoresEsperando>0)) {
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
    		instructoresEsperando++;
    		wait();
    	}
    	instructoresNadando--;
    	log.resting(); 
    	notifyAll();
    }
}
