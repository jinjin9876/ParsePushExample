package yyy.xxx.pushexample;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

	private Context context;
	private LocationManager locationManager;
	private static final String TAG = "main";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#re
			// questPermissions for more details.
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
			return;
		}
		Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		Log.e(TAG, "ss location.getLongitude() ==>> " + location.getLongitude());
		Log.e(TAG, "ss location.getLatitude() ==>> " + location.getLatitude());

		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 20, 0, new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {
				Log.e(TAG, "location.getLongitude() ==>> " + location.getLongitude());
				Log.e(TAG, "location.getLatitude() ==>> " + location.getLatitude());

			}

			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {

			}

			@Override
			public void onProviderEnabled(String provider) {

			}

			@Override
			public void onProviderDisabled(String provider) {

			}
		});


	}
}
