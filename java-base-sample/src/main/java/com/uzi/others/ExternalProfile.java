package com.uzi.others;

import java.util.List;

public class ExternalProfile {

    private String external_corp_name;

    private List<Attrs> external_attr;

    public List<Attrs> getExternal_attr() {
        return external_attr;
    }

    public String getExternal_corp_name() {
        return external_corp_name;
    }

    public void setExternal_attr(List<Attrs> external_attr) {
        this.external_attr = external_attr;
    }

    public void setExternal_corp_name(String external_corp_name) {
        this.external_corp_name = external_corp_name;
    }
}
