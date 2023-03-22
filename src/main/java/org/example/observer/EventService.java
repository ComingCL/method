package org.example.observer;

public abstract class EventService {
	private EventManager eventManager;
	public EventService() {
		eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.MESSAGE);
		eventManager.subscribe(EventManager.EventType.MQ, new MqEventListener());
		eventManager.subscribe(EventManager.EventType.MESSAGE, new MessageEventListener());
	}
	public Event draw(String uid) {
		Event event = doDraw(uid);
		eventManager.notify(EventManager.EventType.MQ, event);
		eventManager.notify(EventManager.EventType.MESSAGE, event);
		return event;
	}
	protected abstract Event doDraw(String uid);
}
