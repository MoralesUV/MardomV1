package common;

import java.io.Serializable;

public class ProductoDTO implements Serializable {
    public String nombre;
    public String categoria;
    public float precioPublico;
    public float precioAdquisicion;
    public String marca;
    public String fechaCaducidad;
}