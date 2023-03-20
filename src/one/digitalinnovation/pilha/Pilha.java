package one.digitalinnovation.pilha;

public class Pilha {

	private No refNoTopPilha;

	public Pilha() {
		this.refNoTopPilha = null;
	}

	public No pop() {

		if (!this.isEmpty()) {
			No noPoped = refNoTopPilha;
			refNoTopPilha = refNoTopPilha.getRef_No();
			return noPoped;
		}
		return null;
	}

	public void push(No novoNo) {
		//no aux vai receber a referencia de entrada da pilha
		No refAuxiliar = refNoTopPilha;
		//no de entrada ira receber a referencia do novo no.
		refNoTopPilha = novoNo;
		
		refNoTopPilha.setRef_No(refAuxiliar);
	}

	public No top() {
		return refNoTopPilha;
	}

	public boolean isEmpty() {

		if (refNoTopPilha == null) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String stringRetorno = "----------------\n";
		stringRetorno += "    Pilha\n";
		stringRetorno += "--------------\n";

		No noAuxiliar = refNoTopPilha;

		while (true) {
			if (noAuxiliar != null) {
				stringRetorno += "[No{dado = " + noAuxiliar.getDado() + "}]\n";
				noAuxiliar = noAuxiliar.getRef_No();
			} else {
				break;
			}
		}
		
		stringRetorno+= "============\n";
		return stringRetorno;
	}

}
