package com.example;

public class Main {
    public static void main(String[] args) {
        Monitor m = new Monitor();
        Portero p = new Portero(m,1);
        Cliente c = new Cliente(m, p);
        Portero p2 = new Portero(m,2);
        Cliente c2= new Cliente(m, p2);

        p2.start();
        c.start();
        c2.start();
        p.start();
    }
}
