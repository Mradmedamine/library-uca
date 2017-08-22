package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.File;
import org.library.uca.model.front.web.dto.FileDTO;
import org.library.uca.model.front.web.queryparams.FileQueryParams;

public interface FileService {

	List<File> findAll();

	List<File> findByCriteria(FileQueryParams fileSearch);

	File findById(Long id);

	File saveFile(FileDTO file);

}
