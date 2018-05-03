/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.fly.main;

import org.flywaydb.core.Flyway;

/**
 *
 * @author filip_000
 */
public class App {
    
    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/probaflyway", "root", "root", args);
        flyway.setLocations("filesystem:/home/filip/Desktop/flyway-novo/src/main/java/migration/");
        flyway.migrate();
    }
}
