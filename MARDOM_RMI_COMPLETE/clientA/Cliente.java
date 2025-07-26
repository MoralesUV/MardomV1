package clientA;

import common.IInventoryManager;
import common.ProductoDTO;
import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) {
        try {
            IInventoryManager inv = (IInventoryManager) Naming.lookup("rmi://localhost:1099/InventoryManager");

            ProductoDTO prod = new ProductoDTO();
            prod.setNombre("Miel Natural");
            prod.setPrecio(120.00f);
            prod.setStock(20);
            prod.setIdSucursal(1); // O la que corresponda


            inv.registrarProducto(prod);
            System.out.println("✅ Producto registrado en sucursal CLIENTE A.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
