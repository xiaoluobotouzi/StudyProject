package com.uzi.others;

import java.util.List;

public class ProjectInfo {

    private String name;
    private List<Integer> department;
    private String alias;
    private String address;
    private Extattr extattr;
    private ExternalProfile external_profile;

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setExtattr(Extattr extattr) {
        this.extattr = extattr;
    }

    public Extattr getExtattr() {
        return extattr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExternalProfile getExternal_profile() {
        return external_profile;
    }

    public void setExternal_profile(ExternalProfile external_profile) {
        this.external_profile = external_profile;
    }

    public List<Integer> getDepartment() {
        return department;
    }

    public void setDepartment(List<Integer> department) {
        this.department = department;
    }
}
