package serverB;

import common.IInventoryManager;
import common.ProductoDTO;
import common.DBConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventoryManagerImpl extends UnicastRemoteObject implements IInventoryManager {

    public InventoryManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public void registrarProducto(ProductoDTO producto) throws RemoteException {
        String query = "INSERT INTO productos (nombre, precio, stock, id_sucursal) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getStock());
            stmt.setInt(4, producto.getIdSucursal());
            stmt.executeUpdate();


            stmt.executeUpdate();
            System.out.println("✅ Producto registrado correctamente en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("❌ Error al registrar producto", e);
        }
    }


    @Override
    public List<ProductoDTO> consultarInventario(int idSucursal) throws RemoteException {
        List<ProductoDTO> productos = new ArrayList<>();
        String query = "SELECT * FROM productos WHERE id_sucursal = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idSucursal);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProductoDTO prod = new ProductoDTO();
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getFloat("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setIdSucursal(rs.getInt("id_sucursal"));
                productos.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("❌ Error al consultar inventario", e);
        }

        return productos;
    }
}
