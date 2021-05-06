package arbolesavl.Model;
/**
 *
 * @author Cris
 */
public class Nodo {
    public int Valor;       //valor
    public int Altura;      // Altura del subarbol
    public int Tamano;        // numero de nodos en el subarbol
    public Nodo Izq;       // subarbol izquierdo
    public Nodo Der;      // subarbol derecho

    public Nodo(int Valor, int Altura, int Tamano) {
        this.Valor = Valor;
        this.Tamano = Tamano;
        this.Altura = Altura;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int Altura) {
        this.Altura = Altura;
    }

    public int getTamano() {
        return Tamano;
    }

    public void setTamano(int Tamano) {
        this.Tamano = Tamano;
    }

    public Nodo getIzq() {
        return Izq;
    }

    public void setIzq(Nodo Izq) {
        this.Izq = Izq;
    }

    public Nodo getDer() {
        return Der;
    }

    public void setDer(Nodo Der) {
        this.Der = Der;
    }

    @Override
    public String toString() {
        return "Nodo{" + "Valor=" + Valor + ", Altura=" + Altura + ", Tamano=" + Tamano + ", Izq=" + Izq + ", Der=" + Der + '}';
    }
    
    
}
