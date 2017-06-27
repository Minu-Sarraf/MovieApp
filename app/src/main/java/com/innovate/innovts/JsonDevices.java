package com.innovate.innovts;

import java.util.List;

/**
 * Created by minu on 6/23/2017.
 */

public class JsonDevices {

    /**
     * id : 2
     * attributes : {}
     * name : BUS2
     * uniqueId : 142857
     * status : unknown
     * lastUpdate : 2017-06-23T07:35:24.513+0000
     * positionId : 37724
     * groupId : 0
     * geofenceIds : []
     * phone :
     * model :
     * contact :
     * category : null
     */

    private int id;
    private AttributesBean attributes;
    private String name;
    private String uniqueId;
    private String status;
    private String lastUpdate;
    private int positionId;
    private int groupId;
    private String phone;
    private String model;
    private String contact;
    private Object category;
    private List<?> geofenceIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AttributesBean getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributesBean attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public List<?> getGeofenceIds() {
        return geofenceIds;
    }

    public void setGeofenceIds(List<?> geofenceIds) {
        this.geofenceIds = geofenceIds;
    }

    public static class AttributesBean {
    }
}
