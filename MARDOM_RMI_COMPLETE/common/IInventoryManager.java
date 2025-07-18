package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IInventoryManager extends Remote {
    void registrarProducto(ProductoDTO producto) throws RemoteException;
    List<ProductoDTO> consultarInventario(String sucursal) throws RemoteException;
}