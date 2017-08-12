package org.library.uca.bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.library.uca.model.domain.RecordStatus;
import org.library.uca.model.domain.RecordType;
import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.domain.entity.Record;
import org.library.uca.repository.AuthorRepository;
import org.library.uca.repository.BookEditionRepository;
import org.library.uca.repository.BookRepository;
import org.library.uca.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class LibraryLoader implements ApplicationListener<ContextRefreshedEvent> {

	private static Logger log = Logger.getLogger(LibraryLoader.class);

	@Autowired
	private RecordRepository recordRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookEditionRepository bookEditionRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		populateData();
	}

	private void populateData() {

		// AUTHORS
		List<Author> authorList = new ArrayList<>();
		Faker faker = new Faker(new Locale("es_ES"));
		for (int i = 0; i < 10; i++) {
			Author author = new Author();
			author.setFullname(faker.name().fullName());
			author.setEmail(faker.internet().emailAddress());
			author.setIdCard(faker.code().ean8());
			authorRepository.save(author);
			authorList.add(author);
		}

		// BOOKS

		Book book1 = new Book();
		book1.setTitle("Title Book 1 ");
		book1.setDescription("Description Book 1 ");
		book1.setAuthors(Collections.singleton(authorList.get(0)));
		bookRepository.save(book1);
		log.info("Saved Book :   id: " + book1.getId());

		BookEdition edition11 = new BookEdition();
		edition11.setIsbn("5959652");
		edition11.setStartDate(LocalDate.now());
		edition11.setEndDate(LocalDate.now());
		edition11.setPrice(45.5);
		edition11.setVat(5.5);
		edition11.setPages(450);
		edition11.setBook(book1);
		bookEditionRepository.save(edition11);
		book1.setEditions(Collections.singleton(edition11));

		// Book 2

		Book book2 = new Book();
		book2.setTitle("Title Book 2 ");
		book2.setDescription("Description Book 2 ");
		book2.setAuthors(Collections.singleton(authorList.get(2)));
		bookRepository.save(book2);
		log.info("Saved Book :   id: " + book2.getId());

		BookEdition edition21 = new BookEdition();
		edition21.setIsbn("5969652");
		edition21.setStartDate(LocalDate.now());
		edition21.setEndDate(LocalDate.now());
		edition21.setPrice(45.5);
		edition21.setVat(5.5);
		edition21.setPages(450);
		edition21.setBook(book2);
		bookEditionRepository.save(edition21);

		book1.setEditions(Collections.singleton(edition21));

		// Book 3

		Book book3 = new Book();
		book3.setTitle("Title Book 3 ");
		book3.setDescription("Description Book 3 ");
		book3.setAuthors(Collections.singleton(authorList.get(2)));

		bookRepository.save(book3);
		log.info("Saved Book :   id: " + book3.getId());

		BookEdition edition31 = new BookEdition();
		edition31.setIsbn("5969652");
		edition31.setStartDate(LocalDate.now());
		edition31.setEndDate(LocalDate.now());
		edition11.setPrice(25.5);
		edition11.setVat(4.5);
		edition31.setPages(450);
		bookEditionRepository.save(edition31);

		book1.setEditions(Collections.singleton(edition31));

		// RECORDS
		Record record1 = new Record();
		record1.setDescription("Aprendiendo C ");
		record1.setResponsible(authorList.get(0));
		record1.setReference("EBK/2013/26");
		record1.setStatus(RecordStatus.IN_PRINTING);
		record1.setType(RecordType.ADMINISTRATIVE);
		record1 = recordRepository.save(record1);
		log.info("Saved Role : id: " + record1.getId());

		Record record2 = new Record();
		record2.setDescription("Reimpreso Aprendiendo C ");
		record2.setResponsible(authorList.get(1));
		record2.setReference("REI/2009/26");
		record2.setStatus(RecordStatus.PRINTED);
		record2.setType(RecordType.EBOOK);
		record2 = recordRepository.save(record2);
		log.info("Saved Role :   id: " + record2.getId());

		Record record3 = new Record();
		record3.setDescription("Aprendiendo C ");
		record3.setResponsible(authorList.get(2));
		record3.setReference("EBK/2013/26");
		record3.setStatus(RecordStatus.IN_PRINTING);
		record3.setType(RecordType.EBOOK);
		record3 = recordRepository.save(record3);
		log.info("Saved Role :   id: " + record3.getId());

		Record record4 = new Record();
		record4.setDescription("Verificación formal de algoritmos: ejercicios resueltos");
		record4.setResponsible(authorList.get(2));
		record4.setReference("REI/IYA/2014/10");
		record4.setStatus(RecordStatus.IN_BUDGET);
		record4.setType(RecordType.EBOOK);
		record4 = recordRepository.save(record4);
		log.info("Saved Role :   id: " + record4.getId());

		Record record33 = new Record();
		record33.setDescription("Introducción a la programación");
		record33.setResponsible(authorList.get(3));
		record33.setReference("MAN/IYA/2010/09");
		record33.setStatus(RecordStatus.REGISTERED);
		record33.setType(RecordType.REPRINT);
		record33 = recordRepository.save(record33);
		log.info("Saved Role :   id: " + record33.getId());

		Record record5 = new Record();
		record5.setDescription("Corrección de algoritmos complejos");
		record5.setResponsible(authorList.get(0));
		record5.setReference("EBK/IYA/2017/07");
		record5.setStatus(RecordStatus.IN_PRINTING);
		record5.setType(RecordType.EBOOK);
		record5.setBook(book1);
		record5 = recordRepository.save(record5);
		log.info("Saved Role :   id: " + record5.getId());

		Record record6 = new Record();
		record6.setDescription("Compiladores y procesadores de lenguajes");
		record6.setResponsible(authorList.get(2));
		record6.setReference("EBK/IYA/2015/03");
		record6.setStatus(RecordStatus.EXTERNAL_MANAGEMENT);
		record6.setType(RecordType.ADMINISTRATIVE);
		record6 = recordRepository.save(record6);
		log.info("Saved Role :   id: " + record6.getId());

		Record record7 = new Record();
		record7.setDescription("Compiladores y procesadores de lenguajes");
		record7.setResponsible(authorList.get(0));
		record7.setReference("EBK/IYA/2015/03");
		record7.setStatus(RecordStatus.DISMISSED);
		record7.setType(RecordType.EBOOK);
		record7.setBook(book2);
		record7 = recordRepository.save(record7);
		log.info("Saved Role :   id: " + record7.getId());

		Record record8 = new Record();
		record8.setDescription("Fundamentos de C++");
		record8.setResponsible(authorList.get(2));
		record8.setReference("REI/IYA/2016/01");
		record8.setStatus(RecordStatus.ACCEPTED);
		record8.setType(RecordType.PAPER);
		record8 = recordRepository.save(record8);
		log.info("Saved Role :   id: " + record8.getId());

		Record record9 = new Record();
		record9.setDescription("Sistemas operativos");
		record9.setResponsible(authorList.get(3));
		record9.setReference("REI/IYA/2009/07");
		record9.setStatus(RecordStatus.IN_PRINTING);
		record9.setType(RecordType.REPRINT);
		record9 = recordRepository.save(record9);
		log.info("Saved Role :   id: " + record9.getId());

		Record record10 = new Record();
		record10.setDescription("Sistemas operativos");
		record10.setResponsible(authorList.get(0));
		record10.setReference("REI/IYA/2009/07");
		record10.setStatus(RecordStatus.IN_PRINTING);
		record10.setType(RecordType.EBOOK);
		record10 = recordRepository.save(record10);
		log.info("Saved Role :   id: " + record10.getId());

		Record record11 = new Record();
		record11.setDescription("Compiladores y procesadores de lenguajes");
		record11.setResponsible(authorList.get(1));
		record11.setReference("EBK/I/2015/03");
		record11.setStatus(RecordStatus.DISMISSED);
		record11.setType(RecordType.EBOOK);
		record11 = recordRepository.save(record11);
		log.info("Saved Role :   id: " + record11.getId());
	}
}
