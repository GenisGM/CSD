// CSD Mar 2013 Juansa Sendra

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    private int numeroFilosofos = 0;
	
	public LimitedTable(StateManager state) {super(state);}
    
    public synchronized void enter(int id) throws InterruptedException {
    	while (numeroFilosofos+1 > 4) {state.wenter(id); wait();}
        state.enter(id);
        numeroFilosofos++;
    }
    public synchronized void exit(int id)  {
    	state.exit(id);
    	numeroFilosofos--;
    	notifyAll();
    }
}
