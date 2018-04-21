/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst2project.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author filip
 */

@ComponentScan(basePackages= {""})
@SpringBootApplication
public class NST2ProjectApplication{
    
    public static void main(String[] args) {
        SpringApplication.run(NST2ProjectApplication.class, args);
    }
}
