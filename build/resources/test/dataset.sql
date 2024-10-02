insert into usuario (cedula, email, nombre, password, ciudad, direccion, telefono, estado)
values
(001, 'jose@example.com', 'José Pérez', 'password', 'ARMENIA', 'Av. Arequipa 123', '999888777','INACTIVO'),
(002, 'maria@example.com', 'María González', 'abc123', 'MANIZALES', 'Av. Providencia 456', '987654321','INACTIVO'),
(003, 'juan@example.com', 'Juan Rodriguez', 'password123', 'BARRANQUILLA', 'Calle 72 # 14-29', '123456789','INACTIVO'),
(004, 'ana@example.com', 'Ana Martinez', 'qwerty', 'BOGOTA', 'Av. Corrientes 789', '555444333','INACTIVO'),
(005, 'carlos@example.com', 'Carlos Sánchez', '123456', 'CALI', 'Av. Insurgentes 456', '111222333','INACTIVO');

insert into producto (descripcion, activo, fecha_creacion, fecha_limite, nombre, precio, unidades, vendedor_cedula)
values('Smartphone Samsung Galaxy S21', 'INACTIVO', '2023-04-25', '2024-05-25', 'Samsung Galaxy S21', 899.99, 50, 001),
       ('Camisa de lino azul', 'INACTIVO', '2023-04-25', '2024-05-25', 'Camisa de lino azul', 49.99, 20, 002),
         ('Cocina de gas', 'INACTIVO', '2023-04-25', '2024-05-25', 'Cocina de gas', 349.99, 10, 003),
         ('Balón de fútbol', 'INACTIVO', '2023-04-25', '2024-05-25', 'Balón de fútbol', 29.99, 30, 001),
         ('Taladro inalámbrico', 'INACTIVO', '2023-04-25', '2024-05-25', 'Taladro inalámbrico', 129.99, 5, 004);




