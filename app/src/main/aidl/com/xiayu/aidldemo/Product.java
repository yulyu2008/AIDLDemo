package com.xiayu.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 创建者     罗夏雨
 * 创建时间   2017/2/23 13:56
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class Product implements Parcelable {
    public String name;
    public int    price;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.price);
    }
    public Product() {
    }

    protected Product(Parcel in) {
        this.name = in.readString();
        this.price = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
