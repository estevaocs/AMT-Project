package br.com.itsstecnologia.jdbc.model;

public class Turma {
	
	private long id_turma;
	private Instrutor instrutor;
	private Horario horario;
	private String area;
	private String local;
	private String	periodo;

	public Turma(long id_turma, Instrutor instrutor, Horario horario, String area, String local, String periodo)
			throws Exception {
		
		this.id_turma = id_turma;
		this.instrutor = instrutor;
		this.horario = horario;
		if(area.equals(instrutor.getArea())) {
		this.area = area;
		} else {
			throw new Exception("Instrutor não expecialista");
		}
		this.local = local;
		this.periodo = periodo;
	}

	public long getId_turma() {
		return id_turma;
	}

	public void setId_turma(long id_turma) {
		this.id_turma = id_turma;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
		this.instrutor.setHorario(horario, this.periodo);
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
}
