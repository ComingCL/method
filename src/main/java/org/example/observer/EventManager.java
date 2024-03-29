package org.example.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
	Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();
	public enum EventType{
		MQ, MESSAGE
	}
	
	@SafeVarargs
	public EventManager(Enum<EventType>... operations) {
		for(Enum<EventType> operation : operations) {
			this.listeners.put(operation, new ArrayList<>());
		}
	}
	
	/**
	 * 订阅
	 * @param eventType 事件类型
	 * @param listener 监听
	 */
	public void subscribe(Enum<EventType> eventType, EventListener listener) {
		List<EventListener> users = listeners.get(eventType);
		users.add(listener);
	}
	/**
	 * 取消订阅
	 * @param eventType 事件类型
	 * @param listener 监听
	 */
	public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
		List<EventListener> users = listeners.get(eventType);
		users.remove(listener);
	}
	/**
	 * 通知
	 * @param eventType 事件类型
	 * @param event 事件
	 */
	public void notify(Enum<EventType> eventType, Event event) {
		List<EventListener> users = listeners.get(eventType);
		for(EventListener listener : users) {
			listener.doEvent(event);
		}
	}
}
