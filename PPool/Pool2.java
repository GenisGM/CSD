// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool1{ //max kids/instructor
	int KI;
    public void init(int ki, int cap)           {
    	KI=ki;
    	}
    public synchronized void kidSwims() throws InterruptedException{
    	while(instructoresNadando*KI < niñosNadando+1) {
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
