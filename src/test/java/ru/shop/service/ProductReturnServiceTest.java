package ru.shop.service;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;


class ProductReturnServiceTest{
    private final ProductReturnService productReturnService = new ProductReturnService();
    private final ProductReturnRepository productReturnRepository = Mockito.mock();

    @Test
    public void add_WithInvalidCount_ShouldThrowBadProductCountException(){
        Order order = new Order(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), 50, 10);
        assertThrows(BadProductReturnCountException.class, () -> productReturnService.add(order, 1000));
    }

    @Test
    public void add_WithValidCount_ShouldPass(){
        Order order = new Order(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), 50, 10);
        assertDoesNotThrow(() -> service.save(order, 5));
    }

    @Test
    public void findAll_WithNoEntities_ShouldReturnEmptyList(){
        List<ProductReturn> productReturnList = new List();
        when(productReturnRepository.findAll()).thenReturn(productReturnList.size());

        List<ProductReturn> result = productReturnService.findAll();
        assertEquals(productReturnList.size(), result.size());
    }

    @Test
    public void findAll_WithEntities_ShouldReturnFullList(){
        List<ProductReturn> productReturnList = new List();
        productReturnList.add(new ProductReturn(UUID.randomUUID(), UUID.randomUUID(), LocalDate.now());
        productReturnList.add(new ProductReturn(UUID.randomUUID(), UUID.randomUUID(), LocalDate.now());
        when(productReturnRepository.findAll()).thenReturn(productReturnList.size());

        List<ProductReturn> result = productReturnService.findAll();
        assertEquals(productReturnList.size(), result.size());
    }

    @Test
    public void findById_WithInvalidId_ShouldThrowEntityNotFoundException(){
         assertThrows(EntityNotFoundException.class, () -> productReturnService.findById(UUID.randomUUID()));
    }

    @Test
    public void findById_WithValidId_ShouldReturnEntity(){
        UUID id = UUID.randomUUID();
        ProductReturn productReturn = new ProductReturn(id, UUID.randomUUID(), LocalDate.now(), 10);
        when(productReturnRepository.findById(id)).thenReturn(Optional.of(productReturn));

        ProductReturn result = productReturnService.findById(id);
        assertEquals(productReturn, result);
    }

}