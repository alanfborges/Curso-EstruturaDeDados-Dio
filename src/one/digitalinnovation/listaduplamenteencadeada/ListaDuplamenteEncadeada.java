package one.digitalinnovation.listaduplamenteencadeada;

public class ListaDuplamenteEncadeada<T> {

	private NoDuplo<T> primeiroNo;
	private NoDuplo<T> ultimoNo;

	private int tamanhoLista;

	public ListaDuplamenteEncadeada() {
		primeiroNo = null;
		ultimoNo = null;
		this.tamanhoLista = 0;
	}

	public T get(int index) {
		return this.getNo(index).getConteudo();
	}

	public void add(T elemento) {

		NoDuplo<T> novoNo = new NoDuplo<>(elemento);
		novoNo.setNoProximo(null);
		novoNo.setNoAnterior(ultimoNo);

		if (primeiroNo == null) {
			primeiroNo = novoNo;
		}

		if (ultimoNo != null) {
			ultimoNo.setNoProximo(novoNo);
		}
		ultimoNo = novoNo;
		tamanhoLista++;
	}

	public void add(int index, T elemento) {

		NoDuplo<T> noAuxiliar = getNo(index);
		NoDuplo<T> novoNo = new NoDuplo<>(elemento);
		
		novoNo.setNoProximo(noAuxiliar);

		if (novoNo.getNoProximo() != null) {
			novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
			novoNo.getNoProximo().setNoAnterior(novoNo);
		} else {
			novoNo.setNoAnterior(ultimoNo);
			ultimoNo = novoNo;
		}

		if (index == 0) {
			primeiroNo = novoNo;
		} else {
			novoNo.getNoAnterior().setNoProximo(novoNo);
		}

		tamanhoLista++;
	}

	public NoDuplo<T> getNo(int index) {
		NoDuplo<T> noAuxiliar = primeiroNo;
		for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
			noAuxiliar = noAuxiliar.getNoProximo();
		}
		return noAuxiliar;
	}

	public void remove(int index) {

		if (index == 0) {
			primeiroNo = primeiroNo.getNoProximo();
			if (primeiroNo != null) {
				primeiroNo.setNoAnterior(null);
			}
		} else {
			NoDuplo<T> noAuxiliar = getNo(index);
			noAuxiliar.getNoAnterior().setNoProximo(noAuxiliar.getNoProximo());
			if (noAuxiliar != ultimoNo) {
				noAuxiliar.getNoProximo().setNoAnterior(noAuxiliar.getNoAnterior());
			} else {
				ultimoNo = noAuxiliar;
			}
		}

		this.tamanhoLista--;
	}

	public int size() {
		return this.tamanhoLista;
	}

	@Override
	public String toString() {
		String strRetorn = "";

		NoDuplo<T> noAuxiliar = primeiroNo;
		for (int i = 0; i < size(); i++) {
			strRetorn += "[No{conteudo =" + noAuxiliar.getConteudo() + "}]<--->";
			noAuxiliar = noAuxiliar.getNoProximo();
		}

		strRetorn += "null";

		return strRetorn;
	}

}
