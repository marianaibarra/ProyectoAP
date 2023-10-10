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
        Nodo aux = P.getLigaD();
        P.setLigaD(X);
        X.setLigaI(P);
        X.setLigaD(aux);
    }

    public void insertarFinal (int dato) {
        Nodo P = this.punta;
        Nodo Q = P.getLigaI();

        Nodo X = new Nodo(dato);
        this.tamano++;

        X.setLigaD(P);
        X.setLigaI(Q);
        P.setLigaI(X);
        Q.setLigaD(X);
    }

    public void insertarRellenado (int veces, int dato) {
        Nodo P = this.punta;
        P = P.getLigaI();

        for (int i = 0; i < veces; i++){
            insertarFinal(0);
        }
        insertarFinal(dato);
    }
    public void ingresarEnPosicion(int posicion, int dato) {
        if(this.punta == null) return;
        // Suponiendo que el usuario ingresa la posicion con el indice iniciando en 1.

        posicion--;
        int i = 0;
        Nodo P = this.punta;
        do {
            if(posicion < this.tamano){
                if (posicion == i) {
                    insertarPosicionado(P, dato);
                }
            }else if(posicion == this.tamano) {
                 insertarFinal(dato);
            }else{
                String menor = "¿Desea rellenar de 0 o insertar al final? \n" +
                        "1. Rellenar \n" +
                        "2. Insertar Final 2\n";
                String porcent = JOptionPane.showInputDialog(null, menor, "Menú de Opciones", JOptionPane.INFORMATION_MESSAGE);
                int Listaporcent = Integer.parseInt(porcent);
                switch (Listaporcent){
                    case 1:
                        insertarRellenado(tamano - posicion, dato);
                        break;
                    case 2:
                        insertarFinal(dato);
                }
            }
        } while (P != punta);
    }
}
