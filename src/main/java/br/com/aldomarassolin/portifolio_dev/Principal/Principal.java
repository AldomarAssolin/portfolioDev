package br.com.aldomarassolin.portifolio_dev.Principal;

import java.sql.Date;
import java.time.LocalDate;

public class Principal {

    public void showMenu() {
        LocalDate hoje = LocalDate.now();
        Date dataSql = Date.valueOf(hoje);
        System.out.printf("PortifolioDev");
        System.out.println("\nInício: " + dataSql);
    }
}

