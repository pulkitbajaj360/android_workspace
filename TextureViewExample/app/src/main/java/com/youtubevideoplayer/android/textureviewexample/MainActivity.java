package com.youtubevideoplayer.android.textureviewexample;

import android.hardware.Camera;
import android.graphics.SurfaceTexture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    private TextureView myTexture;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myTexture = new TextureView(this);
        myTexture.setSurfaceTextureListener(this);
        setContentView(myTexture);
    }


    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int heght) {
        mCamera = Camera.open();//Creating object of Camera Class;

        //Getting previewSize of camera;
        Camera.Size previewSize = mCamera.getParameters().getPreviewSize();

        //Setting params on layout like width, height and position
        myTexture.setLayoutParams(new FrameLayout.LayoutParams(previewSize.width,previewSize.height,Gravity.CENTER));

        try {
            //Setting SurfaceTexture to camera
            mCamera.setPreviewTexture(surface);
        } catch (IOException e) {
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }

        //Starting camera
        mCamera.startPreview();
        myTexture.setAlpha(1.0f);
        myTexture.setRotation(90.0f);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
