package connected.city;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CityConnection {
	public CityConnection(Resource resource) {
		try (Reader reader = new InputStreamReader(resource.getInputStream())) {
			log.info(FileCopyUtils.copyToString(reader));
		} catch (IOException e) {
			log.error("An IO exception occured while creating city connection bean.");
			log.debug("Resource:", resource);
			throw new UncheckedIOException(e);
		}
		log.debug("CityConnection loaded");
	}

	public boolean isConnectionAvailable(String fromCity, String toCity) {
		return true;
	}
}
