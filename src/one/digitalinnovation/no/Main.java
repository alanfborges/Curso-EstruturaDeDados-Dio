package one.digitalinnovation.no;

public class Main {

	public static void main(String[] args) {
		
		No<String> no1 = new No<String>("Conteúdo no1");

		No<String> no2 = new No<String>("Conteúdo no2");
		no1.setProximo(no2);
		
		No<String> no3 = new No<String>("Conteúdo no3");		
		no2.setProximo(no3);
		
		No<String> no4 = new No<String>("Conteúdo no4");
		no3.setProximo(no4);
		
		//no1-> no2-> no3-> no4-> null
		
		System.out.println(no1);
		System.out.println(no1.getProximo());
		System.out.println(no2);
		
		System.out.println("----------------------");
		
		System.out.println(no1);
		System.out.println(no1.getProximo());
		System.out.println(no1.getProximo().getProximo());
		System.out.println(no1.getProximo().getProximo().getProximo());
		System.out.println(no1.getProximo().getProximo().getProximo().getProximo());
	
	}

}
