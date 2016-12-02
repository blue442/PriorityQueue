package app;

import java.util.LinkedList;

public class UninformedPriorityQueue {
	
	LinkedList<LinkedList<QueueItem>> priorityList= new LinkedList<LinkedList<QueueItem>>();
	
	public UninformedPriorityQueue(){
		
	}
	
	
	public void enqueue(QueueItem item, Integer priority){
		if(priorityList.contains(priority)){
			priorityList.get(priority).add(item);
		} else {
			priorityList.add(priority, new LinkedList<QueueItem>());
			priorityList.get(priority).add(item);
		}
	}
	
	
	public QueueItem dequeue(Integer priority){
		LinkedList<QueueItem> ll = priorityList.get(priority);
		return ll.removeLast();
	}
	
	
	public QueueItem dequeue(){
		LinkedList<QueueItem> ll = priorityList.getFirst();
		return ll.removeLast();
	}
	
}
