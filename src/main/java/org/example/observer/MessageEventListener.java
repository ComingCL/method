package org.example.observer;

public class MessageEventListener implements EventListener{
	@Override
	public void doEvent(Event event) {
		System.out.println("MessageListener has received" + event.getUid() + "'s message" + event.getMsg());
	}
}
