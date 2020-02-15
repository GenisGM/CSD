// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool1{ //max kids/instructor
	int KI;
    public void init(int ki, int cap)           {
    	KI=ki;
    	}
    public synchronized void kidSwims() throws InterruptedException{
    	while(instructoresNadando*KI < ni�osNadando+1) {
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
