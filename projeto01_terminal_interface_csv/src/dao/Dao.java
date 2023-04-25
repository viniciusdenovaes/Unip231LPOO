package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import dados.Dados;
import entidades.Pato;

public class Dao {
	
	private String filePath;
	private Dados dados;
	
	public Dao(String aFilePath, Dados dados) {
		this.dados = dados;
		this.filePath = aFilePath;
	}
	
	public void loadPatos(){
        try (   InputStream is = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String id = palavras[0];
                String nome = palavras[1];
                int idade = Integer.parseInt(palavras[2]);
                double peso = Double.parseDouble(palavras[3]);

                Pato pato = new Pato(id, nome, idade, peso);
                dados.addPato(pato);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
		
	}

    public void savePatos(){

        try(    OutputStream os = new FileOutputStream(filePath/*, true*/);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Pato p: dados.getPatos()){
                pw.println(p.getId()+","+p.getNome()+","+p.getIdade()+","+p.getPeso());
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
