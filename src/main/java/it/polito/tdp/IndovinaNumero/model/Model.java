package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {
	
	private int segreto;
	private final int TMAX = 8;
	private final int NMAX = 100;
	private int tentativiFatti;
	private Set<Integer> tentativi;	
	private boolean InGioco = false;
	
	public void nuovaPartita() {
		
		tentativi = new HashSet<Integer>();
		//gestione di una nuova partita
    	this.segreto = (int)((Math.random() * NMAX) +1);
    	this.tentativiFatti = 0;
    	this.InGioco = true;
	}
	
	public int tentativo(int tentativo) {
		
		if(!InGioco)
			throw new IllegalStateException("La partita è terminata! Hai perso!");
		
		if(!tentativoValido(tentativo)) {
    		throw new InvalidParameterException("Devi inserire un numero tra 1 e " + NMAX + " che non hai ancora utilizzato");
    	}
    	
		this.tentativiFatti ++;
		this.tentativi.add(tentativo);
		
		if(this.tentativiFatti == TMAX) {
			this.InGioco = false;
		}
		
		if(tentativo == segreto) {
			this.InGioco = false;
			return 0;
		} else if(tentativo < segreto) {
			return -1;
		} else {
			return 1;
		}
		
	}

	private boolean tentativoValido(int tentativo) {
		if (tentativo < 1 || tentativo > NMAX || tentativi.contains(tentativo))
			return false;
		return true;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getNMAX() {
		return NMAX;
	}
	
	

}
