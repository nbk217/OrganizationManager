package com.demo.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entity {

    private Long id;
    @Size(min=6,message="Enter atleast six characters")
    private String legalName;
    private String user;
    private String jurisdiction;
    private String formOfOrganization;
    private String legalAddress;
    private String headQSameAsLegal;
    private String headquartersAddress;
    private String registeredAgent;
    private String otherNames;
    private String tags;
    private String notes;
    private String groups;
//    @Future(message="Please select future date")
    private Date incorporationDate;
    private boolean status;
    private Date lastUpdated;
    private MultipartFile file;
//    @Email(message="Please Enter valid email")

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
