package one.digitalinnovation.fila;

public class Fila <T>{

	private No <T> ref_No_Entrada_Fila;

	public Fila() {
		this.ref_No_Entrada_Fila = null;
	}

	public void enqueue(T object) {
		No novoNo = new No(object);
		novoNo.setRef_prox_no(ref_No_Entrada_Fila);
		ref_No_Entrada_Fila = novoNo;
	}

	public T first() {
		if (!this.isEmpty()) {
			No primeiroNo = ref_No_Entrada_Fila;
			while (true) {
				if (primeiroNo.getRef_prox_no() != null) {
					primeiroNo = primeiroNo.getRef_prox_no();
				} else {
					break;
				}
			}
			return(T) primeiroNo.getObject();
		}
		return null;
	}

	public T dequeue() {
		if (!this.isEmpty()) {
			No primeiroNo = ref_No_Entrada_Fila;
			No noAuxiliar = ref_No_Entrada_Fila;
			while (true) {
				if (primeiroNo.getRef_prox_no() != null) {
					noAuxiliar = primeiroNo;
					primeiroNo = primeiroNo.getRef_prox_no();
				} else {
					noAuxiliar.setRef_prox_no(null);
					break;
				}
			}
			return (T)primeiroNo.getObject();
		}
		return null;
	}

	public boolean isEmpty() {
		return ref_No_Entrada_Fila == null ? true : false;
	}

	@Override
	public String toString() {
		String stringRetorno = "";
		No noAuxiliar = ref_No_Entrada_Fila;
		
		if(ref_No_Entrada_Fila != null) {
			while(true) {
				stringRetorno+= "[No{objeto=" + noAuxiliar.getObject() + "}]--->";
				
				if(noAuxiliar.getRef_prox_no() != null) {
					noAuxiliar = noAuxiliar.getRef_prox_no();
				}else {
					stringRetorno+=null;
					break;
				}
			}
		}else {
			stringRetorno = null;
		}
		
		return stringRetorno;
	}
	
	
}
