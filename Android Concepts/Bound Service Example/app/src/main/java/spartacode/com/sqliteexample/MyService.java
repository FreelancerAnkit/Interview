package spartacode.com.sqliteexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {
    int value = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        value++;
                        Log.i("Thread Value",value+"");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    //Binding Service to Activity
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("OnBindMethod","In OnBind");
        return iBinder;
    }

    IBinder iBinder = new MyServiceBinder();
    class MyServiceBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

}
