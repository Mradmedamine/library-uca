package org.library.uca.util;

import java.io.IOException;

import org.library.uca.model.domain.entity.PhysicalFile;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	public static PhysicalFile createPhysicalFile(MultipartFile file) {
		try {
			if (file.getSize() > 0) {
				PhysicalFile physicalFile = new PhysicalFile();
				physicalFile.setFileName(file.getOriginalFilename());
				physicalFile.setFileContent(file.getBytes());
				return physicalFile;
			}
		} catch (IOException e) {
			// ignore
		}
		return null;
	}
}
