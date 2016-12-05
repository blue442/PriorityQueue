package app;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class QueueRunner {
	
	public static void main(String args[]){
		Integer testSize = 10000;
		Integer maxPriorities = 10;
		Integer dequeueTestSize = 10;
		
		// initialize queue
		long start = System.nanoTime();
		UninformedPriorityQueue testQueue = populateQueue(maxPriorities, testSize);
		long time = System.nanoTime() - start;
		System.out.println("populating uninformedPriorityQueue with " + testSize + " items over " + maxPriorities + " priority levels took " + time/1000000 + " milliseconds");

		// test dequeuing speed
		ArrayList<Double> times = new ArrayList<Double>();
		for(Integer i=0; i<dequeueTestSize; i++){
			start = System.nanoTime();
			QueueNode qi = testQueue.dequeue();
			time = System.nanoTime() - start;
			times.add((double) time);
			System.out.println("  dequeuing QueueItem " + qi.uuid.toString() + " took " + time + " nanoseconds");
		}
		reportTimeSummary(times);
	}
	
	
	
	public static UninformedPriorityQueue populateQueue(Integer maxPriorities, Integer testSize){
		UninformedPriorityQueue queue = new UninformedPriorityQueue();
		Integer priority;
		for(int i=0; i<=testSize; i++){
			priority = ThreadLocalRandom.current().nextInt(1, maxPriorities + 1);
			QueueNode qi = new QueueNode(priority);
			queue.enqueue(qi, priority);
		}
		return queue;
	}
	
	
	
//	public static void removeEverythingIndividually(UninformedPriorityQueue queue){
//		QueueItem dequeuedItem;
//		while(dequeuedItem != null){
//	 	
//		}
//	}
	
	
	
	public static void reportTimeSummary(ArrayList<Double> times){
		
		Double sum = sumArrayList(times);
		Double timeMean = sum / times.size();
		Double timeSD = sdArrayList(times, timeMean);
		System.out.println("performance time summary:: mean = " + timeMean + "; sd = " + timeSD);
	}
	
	
	
	public static double sumArrayList(ArrayList<Double> inList){
		Double sum = 0.0;
		for(Double t:inList){
			sum += t;
		}
		return sum;
	}
	
	
	
	public static double sdArrayList(ArrayList<Double> inList, Double mean){
		ArrayList<Double> deviations = new ArrayList<Double>();
		for(double d:inList){
			deviations.add(Math.abs(mean - d));
		}
		
		Double sd = sumArrayList(deviations) / deviations.size();
		
		return sd;
		
	}
	
}
