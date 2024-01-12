package com.example;

import java.util.Random;

public class Portero extends Thread{
    private Monitor monitor;

    private Integer numero;


    public Portero(Monitor clientesMonitor, Integer numero) {
        this.monitor = clientesMonitor;
        this.numero = numero;

    }

    @Override
    public void run() {
        do{
            try {
                monitor.salida(this);
                Thread.sleep(new Random().nextInt(499)+200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }while(true);
    }

    public Integer getNumero() {
        return numero;
    }
}
