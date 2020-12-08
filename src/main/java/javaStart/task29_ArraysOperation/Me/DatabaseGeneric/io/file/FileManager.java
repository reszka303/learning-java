package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io.file;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model.ItemDatabase;

public interface FileManager {
    void write(ItemDatabase itemDatabase);
    ItemDatabase read();
}
