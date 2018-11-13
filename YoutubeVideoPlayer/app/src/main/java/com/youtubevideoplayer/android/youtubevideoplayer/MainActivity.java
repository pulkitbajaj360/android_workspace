package com.youtubevideoplayer.android.youtubevideoplayer;

        import android.app.Activity;
        import android.os.Environment;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.BufferedReader;
        import java.io.DataInputStream;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    EditText name, address, number, email, adhar;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        number = findViewById(R.id.number);
        email = findViewById(R.id.email);
        adhar = findViewById(R.id.adhar);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag=true;
                if (validateUserName(name.getText().toString())) {
                    flag=false;
                    Toast.makeText(MainActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                }

                if(address.getText().toString().length()<5)
                {   flag=false;
                    Toast.makeText(MainActivity.this, "Please enter minimum five digit address", Toast.LENGTH_SHORT).show();}

                if(number.getText().toString().length()==10) {
                    flag=false;
                    Toast.makeText(MainActivity.this, "Please enter a valid mobile number", Toast.LENGTH_SHORT).show();}

                if(email.getText().toString().length()<5) {
                    flag=false;
                    Toast.makeText(MainActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();}

                if(adhar.getText().toString().length()==16) {
                    flag = false;
                    Toast.makeText(MainActivity.this, "Please enter a valid sixteen digit adhaar number", Toast.LENGTH_SHORT).show();
                }


                if(flag)
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

            }
        });

    }



        public boolean validateUserName(String userName) {

            int i;
            char byt;
            boolean flag=false;
            for(i=0;i<=userName.length()-1;i++)
            {
                byt=userName.charAt(i);
                if(!((byt>=65&&byt<=90)||(byt>=97&&byt<=122))) {
                    if (byt == 32 && userName.charAt(0) != 32&& userName.charAt(1) != 32&& userName.charAt(2) != 32)
                        continue;
                    flag = true;
                    Toast.makeText(this, "A name can contain letters a-z, A-Z, and white space after three letters", Toast.LENGTH_SHORT).show();
                }
            }
            if(!flag)
                if(userName.length()<3) {
                    flag = true;
                    Toast.makeText(this, "A name can not be less than three letters", Toast.LENGTH_SHORT).show();
                }
            return flag;
        }


    }

/*

public class MainActivity extends Activity {
    EditText inputText;
    TextView response;
    Button saveButton,readButton;

    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText) findViewById(R.id.myInputText);
        response = (TextView) findViewById(R.id.response);


        saveButton =
                (Button) findViewById(R.id.saveExternalStorage);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = new FileOutputStream(myExternalFile);
                    fos.write(inputText.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputText.setText("");
                response.setText("SampleFile.txt saved to External Storage...");
            }
        });

        readButton = (Button) findViewById(R.id.getExternalStorage);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = new FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br =
                            new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    myData="";
                    while ((strLine = br.readLine()) != null) {
                        myData = myData + strLine;
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputText.setText(myData);
                response.setText("SampleFile.txt data retrieved from Internal Storage...");
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveButton.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }


    }
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }


}

*/
