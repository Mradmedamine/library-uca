package org.library.uca.bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.library.uca.model.domain.BookSubject;
import org.library.uca.model.domain.BookType;
import org.library.uca.model.domain.ExchangeType;
import org.library.uca.model.domain.FileStatus;
import org.library.uca.model.domain.FileType;
import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.domain.entity.Exchange;
import org.library.uca.model.domain.entity.File;
import org.library.uca.repository.AuthorRepository;
import org.library.uca.repository.BookEditionRepository;
import org.library.uca.repository.BookRepository;
import org.library.uca.repository.ExchangeRepository;
import org.library.uca.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class LibraryLoader implements ApplicationListener<ContextRefreshedEvent> {

	private static Logger log = Logger.getLogger(LibraryLoader.class);

	@Autowired
	private FileRepository fileRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookEditionRepository bookEditionRepository;
	@Autowired
	private ExchangeRepository exchangeRepository;

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
			author.setPhone(faker.phoneNumber().cellPhone());
			author.setStreet(faker.address().streetAddress());
			authorRepository.save(author);
			authorList.add(author);
		}

		// BOOKS

		Book book1 = new Book();
		book1.setTitle("Introducción a la programación");
		book1.setDescription("Esta obra constituye una completa herramienta para el estudio de los fundamentos de la "
		        + "programación de ordenadores que puede servir como libro de texto para cualquier asignatura de Introducción "
		        + "a la Programación en los estudios universitarios de Informática.");
		book1.setAuthors(Collections.singleton(authorList.get(0)));
		book1.setType(BookType.MANUAL);
		book1.setSubject(BookSubject.INSTITUTIONAL);
		bookRepository.save(book1);
		log.info("Saved Book :   id: " + book1.getId());

		BookEdition edition11 = new BookEdition();
		edition11.setIsbn("978-84-7786-773-9");
		edition11.setStartDate(LocalDate.now());
		edition11.setEndDate(LocalDate.now());
		edition11.setPrice(8.65);
		edition11.setVat(4.0);
		edition11.setPages(185);
		edition11.setBook(book1);
		bookEditionRepository.save(edition11);

		BookEdition edition12 = new BookEdition();
		edition12.setIsbn("978-84-9828-318-1");
		edition12.setStartDate(LocalDate.now());
		edition12.setEndDate(LocalDate.now());
		edition12.setPrice(5.77);
		edition12.setVat(4.0);
		edition12.setPages(180);
		edition12.setBook(book1);
		bookEditionRepository.save(edition12);

		// Book 2
		Book book2 = new Book();
		book2.setTitle("Fundamentos de C++");
		book2.setDescription("Este libro explica el lenguaje de programación C++ según la norma aprobada hace unos "
		        + "años por el instituto de normalización ANSI. Ha sido elaborado pensando en los alumnos de Metodología "
		        + "y Tecnología de Programación II, asignatura de segundo curso de Ingeniería Técnica en Informática de Gestión.");
		book2.setAuthors(Collections.singleton(authorList.get(1)));
		book2.setType(BookType.MANUAL);
		book2.setSubject(BookSubject.MATHEMATICS_PHYSICAL);
		bookRepository.save(book2);
		log.info("Saved Book :   id: " + book2.getId());

		BookEdition edition21 = new BookEdition();
		edition21.setIsbn("978-84-9828-560-4");
		edition21.setStartDate(LocalDate.now());
		edition21.setEndDate(LocalDate.now());
		edition21.setPrice(8.66);
		edition21.setVat(4.0);
		edition21.setPages(475);
		edition21.setBook(book2);
		bookEditionRepository.save(edition21);

		BookEdition edition22 = new BookEdition();
		edition22.setIsbn("978-84-9828-007-4");
		edition22.setStartDate(LocalDate.now());
		edition22.setEndDate(LocalDate.now());
		edition22.setPrice(4.0);
		edition22.setVat(21.0);
		edition22.setPages(475);
		edition22.setBook(book2);
		bookEditionRepository.save(edition22);

		// Book 3

		Book book3 = new Book();
		book3.setTitle("Compiladores y procesadores de lenguajes");
		book3.setDescription("Manual centrado en el uso de los Traductores, programas que leen un programa fuente "
		        + "escrito en el lenguaje fuente y produce como resultado otro programa, con el mismo significado "
		        + "(misma semántica) que el fuente, llamado programa objeto y escrito en el lenguaje objeto. A su vez, "
		        + "un compilador es un caso particular de un traductor en el que el lenguaje objeto es el lenguaje máquina.");
		book3.setAuthors(Collections.singleton(authorList.get(2)));
		book3.setType(BookType.MONOGRAPH);
		book3.setSubject(BookSubject.ECONOMIC_BUSINESS_SCIENCES);
		bookRepository.save(book3);
		log.info("Saved Book :   id: " + book3.getId());
		
		BookEdition edition31 = new BookEdition();
		edition31.setIsbn("978-84-7786-383-0");
		edition31.setStartDate(LocalDate.now());
		edition31.setEndDate(LocalDate.now());
		edition31.setPrice(5.77);
		edition31.setVat(4.0);
		edition31.setPages(273);
		edition31.setBook(book3);
		bookEditionRepository.save(edition31);

		BookEdition edition32 = new BookEdition();
		edition32.setIsbn("978-84-9828-460-7");
		edition32.setStartDate(LocalDate.now());
		edition32.setEndDate(LocalDate.now());
		edition32.setPrice(3.0);
		edition32.setVat(21.1);
		edition32.setPages(273);
		edition32.setBook(book3);
		edition32 = bookEditionRepository.save(edition32);
		log.info("Saved Book Edition :   BookId," + book3.getId() + " EditionId" + edition32.getId());
		
		// Book 4

		Book book4 = new Book();
		book4.setTitle("Verificación formal de algoritmos: ejercicios resueltos");
		book4.setDescription("Con este libro se intenta cubrir una de las necesidades que los alumnos demandan "
		        + "año tras año en el aprendizaje de sus materias. Se trata, por tanto, de un texto con ejercicios "
		        + "resueltos, que complemente a los libros más teóricos, entendiendo que éstos son fundamentales. "
		        + "Viene, pues, este libro a complementar al título Corrección de algoritmos complejos. "
		        + "Verificación formal, publicado recientemente por los mismos autores.");
		book4.setAuthors(Collections.singleton(authorList.get(3)));
		book4.setType(BookType.MANUAL);
		book4.setSubject(BookSubject.CHEMISTRY);
		bookRepository.save(book4);
		log.info("Saved Book :   id: " + book4.getId());
		
		BookEdition edition41 = new BookEdition();
		edition41.setIsbn("978-84-9828-264-1");
		edition41.setStartDate(LocalDate.now());
		edition41.setEndDate(LocalDate.now());
		edition41.setPrice(8.65);
		edition41.setVat(4.0);
		edition41.setPages(240);
		edition41.setBook(book4);
		edition41 = bookEditionRepository.save(edition41);
		log.info("Saved Book Edition :   BookId," + book4.getId() + " EditionId" + edition41.getId());
		
		BookEdition edition42 = new BookEdition();
		edition42.setIsbn("978-84-9828-460-7");
		edition42.setStartDate(LocalDate.now());
		edition42.setEndDate(LocalDate.now());
		edition42.setPrice(4.0);
		edition42.setVat(21.0);
		edition42.setPages(240);
		edition42.setBook(book4);
		edition42 = bookEditionRepository.save(edition42);
		log.info("Saved Book Edition :   BookId," + book4.getId() + " EditionId" + edition42.getId());

		// RECORDS
		File file1 = new File();
		file1.setDescription("Aprendiendo C ");
		file1.setResponsible(authorList.get(0));
		file1.setReference("EBK/2013/26");
		file1.setStatus(FileStatus.IN_PRINTING);
		file1.setType(FileType.ADMINISTRATIVE);
		file1 = fileRepository.save(file1);
		log.info("Saved File : id: " + file1.getId());

		File file2 = new File();
		file2.setDescription("Reimpreso Aprendiendo C ");
		file2.setResponsible(authorList.get(1));
		file2.setReference("REI/2009/26");
		file2.setStatus(FileStatus.PRINTED);
		file2.setType(FileType.EBOOK);
		file2 = fileRepository.save(file2);
		log.info("Saved File :   id: " + file2.getId());

		File file3 = new File();
		file3.setDescription("Aprendiendo C ");
		file3.setResponsible(authorList.get(2));
		file3.setReference("EBK/2013/26");
		file3.setStatus(FileStatus.IN_PRINTING);
		file3.setType(FileType.EBOOK);
		file3 = fileRepository.save(file3);
		log.info("Saved File :   id: " + file3.getId());

		File file4 = new File();
		file4.setDescription("Verificación formal de algoritmos: ejercicios resueltos");
		file4.setResponsible(authorList.get(2));
		file4.setReference("REI/IYA/2014/10");
		file4.setStatus(FileStatus.IN_BUDGET);
		file4.setType(FileType.EBOOK);
		file4 = fileRepository.save(file4);
		log.info("Saved File :   id: " + file4.getId());

		File file33 = new File();
		file33.setDescription("Introducción a la programación");
		file33.setResponsible(authorList.get(3));
		file33.setReference("MAN/IYA/2010/09");
		file33.setStatus(FileStatus.REGISTERED);
		file33.setType(FileType.REPRINT);
		file33 = fileRepository.save(file33);
		log.info("Saved File :   id: " + file33.getId());

		File file5 = new File();
		file5.setDescription("Corrección de algoritmos complejos");
		file5.setResponsible(authorList.get(0));
		file5.setReference("EBK/IYA/2017/07");
		file5.setStatus(FileStatus.IN_PRINTING);
		file5.setType(FileType.EBOOK);
		file5.setBook(book1);
		file5 = fileRepository.save(file5);
		log.info("Saved File :   id: " + file5.getId());

		File file6 = new File();
		file6.setDescription("Compiladores y procesadores de lenguajes");
		file6.setResponsible(authorList.get(2));
		file6.setReference("EBK/IYA/2015/03");
		file6.setStatus(FileStatus.EXTERNAL_MANAGEMENT);
		file6.setType(FileType.ADMINISTRATIVE);
		file6 = fileRepository.save(file6);
		log.info("Saved File :   id: " + file6.getId());

		File file7 = new File();
		file7.setDescription("Compiladores y procesadores de lenguajes");
		file7.setResponsible(authorList.get(0));
		file7.setReference("EBK/IYA/2015/03");
		file7.setStatus(FileStatus.DISMISSED);
		file7.setType(FileType.EBOOK);
		file7.setBook(book2);
		file7 = fileRepository.save(file7);
		log.info("Saved File :   id: " + file7.getId());

		File file8 = new File();
		file8.setDescription("Fundamentos de C++");
		file8.setResponsible(authorList.get(2));
		file8.setReference("REI/IYA/2016/01");
		file8.setStatus(FileStatus.ACCEPTED);
		file8.setType(FileType.PAPER);
		file8 = fileRepository.save(file8);
		log.info("Saved File :   id: " + file8.getId());

		File file9 = new File();
		file9.setDescription("Sistemas operativos");
		file9.setResponsible(authorList.get(3));
		file9.setReference("REI/IYA/2009/07");
		file9.setStatus(FileStatus.IN_PRINTING);
		file9.setType(FileType.REPRINT);
		file9 = fileRepository.save(file9);
		log.info("Saved File :   id: " + file9.getId());

		File file10 = new File();
		file10.setDescription("Sistemas operativos");
		file10.setResponsible(authorList.get(0));
		file10.setReference("REI/IYA/2009/07");
		file10.setStatus(FileStatus.IN_PRINTING);
		file10.setType(FileType.EBOOK);
		file10 = fileRepository.save(file10);
		log.info("Saved File :   id: " + file10.getId());

		File file11 = new File();
		file11.setDescription("Compiladores y procesadores de lenguajes");
		file11.setResponsible(authorList.get(1));
		file11.setReference("EBK/I/2015/03");
		file11.setStatus(FileStatus.DISMISSED);
		file11.setType(FileType.EBOOK);
		file11 = fileRepository.save(file11);
		log.info("Saved File :   id: " + file11.getId());

		Exchange exchange = new Exchange();
		exchange.setIsbn("978-84-9828-560-4");
		exchange.setBookTitle("Compiladores y procesadores de lenguajes");
		exchange.setAuthorName(authorList.get(0).getFullname());
		exchange.setDate(LocalDate.now());
		exchange.setType(ExchangeType.RECEIVE);
		exchange = exchangeRepository.save(exchange);
		log.info("Saved Exchange :   id: " + exchange.getId());

	}
}
