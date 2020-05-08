package com.tzh.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * create by tuzanhua on 2020/4/30
 */
public class BookService extends Service {

    private static final String TAG = "BookService";
    List<Book> books = new ArrayList<>();

    IBookManager.Stub stub = new IBookManager.Stub() {
        @Override
        public List<Book> get() throws RemoteException {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (books.isEmpty()) {
                Book book = new Book();
                book.name = "none";
                book.price = 100.0;
                books.add(book);
            }


            return books;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            books.add(book);
            Log.e(TAG, "添加书籍了 :" + book.price + "   " + book.price);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "server onCreate" );
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(),"bind",Toast.LENGTH_LONG).show();
        Log.e(TAG, "server bind  :" + stub);
        return stub;
    }

}
