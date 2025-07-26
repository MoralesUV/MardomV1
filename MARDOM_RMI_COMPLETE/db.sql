BEGIN TRANSACTION;
CREATE TABLE clientes (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          nombre TEXT NOT NULL,
                          correo TEXT NOT NULL UNIQUE,
                          id_rol INTEGER,
                          id_sucursal INTEGER,
                          FOREIGN KEY(id_rol) REFERENCES roles(id),
                          FOREIGN KEY(id_sucursal) REFERENCES sucursales(id)
);
INSERT INTO "clientes" VALUES(1,'Luis Morales','luis@example.com',1,1);
INSERT INTO "clientes" VALUES(2,'Ruth Martínez','ruth@example.com',2,2);
INSERT INTO "clientes" VALUES(3,'Carlos López','carlos@example.com',3,1);
CREATE TABLE detalle_venta (
                               id INTEGER PRIMARY KEY AUTOINCREMENT,
                               id_venta INTEGER,
                               id_producto INTEGER,
                               cantidad INTEGER NOT NULL,
                               subtotal REAL NOT NULL,
                               FOREIGN KEY(id_venta) REFERENCES ventas(id),
                               FOREIGN KEY(id_producto) REFERENCES productos(id)
);
INSERT INTO "detalle_venta" VALUES(1,1,1,2,300.0);
INSERT INTO "detalle_venta" VALUES(2,1,3,1,150.0);
INSERT INTO "detalle_venta" VALUES(3,2,2,1,200.0);
INSERT INTO "detalle_venta" VALUES(4,2,3,1,100.0);
CREATE TABLE productos (
                           id INTEGER PRIMARY KEY AUTOINCREMENT,
                           nombre TEXT NOT NULL,
                           precio REAL NOT NULL,
                           stock INTEGER NOT NULL
);
INSERT INTO "productos" VALUES(1,'Multivitamínico',150.0,25);
INSERT INTO "productos" VALUES(2,'Colágeno Marino',200.0,10);
INSERT INTO "productos" VALUES(3,'Vitamina C',100.0,50);
CREATE TABLE roles (
                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                       nombre TEXT NOT NULL
);
INSERT INTO "roles" VALUES(1,'Administrador');
INSERT INTO "roles" VALUES(2,'Vendedor');
INSERT INTO "roles" VALUES(3,'Cliente');
CREATE TABLE sucursales (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            nombre TEXT NOT NULL,
                            direccion TEXT NOT NULL
);
INSERT INTO "sucursales" VALUES(1,'Sucursal Centro','Av. Independencia 123');
INSERT INTO "sucursales" VALUES(2,'Sucursal Norte','Calle Reforma 456');
CREATE TABLE ventas (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        id_cliente INTEGER,
                        total REAL NOT NULL,
                        fecha TEXT NOT NULL,
                        FOREIGN KEY(id_cliente) REFERENCES clientes(id)
);
INSERT INTO "ventas" VALUES(1,1,450.0,'2025-09-19');
INSERT INTO "ventas" VALUES(2,2,300.0,'2025-09-18');
DELETE FROM "sqlite_sequence";
INSERT INTO "sqlite_sequence" VALUES('roles',3);
INSERT INTO "sqlite_sequence" VALUES('sucursales',2);
INSERT INTO "sqlite_sequence" VALUES('clientes',3);
INSERT INTO "sqlite_sequence" VALUES('productos',3);
INSERT INTO "sqlite_sequence" VALUES('ventas',2);
INSERT INTO "sqlite_sequence" VALUES('detalle_venta',4);
COMMIT;
