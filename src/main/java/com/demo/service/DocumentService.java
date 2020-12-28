package com.demo.service;

import com.demo.model.Document;
import com.demo.model.Entity;
import com.demo.model.Ownership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class DocumentService {

    @Value("${token}")
    private String token;
    @Value("${dropbox.url.file.upload}")
    private String url;
    private static List<Document> documents = new ArrayList<>();
    private static Long count = 3L;

    static {
        Entity entity1= new Entity(1L, "One LLC", "Nick", "US-East", "Non-Profit", "Nick", "Yes", "Nick", "Nick", "Nick", "Nick", "Nick", "Learn Spring MVC", new Date(), false, new Date(), null);
        Entity entity2= new Entity(2L, "Two Corp.", "Nick", "US-West", "Charity", "Nick", "No", "Nick", "Nick", "Nick", "Nick", "Nick", "Learn Spring MVC", new Date(), true, new Date(), null);
        documents.add(new Document(1L,"Expenses", "ExpenseReport", "US-East", "Expenses",true,null,new Date(),"expenses for event", entity1));
        documents.add(new Document(2L,"Donations", "DonationsReport", "US-West", "Donations",true,null,new Date(),"expenses for event", entity2));
    }

    public List<Document> retrieveAllDocuments(Long entityId){
        List<Document> filteredDocs = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getEntity().getId().equals(entityId))
                filteredDocs.add(doc);
        }
        return filteredDocs;
    }

    public void addDocument(Document doc) {
        documents.add(new Document(++count, doc.getFolder(), doc.getTitle(),
                doc.getJurisdiction(), doc.getType(), doc.getUploadOrLink(), doc.getFile(),
                doc.getDate(), doc.getNotes(), doc.getEntity()));
        MultipartFile file= doc.getFile();
        String path = Paths.get("").toAbsolutePath().toString() + "/" + file.getOriginalFilename();
        try {
            Files.copy(file.getInputStream(), Paths.get(path),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveFileOnDropBox(file);
    }

    private void saveFileOnDropBox(MultipartFile file) {

        RestTemplate restTemplate= new RestTemplate();
        HttpEntity<byte[]> httpEntity = null;
        try {
            httpEntity = new HttpEntity<byte[]>(
                    file.getBytes(), getHttpHeaders(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO show status response to user
        restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println("Done uploading to dropbox");
    }

    private HttpHeaders getHttpHeaders(MultipartFile file) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setBearerAuth(token);
        headers.set("Dropbox-API-Arg", String.format("{" +
                "    \"path\": \"/abcd/%s\"," +
                "    \"mode\": \"add\"," +
                "    \"autorename\": true," +
                "    \"mute\": false," +
                "    \"strict_conflict\": false" +
                "}", file.getOriginalFilename()));
        return headers;
    }


    public void deleteDocument(Long id) {
        Iterator<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            Document doc = iterator.next();
            if (doc.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Document retrieveDocument(Long id){
        for(Document doc : documents){
            if(doc.getId()==id){
                return doc;
            }
        }return null;
    }

    public void updateDocument(Document doc) {
        documents.remove(doc);
        documents.add(doc);
    }



}