/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import info.movito.themoviedbapi.model.core.AbstractJsonMapping;


public class JobDepartment extends AbstractJsonMapping {

    @JsonProperty("department")
    private String department;

    @JsonProperty("jobs")
    private List<String> jobs;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }

}
