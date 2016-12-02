package app;

import java.util.concurrent.ThreadLocalRandom;

public class QueueRunner {
	
	public static void main(String args[]){
		Integer testSize = 10000;
		Integer maxPriorities = 10;
		
		long start = System.currentTimeMillis();
		UninformedPriorityQueue testQueue = populateQueue(maxPriorities, testSize);
		long time = System.currentTimeMillis() - start;
		System.out.println("populating uninformedPriorityQueue with " + testSize + " items over " + maxPriorities + " priority levels took " + time + " milliseconds");

	}
	
	public static UninformedPriorityQueue populateQueue(Integer maxPriorities, Integer testSize){
		UninformedPriorityQueue queue = new UninformedPriorityQueue();
		Integer priority;
		for(int i=0; i<=testSize; i++){
			priority = ThreadLocalRandom.current().nextInt(1, maxPriorities + 1);
			QueueItem qi = new QueueItem(priority);
			queue.enqueue(qi, priority);
		}
		return queue;
	}
	
	
}
