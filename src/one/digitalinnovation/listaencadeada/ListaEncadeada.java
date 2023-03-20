package one.digitalinnovation.listaencadeada;

public class ListaEncadeada<T> {

	private No<T> ref_No_Entrada;

	public ListaEncadeada() {
		this.ref_No_Entrada = null;
	}

	public boolean isEmpty() {
		return ref_No_Entrada == null ? true : false;
	}

	public void add(T conteudo) {
		No<T> novoNo = new No<>(conteudo);
		if (this.isEmpty()) {
			ref_No_Entrada = novoNo;
			return;
		}

		No<T> noAuxiliar = ref_No_Entrada;
		for (int i = 0; i < this.size() - 1; i++) {
			noAuxiliar = noAuxiliar.getProximoNo();
		}

		noAuxiliar.setProximoNo(novoNo);
	}

	private No<T> getNo(int index) {
		validaIndice(index);
		No<T> noAuxiliar = ref_No_Entrada;
		No<T> noRetorno = null;
		for (int i = 0; i <= index; i++) {
			noRetorno = noAuxiliar;
			noAuxiliar = noAuxiliar.getProximoNo();
		}
		return noRetorno;
	}

	private void validaIndice(int index) {
		if (index >= size()) {
			int ultimoIndice = size() - 1;
			throw new IndexOutOfBoundsException(
					"Não existe conteúdo no indice " + index + 
					" desta lista so vai até o indice " + ultimoIndice);
		}

	}

	public T get(int index) {
		return getNo(index).getConteudo();
	}

	public T remove(int index) {
		No<T> noPivor = this.getNo(index);
		if (index == 0) {
			ref_No_Entrada = noPivor.getProximoNo();
			return noPivor.getConteudo();
		}

		No<T> noAnterior = getNo(index - 1);
		noAnterior.setProximoNo(noPivor.getProximoNo());
		return noPivor.getConteudo();
	}

	public int size() {
		int tamanhoLista = 0;
		No<T> referenciaAux = ref_No_Entrada;
		while (true) {
			if (referenciaAux != null) {
				tamanhoLista++;
				if (referenciaAux.getProximoNo() != null) {
					referenciaAux = referenciaAux.getProximoNo();
				} else {
					break;
				}
			} else {
				break;
			}
		}

		return tamanhoLista;
	}

	@Override
	public String toString() {
		
		String strRetorno = "";
		No<T> noAuxiliar = ref_No_Entrada;
		for(int i=0; i<this.size(); i++) {
			strRetorno+= "No [conteudo=" + noAuxiliar.getConteudo() + "]-->";
			noAuxiliar = noAuxiliar.getProximoNo();
		}
		strRetorno+=null;
		 return strRetorno;
	}
	
}
