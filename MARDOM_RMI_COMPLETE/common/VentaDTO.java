package common;

import java.io.Serializable;
import java.util.List;

public class VentaDTO implements Serializable {
    public String sucursal;
    public List<DetalleVentaDTO> detalles;
}