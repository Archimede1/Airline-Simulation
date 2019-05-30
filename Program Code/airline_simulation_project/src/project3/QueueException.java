package project3;

public class QueueException extends RuntimeException {
	
	public QueueException(){
		super("Exception: Queue Error");
	}
	
	public QueueException(String msg){
		super(msg);
	}

}
