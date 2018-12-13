package spartacode.com.myapplication;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermission();

        int seconds = 3;
        Intent intent = new Intent(this, MyReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (seconds * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + seconds + " seconds", Toast.LENGTH_LONG).show();

    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.VIBRATE},
                1);
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.VIBRATE);
        if (PackageManager.PERMISSION_GRANTED == permissionCheck){
        }
    }

}
