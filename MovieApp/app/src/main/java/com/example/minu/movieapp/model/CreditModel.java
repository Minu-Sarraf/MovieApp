package com.example.minu.movieapp.model;

import java.util.List;

/**
 * Created by minu on 10/12/2017.
 */

public class CreditModel {


    private int id;
    private List<CastBean> cast;
    private List<CrewBean> crew;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CastBean> getCast() {
        return cast;
    }

    public void setCast(List<CastBean> cast) {
        this.cast = cast;
    }

    public List<CrewBean> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewBean> crew) {
        this.crew = crew;
    }

    public static class CastBean {
        /**
         * cast_id : 5
         * character : Bill Denbrough
         * credit_id : 57739eda925141251d00058d
         * gender : 2
         * id : 1274508
         * name : Jaeden Lieberher
         * order : 0
         * profile_path : /5iGyfDlrYsQwEeGz8rZibBcxbus.jpg
         */

        private int cast_id;
        private String character;
        private String credit_id;
        private int gender;
        private int id;
        private String name;
        private int order;
        private String profile_path;

        public int getCast_id() {
            return cast_id;
        }

        public void setCast_id(int cast_id) {
            this.cast_id = cast_id;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }

    public static class CrewBean {
        /**
         * credit_id : 58c4e4089251411b3600305d
         * department : Production
         * gender : 1
         * id : 2678
         * job : Casting
         * name : Stephanie Gorin
         * profile_path : /AoOjwB5xvRx6Yq2IoiA42qnkvTl.jpg
         */

        private String credit_id;
        private String department;
        private int gender;
        private int id;
        private String job;
        private String name;
        private String profile_path;

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }
}
