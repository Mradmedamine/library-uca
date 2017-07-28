package org.library.uca.bootstrap;

import org.apache.log4j.Logger;
import org.library.uca.domain.Record;
import org.library.uca.domain.RecordStatus;
import org.library.uca.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class RecordsLoader implements ApplicationListener<ContextRefreshedEvent> {

	private static Logger log = Logger.getLogger(RecordsLoader.class);

	private RecordRepository recordRepository;

	@Autowired
	public void setRecordRepository(RecordRepository recordRepository) {
		this.recordRepository = recordRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Record record1 = new Record();
		record1.setDescription("Aprendiendo C ");
		record1.setAuthor("Rodriguez Corral");
		record1.setReference("EBK/2013/26");
		record1.setStatus(RecordStatus.IN_PRINTING);
		record1 = recordRepository.save(record1);
		log.info("Saved Role :   id: " + record1.getId());

		Record record2 = new Record();
		record2.setDescription("Reimpreso Aprendiendo C ");
		record2.setAuthor("Rodriguez Corral");
		record2.setReference("REI/2009/26");
		record2.setStatus(RecordStatus.PRINTED);
		record2 = recordRepository.save(record2);
		log.info("Saved Role :   id: " + record2.getId());

		Record record3 = new Record();
		record3.setDescription("Aprendiendo C ");
		record3.setAuthor("Rodriguez Corral");
		record3.setReference("EBK/2013/26");
		record3.setStatus(RecordStatus.IN_PRINTING);
		record3 = recordRepository.save(record3);
		log.info("Saved Role :   id: " + record3.getId());

		Record record4 = new Record();
		record4.setDescription("Verificación formal de algoritmos: ejercicios resueltos");
		record4.setAuthor("Silva Ramírez, Esther Lydia");
		record4.setReference("REI/IYA/2014/10");
		record4.setStatus(RecordStatus.ANSWERED);
		record4 = recordRepository.save(record4);
		log.info("Saved Role :   id: " + record4.getId());

		Record record33 = new Record();
		record33.setDescription("Introducción a la programación");
		record33.setAuthor("Hurtado Rodríguez, Nuria");
		record33.setReference("MAN/IYA/2010/09");
		record33.setStatus(RecordStatus.REGISTERED);
		record33 = recordRepository.save(record33);
		log.info("Saved Role :   id: " + record33.getId());

		Record record5 = new Record();
		record5.setDescription("Corrección de algoritmos complejos");
		record5.setAuthor("López Coello, Manuel");
		record5.setReference("EBK/IYA/2017/07");
		record5.setStatus(RecordStatus.IN_PRINTING);
		record5 = recordRepository.save(record5);
		log.info("Saved Role :   id: " + record5.getId());

		Record record6 = new Record();
		record6.setDescription("Compiladores y procesadores de lenguajes");
		record6.setAuthor("Jiménez Millán, José Antonio");
		record6.setReference("EBK/IYA/2015/03");
		record6.setStatus(RecordStatus.EXTERNAL_EVALUATION);
		record6 = recordRepository.save(record6);
		log.info("Saved Role :   id: " + record6.getId());

		Record record7 = new Record();
		record7.setDescription("Compiladores y procesadores de lenguajes");
		record7.setAuthor("Jiménez Millán, José Antonio");
		record7.setReference("EBK/IYA/2015/03");
		record7.setStatus(RecordStatus.DISMISSED);
		record7 = recordRepository.save(record7);
		log.info("Saved Role :   id: " + record7.getId());

		Record record8 = new Record();
		record8.setDescription("Fundamentos de C++");
		record8.setAuthor("Aburruzaga García, Gerardo");
		record8.setReference("REI/IYA/2016/01");
		record8.setStatus(RecordStatus.ACCEPTED_WITH_MODIFICATIONS);
		record8 = recordRepository.save(record8);
		log.info("Saved Role :   id: " + record8.getId());

		Record record9 = new Record();
		record9.setDescription("Sistemas operativos");
		record9.setAuthor("Domínguez Jiménez, Juan José");
		record9.setReference("REI/IYA/2009/07");
		record9.setStatus(RecordStatus.IN_PRINTING);
		record9 = recordRepository.save(record9);
		log.info("Saved Role :   id: " + record9.getId());

		Record record10 = new Record();
		record10.setDescription("Sistemas operativos");
		record10.setAuthor("Domínguez Jiménez, Juan José");
		record10.setReference("REI/IYA/2009/07");
		record10.setStatus(RecordStatus.IN_PRINTING);
		record10 = recordRepository.save(record10);
		log.info("Saved Role :   id: " + record10.getId());

		Record record11 = new Record();
		record11.setDescription("Compiladores y procesadores de lenguajes");
		record11.setAuthor("Jiménez Millán, José Antonio");
		record11.setReference("EBK/I/2015/03");
		record11.setStatus(RecordStatus.DISMISSED);
		record11 = recordRepository.save(record11);
		log.info("Saved Role :   id: " + record11.getId());
	}
}
