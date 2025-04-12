package com.example.demo;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.f4b6a3.ulid.Ulid;

public class ExempleUtilisationManuelle {
    public static void main(String[] args) {
        Ulid newUlid = UlidCreator.getUlid();
        String ulidString = newUlid.toString();
        System.out.println("Nouvel ULID : " + ulidString);
    }
}
