package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

public class ProductInventoryManualTest {
    public static void main(String[] args) {
        ProductInventory inventory = new ProductInventory();

        String productId = "123";
        Integer quantity = 10;
        inventory.addStock(productId, quantity);

        if (inventory.checkStock(productId) == quantity) {
            System.out.println("AddProductToInventory: Passed");
        } else {
            System.out.println("AddProductToInventory: Failed the stock should be" + quantity + " but is " + inventory.checkStock(productId));
        }

        inventory.removeStock(productId, 5);

        if (inventory.checkStock(productId) == 5) {
            System.out.println("RemoveProductFromInventory: Passed");
        } else {
            System.out.println("RemoveProductFromInventory: Failed the stock should be" + quantity + "but is " + inventory.checkStock(productId));
        }

        try {
            inventory.removeStock(productId, 15);
            System.out.println("ThrowExceptionWhenRemovingMoreStockThanAvailable: Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("ThrowExceptionWhenRemovingMoreStockThanAvailable: Passed");
        }
    }
}
