package one.digitalinnovation.listaduplamenteencadeada;

public class Main {

	public static void main(String[] args) {
		
		ListaDuplamenteEncadeada<String> minhaListaEncateada = new ListaDuplamenteEncadeada<String>();
		
		minhaListaEncateada.add("c1");
		minhaListaEncateada.add("c2");
		minhaListaEncateada.add("c3");
		minhaListaEncateada.add("c4");
		minhaListaEncateada.add("c5");
		minhaListaEncateada.add("c6");
		minhaListaEncateada.add("c7");

		System.out.println(minhaListaEncateada);
		
		minhaListaEncateada.remove(3);
		minhaListaEncateada.add(3, "99");
		System.out.println(minhaListaEncateada.get(3));

	}

}
