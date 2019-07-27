package com.example.savedataforjava.data;

import java.io.Serializable;

public class SerializableData implements Serializable{
    private static final long serialVersionUID = 6255752248513019027L;
    private String string_;
    private int number_;

    public String getString() {
        return string_;
    }

    public void setString(String string) {
        string_ = string;
    }

    public int getNumber() {
        return number_;
    }

    public void setNumber(int number) {
        number_ = number;
    }
}