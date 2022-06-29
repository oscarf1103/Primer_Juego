package JavaApplication1.datos;

public abstract class Datos {
    protected String archivo;
    
    public Datos(String archivo) {
        this.archivo = archivo;
    }
    /**
     *Se Confirma si el archivo existe.
     * 
     * @return boolean
     */
    abstract public boolean existeArchivo();

    /**
     * Obtiene el nombre del archivo
     * @return 
     */
    public String getArchivo() {
        return archivo;
    }
}
