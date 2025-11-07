package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaCompras extends AppCompatActivity {

    private EditText edtItem;
    private Button btnAdicionar;
    private ListView listViewItens;

    private ArrayList<String> listaItens;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras);

        edtItem = findViewById(R.id.edtItem);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        listViewItens = findViewById(R.id.listViewItens);

        listaItens = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaItens);
        listViewItens.setAdapter(adapter);

        btnAdicionar.setOnClickListener(v -> {
            String item = edtItem.getText().toString().trim();
            if (!item.isEmpty()) {
                listaItens.add(item);
                adapter.notifyDataSetChanged();
                edtItem.setText("");
            } else {
                Toast.makeText(ListaCompras.this, "Digite um item", Toast.LENGTH_SHORT).show();
            }
        });

        listViewItens.setOnItemClickListener((parent, view, position, id) -> {
            String itemRemovido = listaItens.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(ListaCompras.this, "Removido: " + itemRemovido, Toast.LENGTH_SHORT).show();
        });
    }
}
