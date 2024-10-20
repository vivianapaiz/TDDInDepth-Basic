package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

public class ProductInventoryManualTest {
    public static void main(String[] args) {

        shouldAddProductToInventory("123", 10);

        shouldRemoveProductFromInventory("123", 10, 3);

        shouldFailRemovingMoreStockThanAvailable();
    }

    private static void shouldFailRemovingMoreStockThanAvailable() {
        shouldFailRemovingMoreStockThanAvailable("123", 15);
    }

    private static void shouldFailRemovingMoreStockThanAvailable(String productId, int quantity) {
        ProductInventory inventory = new ProductInventory();
        try {
            inventory.removeStock(productId, quantity);
            System.out.println("ThrowExceptionWhenRemovingMoreStockThanAvailable: Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("ThrowExceptionWhenRemovingMoreStockThanAvailable: Passed");
        }
    }

    private static void shouldAddProductToInventory(String productId, Integer quantity) {
        ProductInventory inventory = new ProductInventory();
        givenTheStock(productId, quantity, inventory);

        if (inventory.checkStock(productId) == quantity) {
            System.out.println("AddProductToInventory: Passed");
        } else {
            System.out.println("AddProductToInventory: Failed, the stock should be: " + quantity + " but is: " + inventory.checkStock(productId));
        }
    }

    private static void shouldRemoveProductFromInventory(String productId, Integer initialQuantity, int quantityToRemove) {
        ProductInventory inventory = new ProductInventory();
        givenTheStock(productId, initialQuantity, inventory);
        inventory.removeStock(productId, quantityToRemove);

        int quantityExpected = initialQuantity - quantityToRemove;
        if (inventory.checkStock(productId) == quantityExpected) {
            System.out.println("RemoveProductFromInventory: Passed");
        } else {
            System.out.println("RemoveProductFromInventory: Failed, the stock should be: " + quantityExpected + " but is: " + inventory.checkStock(productId));
        }
    }

    private static void givenTheStock(String productId, Integer quantity, ProductInventory inventory) {
        inventory.addStock(productId, quantity);
    }
}
