package Pilas;

public class Pilas<Object> {

    private ListaSimple<Object> elemento;

    public Pilas() {
        this.elemento = new ListaSimple();
    }

    //los tres metodos basicos, apilar, desapilar y estavacia.
    public void Apilar(Object elemento) {
        this.elemento.insertarAlInicio(elemento);
    }

    public void Desapilar() {
        this.elemento.eliminarInicio();
    }

    public boolean EstaVacia() {

        return this.elemento.estaVacia();
    }

    public Object getElemento() {
        return this.elemento.getElemento();
    }

    public void setElemento(Object elemento) {
        this.elemento.setElemento(elemento);
    }


}
