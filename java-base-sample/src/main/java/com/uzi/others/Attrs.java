package com.uzi.others;

public class Attrs {

    private Integer type;

    private String name;

    private Text text;

    private Web web;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setWeb(Web web) {
        this.web = web;
    }

    public Web getWeb() {
        return web;
    }
}
