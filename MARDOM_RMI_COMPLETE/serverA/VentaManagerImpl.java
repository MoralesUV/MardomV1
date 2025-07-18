package serverA;

import common.IVentaManager;
import common.VentaDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VentaManagerImpl extends UnicastRemoteObject implements IVentaManager {
    private final List<VentaDTO> ventas = new ArrayList<>();

    public VentaManagerImpl() throws RemoteException {}

    public void registrarVenta(VentaDTO venta) {
        ventas.add(venta);
    }

    public List<VentaDTO> obtenerVentas(String sucursal) {
        return ventas;
    }
}