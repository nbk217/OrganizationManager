package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class People {

    private Long id;
    private String type;
    private Entity entity;
    private Float percentage;
    private Date acquisitionDate;
    private Date dispositionDate;
    private Date lastUpdated;
    private Boolean status;
    private String notes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People ownership = (People) o;
        return Objects.equals(id, ownership.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
