package com.innovate.innovts;

/**
 * Created by minu on 6/23/2017.
 */

public class JsonParser {

    /**
     * id : 37724
     * attributes : {"fuel":"423","status":"1","ip":"49.126.40.93","distance":2.82,"totalDistance":3.578004537E8}
     * deviceId : 2
     * type : null
     * protocol : osmand
     * serverTime : null
     * deviceTime : 2017-06-23T07:35:24.513+0000
     * fixTime : 2017-06-23T07:35:24.513+0000
     * outdated : false
     * valid : true
     * latitude : 27.67203
     * longitude : 85.317223
     * altitude : 0
     * speed : 0.43
     * course : 0
     * address : Lagankhel Satdobato Rd, Patan, Central Development Region, NP
     * accuracy : 0
     * network : null
     */

    private int id;
    private AttributesBean attributes;
    private int deviceId;
    private Object type;
    private String protocol;
    private Object serverTime;
    private String deviceTime;
    private String fixTime;
    private boolean outdated;
    private boolean valid;
    private double latitude;
    private double longitude;
    private double altitude;
    private double speed;
    private double course;
    private String address;
    private double accuracy;
    private Object network;

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

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Object getServerTime() {
        return serverTime;
    }

    public void setServerTime(Object serverTime) {
        this.serverTime = serverTime;
    }

    public String getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(String deviceTime) {
        this.deviceTime = deviceTime;
    }

    public String getFixTime() {
        return fixTime;
    }

    public void setFixTime(String fixTime) {
        this.fixTime = fixTime;
    }

    public boolean isOutdated() {
        return outdated;
    }

    public void setOutdated(boolean outdated) {
        this.outdated = outdated;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public Object getNetwork() {
        return network;
    }

    public void setNetwork(Object network) {
        this.network = network;
    }

    public static class AttributesBean {
        /**
         * fuel : 423
         * status : 1
         * ip : 49.126.40.93
         * distance : 2.82
         * totalDistance : 3.578004537E8
         */

        private String fuel;
        private String status;
        private String ip;
        private double distance;
        private double totalDistance;

        public String getFuel() {
            return fuel;
        }

        public void setFuel(String fuel) {
            this.fuel = fuel;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public double getTotalDistance() {
            return totalDistance;
        }

        public void setTotalDistance(double totalDistance) {
            this.totalDistance = totalDistance;
        }
    }
}
