package clientB;

import common.IInventoryManager;
import common.ProductoDTO;
import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) {
        try {
            IInventoryManager inv = (IInventoryManager) Naming.lookup("rmi://localhost:1100/InventoryManager");

            ProductoDTO prod = new ProductoDTO();
            prod.setNombre("Agua Natural");
            prod.setPrecio(150.00f);
            prod.setStock(20);
            prod.setIdSucursal(2); // O la que corresponda


            inv.registrarProducto(prod);
            System.out.println("✅ Producto registrado en sucursal CLIENTE B.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}