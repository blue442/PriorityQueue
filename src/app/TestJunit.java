package app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {

	   
//	protected void setUp() {
//		Integer testSize = 10000;
//		Integer maxPriorities = 10;
//		Integer dequeueTestSize = 10;
//		
//		// initialize queue
//		long start = System.nanoTime();
//		UninformedPriorityQueue testQueue = QueueRunner.populateQueue(maxPriorities, testSize);
//		long time = System.nanoTime() - start;
//		System.out.println("populating uninformedPriorityQueue with " + testSize + " items over " + maxPriorities + " priority levels took " + time/1000000 + " milliseconds");
//
//	}
   
//   protected void setUp(){
//
//   }
//   
//   
//	@Test
//	public void testOrderingWithinPriority() {
//		UninformedPriorityQueue testQueue = new UninformedPriorityQueue();
//		List<UUID> queueItemIdList = new ArrayList<UUID>();
//
//		// populate queue
//		for(Integer i=0; i<=2; i++){
//			QueueItem qi = new QueueItem(1);
//			testQueue.enqueue(qi, qi.priority);
//			queueItemIdList.add(qi.uuid);
//		}
//	   
//		// dequeue
//		assertEquals(testQueue.dequeue().uuid, queueItemIdList.get(0));
//		assertEquals(testQueue.dequeue().uuid, queueItemIdList.get(1));
//		assertEquals(testQueue.dequeue().uuid, queueItemIdList.get(2));
//	}
//   
//   
//	@Test
//	public void testOrderingBetweenPriorities() {
//		UninformedPriorityQueue testQueue = new UninformedPriorityQueue();
//		
//		// populate queue
//		QueueItem qi1 = new QueueItem(1);
//		testQueue.enqueue(qi1, 1);
//	   
//		QueueItem qi2 = new QueueItem(1);
//		testQueue.enqueue(qi2, 1);
//	   
//		QueueItem qi3 = new QueueItem(2);
//		testQueue.enqueue(qi3, 2);
//	   
//		QueueItem qi4 = new QueueItem(3);
//		testQueue.enqueue(qi4, 3);
//	   	   
//		// dequeue
//		assertEquals(testQueue.dequeue(1), qi1);
//		assertEquals(testQueue.dequeue(1), qi2);
//		assertEquals(testQueue.dequeue(2), qi3);
//		assertEquals(testQueue.dequeue(3), qi4);
//	}
//
//	
//	@Test
//	public void testCountForAllPriorities() {
//		UninformedPriorityQueue testQueue = new UninformedPriorityQueue();
//		
//		// populate queue
//		QueueItem qi1 = new QueueItem(1);
//		testQueue.enqueue(qi1, 1);
//	   
//		QueueItem qi2 = new QueueItem(1);
//		testQueue.enqueue(qi2, 1);
//	   
//		QueueItem qi3 = new QueueItem(2);
//		testQueue.enqueue(qi3, 2);
//	   
//		QueueItem qi4 = new QueueItem(3);
//		testQueue.enqueue(qi4, 3);
//	   	   
//		// dequeue
//		assertEquals(testQueue.count(), 4);
//	}
//
//	
//	@Test
//	public void testCountForSinglePriority() {
//		UninformedPriorityQueue testQueue = new UninformedPriorityQueue();
//		
//		// populate queue
//		QueueItem qi1 = new QueueItem(1);
//		testQueue.enqueue(qi1, 1);
//	   
//		QueueItem qi2 = new QueueItem(1);
//		testQueue.enqueue(qi2, 1);
//	   
//		QueueItem qi3 = new QueueItem(2);
//		testQueue.enqueue(qi3, 2);
//	   
//		QueueItem qi4 = new QueueItem(3);
//		testQueue.enqueue(qi4, 3);
//	   	   
//		// dequeue
//		assertEquals(testQueue.count(1), 2);
//	}
//	
	
	
	@Test
	public void testHeap(){
		
		System.out.println("Testing heap");
		Heap h = new Heap();
		
		int[] initOrder = new int[] {8, 3, 2, 7, 4, 6, 5, 1, 9};
		
		for(int i:initOrder){
			System.out.println("adding item priority " + i + " to array:");
			h.reportPriorities();
			QueueNode qi1 = new QueueNode(i);
			h.enqueue(qi1);	
		}
		
		h.reportPriorities();
		
		QueueNode testResult1 = h.dequeueNode();
		System.out.println("first item out of heap: " + testResult1.priority);
		assertEquals((int)testResult1.priority, (int) 1);
		assertEquals((int)h.dequeueNode().priority, (int) 2);
		assertEquals((int)h.dequeueNode().priority, (int) 3);
		assertEquals((int)h.dequeueNode().priority, (int) 4);
		assertEquals((int)h.dequeueNode().priority, (int) 5);
		assertEquals((int)h.dequeueNode().priority, (int) 6);
		assertEquals((int)h.dequeueNode().priority, (int) 7);
		
	}
	
	
	@Test
	public void testItemOrdering(){
		
		System.out.println("Testing ordering of items");
		Heap h = new Heap();
		
		Map<Integer, LinkedList<UUID>> priorityList = new TreeMap<Integer, LinkedList<UUID>>();
		
		Integer n = 100000;
		int low = 0;
		int high = 10;
		Random r = new Random();
		
		// setup
		for(int i=1; i<=n; i++){
			int rand = r.nextInt(high-low) + low;
			
			QueueItem newQI = new QueueItem(rand);
			if(!priorityList.containsKey(newQI.priority)){
				priorityList.put(newQI.priority, new LinkedList<UUID>());
			}
			priorityList.get(newQI.priority).add(newQI.uuid);
			h.enqueue(newQI);	
		}
		
		
		for(int i:priorityList.keySet()){
			LinkedList<UUID> currentList = priorityList.get(i);
			UUID currentItemUUID = currentList.remove(0);
			while(currentItemUUID != null){
				QueueItem currentItem = h.dequeue();
				assertEquals(currentItem.uuid, currentItemUUID);
			}
		}
		
	}
}