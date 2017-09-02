package org.library.uca.model.domain;

import java.util.ArrayList;
import java.util.List;

public class InstitutionRepo {

	private static List<String> institutionList = new ArrayList<>();
	static {
		institutionList.add("Universidad de Málaga");
		institutionList.add("Universidad de Sevilla");
		institutionList.add("Universidad de Córdoba");
		institutionList.add("Universidad de Huelva");
		institutionList.add("Universidad de Almería");
		institutionList.add("Universidad de Granada");
		institutionList.add("Universidad de Jaén");
	}

	public static List<String> getList() {
		return institutionList;
	}
}
