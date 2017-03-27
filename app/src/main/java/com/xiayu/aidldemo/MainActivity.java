package com.xiayu.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent mIntent;
    private XiayuConnection mXiayuConnection;
    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent(this, AIDLService.class);
        mXiayuConnection = new XiayuConnection();
        mProduct = new Product();
        mProduct.name = "xiayu";
        mProduct.price = 50;
    }

    public void change(View v) {
//        mProduct.price = new Random().nextInt(100);
        System.out.println("change" + mProduct.price);
    }
    public void bind(View v) {
        bindService(mIntent, mXiayuConnection, BIND_AUTO_CREATE);
    }
    public void unbind(View v) {
        unbindService(mXiayuConnection);
    }

    private class  XiayuConnection implements ServiceConnection{

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        IShop iShop = IShop.Stub.asInterface(service);
        try {
            iShop.setProduct(mProduct);
            Product buy = iShop.buy();
            System.out.println("buy="+buy.price);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
