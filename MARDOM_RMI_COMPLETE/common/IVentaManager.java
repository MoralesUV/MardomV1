package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVentaManager extends Remote {
    void registrarVenta(VentaDTO venta) throws RemoteException;
    List<VentaDTO> obtenerVentas(String sucursal) throws RemoteException;
}