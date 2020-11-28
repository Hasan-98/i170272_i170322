package com.hasan.i170272_i170322;

public class Msg {
    String sender, receiver, msg;

    public Msg(String sender, String receiver, String msg) {
        this.sender = sender;
        this.receiver = receiver;
        this.msg = msg;
    }

    public Msg(){}

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
