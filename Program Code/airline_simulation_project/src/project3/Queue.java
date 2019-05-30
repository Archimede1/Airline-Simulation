package project3;

import java.util.*;


public class Queue<T> implements QueueADT<T> {
	private T data[];
	private int front, rear, size, MAX_SIZE;
	
	public Queue() {
		front = this.size =  0;
		this.MAX_SIZE = 100;
		rear = MAX_SIZE - 1;
		this.data = (T[]) new Object[MAX_SIZE];
		
	}
	
	public Queue(int maxSize) {
		front = this.size =  0;
		this.MAX_SIZE = maxSize;
		rear = MAX_SIZE - 1;
		this.data = (T[]) new Object[MAX_SIZE];
		
	}
	

	public synchronized void enqueue(T d) {
		if(isFull()) throw new QueueException("Queue is Full!");
		else {
			 rear = (rear + 1) % MAX_SIZE;
			 data[rear] = d;
			 size++;
		}
	}


	public synchronized T dequeue() {
		T result;
		if(isEmpty()) throw new QueueException("Queue is empty!");
		else {
			result = data[front];
			front = (front + 1) % MAX_SIZE;
			size--;
		}
		return result;
	}

	
	public synchronized T front() {
		return (T) data[front];
	}

	
	public synchronized T rear() {
		return (T) data[rear];
	}

	
	public synchronized boolean isEmpty() {
		if(size == 0 || data == null) {
			return true;
		}
		return false;
	}

	
	public synchronized boolean isFull() {
		if(size == MAX_SIZE) {
			return true;
		}
		return false;
	}
	
	public synchronized String queueChecker(){
		String str = " ";
		if(isEmpty()) {
			str = "This Queue is Empty";
			return str;
		}
		if(isFull()) {
			str = "This Queue is Full";
			return str;
		}
		if(!isEmpty() && !isFull()) {
			str = "This Queue is Populated \n" + "There are " + size + "items in the queue and " + (MAX_SIZE - size) + "\n"; 
		}
		return str;
	}
	
	public synchronized void makeEmpty() {
		rear = 0;
	    front = 0;
	    data = (T[])new Object[MAX_SIZE];
	    size = 0;
	    
	}


	public synchronized int getSize() {
		return size;
	}
	
	public synchronized String toString() {
		String str = " ";
		if(isEmpty() && size == 0) str = "Queue is empty! Maximum number of items that can be stored is " + MAX_SIZE;
		else {
			String str2 = "";
			for (int i = 0; i < size; i++) {
				str2 += data[(i + front) % MAX_SIZE] + " ";
				
			}
			str = "The Numbers of Items in the Queue is: " + size + "\nThe Queue contains the following: " + str2 + "\n";
		}
	return str;	
	}



}
