package serverB;

import common.IInventoryManager;
import common.IVentaManager;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1100);
            IInventoryManager inv = new InventoryManagerImpl();
            IVentaManager venta = new VentaManagerImpl();
            Naming.rebind("rmi://localhost:1100/InventoryManager", inv);
            Naming.rebind("rmi://localhost:1100/VentaManager", venta);
            System.out.println("Servidor RMI listo en puerto 1100.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}