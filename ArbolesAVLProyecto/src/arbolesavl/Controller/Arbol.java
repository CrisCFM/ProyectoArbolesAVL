package arbolesavl.Controller;
import arbolesavl.Model.Nodo;
/**
 *
 * @author Cris
 */
public class Arbol {
    public Nodo nodo;    
    /**
     * Revisa si el arbol esta vacio
     * 
     * @return {@code true}
     */
    public boolean EstaVacio() {
        //revisa si el nodo esta vacio  y si lo esta devuelve true
        return nodo == null;
    }

    /**
     * Devuelve el numero de nodos.
     * 
     * @return
     */
    public int Tamano() {
        return Cantsub(nodo);
    }

    /**
     * Devulev en el numero de nodos en el subarbol
     * @param nodo 
     * 
     * @return 
     */
    private int Cantsub(Nodo nodo) {
        if (nodo == null) return 0;
        return nodo.Tamano;
    }

    /**
     * Devuelve la altura interna del arbol.
     * altura de un arbol vacio=-1 y un arbol con altura de solo un nodo es 0
     * @return 
     */
    public int Altura() {
        return Alturasub(nodo);
    }

    /**
     * Devuelve la altura de el subarbor. 
     * @param nodo
     * @return
     */
    private int Alturasub(Nodo nodo) {
        if (nodo == null) return -1;
        return nodo.Altura;
    }

     /**
     * inserta un valor en el arbol
     * @param Valor
     */
    public void Insert(int Valor) {
        nodo = InsertSub(nodo, Valor);
    }
    
    /**
     * Recorre el árbol para encontrar un valor, devolviendo su nodo o null si no lo encuentra
     * @param Valor
     * @param nodo
     * @return 
     */
    public Nodo Buscar(int Valor, Nodo nodo){
        if (nodo==null){
            return null;
        }        
        if (nodo.Valor==Valor){
            return nodo;
        }
        else if (Valor < nodo.Valor){
            return Buscar(Valor,nodo.Izq);
        }
        else
        {
            return Buscar(Valor,nodo.Der);
        }
    }

    /**
     * Inserta el valor en el sibarbol. 
     * @param nodo 
     * @param Valor 
     * @return 
     */
    private Nodo InsertSub(Nodo nodo, int Valor) {
        if (nodo == null) return new Nodo(Valor, 0, 1);
        
        if (Valor < nodo.Valor) {
            nodo.Izq = InsertSub(nodo.Izq, Valor);
        }
        else if (Valor > nodo.Valor) {
            nodo.Der = InsertSub(nodo.Der, Valor);
        }
        else {
            nodo.Valor = Valor;
            return nodo;
        }
        nodo.Tamano = 1 + Cantsub(nodo.Izq) + Cantsub(nodo.Der);
        nodo.Altura = 1 + Math.max(Alturasub(nodo.Izq), Alturasub(nodo.Der));
        return balance(nodo);
    }

    /**
     * Realiza el balance AVL
     * 
     * @param nodo 
     * @return 
     */
    private Nodo balance(Nodo nodo) {
        if (FactorBala(nodo) > 1) {
            if (FactorBala(nodo.Der) < 0) {
                nodo.Der = Rotacionderecha(nodo.Der);
            }
            nodo = Rotacionizquierda(nodo);
        }
        else if (FactorBala(nodo) < -1) {
            if (FactorBala(nodo.Izq) > 0) {
                nodo.Izq = Rotacionizquierda(nodo.Izq);
            }
            nodo = Rotacionderecha(nodo);
        }
        return nodo;
    }

    /**
     * Devuelde el factor de balance en el subarbol, el factor de balance es la diferencia de altura del subarbol de la izquierda y del arbol de la derecha
     * @param nodo 
     * @return 
     */
    private int FactorBala(Nodo nodo) {
        return Alturasub(nodo.Der) - Alturasub(nodo.Izq);
    }

