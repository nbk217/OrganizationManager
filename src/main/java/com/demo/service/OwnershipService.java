package com.demo.service;

import com.demo.model.Entity;
import com.demo.model.Ownership;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Service
public class OwnershipService {

    private static List<Ownership> ownerships = new ArrayList<>();
    private static Long count = 3L;

    static {
        ownerships.add(new Ownership(1L,"Parent", getEntity("Benin LLC"), 35f,
                new Date(),new Date(),new Date(), true, ""));
        ownerships.add(new Ownership(2L,"Parent", getEntity("Cadence LLC"), 11f,
                new Date(),new Date(),new Date(), false, ""));
        ownerships.add(new Ownership(3L,"Subsidiary", getEntity("Deustche LLC"), 9f,
                new Date(),new Date(),new Date(), true, ""));
        ownerships.add(new Ownership(4L,"Subsidiary", getEntity("Erin LLC"), 9f,
                new Date(),new Date(),new Date(), false, ""));
    }

    private static Entity getEntity(String name) {
        Entity entity= new Entity();
        entity.setLegalName(name);
        return entity;
    }

    public List<Ownership> retrieveAllOwnerships(String type, Boolean active){
//        List<Ownership> filteredOwnerships = new ArrayList<>();
//        if(type==null && active == null) {
//            return ownerships;
//        }else {
//            for (Ownership ownership : ownerships) {
//                if (ownership.getType().equals(type) && ownership.getStatus().equals(active))
//                    filteredOwnerships.add(ownership);
//            }
//            return filteredOwnerships;
//        }
        return ownerships;
    }

    public List<Ownership> retrieveOwnership(String legalName) {
        List<Ownership> filteredOwnerships = new ArrayList<>();
        for (Ownership ownership : ownerships) {
            if (ownership.getEntity().getLegalName().equals(legalName))
                filteredOwnerships.add(ownership);
        }
        return filteredOwnerships;
    }

    public void addOwnership(Ownership ownership) {
        ownerships.add(new Ownership(++count,ownership.getType(), ownership.getEntity(), ownership.getPercentage(),
                ownership.getAcquisitionDate(),ownership.getDispositionDate(),ownership.getLastUpdated(),
                ownership.getStatus(), ownership.getNotes()));
    }

    public void addOwnership(String type, Entity entity, Float percentage, Date acquisitionDate, Date dispositionDate, Date lastUpdated, Boolean status, String notes) {
        ownerships.add(new Ownership(++count,type, entity, percentage,
                acquisitionDate,dispositionDate,lastUpdated, status, notes));
    }

    public void deleteOwnership(Long id) {
        Iterator<Ownership> iterator = ownerships.iterator();
        while (iterator.hasNext()) {
            Ownership ownership = iterator.next();
            if (ownership.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Ownership retrieveOwnership(Long id){
        for(Ownership ownership : ownerships){
            if(ownership.getId()==id){
                return ownership;
            }
        }return null;
    }

    public void updateOwnership(Ownership ownership) {
        ownerships.remove(ownership);
        ownerships.add(ownership);
    }
}