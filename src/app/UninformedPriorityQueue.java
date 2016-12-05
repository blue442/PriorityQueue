package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UninformedPriorityQueue {
	
	Map<Integer, LinkedList<QueueNode>> priorityList= new HashMap<Integer, LinkedList<QueueNode>>();
	
	public UninformedPriorityQueue(){
		
	}
	
	
	public synchronized void enqueue(QueueNode item, Integer priority){
		if(priorityList.containsKey(priority)){
			priorityList.get(priority).add(item);
		} else {
			priorityList.put(priority, new LinkedList<QueueNode>());
			priorityList.get(priority).add(item);
		}
	}
	
	
	public synchronized QueueNode dequeue(Integer priority){
		LinkedList<QueueNode> ll = priorityList.get(priority);
		return ll.removeFirst();
	}
	
	
	public synchronized QueueNode dequeue(){
		Set<Integer> keySet = priorityList.keySet();
		List<Integer> sortedKeyList = new ArrayList<Integer>(keySet);
		Collections.sort(sortedKeyList);
		
		Integer currentPriority = sortedKeyList.get(0);
		
		LinkedList<QueueNode> ll = priorityList.get(currentPriority);
		while(!ll.isEmpty()){
			priorityList.get(currentPriority++);
		}
		return ll.removeFirst();
	}
	
	public synchronized int count(){
		int count = 0;
		for(int key:priorityList.keySet()){
			count += priorityList.get(key).size();
		}
		return count;
	}

	public synchronized int count(Integer priority){
		return priorityList.get(priority).size();
	}
}
