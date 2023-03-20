package one.digitalinnovation.arvoriabinaria;

public class ArvoreBinaria<T extends Comparable<T>> {

	private BinNo<T> raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public void inserir(T conteudo) {
		BinNo<T> novoNo = new BinNo<>(conteudo);
		raiz = inserir(raiz, novoNo);
	}

	private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
		if (atual == null) {
			return novoNo;
		} else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
			atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
		} else {
			atual.setNoDir(inserir(atual.getNoDir(), novoNo));
		}
		return atual;
	}

	public void exibirInOrdem() {
		System.out.print("\n Exibindo InOrdem \n");
		exibirInOrdem(this.raiz);
	}

	private void exibirInOrdem(BinNo<T> atual) {
		if (atual != null) {
			exibirInOrdem(atual.getNoEsq());
			System.out.print(atual.getConteudo() + ", ");
			exibirInOrdem(atual.getNoDir());
		}

	}

	public void exibirPosOrdem() {
		System.out.print("\n Exibindo PosOrdem \n");
		exibirPosOrdem(this.raiz);
	}

	private void exibirPosOrdem(BinNo<T> atual) {
		if (atual != null) {
			exibirPosOrdem(atual.getNoEsq());
			exibirPosOrdem(atual.getNoDir());
			System.out.print(atual.getConteudo() + ", ");
		}

	}

	public void exibirPreOrdem() {
		System.out.print("\n Exibindo PreOrdem \n");
		exibirPreOrdem(this.raiz);
	}

	private void exibirPreOrdem(BinNo<T> atual) {
		if (atual != null) {
			System.out.print(atual.getConteudo() + ", ");
			exibirPreOrdem(atual.getNoEsq());
			exibirPreOrdem(atual.getNoDir());
		}
	}

	public void remover(T conteudo) {
		try {
			BinNo<T> atual = this.raiz;
			BinNo<T> pai = null;
			BinNo<T> filho = null;
			BinNo<T> temp = null;
			
			//laço para percorrer todos os nos da arvore ate que o conteudo seja encontrado ou chegue no final da arvora.
			//o loop sera feito ate que o no atual seja null.
			//ou o conteudo passado for igual o conteudo na arvore.			
			while (atual != null && !atual.getConteudo().equals(conteudo)) {
				pai = atual;
				//testando se o conteudo passado é menor que o no atual da arvore
				if (conteudo.compareTo(atual.getConteudo()) < 0) {
					atual = atual.getNoEsq();
				} else {
					atual = atual.getNoDir();
				}
			}
			//o conteudo nao foi encontrado na arvore
			if (atual == null) {
				System.out.println("Conteudo nao encontrado. Bloco Try");
			}
			//realocando os nos descendentes do no q tiramos
			if(pai == null) {
				if(atual.getNoDir() == null) {
					this.raiz = atual.getNoEsq();
				}else if(atual.getNoEsq() == null) {
					this.raiz = atual.getNoDir();
				}else {
					for(temp =atual, filho = atual.getNoEsq();
						filho.getNoDir() != null;
						temp = filho, filho = filho.getNoEsq()){
						
						if(filho != atual.getNoEsq()){
							temp.setNoDir(filho.getNoEsq());
							filho.setNoEsq(raiz.getNoEsq());
						}
					}
					filho.setNoDir(raiz.getNoDir());
					raiz = filho;
				}
			//se a referencia do no a direita for igual a null
			//testaremos o no a esquerda
			}else if(atual.getNoDir() == null) {
				//se a referencia de no a esq do no pai for igual a atual
				if(pai.getNoEsq() == atual) {
					//setaremos a referencia do no a esquerda com o no atualEsq.
					pai.setNoEsq(atual.getNoEsq());				
				}else {
					//setaremos a referencia do no a direita com o no atualEsq.
					pai.setNoDir(atual.getNoEsq());
				}
			//se a referencia da esquerda do no atual for null	
			//testaremos o no a esquerda	
			}else if(atual.getNoEsq() == null) {
				//se a referencia de no a esq do no pai for igual a atual
				if(pai.getNoEsq() == atual) {
					//setaremos a referencia do no a direita com o no atualDir.
					pai.setNoEsq(atual.getNoDir());				
				}else {
					//setaremos a referencia do no a direita com o no atualDir.
					pai.setNoDir(atual.getNoDir());
				}
			//
			}else {
				for(temp = atual, filho = atual.getNoEsq();
					filho.getNoDir() != null;
					temp = filho, filho = filho.getNoDir()){
					
					if(filho != atual.getNoEsq()){
						temp.setNoDir(filho.getNoEsq());
						filho.setNoEsq(atual.getNoEsq());
					}
					filho.setNoDir(atual.getNoDir());
					if(pai.getNoEsq() == atual) {
						pai.setNoEsq(filho);
					}else {
						pai.setNoDir(filho);
					}
				}
			}
			
		} catch (NullPointerException e) {
			System.out.println("Conteudo nao encontrado. Bloco catch");
		}
	}

}
