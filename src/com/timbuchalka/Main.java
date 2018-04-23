package com.timbuchalka;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ITelephone timsPhone;
        timsPhone = new DeskPhone(12345);
        timsPhone.powerOn();
        timsPhone.callPhone(12345);
        timsPhone.answer();

        timsPhone = new MobilePhone(24231);
        timsPhone.powerOn();
        timsPhone.callPhone(24231);
        timsPhone.answer();
    }
}
