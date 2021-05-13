package com.zn.springCloud.entities;

import lombok.Data;

@Data
public class Payment {
    private Long id;
    private String serial;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
