package serverA;

import common.IInventoryManager;
import common.ProductoDTO;

import java.rmi.Naming;

import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Levanta el registro RMI en el puerto 1099
            LocateRegistry.createRegistry(1099);

            // Crea la instancia del objeto remoto
            //IInventoryManager inv = (IInventoryManager) Naming.lookup("//localhost:1100/InventoryManager");
            IInventoryManager inv = new InventoryManagerImpl();

            // Publica el objeto remoto con el nombre "InventoryManager"
            Naming.rebind("InventoryManager", inv);

            System.out.println("✔ Servidor A levantado y objeto InventoryManager publicado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
