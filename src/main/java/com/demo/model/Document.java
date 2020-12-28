package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    private Long id;
    private  String folder;
    private String title;
    private String jurisdiction;
    private String type;
    private Boolean  uploadOrLink;
    private MultipartFile file;
    private Date date;
    private String notes;
    private Entity entity;

}
