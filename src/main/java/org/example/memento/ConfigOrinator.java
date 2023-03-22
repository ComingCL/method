package org.example.memento;

public class ConfigOrinator {
	private ConfigFile configFile;
	
	public void setConfigFile(ConfigFile configFile) {
		this.configFile = configFile;
	}
	public ConfigFile getConfigFile() {
		return configFile;
	}
	public ConfigMemento saveMemento() {
		return new ConfigMemento(this.configFile);
	}
	public void getMemento(ConfigMemento configMemento) {
		this.configFile = configMemento.getConfigFile();
	}
}
