package org.library.uca.model.domain;

import java.util.ArrayList;
import java.util.List;

import org.library.uca.model.domain.entity.Library;

public class LibraryRepo {

	private static List<Library> libraryList = new ArrayList<>();
	static {
        libraryList.add(new Library("Biblioteca Central"));
        libraryList.add(new Library("Ciencias"));
        libraryList.add(new Library("Ciencias de la Salud"));
        libraryList.add(new Library("Derecho"));
        libraryList.add(new Library("Empresariales"));
        libraryList.add(new Library("Humanidades"));
        libraryList.add(new Library("Ingeniería"));
        libraryList.add(new Library("Magisterio"));   
    }

	public static List<Library> getLibraryList() {
		return libraryList;
	}
}
