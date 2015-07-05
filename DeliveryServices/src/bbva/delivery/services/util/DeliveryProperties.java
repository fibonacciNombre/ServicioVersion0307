package bbva.delivery.services.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import bbva.delivery.services.commons.Constants;

public class DeliveryProperties extends PropertyPlaceholderConfigurer {

	public DeliveryProperties() {
		super();

		String configPropertyPath = System.getProperty(Constants.RUTA_ARCH_DEFAULT) + Constants.RUTA_FILE_CONFIGURACION_APP;
		Resource configResource = new FileSystemResource(configPropertyPath);

		setLocation(configResource);
	}

}
