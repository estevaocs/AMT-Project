package br.com.itsstecnologia.jdbc.model;

import java.util.ArrayList;

import br.com.itsstecnologia.jdbc.dao.CelulaDao;

public class DiaSemana {
	
	public long id_dia;
	public Celula mt1;
	public Celula mt2;
	public Celula mt3;
	public Celula vp1;
	public Celula vp2;
	public Celula vp3;
	
	
	public DiaSemana(long id_dia, int mt1, int mt2, int mt3, int vp1, int vp2, int vp3) {
		CelulaDao dao = new CelulaDao();
		ArrayList<Celula> list = dao.getList();
		this.id_dia = id_dia;
		this.mt1 = list.get(getIndex(list, mt1));
		this.mt2 = list.get(getIndex(list, mt2));
		this.mt3 = list.get(getIndex(list, mt3));
		this.vp1 = list.get(getIndex(list, vp1));
		this.vp2 = list.get(getIndex(list, vp2));
		this.vp3 = list.get(getIndex(list, vp3));
	}
	
	public DiaSemana(long id_dia, Celula mt1, Celula mt2, Celula mt3, Celula vp1, Celula vp2, Celula vp3) {
		this.id_dia = id_dia;
		this.mt1 = mt1;
		this.mt2 = mt2;
		this.mt3 = mt3;
		this.vp1 = vp1;
		this.vp2 = vp2;
		this.vp3 = vp3;
	}

	public long getId_dia() {
		return id_dia;
	}

	public void setId_dia(long id_dia) {
		this.id_dia = id_dia;
	}

	public Celula getMt1() {
		return mt1;
	}

	public void setMt1(Celula mt1) {
		this.mt1 = mt1;
	}

	public Celula getMt2() {
		return mt2;
	}

	public void setMt2(Celula mt2) {
		this.mt2 = mt2;
	}

	public Celula getMt3() {
		return mt3;
	}

	public void setMt3(Celula mt3) {
		this.mt3 = mt3;
	}

	public Celula getVp1() {
		return vp1;
	}

	public void setVp1(Celula vp1) {
		this.vp1 = vp1;
	}

	public Celula getVp2() {
		return vp2;
	}

	public void setVp2(Celula vp2) {
		this.vp2 = vp2;
	}

	public Celula getVp3() {
		return vp3;
	}

	public void setVp3(Celula vp3) {
		this.vp3 = vp3;
	}

	private int getIndex(ArrayList<Celula> list, long id){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId_celula() == id) return i;
		}
		return -1;
	}
	
}
