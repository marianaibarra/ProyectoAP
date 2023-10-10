package CIrcleList;

public class Nodo {
    public int dato;
    private Nodo LigaD = null;
    private Nodo LigaI = null;

    public Nodo(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getLigaD() {
        return LigaD;
    }

    public void setLigaD(Nodo ligaD) {
        LigaD = ligaD;
    }

    public Nodo getLigaI() {
        return LigaI;
    }

    public void setLigaI(Nodo ligaI) {
        LigaI = ligaI;
    }
}
