package Pilas;

public class ListaSimple<Object> {

    private NodoSimple<Object> inicio, actual;

    //llama a establecer, establecer saca la estancia 
    public ListaSimple() {
        establecer(null);
    }

    //este constructor ya recibe el objeto que va a almacenar (el constructor de la sobrecarga)
    public ListaSimple(Object elemento) {
        establecer(new NodoSimple(elemento));
    }

    private void establecer(NodoSimple valor) {
        //esta es una asignacion multiple, y el valor siempre lo va a tener el ultimo valor de la lista de asignaciones
        this.inicio = this.actual = valor;
    }

    public void reiniciar() {
        this.actual = this.inicio;
    }

    //Enlaza nodos solamente para pilas
    public void enlazaA(Object elemento) {
        NodoSimple nodo = new NodoSimple(elemento);
        nodo.setSiguiente(inicio);
        establecer(nodo);
    }

    //Enlaza nodos solamente para listas simples
    //EnlazaA vinvula los datos
    public void enlazaA(NodoSimple nodo, Object elemento) {
        NodoSimple aux = nodo.getSiguiente();
        nodo.setSiguiente(new NodoSimple(elemento));
        nodo.getSiguiente().setSiguiente(aux);
    }

    public void anadir(Object elemento) {
        if (this.estaVacia()) {
            this.establecer(new NodoSimple(elemento));
        } else {
            this.enlazaA(this.actual, elemento);
        }
    }

    public void anadir() {
        this.anadir(null);
    }

    public boolean siguiente() {
        this.actual = this.actual.getSiguiente();
        return this.actual != null;
    }

    public Object getElemento() {
        return this.actual.getElemento();
    }

    public void setElemento(Object Elemento) {
        this.actual.setElemento(Elemento);
    }

    public Object getElementoInicio() {
        return this.inicio.getElemento();
    }

    public boolean estaVacia() {
        return this.inicio == null;
    }

    public void insertarAlInicio(Object elemento) {
        if (estaVacia()) {
            this.establecer(new NodoSimple(elemento));
            return; //se sale del condicional y del metodo
        }
        Object aux = this.inicio.getElemento();
        this.inicio.setElemento(elemento);
        this.enlazaA(this.inicio, aux);
    }

    public void insertarAlInicio() {
        this.insertarAlInicio(null);
    }

    public void eliminarInicio() {
        NodoSimple aux = this.inicio.getSiguiente();
        if (this.actual == this.inicio) {
            this.actual = this.inicio.getSiguiente();
        }
        this.inicio.setSiguiente(null);
        this.inicio = aux;
    }

}
