package clientB;

import common.IInventoryManager;
import common.ProductoDTO;

import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) {
        try {
            IInventoryManager inv = (IInventoryManager) Naming.lookup("rmi://localhost:1100/InventoryManager");
            ProductoDTO prod = new ProductoDTO();
            prod.nombre = "Miel Natural";
            prod.categoria = "Suplemento";
            prod.precioPublico = 50;
            prod.precioAdquisicion = 30;
            prod.marca = "EcoVida";
            prod.fechaCaducidad = "2025-12-01";
            inv.registrarProducto(prod);
            System.out.println("Producto registrado en sucursal CLIENTB.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}