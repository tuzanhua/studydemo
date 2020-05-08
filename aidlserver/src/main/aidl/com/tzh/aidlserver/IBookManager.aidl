// IBookManager.aidl
package com.tzh.aidlserver;

// Declare any non-default types here with import statements
import com.tzh.aidlserver.Book;
interface IBookManager {
          List<Book> get();
          void addBook(in Book book);

}
