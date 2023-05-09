package dao.csv;

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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import entidades.Pato;

public class DaoCSV implements Dao{
	
	private Path dirPath;
	private final Path fileName = Paths.get("patos.csv");
	private Path filePath;
	
	public DaoCSV(Path aDirPath) {
		this.dirPath = aDirPath;
		this.filePath = aDirPath.resolve(this.fileName);
	}
	
	public DaoCSV(String aDirPath) {
		this(Paths.get(aDirPath));
	}
	
	@Override
	public boolean addPato(Pato p) {
        try(    OutputStream os = new FileOutputStream(filePath.toString(), true);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
        	if(this.getPatoById(p.getId())!=null) {
        		return false;
        	}
        	pw.println(p.getId()+","+p.getNome()+","+p.getIdade()+","+p.getPeso());
        	return true;

        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public List<Pato> getTodosPatos() {
		List<Pato> patos = new ArrayList<>();
        try (   InputStream is = new FileInputStream(filePath.toFile());
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
                patos.add(pato);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
		
		return patos;
	}

	@Override
	public List<Pato> getPatosByNome(String keyName) {
		List<Pato> patos = new ArrayList<>();
        try (   InputStream is = new FileInputStream(filePath.toFile());
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String id = palavras[0];
                String nome = palavras[1];
                if(!nome.toLowerCase().contains(keyName.toLowerCase())) {
                	continue;
                }
                int idade = Integer.parseInt(palavras[2]);
                double peso = Double.parseDouble(palavras[3]);

                Pato pato = new Pato(id, nome, idade, peso);
                patos.add(pato);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
		
		return patos;
	}

	@Override
	public Pato getPatoById(String theId) {
        try (   InputStream is = new FileInputStream(filePath.toString());
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String id = palavras[0];
                if(theId.equals(id)) {
                    String nome = palavras[1];
                    int idade = Integer.parseInt(palavras[2]);
                    double peso = Double.parseDouble(palavras[3]);
                    Pato pato = new Pato(id, nome, idade, peso);
                    return pato;
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
		
		return null;
	}

}
