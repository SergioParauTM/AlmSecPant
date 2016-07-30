package ejemplo.sergio.almsecpant;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecActivity extends AppCompatActivity {

    private static TextView mostrado;
    File tarjeta = Environment.getExternalStorageDirectory();
    File fichero = new File(tarjeta.getAbsolutePath(), "info.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_main);

        mostrado = (TextView) findViewById(R.id.mostrarArchivo);

        try {



            // procedemos a abrir y leer fihcero
            FileInputStream fIn = new FileInputStream(fichero);

            InputStreamReader archivo = new InputStreamReader(fIn);

            BufferedReader br = new BufferedReader(archivo);

            String linea = br.readLine();
            String todo = "";
            while (linea != null) {
                todo = todo + linea + "\n";
                linea = br.readLine();
            }
            br.close();
            archivo.close();

            mostrado.setText(todo);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}


