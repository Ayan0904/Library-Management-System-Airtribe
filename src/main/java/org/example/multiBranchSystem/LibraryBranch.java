package org.example.multiBranchSystem;

import org.example.service.InventoryService;

import java.util.UUID;

public class LibraryBranch {
    private final String branchId;
    private String name;
    private InventoryService inventoryService;

    public LibraryBranch(String name) {
        this.branchId = UUID.randomUUID().toString();
        this.name = name;
        this.inventoryService = new InventoryService();
    }

    public String getBranchId() {
        return branchId;
    }

    public String getName() {
        return name;
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }
}
