// IShop.aidl
package com.xiayu.aidldemo;

import com.xiayu.aidldemo.Product;

interface IShop {

    Product buy();

    void setProduct(in Product product);

}
