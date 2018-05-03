/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.jasper.report;

import rs.fon.silab.spring.springdata.jasper.controller.JasperController;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintLine;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.base.JRBasePrintLine;
import net.sf.jasperreports.engine.base.JRBasePrintPage;
import net.sf.jasperreports.engine.base.JRBasePrintText;
import net.sf.jasperreports.engine.util.JRSaver;
import rs.fon.silab.spring.springdata.domen.Mesto;

/**
 *
 * @author filip
 */
public class JasperReport {

    public void fill(List<Mesto> lm) throws JRException {
        JasperPrint jprint = getJasperPrint(lm);
        JRSaver.saveObject(jprint, "report.jprint");
    }

    private JasperPrint getJasperPrint(List<Mesto> lm) {
        JasperPrint jasperPrint = new JasperPrint();
        jasperPrint.setName("Izvestaj");
        jasperPrint.setPageHeight(800);
        jasperPrint.setPageWidth(600);

        JRPrintPage page = new JRBasePrintPage();
        JRPrintLine line = new JRBasePrintLine(jasperPrint.getDefaultStyleProvider());
        line.setX(40);
        line.setY(50);
        line.setWidth(500);
        line.setHeight(5);
        page.addElement(line);

        int y = 150;
        for (Mesto m : lm) {
            JRPrintText text = new JRBasePrintText(jasperPrint.getDefaultStyleProvider());
            text.setX(40);
            text.setY(y);
            text.setWidth(500);
            text.setHeight(50);
            text.setTextHeight(50);
            text.setText(m.getPtt() + "\t\t\t" + m.getNaziv());
            page.addElement(text);
            y = y + 50;
        }
        jasperPrint.addPage(page);
        return jasperPrint;
    }
}
