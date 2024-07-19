package com.utilities;

import com.github.javafaker.Faker;
public class FakeDataGenerator {
    public static void fakeDataCreation() {
        Faker fakeData = new Faker();
        String connectionName = fakeData.name().title();
        System.out.println(connectionName);
    }

    public static void main(String[] args) {
        fakeDataCreation();
    }
}
