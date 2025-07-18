package serverB;

import common.IInventoryManager;
import common.ProductoDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class InventoryManagerImpl extends UnicastRemoteObject implements IInventoryManager {
    private final List<ProductoDTO> inventario = new ArrayList<>();

    public InventoryManagerImpl() throws RemoteException {}

    public void registrarProducto(ProductoDTO producto) {
        inventario.add(producto);
    }

    public List<ProductoDTO> consultarInventario(String sucursal) {
        return inventario;
    }
}