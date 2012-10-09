package com.my.sensors;

import com.example.mysensor.R;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class allsensor extends Activity implements SensorEventListener {
	 	private static final String TAG = "Mysensor";
	    SensorManager sm = null;
	    
	    TextView nameAccView = null;
	    TextView xViewA = null;
	    TextView yViewA = null;
	    TextView zViewA = null;
	    
	    TextView nameOriView = null;
	    TextView xViewO = null;
	    TextView yViewO = null;
	    TextView zViewO = null;
	    
	    TextView nameMagView = null;
	    TextView xViewM = null;
	    TextView yViewM = null;
	    TextView zViewM = null;

	    TextView nameGravityView = null;
	    TextView xViewG = null;
	    TextView yViewG = null;
	    TextView zViewG = null;
	    
	    TextView nameGyroscopeView = null;
	    TextView xViewGy = null;
	    TextView yViewGy = null;
	    TextView zViewGy = null;
	    
	    TextView nameProximityView = null;
	    TextView xViewPro = null;
	    
	    TextView nameLightView = null;
	    TextView xViewLig = null;
	    
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       // get reference to SensorManager
	        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
	        setContentView(R.layout.main);

	        nameAccView = (TextView) findViewById(R.id.name_accelerometer);
	        xViewA = (TextView) findViewById(R.id.xbox);
	        yViewA = (TextView) findViewById(R.id.ybox);
	        zViewA = (TextView) findViewById(R.id.zbox);
	        
	        nameOriView = (TextView) findViewById(R.id.name_orientation);
	        xViewO = (TextView) findViewById(R.id.xboxo);
	        yViewO = (TextView) findViewById(R.id.yboxo);
	        zViewO = (TextView) findViewById(R.id.zboxo);
	        
	        nameMagView = (TextView) findViewById(R.id.name_magnetic);
	        xViewM = (TextView) findViewById(R.id.xboxm);
	        yViewM = (TextView) findViewById(R.id.yboxm);
	        zViewM = (TextView) findViewById(R.id.zboxm);
	        
	        nameGravityView = (TextView) findViewById(R.id.name_gravity);
	        xViewG = (TextView) findViewById(R.id.xboxg);
	        yViewG = (TextView) findViewById(R.id.yboxg);
	        zViewG = (TextView) findViewById(R.id.zboxg);
	        
	        nameGyroscopeView = (TextView) findViewById(R.id.name_gyroscope);
	        xViewGy = (TextView) findViewById(R.id.xboxgy);
	        yViewGy = (TextView) findViewById(R.id.yboxgy);
	        zViewGy = (TextView) findViewById(R.id.zboxgy);
	        
	        nameProximityView = (TextView) findViewById(R.id.name_proximity);
	        xViewPro = (TextView) findViewById(R.id.xboxpro);
	        
	        nameLightView = (TextView) findViewById(R.id.name_light);
	        xViewLig = (TextView) findViewById(R.id.xboxlig);
	    }
	    
	    public void onSensorChanged(SensorEvent event) {
	        synchronized (this) {
	            //Log.d(TAG, "onSensorChanged: " + event.sensor.getType() + ", x: " + 
	            //			event.values[0] + ", y: " + event.values[1] + ", z: " + event.values[2]);
	            if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
	            	nameOriView.setText("Orientation name : " + event.sensor.getName());
	                xViewO.setText("Orientation X: " + event.values[0]);
	                yViewO.setText("Orientation Y: " + event.values[1]);
	                zViewO.setText("Orientation Z: " + event.values[2]);
	            }
	            
	            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
	            	nameAccView.setText("Accelerometer name : " + event.sensor.getName());
	                xViewA.setText("Accel X: " + event.values[0]);
	                yViewA.setText("Accel Y: " + event.values[1]);
	                zViewA.setText("Accel Z: " + event.values[2]);
	            }
	            
	            if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
	            	nameMagView.setText("Magnetic field device name : " + event.sensor.getName());
	            	xViewM.setText("Magnetic field X: " + event.values[0] + " uT");
	            	yViewM.setText("Magnetic field Y: " + event.values[1] + " uT");
	            	zViewM.setText("Magnetic field Z: " + event.values[2] + " uT");
	            }
	            
	            if (event.sensor.getType() == Sensor.TYPE_GRAVITY) {
	            	nameGravityView.setText("Gravity device name : " + event.sensor.getName());
	            	xViewG.setText("Gravity X: " + event.values[0] + " m/s2");
	            	yViewG.setText("Gravity Y: " + event.values[1] + " m/s2");
	            	zViewG.setText("Gravity Z: " + event.values[2] + " m/s2");
	            }
	            
	            if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
	            	nameGyroscopeView.setText("Gyroscope device name : " + event.sensor.getName());
	            	xViewGy.setText("Gyroscope X: " + event.values[0] + " rad/s");
	            	yViewGy.setText("Gyroscope Y: " + event.values[1] + " rad/s");
	            	zViewGy.setText("Gyroscope Z: " + event.values[2] + " rad/s");
	            	
	            }
	            
	            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
	            	nameProximityView.setText("Proximity device name : " + event.sensor.getName());
	            	xViewPro.setText("Proximity distance : " + event.values[0] + " cm");
	            }
	            
	            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
	            	nameLightView.setText("Light device name : " + event.sensor.getName());
	            	xViewLig.setText("Light illumination : " + event.values[0] + " lx");
	            	
	            }
	        }
	    }
	    
	    public void onAccuracyChanged(int sensor, int accuracy) {
	    	//Log.d(TAG,"onAccuracyChanged: " + sensor + ", accuracy: " + accuracy);
	    }
	    
	    @Override
	    protected void onResume() {
	        super.onResume();
	      // register this class as a listener for the orientation and accelerometer sensors
	        sm.registerListener(this,
	                sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
	                SensorManager.SENSOR_DELAY_NORMAL);
	        
	        sm.registerListener(this,
	                sm.getDefaultSensor(Sensor.TYPE_ORIENTATION),
	                SensorManager.SENSOR_DELAY_NORMAL);
	        
	        sm.registerListener(this,
	                sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
	                SensorManager.SENSOR_DELAY_NORMAL);
	        
	        sm.registerListener(this,
	        		sm.getDefaultSensor(Sensor.TYPE_GRAVITY),
	        		SensorManager.SENSOR_DELAY_NORMAL);
	        
	        sm.registerListener(this,
	        		sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
	        		SensorManager.SENSOR_DELAY_NORMAL);
	        
	        sm.registerListener(this,
	        		sm.getDefaultSensor(Sensor.TYPE_PROXIMITY),
	        		SensorManager.SENSOR_DELAY_NORMAL);
	        
	        sm.registerListener(this,
	        		sm.getDefaultSensor(Sensor.TYPE_LIGHT),
	        		SensorManager.SENSOR_DELAY_NORMAL);
	        		
	    }
	    
	    @Override
	    protected void onStop() {
	        // unregister listener
	        sm.unregisterListener(this);
	        super.onStop();
	    }

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}

}
