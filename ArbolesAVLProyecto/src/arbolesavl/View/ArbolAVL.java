package arbolesavl.View;
import arbolesavl.Controller.Arbol;
/**
 *
 * @author Cris
 */
public class ArbolAVL {
    
    public static void main(String[] args) {        
        //Arbol con rotación doble a la izquierda
        Arbol ArbolAVL = new Arbol();  
        System.out.println("PRUEBA DE INSERCIONES:Insertaremos datos en el primer arbol para poder ve si la opcion de insertar funciona correctamente:");
        System.out.println();
        System.out.println("Insercion dato 5:");
        ArbolAVL.Insert(5);
                if (ArbolAVL.Buscar(5, ArbolAVL.nodo)!= null){
            System.out.println("Dato 5 insertado correctamente");
            System.out.println("Prueba correcta");
        }else{
            System.out.println("No se encuentra el valor");
        }
                
        System.out.println();
        System.out.println("Insercion dato 3:");       
        ArbolAVL.Insert(3);
                if (ArbolAVL.Buscar(3, ArbolAVL.nodo)!= null){
            System.out.println("Dato 3 insertado correctamente");
            System.out.println("Prueba correcta");
        }else{
            System.out.println("No se encuentra el valor");
        }
        System.out.println();
        System.out.println("Insercion dato 10:");        
        ArbolAVL.Insert(10);
                if (ArbolAVL.Buscar(10, ArbolAVL.nodo)!= null){
            System.out.println("Dato 10 insertado correctamente");
            System.out.println("Prueba correcta");
        }else{
            System.out.println("No se encuentra el valor");
        }
        System.out.println();
        System.out.println("Insercion dato 7:");        
        ArbolAVL.Insert(7);
                if (ArbolAVL.Buscar(7, ArbolAVL.nodo)!= null){
            System.out.println("Dato 7 insertado correctamente");
            System.out.println("Prueba correcta");
        }else{
            System.out.println("No se encuentra el valor");
        }
        System.out.println();
        System.out.println("Insercion dato 12:");        
        ArbolAVL.Insert(12);
        if (ArbolAVL.Buscar(12, ArbolAVL.nodo)!= null){
            System.out.println("Dato 12 insertado correctamente");
            System.out.println("Prueba correcta");
        }    else{
            System.out.println("No se encuentra el valor");
        }
        System.out.println();
        System.out.println("Insercion dato 6:");
        ArbolAVL.Insert(6);
        if (ArbolAVL.Buscar(6, ArbolAVL.nodo)!= null){
            System.out.println("Dato 6 insertado correctamente");
            System.out.println("Prueba correcta");
        }     else{
            System.out.println("No se encuentra el valor");
        }
        System.out.println();
        
        System.out.println("ARBOL 1: Recorrido en PreOrden tras una rotación doble a la izquierda");
        ArbolAVL.preOrden(ArbolAVL.nodo);
        System.out.println();        
        System.out.println("ARBOL 1: Recorrido en PostOrden tras una rotación doble a la izquierda");
        ArbolAVL.postOrden(ArbolAVL.nodo);
        System.out.println();  
        System.out.println("ARBOL 1: Recorrido en InOrden tras una rotación doble a la izquierda");
        ArbolAVL.inOrden(ArbolAVL.nodo);
        System.out.println();  
        
        System.out.println("ARBOL 1: Recorrido en PreOrden tras eliminar el 6");
        ArbolAVL.delete(6);
        ArbolAVL.preOrden(ArbolAVL.nodo);
        for (int i = 0; i < 4; i++) {
            System.out.println();
        }                                   
        System.out.println("**********************************************CAMBIO DE ARBOL**********************************");
        for (int i = 0; i < 3; i++) {
            System.out.println();
        } 
        //Arbol con rotación doble a la derecha
        Arbol ArbolAVL2 = new Arbol();        
        ArbolAVL2.Insert(9);
        ArbolAVL2.Insert(5);
        ArbolAVL2.Insert(10);
        ArbolAVL2.Insert(1);
        ArbolAVL2.Insert(7);
        ArbolAVL2.Insert(6);
        
        System.out.println("ARBOL 2:Recorrido en PreOrden tras una rotación doble a la derecha");
        ArbolAVL2.preOrden(ArbolAVL2.nodo);
        System.out.println();     
        System.out.println("ARBOL 2: Recorrido en PostOrden tras una rotación doble a la derecha");
        ArbolAVL2.inOrden(ArbolAVL2.nodo);
        System.out.println();
        System.out.println("ARBOL 2: Recorrido en InOrden tras una rotación doble a la derecha ");
        ArbolAVL2.postOrden(ArbolAVL2.nodo);
        System.out.println();       
        System.out.println("ARBOL 2: Recorrido en PreOrden tras eliminar el 6");
        ArbolAVL2.delete(6);
        ArbolAVL2.preOrden(ArbolAVL2.nodo);
        System.out.println();
        
        //Preguntamos antes si el arbol no esta vacio para poder borrar.
        System.out.println("PRUEBA DEL DELETE:Borraremos todos lo datos para poder comprobar tambien el metodo esta vacio <.");
        System.out.println();
        if (!ArbolAVL.EstaVacio()){
            ArbolAVL.delete(7);
            System.out.println("Dato 7 del arbol borrado");
        }
        if (!ArbolAVL.EstaVacio()){
            ArbolAVL.delete(12);
            System.out.println("Dato 12 del arbol borrado");
        }
        if (!ArbolAVL.EstaVacio()){
            ArbolAVL.delete(3);
            System.out.println("Dato 3 del arbol borrado");
        }
        if (!ArbolAVL.EstaVacio()){
            System.out.println("Dato 10 del arbol borrado");
            ArbolAVL.delete(10);
        }
        if (!ArbolAVL.EstaVacio()){
            System.out.println("Dato 5 del arbol borrado");
            ArbolAVL.delete(5);
        }
        System.out.println();
        System.out.println("Prueba metodo esta vacio:");
        System.out.println("Como podemos ver arriba en la prueba del metodo delete borramos todos los datos que tenia el arbol con rotacion a la derecha con lo cual al probar el metodo de que si esta vacio nos debe mostrar 'TRUE':");
        System.out.println();
        System.out.println(ArbolAVL.EstaVacio());
        System.out.println("");
               
                  
        /*//Preguntamos antes si el arbol no esta vacio para poder borrar
        if (!ArbolAVL.EstaVacio()){
            ArbolAVL.preOrden(ArbolAVL.nodo);
        }
        else{
            System.out.println("Árbol vacío");
        }*/
        
        System.out.println("Prueba del metodo buscar: buscaremos el dato 5 en arbol2 con rotacion hacia la izquierda, el cual si esta con lo que nos debe dar 'Valor encontrado'");        
        if (ArbolAVL2.Buscar(5, ArbolAVL2.nodo)!= null){
            System.out.println("Valor encontrado!");
            System.out.println("Prueba correcta");
        }
        else{
            System.out.println("No se encuentra el valor");
        }
        for (int i = 0; i < 3; i++) {
            System.out.println();                   
        }
        System.out.println("Prueba del metodo buscar: buscaremos el dato 89 en arbol2 con rotacion hacia la izquierda, el cual no esta con lo cual nos debe dar 'No se encuentra el valor'");  
        if (ArbolAVL2.Buscar(89, ArbolAVL2.nodo)!= null){
            System.out.println("Valor  encontrado");
        }
        else{
            System.out.println("No se encuentra el valor");
            System.out.println("Prueba correcta");
        }
        
        System.out.println("ARBOL 2:Prueba el metodo buscar");
        ArbolAVL2.preOrden(ArbolAVL2.nodo);
        System.out.println();  
        
    }
    
}
