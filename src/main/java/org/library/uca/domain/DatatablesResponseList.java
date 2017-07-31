package org.library.uca.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DatatablesResponseList<T> implements Serializable {

	private static final long serialVersionUID = 8860231256172178051L;

	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> newData) {
		if (data == null) {
			data = new ArrayList<T>();
		} else {
			data.clear();
		}
		if (newData != null) {
			for (int i = 0; i < newData.size(); i++) {
				add(newData.get(i));
			}
		}
	}

	public void add(T itemData) {
		if (data == null) {
			data = new ArrayList<T>();
		}
		if (itemData != null) {
			data.add(itemData);
		}
	}

	public int size() {
		if (getData() != null) {
			return getData().size();
		} else {
			return -1;
		}
	}
}