    /**
     *rota el subarbol hacia la derecha.
     * 
     * @param nodo 
     * @returnthe right rotated subtree
     */
    private Nodo Rotacionderecha(Nodo nodo) {
        Nodo y = nodo.Izq;
        nodo.Izq = y.Der;
        y.Der = nodo;
        y.Tamano = nodo.Tamano;
        nodo.Tamano = 1 + Cantsub(nodo.Izq) + Cantsub(nodo.Der);
        nodo.Altura = 1 + Math.max(Alturasub(nodo.Izq), Alturasub(nodo.Der));
        y.Altura = 1 + Math.max(Alturasub(y.Izq), Alturasub(y.Der));
        return y;
    }

    /**
     * rota el subarbol a la izquierda
     * 
     * @param nodo 
     * @return 
     */
    private Nodo Rotacionizquierda(Nodo nodo) {
        Nodo y = nodo.Der;
        nodo.Der = y.Izq;
        y.Izq = nodo;
        y.Tamano = nodo.Tamano;
        nodo.Tamano = 1 + Cantsub(nodo.Izq) + Cantsub(nodo.Der);
        nodo.Altura = 1 + Math.max(Alturasub(nodo.Izq), Alturasub(nodo.Der));
        y.Altura = 1 + Math.max(Alturasub(y.Izq), Alturasub(y.Der));
        return y;
    }

    /**
     * Remueve el valor especificado
     * @param Valor the value
     */
    public void delete(int Valor) {
        nodo = delete(nodo, Valor);
    }

    /**
     *  Elimina el valor especificado y su nodo asociado del dado subarbol
     * 
     * @param nodo 
     * @param Valor 
     * @return 
     */
    private Nodo delete(Nodo nodo, int Valor) {
        if (Valor < nodo.Valor) {
            nodo.Izq = delete(nodo.Izq, Valor);
        }
        else if (Valor > nodo.Valor) {
            nodo.Der = delete(nodo.Der, Valor);
        }
        else {
            if (nodo.Izq == null) {
                return nodo.Der;
            }
            else if (nodo.Der == null) {
                return nodo.Izq;
            }
            else {
                Nodo y = nodo;
                nodo = Nodomenor(y.Der);
                nodo.Der = deleteMin(y.Der);
                nodo.Izq = y.Izq;
            }
        }
        nodo.Tamano = 1 + Cantsub(nodo.Izq) + Cantsub(nodo.Der);
        nodo.Altura = 1 + Math.max(Alturasub(nodo.Izq), Alturasub(nodo.Der));
        return balance(nodo);
    }  
     
    /**
     * Elimina el nodo mas pequeño del subarbol dado
     * 
     * @param nodo
     * @return 
     */
    private Nodo deleteMin(Nodo nodo){
        if (nodo.Izq == null) return nodo.Der;
        nodo.Izq = deleteMin(nodo.Izq);
        nodo.Tamano = 1 + Cantsub(nodo.Izq) + Cantsub(nodo.Der);
        nodo.Altura = 1 + Math.max(Alturasub(nodo.Izq), Alturasub(nodo.Der));
        return balance(nodo);
    }
    
    /**
     * Devuelve el nodo mas pequeño en el subarbol
     * 
     * @param nodo 
     * @return 
     */
    private Nodo Nodomenor(Nodo nodo){
        if (nodo.Izq == null) return nodo;
        return Nodomenor(nodo.Izq);
    }
    
    /**
     * Recorre el árbol en InOrden
     * @param nodo 
     */
    public void inOrden(Nodo nodo){
        if (nodo!=null){
            inOrden(nodo.Izq);
            System.out.print(nodo.Valor + ", ");
            inOrden(nodo.Der);
        }
    }
    
    /**
     * Recorre el árbol en PreOrden
     * @param nodo 
     */
    public void preOrden(Nodo nodo)
    {
        if (nodo!=null){
            System.out.print(nodo.Valor + ", ");
            preOrden(nodo.Izq);
            preOrden(nodo.Der);
        }
    }
    
    /**
     * Recorre el árbol en PostOrden
     * @param nodo 
     */
    public void postOrden(Nodo nodo)
    {
        if (nodo!=null)
        {
            postOrden(nodo.Izq);
            postOrden(nodo.Der);
            System.out.print(nodo.Valor + ", ");
        }
    }
}
