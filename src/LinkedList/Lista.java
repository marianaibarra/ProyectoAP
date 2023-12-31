package LinkedList;

import javax.swing.JOptionPane;
public class Lista {
    //Atributos
    private Nodo punta;
    //Métodos
    //Constructor

    public Lista() {
        this.punta = null;
    }

    public Nodo getPunta() {
        return punta;
    }

    public void setPunta(Nodo punta) {
        this.punta = punta;
    }

    //Insertar al inicio
    public void insertarInicio(int dato) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        if (this.punta == null) {
            this.punta = nuevo;
        } else {
            nuevo.setLigaD(this.punta);
            punta.setLigaI(nuevo);
            punta = nuevo;
        }
    }

    //Mostrar lista

    public void mostrarLista() {
        Nodo aux = punta;
        String s = "";
        while (aux != null) {
            System.out.print(aux.getDato() + " ");
            s += aux.getDato() + " ";
            aux = aux.getLigaD();

        }
        JOptionPane.showMessageDialog(null, s);
    }

    // insertar ordenado
    // l3 = l1 + l2
    public void ordenar() {
        int aux;
        Nodo P = this.punta;
        Nodo Q = P;
        for (P = this.punta; P != null; P = P.getLigaD()) {
            for (Q = P.getLigaD(); Q != null; Q = Q.getLigaD()) {
                if (P.getDato() > Q.getDato()) {
                    aux = P.getDato();
                    P.setDato(Q.getDato());
                    Q.setDato(aux);
                }
            }
        }
    }

    public void insertarOrdenado(int dato) {
        if (this.punta == null) return;
        Nodo P = this.punta;
        Nodo Q = P;

        while (dato > P.getDato() && P != null) {
            Q = P;
            P = P.getLigaD();
        }
        Nodo x = new Nodo(dato);
        if (P != Q) Q.setLigaD(x);
        x.setLigaD(P);
        x.setLigaI(Q);
        if (P == Q) this.punta = x;
    }

    public void insertarFinal(int dato) {
        if (punta == null) {
            Nodo nuevo = new Nodo(dato);
            punta = nuevo;
        } else {
            Nodo aux = punta;
            while (aux.getLigaD() != null) {
                aux = aux.getLigaD();
            }
            Nodo nuevo = new Nodo(dato);
            aux.setLigaD(nuevo);
            nuevo.setLigaI(aux);
        }
    }

    public void sumarListas(Lista A, Lista B) {
        Nodo P = A.punta;
        Nodo Q = B.punta;
        while (P != null || Q != null) {
            int d = 0;
            if (P == null) d = Q.getDato();
            else if (Q == null) d = P.getDato();
            else d = P.getDato() + Q.getDato();
            insertarFinal(d);
            P = P.getLigaD();
            Q = Q.getLigaD();
        }
    }

    public void Reemplazar(int dato, int nuevoDato) {
        Nodo aux = new Nodo();
        aux = punta;
        boolean found = false;
        while (aux != null) {
            if (aux.getDato() == dato) {
                aux.setDato(nuevoDato);
                found = true;
            } else {
                aux = aux.getLigaD();
            }
        }
        if(!found) JOptionPane.showMessageDialog(null, "El dato no se encontró en la lista");
    }

    public void Busqueda(int Dato) {
        Nodo aux = punta;
        boolean found = false;
        int i = 1;
        while (aux != null) {
            if (aux.getDato() == Dato) {
                found = true;
                JOptionPane.showMessageDialog(null, "El dato " + Dato + " se encuentra en la posicion " + i);
            }

            aux = aux.getLigaD();
            i++;
        }
        if(!found) JOptionPane.showMessageDialog(null, "El dato no se encontró en la lista");
    }

    public void Eliminar(int dato){
        Nodo P=punta;
        Nodo Q=P.getLigaD();
        boolean found = false;
        Nodo aux=new Nodo();
        while(P!=null && Q!=null){
            if(Q.getDato()==dato){
                aux=Q;
                Q=Q.getLigaD();
                aux.getLigaD().setLigaI(aux.getLigaI());
                aux.getLigaI().setLigaD(aux.getLigaD());
                found = true;
                JOptionPane.showMessageDialog(null, "El dato se eliminó exitosamente");

            }else{
                Q=Q.getLigaD();

            }
        }
        if(!found) JOptionPane.showMessageDialog(null, "El dato no se encontró en la lista");
    }
    public void Eliminar(Nodo X){

        Nodo A = X.getLigaI();
        Nodo B = X.getLigaD();

        B.setLigaI(A);
        A.setLigaD(B);
    }
    public void Distribuir(Lista A, Lista B) {
        Nodo P = A.punta;
        Nodo Q = B.punta;
        int acumulador = 0;
        while (Q != null) {

            while (P != null) {
                acumulador = acumulador + P.getDato();
                P = P.getLigaD();
            }

            int d = Q.getDato() * acumulador;
            insertarFinal(d);

            Q = Q.getLigaD();
        }
    }
    public void intercalar (Lista L1, Lista L2)
    {
        Nodo P = L1.punta;
        Nodo Q = L2.punta;
        while (P != null || Q != null)
        {
            if (P != null && Q != null)
            {
                insertarFinal(P.getDato());
                insertarFinal(Q.getDato());
                P = P.getLigaD();
                Q = Q.getLigaD();
            }
            else
            {
                if (P == null)
                {
                    insertarFinal(Q.getDato());
                    Q = Q.getLigaD();
                }
                else
                {
                    insertarFinal(P.getDato());
                    P = P.getLigaD();
                }
            }

        }

    }
    public void compararListas(Lista B) {
        if(this.punta == null || B.punta == null) return;

        Nodo P = this.punta;
        Nodo Q = B.punta;
        boolean esTamanoIgual = false, esDatoIgual = false;

        do {
            esDatoIgual = P.getDato() == P.getDato();
            P = P.getLigaD();
            Q = Q.getLigaD();
            esTamanoIgual = P != null && Q != null;
            if( P == null && Q == null) esTamanoIgual = true;
        } while( esTamanoIgual && esDatoIgual && (P != null || Q != null) );

        if ( esTamanoIgual && esDatoIgual )
            JOptionPane.showMessageDialog(null, "Las listas son iguales");
        else
            JOptionPane.showMessageDialog(null, "Las listas no son iguales");

    }
    public void porcentajeMen (int dato) {
        if(this.punta == null) return;
        int contador = 0;
        int contadorMen = 0;
        Nodo P = punta;
        while (P != null){
            if (P.getDato() < dato) contadorMen++;
            contador ++;
            P = P.getLigaD();
        }
        int porcentajeM = (contadorMen * 100) / contador;
        String mensaje = "El porcentaje de números menores es: " + String.valueOf(porcentajeM) + "%.\n";
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void eliminarConsecutivos () {
        if(this.punta == null) return;
        Nodo P = this.punta;
        Nodo Q = P.getLigaD();
        Nodo aux = null;

        while (Q != null) {
            if (P.getDato() == Q.getDato()){
                aux = Q;
                Q = Q.getLigaD();
                this.Eliminar(aux);
            }
            P = P.getLigaD();
            Q = Q.getLigaD();
        }
    }
}