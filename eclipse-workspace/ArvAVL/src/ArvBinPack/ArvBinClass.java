package ArvBinPack;
import java.util.ArrayList;

public class ArvBinClass {
	public No raiz;
	public ArrayList<No> ordem ;
	public int alturaDaArvore;
	
	void ArvBinPack(){
		this.raiz = null;
	}
	public void insertNo(No no, No referencia ){
		//No inicio no referencia precisa ser raiz
		
		if(referencia == null){ 
			// Se raiz nulo isso vai ser raiz
			referencia = no;
		}
		else if(no.varNo < referencia.varNo){ // Se menor vá pra esquerda
			referencia = referencia.filhoEsc;
			insertNo(no, referencia);
		}
		else if(no.varNo > referencia.varNo){
			referencia = referencia.filhoDir;
			insertNo(no, referencia);
		}
	}
	public No popNo(No no){
		/* Casos de remoção
		 * Nó folha: remove as referencias e cabou
		 * Nó tem 2 filhos: 1 pra direita e depois desce até o final pra esqueda e substitui
		 * no tem 1 filho: o 1 filho subistitui o pai
		*/
		No achado = findNo(no, this.raiz);
		// Corte as relações
		if(achado.filhoDir == null && achado.filhoEsc == null){
			// Nó é folha
			// É maior ou menor que pai? Se menor Esq se maior DirV
			if(achado == achado.noPai.filhoEsc){
				achado.noPai.filhoEsc = null;
			}
			else if(achado == achado.noPai.filhoDir){
				achado.noPai.filhoDir = null;
			}
			achado.noPai = null;
		}
		// Tem um unico filho (é esquerdo ou direito? o nó a ser removido é um filho esq ou dir?)
		else if(achado.filhoDir == null && achado.filhoEsc != null || achado.filhoDir != null && achado.filhoEsc == null){
			if(achado == achado.noPai.filhoEsc){
				//Achado É filho Esq 
				if(achado.filhoEsc != null){
					//Filho na esquerda
					achado.filhoEsc.noPai = achado.noPai;
					achado.noPai.filhoEsc = achado.filhoEsc;
					achado.noPai = null;
					achado.filhoEsc = null;
				} else if(achado.filhoDir != null){
					//Filho na direita
					achado.filhoDir.noPai = achado.noPai;
					achado.noPai.filhoEsc = achado.filhoDir;
					achado.noPai = null;
					achado.filhoDir = null;
				}
			}
			else if(achado == achado.noPai.filhoDir){
				//Achado É Filho Dir
				if(achado.filhoEsc != null){
					//Filho na esquerda
					achado.filhoEsc.noPai = achado.noPai;
					achado.noPai.filhoDir = achado.filhoEsc;
					achado.noPai = null;
					achado.filhoEsc = null;
				} else if(achado.filhoDir != null){
					//Filho na direita
					achado.filhoDir.noPai = achado.noPai;
					achado.noPai.filhoDir = achado.filhoDir;
					achado.noPai = null;
					achado.filhoDir = null;
				}
			}
		}
		
		// Tem 2 filhos
		if(achado.filhoDir != null && achado.filhoEsc != null){
			No substituto = achado.filhoDir; // desce um pra dir eo resto pra esc
			// se substituto n tem filhos esquerdo vai ele mesmo
			if(substituto.filhoEsc == null){
				if(achado.noPai.filhoEsc == achado){
					//achado é filho esquerdo
					achado.noPai.filhoEsc = substituto;
					substituto.noPai = achado.noPai;
					achado.noPai = null;
					achado.filhoDir = null;

				}else{
					//achado é filho direito
					achado.noPai.filhoDir = substituto;
					substituto.noPai = achado.noPai;
					achado.noPai = null;
					achado.filhoDir = null;
				}
			} else{
				substituto = descePraEsq(substituto);
				substituto.noPai.filhoEsc = null;
				substituto.noPai = achado.noPai;
				substituto.filhoEsc = achado.filhoEsc;
				substituto.filhoDir = achado.filhoDir;
				achado.filhoDir = null;
				achado.filhoEsc = null;
				achado.noPai = null;
			}
		}
		return achado;
	}
	public No descePraEsq(No substituto){
		if (substituto.filhoEsc != null){
			substituto = substituto.filhoEsc;
			descePraEsq(substituto);
		}
		return substituto;
	}
	
	// Passe raiz e seu alvo
	public No findNo(No no, No referencia){ 
		//No referencia começa como raiz
		if(referencia == null){ 
			 System.out.println("Arvore vazia ou referecia não existe");
		}
		else if(no.varNo < referencia.varNo){ // Se menor vá pra esquerda
			referencia = referencia.filhoEsc;
			findNo(no, referencia);
		}
		else if(no.varNo > referencia.varNo){
			referencia = referencia.filhoDir;
			findNo(no, referencia);

		}else if(no == referencia){
			System.out.println("No: " + referencia.varNo);
			System.out.println("Pai: "+ referencia.noPai.varNo);
			System.out.println("Filho Esq: " + referencia.filhoEsc.varNo);
			System.out.println("Filho Dir: " + referencia.filhoDir.varNo);
		}
		return referencia;
	}
	
	public void printArvore(){

		emOrdem(raiz);
		this.alturaDaArvore = altura(this.raiz);
		//precisa saber o dep de cada nó
		
		int matriz[][] = new int[this.alturaDaArvore][this.ordem.size()];

		//tentando inserir na tabela
		for(int i = 0; i < this.ordem.size(); i++){
			No no = this.ordem.get(i);
			//falta inserir


		}

		// Falta rotações
		// Falta print
	}

	public void emOrdem(No no){
		if(no != null){
			emOrdem(no.filhoEsc);
			this.ordem.add(no);
			emOrdem(no.filhoDir);
		}
	}

	public int altura(No raiz){
        // caso base: árvore vazia tem altura 0
        if (raiz == null) {
            return -1;
        }
        // recorre para a subárvore esquerda e direita e considera a profundidade máxima
        return 1 + Math.max(altura(raiz.filhoEsc), altura(raiz.filhoDir));
    }
	public int deepNo(No alvo){
		No esseNo = findNo(this.raiz, alvo);
		int conte = 0;
		while (esseNo.noPai != null){
			conte = conte + 1;
			esseNo = esseNo.noPai;
		}
		return conte;
	}
}