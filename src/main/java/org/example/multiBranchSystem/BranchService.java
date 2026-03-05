package org.example.multiBranchSystem;

import org.example.model.BookItem;

import java.util.logging.Logger;

public class BranchService {

    private static final Logger logger =
            Logger.getLogger(BranchService.class.getName());

    public void transferBook(
            BookItem bookItem,
            LibraryBranch fromBranch,
            LibraryBranch toBranch
    ) {

        logger.info("Transferring book: "
                + bookItem.getBook().getTitle()
                + " from "
                + fromBranch.getName()
                + " to "
                + toBranch.getName());

        fromBranch.getInventoryService()
                .removeBookCopy(bookItem);

        toBranch.getInventoryService()
                .addBookCopy(bookItem);

        logger.info("Book transfer completed");
    }
}