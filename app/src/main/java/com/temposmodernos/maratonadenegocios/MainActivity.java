package com.temposmodernos.maratonadenegocios;

//Programado por HeroRickyGames
//Desenvolvido com varias queimas de categorias pensando em codigo

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    //Icones da interface
    private EditText nome;
    private EditText idade;
    private EditText CEP;
    private EditText opiniao;
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("Formularios");

    //Data base
    private FirebaseDatabase database;
    private ValueEventListener valueEventListener;

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



        //db
        database = FirebaseDatabase.getInstance();
    }

    public void EnviarRelatorio(View view){

        //referencias
        //nome.getText();
        idade.getText();
        CEP.getText();
        opiniao.getText();

        String nomedb = nome.getText().toString();
        String idadedb = idade.getText().toString();
        String CEPdb = CEP.getText().toString();
        String opiniaodb = opiniao.getText().toString();

        //Enviar pra o DB
        referencia.child(nomedb).child("nome").setValue(nomedb);
        referencia.child(nomedb).child("idade").setValue(idadedb);
        referencia.child(nomedb).child("cep").setValue(CEPdb);
        referencia.child(nomedb).child("opiniao").setValue(opiniaodb);


    }
}