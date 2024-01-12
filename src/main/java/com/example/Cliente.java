package com.example;

import java.util.Random;

public class Cliente extends Thread{
    private Monitor monitor;

    private Portero portero;


    public Cliente(Monitor clientesMonitor, Portero p) {
        this.monitor = clientesMonitor;
        this.portero = p;

    }

    @Override
    public void run() {
        do{
            try {
                monitor.entrada(this.portero);
                Thread.sleep(new Random().nextInt(499)+100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }while(true);
    }


}
