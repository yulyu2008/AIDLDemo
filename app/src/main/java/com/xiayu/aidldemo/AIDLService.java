package com.xiayu.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * 创建者     罗夏雨
 * 创建时间   2017/2/23 10:12
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class AIDLService extends Service {

    Product mProduct;

    private Binder mBinder = new IShop.Stub() {

        @Override
        public Product buy() throws RemoteException {
            return mProduct;
        }

        @Override
        public void setProduct(Product product) throws RemoteException {
            mProduct = product;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
