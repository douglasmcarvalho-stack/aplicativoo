package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class Funcionario extends AppCompatActivity {

    EditText edtNome, edtSalario, edtExtra;
    Spinner spinnerTipo;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.funcionario);

        edtNome = findViewById(R.id.edtNome);
        edtSalario = findViewById(R.id.edtSalario);
        edtExtra = findViewById(R.id.edtExtra);
        spinnerTipo = findViewById(R.id.spinnerTipo);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tipo = spinnerTipo.getSelectedItem().toString();
                if(tipo.equals("Estagiário")){
                    edtExtra.setVisibility(View.GONE);
                } else {
                    edtExtra.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtNome.getText().toString();
                float salario = Float.parseFloat(edtSalario.getText().toString());
                String tipo = spinnerTipo.getSelectedItem().toString();
                float extra = 0;
                if(!edtExtra.getText().toString().isEmpty())
                    extra = Float.parseFloat(edtExtra.getText().toString());

                Funcionario f;
                switch (tipo){
                    case "Gerente":
                        f = new Gerente(nome, salario, extra);
                        break;
                    case "Desenvolvedor":
                        f = new Desenvolvedor(nome, salario, (int) extra);
                        break;
                    default:
                        f = new Estagiario(nome, salario);
                }

                txtResultado.setText("Nome: " + f.nome + "\nSalário final: " + f.calcularSalario());
            }
        });
    }


    public static class Funcionario {
        protected String nome;
        protected float salario_base;
        public Funcionario(String nome, float salario_base){
            this.nome = nome;
            this.salario_base = salario_base;
        }
        public float calcularSalario(){
            return salario_base;
        }
    }

    public static class Gerente extends Funcionario {
        private float bonus;
        public Gerente(String nome, float salario_base, float bonus){
            super(nome, salario_base);
            this.bonus = bonus;
        }
        @Override
        public float calcularSalario(){
            return salario_base + bonus;
        }
    }

    public static class Desenvolvedor extends Funcionario {
        private int horasExtras;
        public Desenvolvedor(String nome, float salario_base, int horasExtras){
            super(nome, salario_base);
            this.horasExtras = horasExtras;
        }
        @Override
        public float calcularSalario(){
            return salario_base + (horasExtras * 50);
        }
    }

    public static class Estagiario extends Funcionario {
        public Estagiario(String nome, float salario_base){
            super(nome, salario_base);
        }
        @Override
        public float calcularSalario(){
            return salario_base * 0.8f;
        }
    }
}
