package com.example.android.surfaceviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    Camera camera;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;

    PictureCallback rawCallback;
    ShutterCallback shutterCallback;
    PictureCallback jpegCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        surfaceHolder.addCallback(this);

        // deprecated setting, but required on Android versions prior to 3.0
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        jpegCallback = new PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                FileOutputStream outStream = null;
                try {
                    outStream = new FileOutputStream(String.format("/sdcard/%d.jpg", System.currentTimeMillis()));
                    outStream.write(data);
                    outStream.close();
                    Log.d("Log", "onPictureTaken - wrote bytes: " + data.length);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, ""+e, Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Picture Saved", Toast.LENGTH_LONG).show();

                refreshCamera();

            }
        };

    }
    public void refreshCamera() {
        if(surfaceHolder.getSurface()==null){
            return;
        }

        camera.stopPreview();

        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }

        public void captureImage(View v){
        camera.takePicture(null, null, jpegCallback);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();
        Camera.Parameters param = camera.getParameters();

        param.setPreviewSize(352, 288);
        camera.setParameters(param);

        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e);

        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        refreshCamera();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera.stopPreview();
        camera.release();
        camera = null;


    }
}
