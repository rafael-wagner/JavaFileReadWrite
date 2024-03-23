package org.example.repositorioArquivos;


import org.example.repositorioArquivos.controller.EditarArquivo;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        EditarArquivo arquivo = new EditarArquivo("output1");

        for(int i=0; i<5; i++){
            arquivo.editar("l"+i);
        }

        EditarArquivo arquivo2 = new EditarArquivo("output2");
        for(int i=0; i<5; i++){
            arquivo2.escrever("l"+i);
        }

    }

}
