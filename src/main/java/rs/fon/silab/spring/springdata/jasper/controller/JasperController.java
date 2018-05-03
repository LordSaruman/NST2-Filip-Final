/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.jasper.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import rs.fon.silab.spring.springdata.config.MySpringDataPersistenceJPAConfig;
import rs.fon.silab.spring.springdata.domen.Mesto;
import rs.fon.silab.spring.springdata.main.Main;

/**
 *
 * @author filip
 */
@Component
@Configurable
public class JasperController {

    @Autowired
    private Main main;

    private static JasperController jasperController;

    private JasperController() {
    }

    public static JasperController getInstance() {
        if (jasperController == null) {
            jasperController = new JasperController();
            ApplicationContext context = new AnnotationConfigApplicationContext(MySpringDataPersistenceJPAConfig.class);
        }
        return jasperController;
    }

    public List<Mesto> getAllMesta() {
        List<Mesto> list = new LinkedList<>();
        Main main = new Main();
        list = main.returnAllMesta();

        return list;
    }

}
