package spartacode.com.sqliteexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Intent serviceintent;
    ServiceConnection serviceConnection;
    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myService = ((MyService.MyServiceBinder)iBinder).getService();
                Log.i("Service Value C",myService.value+"");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i("Service Disconnect","Disconnected");
                Log.i("Service Value D",myService.value+"");
            }
        };
        serviceintent = new Intent(this,MyService.class);
        startService(serviceintent);
        bindService(serviceintent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
