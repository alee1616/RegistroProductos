package com.example.registroproductos.repository;

import com.example.registroproductos.model.Producto;

import java.time.LocalDate;
import java.util.List;

public class ProductoRepository {

    // aquí iría la lógica para obtener todos los productos de la base de datos
    public List<Producto> findAll() {
        return List.of(

                new Producto(1, "Monitor Samsung",
                        "Tecnología", 7000.50,
                        LocalDate.of(2026, 8,31),
                        null),

                new Producto(2, "Laptop DELL",
                        "Tecnología", 26000.44,
                        LocalDate.of(2026, 8,31),
                        null),

                new Producto(3, "Material Sintético",
                        "Hogar", 5000.50,
                        LocalDate.of(2026, 8,31),
                        null),

                new Producto(4, "Labial Italia Delux",
                        "Maquillaje", 1200.70,
                        LocalDate.of(2026, 8,31),
                        null),

                new Producto(5, "Shampoo Dove",
                        "Higiene", 1800.30,
                        LocalDate.of(2026, 8,31),
                        null
                )
        );
    }
}
