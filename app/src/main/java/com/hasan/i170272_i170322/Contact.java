package com.hasan.i170272_i170322;

public class Contact {

    private String name,phno,email;

    public Contact(){}

    public Contact(String name, String phno, String email) {
        this.name = name;
        this.phno = phno;
        this.email = email;
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
