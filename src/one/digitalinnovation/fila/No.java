package one.digitalinnovation.fila;

public class No<T> {
	
	private T object;
	private No <T> ref_prox_no;
	
	public No(T object) {
		this.ref_prox_no = null;
		this.object = object;
	}
	
	public No() {
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public No getRef_prox_no() {
		return ref_prox_no;
	}

	public void setRef_prox_no(No refno) {
		this.ref_prox_no = refno;
	}

	@Override
	public String toString() {
		return "No [object=" + object + "]";
	}
	
}
