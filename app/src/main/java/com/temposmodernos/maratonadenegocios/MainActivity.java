package com.temposmodernos.maratonadenegocios;

//Programado por HeroRickyGames

//Desenvolvido com vários dias de programação e queima de caloria pensando em corrigir bugs!

//Se você está aqui é porque quer aprender como eu programei, enfim tentei resumir um pouco como que eu fiz esse codigo!

//Espero que aprendam bastante com esse app!

//O app é totalmente de codigo aberto!

//Os codigos aqui podem ser reutilizados em outros apps como base para criação de outros projetos!

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        //db
        database = FirebaseDatabase.getInstance();
    }

    public void EnviarRelatorio(View view){

        //referencias
        String nomedb = nome.getText().toString();
        String idadedb = idade.getText().toString();
        String CEPdb = CEP.getText().toString();
        String opiniaodb = opiniao.getText().toString();

        //Enviar pra o DB
        referencia.child(nomedb).child("nome").setValue(nomedb);
        referencia.child(nomedb).child("idade").setValue(idadedb);
        referencia.child(nomedb).child("cep").setValue(CEPdb);
        referencia.child(nomedb).child("opiniao").setValue(opiniaodb);
        
        //e se os campos estiverem vazios?
        if(nomedb.isEmpty() || idadedb.isEmpty() || CEPdb.isEmpty() || opiniaodb.isEmpty()){

            //Toast para notificação se está vazio
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
       
        }

    }

}