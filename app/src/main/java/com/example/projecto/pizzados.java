package com.example.projecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class pizzados extends AppCompatActivity {

    Spinner spinner;
    String respuesta;
    CheckBox cb1, cb2, cb3, cb4;
    RadioGroup rGroup;
    RadioButton rButton;
    RatingBar rBar;
    TextView txtNombre;
    TextView txtIngredientes;
    TextView txtPrecio;
    TextView result;
    List<list_Elements> elem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzados);

        cb1 = findViewById(R.id.cbTomate);
        cb2 = findViewById(R.id.cbMostaza);
        cb3 = findViewById(R.id.cbBbq);
        cb4 = findViewById(R.id.cbSweetchilli);

        rGroup = findViewById(R.id.rgBebida);

        txtPrecio = findViewById(R.id.txtPrecio);
        txtIngredientes = findViewById(R.id.txtIngredientes);
        txtNombre = findViewById(R.id.txtNombre);
        result = findViewById(R.id.result);

        //RatingBar
        rBar = findViewById(R.id.rBar);
        rBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(pizzados.this,"Usted calificó con: "+v,Toast.LENGTH_SHORT).show();
            }
        });


        //Spinner
        spinner = findViewById(R.id.spinner);
        String[] acompanamientos = {"Palitos de ajo","Alitas de pollo"," Papas fritas","Brownie"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,acompanamientos);
        spinner.setAdapter(adapter);

        //Obtener datos del array para setearlos en la actividad en su TextView correspondiente
        elem = new ArrayList<>();
        elem.add(new list_Elements(R.drawable.p2,"Pizza 2","Jamón Serrano, Champiñones, Cebolla morada, Queso","$12.000"));

        txtNombre.setText(elem.get(0).getName());
        txtIngredientes.setText(elem.get(0).getIngredientes());
        txtPrecio.setText(elem.get(0).getPrecio());
    }
    public void comprar(View v){

        //Spinner
        String seleccion = spinner.getSelectedItem().toString();
        if (seleccion.equals("Palitos de ajo")){
            respuesta = "se ha seleccionado Palitos de ajo";
        }
        else if (seleccion.equals("Papas fritas")){
            respuesta ="se ha seleccionado Papas fritas";
        }
        else if (seleccion.equals("Brownie")){
            respuesta ="se ha seleccionado Brownie";
        }

        //CheckBox
        String cbSelect="";
        if (cb1.isChecked()==true){
            cbSelect += "salsa de tomate ";
        }
        if (cb2.isChecked()==true){
            cbSelect += "salsa de mostaza ";
        }
        if (cb3.isChecked()==true){
            cbSelect += "salsa de BBQ ";
        }
        if (cb4.isChecked()==true){
            cbSelect += "salsa de Sweet Chilli ";
        }

        //RadioGroup/Button
        int selectId = rGroup.getCheckedRadioButtonId();
        rButton = findViewById(selectId);
        String res;
        if (selectId==-1){
            res = "No has seleccionado una bebida";
        }else{
            res = rButton.getText().toString();
        }
        result.setText("Seleccionó: "+cbSelect+"\nBebida: "+res+"\ntotal: "+txtPrecio.getText());
    }
    //ImageButton para volver al Menú
    public void Back(View v){
        Intent back = new Intent(this, Menu.class);
        startActivity(back);
    }
}