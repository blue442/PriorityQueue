package app;

import java.util.UUID;

public class QueueItem {
	public UUID uuid;
	public Integer priority;
	
	public QueueItem(Integer priority){
		this.uuid = UUID.randomUUID();
		this.priority = priority;
		
	}
}
