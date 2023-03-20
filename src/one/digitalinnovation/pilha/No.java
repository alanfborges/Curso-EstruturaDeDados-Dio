package one.digitalinnovation.pilha;

public class No {

	private int dado;
	
	private No ref_No;

	public No(int dado) {
		this.dado = dado;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public No getRef_No() {
		return ref_No;
	}

	public void setRef_No(No Ref_No) {
		this.ref_No = Ref_No;
	}

	@Override
	public String toString() {
		return "No [dado=" + dado + "]";
	}
	
}
