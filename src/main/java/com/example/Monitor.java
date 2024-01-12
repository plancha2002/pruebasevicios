package com.example;

import java.util.ArrayList;

public class Monitor {

    private static ArrayList<Boolean> clientes = new ArrayList<>(10);

    public Monitor() {
    }

    /*
    les agregaremos un objeto portero para poder indetificar por donde entran y por
    donde salen los clientes
     */
    public synchronized void entrada(Portero p) throws InterruptedException {
        if(comprobarLista()){
            System.out.printf("Portero "+ p.getNumero()+ ": ");
            System.out.println("Entro un cliente hay " + clientes.size());
            // como entra un cliente notificamos a posibles hilos esperando por quedarse vacios
            notifyAll();
        } else {
            System.out.printf("Portero "+ p.getNumero()+ ": ");
            System.out.println("La sala esta llena. Espere");
            //como la sala esta llena esperamos a que nos notifiquen para poder entrar
            wait();
        }
    }

    public synchronized void salida(Portero p) throws InterruptedException {
        if (quitarLista()){
            System.out.printf("Portero "+ p.getNumero()+ ": ");
            System.out.println("Un cliente ha salido." + clientes.size());
            //como hemos sacado a un cliente notificamos a hilos a espera por haberse encontrado
            //la sala llena
            notifyAll();
        }else {
            System.out.printf("Portero "+ p.getNumero()+ ": ");
            System.out.println("La sala esta vacia");
            //para que no este constantemente comprobando si la sala esta vacia lo hacemos esperar
            wait();
        }
    }


   /*
    boolean -> true si: se a agregado un cliente
               false si: si la sala esta llena

     Cuando la sala tiene hueco se agrega un cliente

    */

    public boolean comprobarLista(){
        //si el tamaño de la lista es menor a 10 quiere dechir que no esta llena la sala
        if (clientes.size()<10 ){
            clientes.add(true);
            return true;
        }else {
            return false;
        }

    }

    /*
        boolean -> true si: se a removido a un cliente
                   false si: la sala esta vacia

     */
    public boolean quitarLista(){
//        Cuando la sala no esta vacia saca a cliente de la misma
        if (!clientes.isEmpty()){
            clientes.remove(clientes.size()-1);
            return true;
        }else{
            return false;
        }

    }
}
