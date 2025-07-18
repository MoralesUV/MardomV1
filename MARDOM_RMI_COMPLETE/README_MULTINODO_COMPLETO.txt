# 📘 README MULTINODO – Proyecto Java RMI MARDOM

Este proyecto simula un entorno distribuido con dos sucursales usando Java RMI:
- Sucursal A opera en el puerto 1099
- Sucursal B opera en el puerto 1100

## 📁 Estructura del Proyecto

- `common/` – Interfaces remotas y DTOs compartidos
- `serverA/` – Servidor RMI en puerto 1099
- `serverB/` – Servidor RMI en puerto 1100
- `clientA/` – Clientes para sucursal A
- `clientB/` – Clientes para sucursal B

## 🛠️ Requisitos Previos

- Java JDK 8 o superior instalado
- Variables de entorno JAVA_HOME configuradas
- Ejecutar desde terminal (CMD, Bash) o configurar como proyecto en NetBeans/IntelliJ

---

## 🧪 Paso a Paso para Compilar y Ejecutar

### 1. Compilar interfaces y DTOs

```bash
javac common/*.java
```

### 2. Compilar servidores y clientes

```bash
javac -cp . serverA/*.java
javac -cp . serverB/*.java
javac -cp . clientA/*.java
javac -cp . clientB/*.java
```

### 3. Ejecutar servidor de Sucursal A (puerto 1099)

```bash
java -cp . serverA.Servidor
```

En otra terminal...

### 4. Ejecutar servidor de Sucursal B (puerto 1100)

```bash
java -cp . serverB.Servidor
```

---

## 🚀 Ejecutar los Clientes

### 5. Ejecutar cliente de productos de Sucursal A

```bash
java -cp . clientA.Cliente
```

### 6. Ejecutar cliente de ventas de Sucursal A

```bash
java -cp . clientA.ClienteVenta
```

### 7. Ejecutar cliente de productos de Sucursal B

```bash
java -cp . clientB.Cliente
```

### 8. Ejecutar cliente de ventas de Sucursal B

```bash
java -cp . clientB.ClienteVenta
```

