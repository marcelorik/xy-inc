package br.com.xy.pois;

public class POIs {

	private String nome;
	private int x;
	private int y;

	public POIs(String nome, int x, int y) {
		this.nome = nome;
		this.x = x;
		this.y = y;
	}

	public POIs() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isNear(int x, int y, int distance){
		return (Math.abs(x - this.x) + Math.abs(y - this.y)) <= distance;
	}

}
