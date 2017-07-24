package org.library.uca.bootstrap;

import org.apache.log4j.Logger;
import org.library.uca.domain.Record;
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
		record1.setName("Aprendiendo C ");
		record1.setAuthor("Rodriguez Corral");
		record1.setReference("EBK/2013/26");
		record1.setStatus("Impreso");
		record1 = recordRepository.save(record1);
		log.info("Saved Role :   id: " + record1.getId());

		Record record2 = new Record();
		record2.setName("Reimpreso Aprendiendo C ");
		record2.setAuthor("Rodriguez Corral");
		record2.setReference("REI/2009/26");
		record2.setStatus("Impreso");
		record2 = recordRepository.save(record2);
		log.info("Saved Role :   id: " + record2.getId());

	}
}
