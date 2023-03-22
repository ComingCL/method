package org.example.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Caretaker {
	private int cursorIndex = -1;// 当前所处的版本游标
	private List<ConfigMemento> mementoList = new ArrayList<>();
	private Map<String, ConfigMemento> mementoMap = new ConcurrentHashMap<>();
	
	public void append(ConfigMemento configMemento) {
		mementoList.add(configMemento);
		mementoMap.put(configMemento.getConfigFile().getVersionNo(), configMemento);
		cursorIndex += 1;
	}
	public ConfigMemento undo() {
		if(--cursorIndex <= 0) {
			return mementoList.get(0);
		}
		return mementoList.get(cursorIndex);
	}
	public ConfigMemento redo() {
		if(++cursorIndex >= mementoList.size()) {
			return mementoList.get(mementoList.size() - 1);
		}
		return mementoList.get(cursorIndex);
	}
	public ConfigMemento get(String versionNo) {
		return mementoMap.get(versionNo);
	}
	public int getCursorIndex() {
		return cursorIndex;
	}
	public void setCursorIndex(int cursorIndex) {
		this.cursorIndex = cursorIndex;
	}
}
