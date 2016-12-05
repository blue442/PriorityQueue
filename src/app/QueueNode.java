package app;

import java.util.LinkedList;
import java.util.UUID;

public class QueueNode extends LinkedList<QueueItem> {
	
	public UUID uuid;
	public Integer priority;
	
	public QueueNode(Integer priorityTracker){
		this.uuid = UUID.randomUUID();
		this.priority = priorityTracker;
		
	}
}
