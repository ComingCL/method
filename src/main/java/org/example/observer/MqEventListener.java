package org.example.observer;

public class MqEventListener implements EventListener{

	@Override
	public void doEvent(Event event) {
		System.out.println("MQ records user" + event.getUid() + "'s messages " + event.getMsg());
	}
}
