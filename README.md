# Sistema de Gestión de Pedidos — Principios SOLID

Proyecto de práctica en Java puro (sin frameworks) que simula el procesamiento de un
pedido: cálculo de descuentos, "persistencia" y notificación al cliente. El objetivo
no es la funcionalidad en sí, sino mostrar la aplicación práctica de los 5 principios
SOLID sobre un mismo caso de uso, con evidencia de cada paso en el historial de commits.

## Cómo está aplicado cada principio

**S — Single Responsibility Principle**
`GestorPedidos` no calcula, persiste y notifica todo en un mismo método. Cada
responsabilidad vive en su propia clase: `RepositorioPedidos` (persistencia) y
`Notificador` (notificación). `GestorPedidos` solo orquesta.

**O — Open/Closed Principle**
Los descuentos se resuelven con la interfaz `EstrategiaDescuento` y una implementación
por tipo de cliente (`DescuentoRegular`, `DescuentoVIP`, `DescuentoMayorista`,
`DescuentoEmpleado`). Agregar un tipo de descuento nuevo no requiere modificar
`GestorPedidos` ni ninguna estrategia existente, solo agregar una clase nueva.

**L — Liskov Substitution Principle**
`NotificadorPedidosGrandes` (una implementación de `Notificador`) llegó a lanzar una
excepción para pedidos por debajo de cierto monto, rompiendo la promesa del contrato
`Notificador` y quebrando cualquier código que tratara a todas las implementaciones
por igual. El historial de commits conserva ese estado como evidencia (ver
[`dcc843d`](https://github.com/Moises7MC/principios-solid/commit/dcc843d3e6b8ebadc3b6d618f1348f3c1f782d3e))
antes de corregirlo (ver
[`cc5a594`](https://github.com/Moises7MC/principios-solid/commit/cc5a5943a2c0e781a7ae96599e904a073085b9d7))
moviendo la regla de negocio a `GestorPedidos.elegirNotificador(total)`, de forma que
ninguna implementación necesita rechazar una entrada válida según el contrato.

**I — Interface Segregation Principle**
`GeneradorFactura` se separó de `Notificador` en vez de agregarle un método más. Solo
`NotificadorPedidos` (email) implementa ambas interfaces; `NotificadorPedidosGrandes`
no se ve obligado a implementar una capacidad que no soporta.

**D — Dependency Inversion Principle**
`GestorPedidos` depende de la abstracción `RepositorioPedidos`, recibida por
constructor, no de la implementación concreta `RepositorioPedidosMemoria`. `Main` es
el único punto del programa que decide qué implementación concreta usar (composition
root). `RepositorioPedidosFalso` demuestra que `GestorPedidos` puede recibir cualquier
implementación del contrato sin modificarse, sentando la base para pruebas unitarias
aisladas de dependencias externas.

## Estructura del código

```
src/main/java/pe/jllalle/pedidos/
├── Pedido.java                    Modelo de dominio: agrupa ItemPedido y calcula el total
├── ItemPedido.java                Modelo de dominio: producto, precio y cantidad
├── GestorPedidos.java             Orquestador del proceso de un pedido
├── EstrategiaDescuento.java       Interfaz de descuento (Open/Closed)
├── DescuentoRegular.java
├── DescuentoVIP.java
├── DescuentoMayorista.java
├── DescuentoEmpleado.java
├── Notificador.java               Interfaz de notificación
├── NotificadorPedidos.java        Notificación por email + factura PDF
├── NotificadorPedidosGrandes.java Notificación prioritaria para pedidos grandes
├── GeneradorFactura.java          Interfaz segregada de Notificador (Interface Segregation)
├── RepositorioPedidos.java        Abstracción de persistencia (Dependency Inversion)
├── RepositorioPedidosMemoria.java Implementación real (simulada)
└── RepositorioPedidosFalso.java   Implementación de prueba, sin efectos externos
```

## Cómo ejecutar

```
mvn compile exec:java -Dexec.mainClass="pe.jllalle.pedidos.Main"
```

O directamente desde IntelliJ IDEA, ejecutando la clase `Main`.

## Historial de commits

El repositorio conserva un commit por cada paso: el punto de partida sin SOLID, y luego
uno por cada principio aplicado (incluyendo el commit "antes del fix" de Liskov, dejado
a propósito como evidencia del problema). `git log --oneline` muestra la evolución
completa.
