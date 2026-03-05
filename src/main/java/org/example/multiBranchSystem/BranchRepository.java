package org.example.multiBranchSystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BranchRepository {
    private Map<String, LibraryBranch> branches = new HashMap<>();

    public void addBranch(LibraryBranch branch) {
        branches.put(branch.getBranchId(), branch);
    }

    public LibraryBranch getBranch(String branchId) {
        return branches.get(branchId);
    }

    public Collection<LibraryBranch> getAllBranches() {
        return branches.values();
    }
}
