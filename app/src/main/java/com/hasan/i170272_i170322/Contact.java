package com.hasan.i170272_i170322;

public class Contact {

    private String name,phno,email, dpUri;

    public Contact(){}

    public String getDpUri() {
        return dpUri;
    }

    public void setDpUri(String dpUri) {
        this.dpUri = dpUri;
    }

    public Contact(String name, String phno, String email, String dpUri) {
        this.name = name;
        this.phno = phno;
        this.email = email;
        this.dpUri=dpUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
