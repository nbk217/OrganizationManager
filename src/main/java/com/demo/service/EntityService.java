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

    @Value("${dropbox}")
    private String dropbox;
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
        // TODO fix this file download
        String path = Paths.get("").toAbsolutePath().toString() + "/" + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(path),
                StandardCopyOption.REPLACE_EXISTING);
        saveFileOnDropBox(file);
    }

    private void saveFileOnDropBox(MultipartFile file) {

        RestTemplate restTemplate= new RestTemplate();
        String url= "https://content.dropboxapi.com/2/files/upload";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setBearerAuth(dropbox);
        headers.set("Dropbox-API-Arg", String.format("{" +
                "    \"path\": \"/abcd/%s\"," +
                "    \"mode\": \"add\"," +
                "    \"autorename\": true," +
                "    \"mute\": false," +
                "    \"strict_conflict\": false" +
                "}", file.getOriginalFilename()));
        HttpEntity<byte[]> httpEntity = null;
        try {
            httpEntity = new HttpEntity<byte[]>(
                    file.getBytes(), headers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(
                MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(converter);

        restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println("Done uploading to dropbox");
    }

    public void deleteEntity(int id) {
        Iterator<Entity> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Entity retrieveEntity(int id) {
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