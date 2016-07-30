package ejemplo.sergio.almsecpant;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static EditText nombree;
    private  static EditText dnii;
    private  static EditText fecha ;
   private  static EditText sexo;
    private static Button guardar;
    private static Button mostrar;


    File tarjeta = Environment.getExternalStorageDirectory();
    File fichero = new File(tarjeta.getAbsolutePath(),"info.txt");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guardar = (Button) findViewById(R.id.guardar);
        mostrar = (Button) findViewById(R.id.mostrar);
        dnii =(EditText) findViewById(R.id.editText2Dni);
        nombree=(EditText) findViewById(R.id.editTextNom);
        fecha =(EditText)findViewById(R.id.editTextFecha);
       sexo = (EditText)findViewById(R.id.sex);

//llamamos al metodo guardar al presionar el boton
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });

        //Llamamos al metodo mostrado cuando presionamos boton
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrado();

            }
        });





    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_power:
                Toast.makeText(this, "ha seleccionado:apagar", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.action_settings:
                Toast.makeText(this, "ha selecionado, opciones", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_saw:
                Toast.makeText(this, "ha selecionado, ver", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }


    public void guardar() {

        String nom = nombree.getText().toString();
        String dd= dnii.getText().toString();
        String ffecha = fecha.getText().toString();
        String Sexo = sexo.getText().toString();

        //Completo nos guardara aquellos datos que introduzcamos en pantalla en un fichero

        String completo = ("\n"+ "nombre: "+nom+ "\n" +"dni: " + dd+ "\n" + "fecha: "+ffecha +  "\n"+ "sexo: "+Sexo);

        try {


        //creamos fichero
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream(fichero));

//escribimos en fichero los datos introducidos
            osw.write(completo);
            osw.close();

            Toast.makeText(this, "guardado correctamente",
                    Toast.LENGTH_SHORT).show();
        } catch (IOException ioe) {
            Toast.makeText(this, "No se pudo guardar",
                    Toast.LENGTH_SHORT).show();
        }


    }

  public void mostrado(){

      // lo que hacemos es llamar al segundo Activity  una vez clikeamos sobre el boton mostrar
      Intent llamada = new Intent(MainActivity.this, SecActivity.class);
      startActivity(llamada);
  }
}
