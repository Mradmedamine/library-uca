package org.library.uca.service.impl;

import java.util.Arrays;
import java.util.List;

import org.library.uca.model.domain.FileStatus;
import org.library.uca.model.domain.FileType;
import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.File;
import org.library.uca.model.front.web.dto.FileDTO;
import org.library.uca.model.front.web.queryparams.FileQueryParams;
import org.library.uca.repository.FileRepository;
import org.library.uca.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class FileServiceImpl extends ServiceBaseImpl implements FileService {

	@Autowired
	private FileRepository fileRepository;

	@Override
	public List<File> findAll() {
		return fileRepository.findAll();
	}

	@Override
	public File findById(Long id) {
		return fileRepository.findOne(id);
	}

	@Override
	public File saveFile(FileDTO file) {
		File entityFile = null;
		Long fileId = file.getId();
		if (fileId != null) {
			entityFile = findById(fileId);
		} else {
			entityFile = new File();
		}
		entityFile.setDescription(file.getDescription());
		entityFile.setStatus(file.getStatus());
		entityFile.setType(file.getType());
		file.setReference("any reference");
		// Book
		if (file.getBookId() != null) {
			Book entityBook = new Book();
			entityBook.setId(file.getBookId());
			entityFile.setBook(entityBook);
		}
		// Responsible
		Author responsible = new Author();
		responsible.setId(file.getResponsibleId());
		entityFile.setResponsible(responsible);
		return fileRepository.save(entityFile);
	}

	@Override
	public List<File> findByCriteria(FileQueryParams fileSearch) {
		String descriptionText = buildQueryTextParam(fileSearch.getDescriptionText());
		List<FileType> typeList = fileSearch.getTypes();
		if (CollectionUtils.isEmpty(typeList)) {
			typeList = Arrays.asList(FileType.values());
		}
		List<FileStatus> statusList = fileSearch.getStatus();
		if (CollectionUtils.isEmpty(statusList)) {
			statusList = Arrays.asList(FileStatus.values());
		}
		return fileRepository.findByCriteria(descriptionText, statusList, typeList);
	}

}
