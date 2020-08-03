package connected.city.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CityConnectionImpl implements CityConnection {
	private static final Map<String, Set<String>> connections = new HashMap<>();

	public CityConnectionImpl(@Value("classpath:city.txt") Resource resource) {
		try (Reader in = new InputStreamReader(resource.getInputStream())) {
			log.debug("Reading resource file line by line");
			new BufferedReader(in).lines().forEach(line -> {
				if (null != line) {
					String[] cities = line.split(",");
					String from = null == cities[0] ? null : cities[0].trim();
					String to = null == cities[1] ? null : cities[1].trim();
					if (null != from || null != to) {
						if (!connections.containsKey(from)) {
							connections.put(cities[0].trim(), new HashSet<>());
						}
						connections.get(from).add(to);
					}

				}
			});
		} catch (IOException e) {
			log.error("An IO exception occured while creating city connection bean.");
			log.debug("Resource:", resource);
			throw new UncheckedIOException(e);
		}
		log.debug("CityConnections loaded");
	}

	public boolean isConnectionAvailable(String fromCity, String toCity) {
		log.debug("Checking resource for any available connection.");
		if (connections.containsKey(fromCity) && connections.get(fromCity).contains(toCity)
				|| connections.containsKey(toCity) && connections.get(toCity).contains(fromCity)) {
			return true;
		}
		return false;
	}
}
