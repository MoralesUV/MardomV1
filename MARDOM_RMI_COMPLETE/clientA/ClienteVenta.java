package clientA;

import common.IVentaManager;
import common.DetalleVentaDTO;
import common.VentaDTO;

import java.rmi.Naming;
import java.util.ArrayList;

public class ClienteVenta {
    public static void main(String[] args) {
        try {
            IVentaManager ventaManager = (IVentaManager) Naming.lookup("rmi://localhost:1099/VentaManager");

            DetalleVentaDTO detalle = new DetalleVentaDTO();
            detalle.productoNombre = "Miel Natural";
            detalle.cantidad = 2;
            detalle.precioUnitario = 50;

            VentaDTO venta = new VentaDTO();
            venta.sucursal = "CLIENTA";
            venta.detalles = new ArrayList<>();
            venta.detalles.add(detalle);

            ventaManager.registrarVenta(venta);
            System.out.println("Venta registrada en sucursal CLIENTA.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}