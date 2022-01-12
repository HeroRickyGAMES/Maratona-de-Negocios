package com.temposmodernos.maratonadenegocios;

//Programado por HeroRickyGames
//Desenvolvido com varias queimas de categorias pensando em codigo

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    //Icones da interface
    private EditText nome;
    private EditText idade;
    private EditText CEP;
    private EditText opiniao;
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("Pessoa1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Comunicação do codigo com a interface grafica e os elementos graficos!
        nome = findViewById(R.id.editNome);
        idade = findViewById(R.id.editIdade);
        CEP = findViewById(R.id.editCEP);
        opiniao = findViewById(R.id.editOpiniao);

        //classe
        EnviarRelatorio();
    }

    public void EnviarRelatorio(){

        //referencias
        nome.getText();
        idade.getText();
        CEP.getText();
        opiniao.getText();

        //Enviar pra o DB
        referencia.child("pessoa").setValue(nome);
        referencia.child("pessoa").setValue(idade);
        referencia.child("pessoa").setValue(CEP);
        referencia.child("pessoa").setValue(opiniao);

    }
}