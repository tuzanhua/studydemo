package com.tzh.aidlclient;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tzh.aidlserver.Book;
import com.tzh.aidlserver.IBookManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IBookManager iBookManager;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.tzh.aidlserver");
                intent.setPackage("com.tzh.aidlserver");
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<Book> books = iBookManager.get();
                    Log.e(TAG, books.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.name = Math.random() + "新书";
                book.price = Math.random() + 200;
                try {
                    iBookManager.addBook(book);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.btn_loacl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemoService.class);
                startService(intent);
            }
        });

        findViewById(R.id.btn_loacl_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemoService.class);
                bindService(intent, serviceConnection1, Service.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemoService.class);
                stopService(intent);
            }
        });

        findViewById(R.id.btn_unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 只可以解绑一次 绑定的时候会将service 注册 解绑的时候会unregister  如果再次调用那么会 抛出 not register 异常
                unbindService(serviceConnection1);
            }
        });
    }

    ServiceConnection serviceConnection1 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "onServiceDisconnected");
        }
    };

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "链接上了");
            iBookManager = IBookManager.Stub.asInterface(service);
            Log.e(TAG, "iBookManager :" + iBookManager);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
