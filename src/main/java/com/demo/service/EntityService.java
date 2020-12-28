package com.demo.service;

import com.demo.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;


@Service
public class EntityService {

    private static List<Entity> entities = new ArrayList<>();
    private static Long entityCount = 3L;

    static {
        entities.add(new Entity(1L, "One LLC", "Nick", "US-East", "Non-Profit", "Nick", "Yes", "Nick", "Nick", "Nick", "Nick", "Nick", "Learn Spring MVC", new Date(), false, new Date(), null));
        entities.add(new Entity(2L, "Two Corp.", "Nick", "US-West", "Charity", "Nick", "No", "Nick", "Nick", "Nick", "Nick", "Nick", "Learn Spring MVC", new Date(), true, new Date(), null));
        entities.add(new Entity(3L, "Three Org", "Nick", "EU-East", "Non-Profit", "Nick", "No", "Nick", "Nick", "Nick", "Nick", "Nick", "Learn Spring MVC", new Date(), false, new Date(), null));
    }

    public List<Entity> retrieveAllEntities() {
        return entities;
    }

    public Entity retrieveEntity(String legalName) {
        for (Entity entity : entities) {
            if (entity.getLegalName().equals(legalName)) {
                return entity;
            }
        }
        return null;
    }

    public void addEntity(String legalName, String user, String jurisdiction, String formOfOrganization, String legalAddress, String headQSameAsLegal, String headquartersAddress, String registeredAgent, String otherNames, String tags, String notes, String groups, Date incorporationDate, boolean status, Date lastUpdated, MultipartFile file) throws IOException {
        entities.add(new Entity(++entityCount, legalName, user, jurisdiction, formOfOrganization, legalAddress, headQSameAsLegal, headquartersAddress, registeredAgent, otherNames, tags, notes, groups, incorporationDate, status, lastUpdated, file));
    }

    public void deleteEntity(Long id) {
        Iterator<Entity> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Entity retrieveEntity(Long id) {
        for (Entity entity : entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    public void updateEntity(Entity entity) {
        entities.remove(entity);
        entities.add(entity);
    }

}