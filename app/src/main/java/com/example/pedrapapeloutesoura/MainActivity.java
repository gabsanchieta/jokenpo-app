package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().hide();
    }

    //recebe dos botões através do evento onClick o valor da opção selecionada pelo usuário
    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    //executa a lógica principal do jogo
    public void opcaoSelecionada(String opcaoSelecionada){

        //recebe e armazena as referências dos objetos para serem utilizados
        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);

        //sorteia um número de 0 a 3 para ser a opção do app
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        //muda a imagem da opção do app de acordo com a opção sorteada
        switch ( opcaoApp ) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        //verifica qual opção escolhida leva a melhor e muda o texto na tela
        if(
                (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ){ //App ganhou
            textoResultado.setText("Você Perdeu...");
        }else if(
                (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")
        ){ //Usuário ganhou
            textoResultado.setText("Você Ganhou!");
        }else{ //Empate
            textoResultado.setText("Empate.");
        }
    }
}