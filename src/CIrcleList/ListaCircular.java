package CIrcleList;

import javax.swing.*;

public class ListaCircular {
    private Nodo punta;
    private int tamano;
    public ListaCircular () {
        this.punta = null;
        this.tamano = 0;
    }

    public void insertarPosicionado (Nodo P, int dato) {
        Nodo X = new Nodo(dato);
        this.tamano++;

        Nodo aux = P.getLigaD();
        X.setLigaI(P);
        X.setLigaD(aux);
        P.setLigaD(X);
    }

    public void insertarFinal (int dato) {
        if(this.punta == null) {
            Nodo X = new Nodo(dato);
            this.tamano++;
            this.punta = X;
            X.setLigaD(X);
            X.setLigaI(X);
            this.mostrarListaCircular();
            return;
        }
        Nodo P = this.punta;
        Nodo Q = P.getLigaI();

        Nodo X = new Nodo(dato);
        this.tamano++;

        P.setLigaI(X);
        Q.setLigaD(X);
        X.setLigaI(Q);
        X.setLigaD(P);
        this.mostrarListaCircular();

    }

    public void insertarRellenado (int veces, int dato) {

        for (int i = 0; i < veces; i++){
            insertarFinal(0);
        }
        insertarFinal(dato);
    }
    public void mostrarListaCircular (){
        Nodo P = this.punta;
        int i = 0;
        do {
            System.out.print(i + "-> " + P.getDato() + "\n");
            i++;
            P = P.getLigaD();
        } while(P != this.punta);
    }
    public void ingresarEnPosicion(int posicion, int dato) {
        if(this.punta == null) return;
        // Se supone usuario ingresa con índice inicial en 0.

        int i = 0;
        Nodo P = this.punta;
        do {
            if(posicion < this.tamano){
                if (posicion > i) {
                    i++;
                    P = P.getLigaD();
                }
                else if (posicion == i) insertarPosicionado(P, dato);
            } else {
                String mensaje = "¿Desea rellenar de 0 o insertar al final? \n" +
                        "1. Rellenar lista \n" +
                        "2. Insertar dato al final \n";
                String opcion = JOptionPane.showInputDialog(null, mensaje, "Elección", JOptionPane.INFORMATION_MESSAGE);
                int OpcInt = Integer.parseInt(opcion);
                switch (OpcInt){
                    case 1:
                        insertarRellenado(posicion - this.tamano, dato);
                        break;
                    case 2:
                        insertarFinal(dato);
                        break;
                }
                P = P.getLigaD();
            }
        } while (P != this.punta);

        this.mostrarListaCircular();
    }
}
