package org.example.multiBranchSystem;

import org.example.model.BookItem;

public class BranchService {
    public void transferBook(
            BookItem bookItem,
            LibraryBranch fromBranch,
            LibraryBranch toBranch
    ) {

        fromBranch.getInventoryService()
                .removeBookCopy(bookItem);

        toBranch.getInventoryService()
                .addBookCopy(bookItem);
    }
}
