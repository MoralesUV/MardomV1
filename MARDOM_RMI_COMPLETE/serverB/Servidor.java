package serverB;

import common.IInventoryManager;
import common.ProductoDTO;

import java.rmi.Naming;

import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Levanta el registro RMI en el puerto 1100
            LocateRegistry.createRegistry(1100);

            // Crea la instancia del objeto remoto
            //IInventoryManager inv = new InventoryManagerImpl();
            IInventoryManager inv = new InventoryManagerImpl();

            // Publica el objeto remoto con el nombre "InventoryManager"
            Naming.rebind("//localhost:1100/InventoryManager", inv);

            System.out.println("✔ Servidor A levantado y objeto InventoryManager publicado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
