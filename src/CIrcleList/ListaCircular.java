package CIrcleList;

import javax.swing.*;

public class ListaCircular {
    private Nodo punta;
    private int tamano;
    public ListaCircular () {
        this.punta = null;
        this.tamano = 0;
    }

    public Nodo getPunta() {
        return punta;
    }

    public void setPunta(Nodo punta) {
        this.punta = punta;
    }

    public void insertarInicio(int dato)
    {
        Nodo X = new Nodo(dato);
        this.tamano++;
        if(this.punta == null)
        {
            this.punta = X;
            X.setLigaD(X);
            X.setLigaI(X);
            return;
        }
        else
        {
            X.setLigaD(this.punta);
            this.punta.setLigaI(X);
        }
        Nodo P = this.punta;
        while (P.getLigaD()!= this.punta)
        {
            P = P.getLigaD();
        }
        this.punta = X;
        P.setLigaD(this.punta);
        this.punta.setLigaI(P);
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
        Nodo X = new Nodo(dato);

        if(this.punta == null) {
            this.punta = X;
            X.setLigaD(X);
            X.setLigaI(X);
            this.tamano++;
            return;
        }
        Nodo P = this.punta;
        Nodo Q = punta.getLigaI();
        P.setLigaI(X);
        Q.setLigaD(X);
        X.setLigaI(Q);
        X.setLigaD(P);
        this.tamano++;
    }

    public void insertarRellenado (int veces, int dato) {
        for (int i = 0; i < veces; i++){
            insertarFinal(0);
        }
        insertarFinal(dato);
    }
    public void mostrarListaCircular (){
        if(this.punta == null) return;
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
        } while (P != this.punta && posicion < this.tamano);
    }
    public void insertarRaro(ListaCircular A, ListaCircular B)
    {
        Nodo P = A.punta;
        Nodo Q = B.punta.getLigaI();

        do
        {
            insertarFinal(P.getDato());
            insertarFinal(Q.getDato());
            P = P.getLigaD();
            Q = Q.getLigaI();
        } while(P != A.punta && Q != B.punta.getLigaI());

        if (P == A.punta);
        {
            boolean inicio = true;
            while (Q != B.punta.getLigaI())
            {
                if (inicio)
                {
                    insertarInicio(Q.getDato());
                    inicio = false;
                    Q = Q.getLigaI();
                }
                else
                {

                    insertarFinal(Q.getDato());
                    inicio = true;
                    Q = Q.getLigaI();

                }
            }
        }
        if (Q == B.punta.getLigaI())
        {
            boolean inicio = true;
            while (P != A.punta)
            {
                if (inicio)
                {
                    insertarInicio(P.getDato());
                    inicio = false;
                    P = P.getLigaD();
                }
                else
                {
                    insertarFinal(P.getDato());
                    inicio = true;
                    P = P.getLigaD();
                }
            }
        }
    }
}
