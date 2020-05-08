package com.tzh.aidlserver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * create by tuzanhua on 2020/4/30
 */
public class Book implements Parcelable {

    String name;
    double price;

    public Book() {
    }

    protected Book(Parcel in) {
        name = in.readString();
        price = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
