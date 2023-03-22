package org.example.memento;

import java.util.Date;

public class MementoDemo {
	public static void main(String[] args) {
		Caretaker taker = new Caretaker();
		ConfigOrinator configOrinator = new ConfigOrinator();
		
		configOrinator.setConfigFile(new ConfigFile("0", "配置0", new Date(), "clarence"));
		taker.append(configOrinator.saveMemento());
		
		configOrinator.setConfigFile(new ConfigFile("1", "配置1", new Date(), "clarence"));
		taker.append(configOrinator.saveMemento());
		
		configOrinator.setConfigFile(new ConfigFile("2", "配置2", new Date(), "clarence"));
		taker.append(configOrinator.saveMemento());

		configOrinator.setConfigFile(new ConfigFile("3", "配置3", new Date(), "clarence"));
		taker.append(configOrinator.saveMemento());
		
		System.out.println(configOrinator.getConfigFile().getVersionNo());
		configOrinator.getMemento(taker.undo());
		System.out.println(configOrinator.getConfigFile().getVersionNo());
		configOrinator.getMemento(taker.undo());
		System.out.println(configOrinator.getConfigFile().getVersionNo());
		
		configOrinator.getMemento(taker.redo());
		System.out.println(configOrinator.getConfigFile().getVersionNo());
		configOrinator.getMemento(taker.get("0"));
		System.out.println(configOrinator.getConfigFile().getVersionNo());
	}
}
