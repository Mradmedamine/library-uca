package org.library.uca.bootstrap;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.library.uca.model.domain.RecordStatus;
import org.library.uca.model.domain.RecordType;
import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.Record;
import org.library.uca.repository.AuthorRepository;
import org.library.uca.repository.BookRepository;
import org.library.uca.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LibraryLoader implements ApplicationListener<ContextRefreshedEvent> {

	private static Logger log = Logger.getLogger(LibraryLoader.class);

	@Autowired
	private RecordRepository recordRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		populateData();
	}

	private void populateData() {

		// AUTHORS
		Author author1 = new Author();
		author1.setName("Rodriguez Corral");
		authorRepository.save(author1);
		log.info("Saved Author :   id: " + author1.getId());

		Author author2 = new Author();
		author2.setName("Silva Ramírez, Esther Lydia");
		authorRepository.save(author2);
		log.info("Saved Author :   id: " + author2.getId());

		Author author3 = new Author();
		author3.setName("Hurtado Rodríguez, Nuria");
		authorRepository.save(author3);
		log.info("Saved Author :   id: " + author3.getId());

		Author author4 = new Author();
		author4.setName("Domínguez Jiménez, Juan José");
		authorRepository.save(author4);
		log.info("Saved Author :   id: " + author4.getId());

		// BOOKS
		Book book1 = new Book();
		book1.setTitle("Title Book 1 ");
		book1.setReference("book1 Reference");
		book1.setAuthors(Collections.singleton(author1));
		bookRepository.save(book1);
		log.info("Saved Book :   id: " + book1.getId());

		Book book2 = new Book();
		book2.setTitle("Title Book 2 ");
		book2.setReference("book2 Reference");
		book2.setAuthors(Collections.singleton(author3));
		bookRepository.save(book2);
		log.info("Saved Book :   id: " + book2.getId());

		Book book3 = new Book();
		book3.setTitle("Title Book 3 ");
		book3.setReference("book. Reference");
		book3.setAuthors(Collections.singleton(author2));
		bookRepository.save(book3);
		log.info("Saved Book :   id: " + book3.getId());

		// RECORDS
		Record record1 = new Record();
		record1.setDescription("Aprendiendo C ");
		record1.setResponsible(author1);
		record1.setReference("EBK/2013/26");
		record1.setStatus(RecordStatus.IN_PRINTING);
		record1.setType(RecordType.ADMINISTRATIVE);
		record1 = recordRepository.save(record1);
		log.info("Saved Role :   id: " + record1.getId());

		Record record2 = new Record();
		record2.setDescription("Reimpreso Aprendiendo C ");
		record2.setResponsible(author2);
		record2.setReference("REI/2009/26");
		record2.setStatus(RecordStatus.PRINTED);
		record2.setType(RecordType.EBOOK);
		record2 = recordRepository.save(record2);
		log.info("Saved Role :   id: " + record2.getId());

		Record record3 = new Record();
		record3.setDescription("Aprendiendo C ");
		record3.setResponsible(author3);
		record3.setReference("EBK/2013/26");
		record3.setStatus(RecordStatus.IN_PRINTING);
		record3.setType(RecordType.EBOOK);
		record3 = recordRepository.save(record3);
		log.info("Saved Role :   id: " + record3.getId());

		Record record4 = new Record();
		record4.setDescription("Verificación formal de algoritmos: ejercicios resueltos");
		record4.setResponsible(author2);
		record4.setReference("REI/IYA/2014/10");
		record4.setStatus(RecordStatus.IN_BUDGET);
		record4.setType(RecordType.EBOOK);
		record4 = recordRepository.save(record4);
		log.info("Saved Role :   id: " + record4.getId());

		Record record33 = new Record();
		record33.setDescription("Introducción a la programación");
		record33.setResponsible(author4);
		record33.setReference("MAN/IYA/2010/09");
		record33.setStatus(RecordStatus.REGISTERED);
		record33.setType(RecordType.REPRINT);
		record33 = recordRepository.save(record33);
		log.info("Saved Role :   id: " + record33.getId());

		Record record5 = new Record();
		record5.setDescription("Corrección de algoritmos complejos");
		record5.setResponsible(author1);
		record5.setReference("EBK/IYA/2017/07");
		record5.setStatus(RecordStatus.IN_PRINTING);
		record5.setType(RecordType.EBOOK);
		record5.setBook(book1);
		record5 = recordRepository.save(record5);
		log.info("Saved Role :   id: " + record5.getId());

		Record record6 = new Record();
		record6.setDescription("Compiladores y procesadores de lenguajes");
		record6.setResponsible(author3);
		record6.setReference("EBK/IYA/2015/03");
		record6.setStatus(RecordStatus.EXTERNAL_MANAGEMENT);
		record6.setType(RecordType.ADMINISTRATIVE);
		record6 = recordRepository.save(record6);
		log.info("Saved Role :   id: " + record6.getId());

		Record record7 = new Record();
		record7.setDescription("Compiladores y procesadores de lenguajes");
		record7.setResponsible(author1);
		record7.setReference("EBK/IYA/2015/03");
		record7.setStatus(RecordStatus.DISMISSED);
		record7.setType(RecordType.EBOOK);
		record7.setBook(book2);
		record7 = recordRepository.save(record7);
		log.info("Saved Role :   id: " + record7.getId());

		Record record8 = new Record();
		record8.setDescription("Fundamentos de C++");
		record8.setResponsible(author3);
		record8.setReference("REI/IYA/2016/01");
		record8.setStatus(RecordStatus.ACCEPTED);
		record8.setType(RecordType.PAPER);
		record8 = recordRepository.save(record8);
		log.info("Saved Role :   id: " + record8.getId());

		Record record9 = new Record();
		record9.setDescription("Sistemas operativos");
		record9.setResponsible(author4);
		record9.setReference("REI/IYA/2009/07");
		record9.setStatus(RecordStatus.IN_PRINTING);
		record9.setType(RecordType.REPRINT);
		record9 = recordRepository.save(record9);
		log.info("Saved Role :   id: " + record9.getId());

		Record record10 = new Record();
		record10.setDescription("Sistemas operativos");
		record10.setResponsible(author1);
		record10.setReference("REI/IYA/2009/07");
		record10.setStatus(RecordStatus.IN_PRINTING);
		record10.setType(RecordType.EBOOK);
		record10 = recordRepository.save(record10);
		log.info("Saved Role :   id: " + record10.getId());

		Record record11 = new Record();
		record11.setDescription("Compiladores y procesadores de lenguajes");
		record11.setResponsible(author2);
		record11.setReference("EBK/I/2015/03");
		record11.setStatus(RecordStatus.DISMISSED);
		record11.setType(RecordType.EBOOK);
		record11 = recordRepository.save(record11);
		log.info("Saved Role :   id: " + record11.getId());
	}
}
