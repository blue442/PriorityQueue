package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap extends ArrayList<QueueNode> {
	
	private static final long serialVersionUID = 1L;


	Heap(){
		// soak up first position to accomodate binary tree logic
		this.add(new QueueNode(0));
	}
	
	
	
	public void enqueue(QueueNode qn){
		this.add(qn);
		int pos = this.size() - 1;
		bubbleUp(pos);
	}
	
	
	
	public void enqueue(QueueItem qi){
		QueueNode qn = this.getNode(qi.priority);
		if(qn != null){
			qn.add(qi);
		} else {
			qn = new QueueNode(qi.priority);
			qn.add(qi);
			this.enqueue(qn);
		}
	}
	
	
	public QueueNode getNode(int priority){
		for(QueueNode qn:this){
			if(qn.priority == priority){
				return qn;
			}
		}
		return null;
	}
	
	
	
	public void bubbleUp(int pos){
		if(pos/2 != 0){
			if(this.get(pos).priority < this.get(pos/2).priority){
				swap(pos, pos/2);
				bubbleUp(pos/2);
			}
		}
	}
	
	
	
	public QueueItem dequeue(){
		if(this.get(1).size() == 0){
			dequeueNode();
		}
		QueueItem qi = this.get(1).remove(); 
		return qi;
	}
	
	
	
	public QueueNode dequeueNode(){
		
		QueueNode qn = this.remove(1);
		
		// pop bottom to top
		this.add(1, this.remove(this.size() - 1));
		sink(1);
		
		return qn;
	}
	
	
	public int count(){
		int count = 0;
		for(int i=1; i<this.size(); i++){
			count += this.get(i).size();
		}
		return count;
	}
	
	
	public int prioirtyCount(){
		return this.size() - 1;
	}
	
	
	
	public void sink(int pos){
		int child1 = 2*pos;
		int child2 = 2*pos + 1;
		
		if(child1 < this.size()){
			if(child2 < this.size() && this.get(child2).priority < this.get(child1).priority){
				if(this.get(child2).priority < this.get(pos).priority){
				 	swap(pos, child2);
				 	sink(child2);
				}
			} else {
				if(this.get(child1).priority < this.get(pos).priority){
					swap(pos, child1);
					sink(child1);
				}
			}
		}
	}
	
	
	
	public void swap(int pos1, int pos2){
		Collections.swap(this, pos1, pos2);
	}
	
	
	public void reportPriorities(){
		List<Integer> priorityArray = new ArrayList<Integer>();
		for(int i=0; i<this.size(); i++){
			priorityArray.add(this.get(i).priority);
		}
		System.out.println("Priority array: " + priorityArray);
		
	}
	

		
}
