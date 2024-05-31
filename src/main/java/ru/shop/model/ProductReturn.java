package ru.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
// Сущности хранятся в БД
@Entity
// Задаём таблицы для хранения
@Table(name = "product_return")
public class ProductReturn {
    // первичный ключ
    @Id
    private UUID id;
    @NonNull
    private UUID orderId;
    private LocalDate date;
    private int quantity;
}