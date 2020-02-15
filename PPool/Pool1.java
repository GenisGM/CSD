// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {   //no kids alone
    protected int ni�osNadando = 0;
    protected int instructoresNadando = 0;
	public void init(int ki, int cap)           {}
	public synchronized void kidSwims() throws InterruptedException{
		while(instructoresNadando == 0) {
		log.waitingToSwim();
		wait();
		}
		ni�osNadando++;
		log.swimming();
		notifyAll();}
    public synchronized void kidRests()      {
    	ni�osNadando--;
    	log.resting();
    	notifyAll();}
    public synchronized void instructorSwims() throws InterruptedException{
    	instructoresNadando++;
    	log.swimming();
    	notifyAll();}
    public synchronized void instructorRests() throws InterruptedException{
    	while(ni�osNadando>0 && instructoresNadando<2) {
    	log.waitingToRest();
    	wait();
    	}
    	instructoresNadando--;
    	log.resting();
    	notifyAll();}
}
