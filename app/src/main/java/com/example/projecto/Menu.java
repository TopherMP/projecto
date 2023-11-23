package com.example.projecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    List<list_Elements> elem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        elementos();
    }
    public void elementos(){
        elem = new ArrayList<>();
        elem.add(new list_Elements(R.drawable.p1,"Pizza 1","Pepperoni, Queso, Orégano","$8.000"));
        elem.add(new list_Elements(R.drawable.p2,"Pizza 2","Jamón Serrano, Champiñones, Cebolla morada, Queso","$12.000"));
        elem.add(new list_Elements(R.drawable.p3,"Pizza 3","Pepperoni, Jamón, Queso, Pimiento verde","$10.000"));
        elem.add(new list_Elements(R.drawable.p4,"Pizza 4","Piña, Tomate, Carne mechada, Pollo","$14.000"));

        ListaAdaptador lista = new ListaAdaptador(elem,this);
        RecyclerView recycler = findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(lista);
    }
    public void Back(View v){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
}