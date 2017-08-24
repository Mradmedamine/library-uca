package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.File;
import org.library.uca.model.domain.entity.FileAction;
import org.library.uca.model.front.web.dto.FileDTO;
import org.library.uca.model.front.web.queryparams.FileQueryParams;


public interface FileService {

	List<File> findAll();

	List<File> findByCriteria(FileQueryParams fileSearch);

	File findById(Long id);

	File saveFile(FileDTO file);

	List<FileAction> findActionsByFileId(Long fileId);

	FileAction findFileActionById(Long actionId);

	FileAction saveFileAction(Long fileId, FileAction fileAction);

}
