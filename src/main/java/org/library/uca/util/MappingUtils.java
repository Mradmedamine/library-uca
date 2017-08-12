package org.library.uca.util;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

public abstract class MappingUtils {

	private static Logger log = LoggerFactory.getLogger(MappingUtils.class);

	private MappingUtils() {
		throw new UnsupportedOperationException();
	}

	public static Object map(Object src, Object dest) {
		try {
			BeanUtils.copyProperties(src, dest);
			return dest;
		} catch (BeansException e) {
			String message = MessageFormat.format(
					"error occured while mapping from bean Class {} to bean {}, Exception: {}", src.getClass(),
					dest.getClass(), e.getMessage());
			log.error(message);
			throw new RuntimeException(message);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T map(Object src, Class<T> destClass) {
		try {
			return (T) map(src, destClass.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			String msg = MessageFormat.format("error instantiating object of class {}, Ex: {}", destClass,
					e.getMessage());
			throw new RuntimeException(msg);
		}
	}
}
