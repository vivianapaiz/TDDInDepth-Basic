package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ProductInventoryShould {
    @Test
    public void AddProductToInventory() {
        ProductInventory inventory = new ProductInventory();

        String productId = "123";
        Integer quantity = 10;
        inventory.addStock(productId, quantity);

        assertThat(inventory.checkStock(productId)).isEqualTo(quantity);
    }

    @Test
    public void RemoveProductFromInventory() {
        ProductInventory inventory = new ProductInventory();

        String productId = "123";
        Integer quantity = 10;
        inventory.addStock(productId, quantity);

        inventory.removeStock(productId, 5);

        assertThat(inventory.checkStock(productId)).isEqualTo(5);
    }

    @Test
    public void ThrowExceptionWhenRemovingMoreStockThanAvailable() {
        ProductInventory inventory = new ProductInventory();

        String productId = "123";
        Integer quantity = 10;
        inventory.addStock(productId, quantity);

        assertThatThrownBy(() -> inventory.removeStock(productId, 15))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Not enough stock available for " + productId);
    }
}
