public abstract class Unidad extends Pieza {

    protected boolean ocupado;  //TODO: A futuro cambiar por patrón state.

    //TODO: ¿No se supone que Unidad nunca puede ser instanciable porque es abstracta?
    public Unidad(Area unArea) throws Excepcion {
        super(unArea);
        ocupado = false;
    }

    //TODO: REPITO: Sacar estos métodos falopas.
    protected void siEstaOcupadoDaError() throws Excepcion {
        if(ocupado)

            throw new Excepcion("ERROR: La unidad esta ocupada.");
    }


}
