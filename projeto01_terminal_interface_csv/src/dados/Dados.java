package dados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entidades.Pato;

public class Dados {
	
	private Map<String, Pato> patos = new TreeMap<>();
	
	public Map<String, Pato> getPatosById(){
		return this.patos;
	}
	
	
	// Retorna false se ja existe pato com este id
	public boolean addPato(Pato p) {
		if(patos.containsKey(p.getId())) {
			return false;
		}
		this.patos.put(p.getId(), p);
		
		return true;
	}
	
	public Collection<Pato> getPatos(){
		return this.patos.values();
	}
	
	
	// Retorna nulo caso nao exista o id
	public Pato getPatoById(String id) {
		return patos.get(id);
	}
	
	public List<Pato> getPatosByNome(String keyName){
		
		List<Pato> patosByName = new ArrayList<>();
		
		for(Pato p: patos.values()) {
			if(p.getNome().toLowerCase().contains(keyName.toLowerCase())){
				patosByName.add(p);
			}
		}
		return patosByName;
	}
	
}
