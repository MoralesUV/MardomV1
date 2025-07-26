package clientB;

import common.IInventoryManager;
import common.ProductoDTO;

import java.rmi.Naming;
import java.util.List;

public class ClienteInventario {
    public static void main(String[] args) {
        try {
            // Enlace con el objeto remoto
            IInventoryManager inv = (IInventoryManager) Naming.lookup("rmi://localhost:1100/InventoryManager");

            // Consulta inventario
            List<ProductoDTO> productos = inv.consultarInventario(2);

            // Imprime resultados
            System.out.println("📦 Inventario disponible:");
            for (ProductoDTO prod : productos) {
                System.out.println("ID: " + prod.getId()
                        + " | Nombre: " + prod.getNombre()
                        + " | Precio: $" + prod.getPrecio()
                        + " | Stock: " + prod.getStock());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error al consultar inventario.");
        }
    }
}
