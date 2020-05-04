/*
Ciencia da Computação - Pucminas
AEDs II
Pedro Henrique Lima Carvalho
Matricula: 651230
TP 3 - Q04
*/

import java.util.Date;


/**
* Classe Personagem
*/
class Personagem {

//atributos
	private String nome;
	private int altura;
	private double peso;
	private String corDoCabelo;
	private String corDaPele;
	private String corDosOlhos;
	private String anoNascimento;
	private String genero;
	private String homeworld;

//construtores
	Personagem(String nome, int altura, double peso, String corDoCabelo,
		   String corDaPele, String corDosOlhos, String anoNascimento,
		   String genero, String homeworld){

		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.corDoCabelo = corDoCabelo;
		this.corDaPele = corDaPele;
		this.corDosOlhos = corDosOlhos;
		this.anoNascimento = anoNascimento;
		this.genero = genero;
		this.homeworld = homeworld;
	}

	Personagem(String endereco){
		Arq.openRead(endereco);
		String lida = Arq.readLine();
		Arq.close();
		
		String[] dados = parsePersonagem(lida);
	
		this.nome = dados[0];
		try{
			this.altura = Integer.parseInt(dados[1]);
		}
		catch(Exception e){
			this.altura = 0;
		}
		try{
			dados[2]=dados[2].replaceAll(",", "");
			this.peso = Double.parseDouble(dados[2]);
		}
		catch(Exception e){
			this.peso = 0;
		}
		this.corDoCabelo = dados[3];
		this.corDaPele = dados[4];
		this.corDosOlhos = dados[5];
		this.anoNascimento = dados[6];
		this.genero = dados[7];
		this.homeworld = dados[8];		
	}

//metodos
 //gets
	/*
	*getNome
	*@return String nome
	*/
	public String getNome(){
		return(this.nome);
	}

	/*
	*getAltura
	*@return int altura
	*/
	public int getAltura(){
		return(this.altura);
	}

	/*
	*getPeso
	*@return double peso
	*/
	public double getPeso(){
		return(this.peso);
	}
	
	/*
	*get corDoCabelo
	*@return String corDoCabelo 
	*/
	public String getCorDoCabelo(){
		return(this.corDoCabelo);
	}

	/*
	*getCorDaPele
	*@return String corDaPele
	*/
	public String getCorDaPele(){
		return(this.corDaPele);
	}

	/*
	*getCorDosOlhos
	*@return String corDosOlho
	*/
	public String getCorDosOlhos(){
		return(this.corDosOlhos);
	}

	/*
	*getAnoNascimento
	*@return String anoNascimento
	*/
	public String getAnoNascimento(){
		return(this.anoNascimento);
	}

	/*
	*getGenero
	*@return String genero
	*/
	public String getGenero(){
		return(this.genero);
	}

	/*
	*getHomeworld
	*@return String homeworld
	*/
	public String getHomeworld(){
		return(this.homeworld);
	}

//sets
	/*
	*setNome
	*@param String nome
	*/
	public void setNome(String nome){
		this.nome = nome;
	}	

	/*
	*setAltura
	*@param int altura
	*/
	public void setAlgura(int altura){
		this.altura = altura;
	}

	/*
	*setPeso
	*@param double peso
	*/
	public void setPeso(double peso){
		this.peso = peso;
	}

	/*
	*setCorDoCabelo
	*@param String corDoCabelo
	*/
	public void setCorDoCabelo (String corDoCabelo){
		this.corDoCabelo = corDoCabelo;
	}

	/*
	*setCorDaPele
	*@param String corDaPele
	*/
	public void setCorDaPelo(String corDaPelo){
		this.corDaPele = corDaPele;
	}

	/*
	*setCorDosOlhos
	*@param String corDosOlhos
	*/
	public void setCorDosOlhos(String corDosOlhos){
		this.corDosOlhos = corDosOlhos;
	}

	/*
	*setAnoNascimento
	*@param String anoNascimento
	*/
	public void setAnoNascimento(String anoNascimento){
		this.anoNascimento = anoNascimento;
	}

	/*
	*setGenero
	*@param String genero
	*/
	public void setGenero(String genero){
		this.genero = genero;
	}

	/*
	*setHomeworld
	*@param String homeworld
	*/
	public void setHomeworld(String homeworld){
		this.homeworld = homeworld;
	}

//clone
	/*
	*clone
	*@param Personagem
	*@return Personagem
	*/
	public Personagem clone(Personagem a){
		return (new Personagem(a.nome, a.altura, a.peso, a.corDoCabelo,
			a.corDaPele, a.corDosOlhos, a.anoNascimento, a.genero,
			a.homeworld));
	}

//imprimir
	/*
	*imprimir
	*/
	public void imprimir(){
		MyIO.print(" ## "+this.nome);
		MyIO.print(" ## "+this.altura);
		if (this.peso%1==0)
			MyIO.print(" ## "+(int)this.peso);
		else
			MyIO.print(" ## "+this.peso);
		MyIO.print(" ## "+this.corDoCabelo);
		MyIO.print(" ## "+this.corDaPele);
		MyIO.print(" ## "+this.corDosOlhos);
		MyIO.print(" ## "+this.anoNascimento);
		MyIO.print(" ## "+this.genero);
		MyIO.print(" ## "+this.homeworld);
		MyIO.println(" ## ");

	}

//ler
	/*
	*ler
	*@return String com dados do personagem
	*/
	public String ler(){
		String s = " ## "+this.nome+" ## "+this.altura+" ## ";

		if (this.peso%1==0)
			s = s + (int)this.peso;
		else
			s = s + this.peso;
		s = s + " ## "+this.corDoCabelo+" ## "+this.corDaPele+" ## "+ 
		        this.corDosOlhos+" ## "+this.anoNascimento+" ## "+this.genero+
		        " ## "+this.homeworld+" ## ";	
		return s;
	}

//compareTo
	/*
	*@param Personagem a ser comparado e int da operacao
	*@return <0 se this menor q param, 0 se igual, >0 se maior
	*/
	public double compareTo (Personagem p, int op){
		double resp = 0.0;
	
		switch (op){	
			case 1:
  			 resp = this.altura - p.altura;
			 break;
			case 2:
			 resp = this.peso - p.peso;
			 break;
			case 3:
			 resp = this.corDoCabelo.compareTo(p.corDoCabelo);
			 break;
			case 4:
			 resp = this.corDaPele.compareTo(p.corDaPele);
			 break;
			case 5:
			 resp = this.corDosOlhos.compareTo(p.corDosOlhos);
			 break;
			case 6:
			 resp = this.anoNascimento.compareTo(p.anoNascimento);
			 break;
			case 7:
			 resp = this.genero.compareTo(p.genero);
			 break;
			case 8:
			 resp = this.homeworld.compareTo(p.homeworld);
			 break;
			default:
				resp = this.nome.compareTo(p.nome);
		}
		
		if (resp==0){
			resp = this.nome.compareTo(p.nome);
		}
		return resp;
	}	

//metodos estaticos publicos

 //isFim
	/**
	*isFim - verifica FIM
	*@param String
	*@return boolean
	*/
	public static boolean isFim(String s){
		return (s.equals("FIM"));
	}

 //toIso
	/**
	*toIso - muda o encoding de uma String para ISO
	*@param String UTF-8
	*@return String ISO
	*/
	public static String toIso(String s) throws Exception{
		return (new String(s.getBytes("UTF-8"), "ISO-8859-1"));
	}

 //toUtf
	/**
	*toUtf - muda o encoding de uma String para UTF-8
	*@param String ISO
	*@return String UTF-8
	*/
	public static String toUtf(String s) throws Exception{
		return(new String(s.getBytes("ISO-8859-1"), "UTF-8"));
	}

 //parsePersonagem
	/**
	*parsePersonagem - Separa os atributos do personagem de uma String
	*@param String
	*@return String[]
	*/
	private static String[] parsePersonagem(String s){
		String[] dados = new String[9];

		int init = 0;
		int end = -1;
		
		for (int i=0; i<9; i++){
			init = s.indexOf("\'", end+1)+1;
			end = s.indexOf("\'", init);
			init = s.indexOf("\'", end+1)+1;
			end = s.indexOf("\'", init);
			dados[i] = s.substring(init, end);
		}
		return (dados);
	}
}

/**
*Classe Celula
*/
class Celula{
 //atributos
	public Celula ant;
	public Personagem elemento;
	public Celula prox;

 //construtores
	public Celula(Personagem p){
		this.ant=null;
		this.elemento=p;
		this.prox=null;
	}
	
	public Celula(){
		this.ant=null;
		this.elemento=null;
		this.prox=null;
	}
}

/**
*Classe Lista Flexivel
*/
class Lista{
 //atributos
	private Celula primeiro;
	private Celula ultimo;

 //contrutotres
	public Lista(){
		this.primeiro = new Celula();
		this.ultimo = primeiro;
	}

//inserir
	/**
	*inserirInicio - insere um elemento no inicio da lista
	*@param Personagem elemento
	*/
	public void inserirInicio(Personagem p){
		Celula tmp = new Celula(p);
		tmp.prox=primeiro.prox;
		tmp.ant=primeiro;
		primeiro.prox=tmp;
		if (primeiro==ultimo)
			ultimo=primeiro.prox;
		else
			tmp.prox.ant=tmp;
		tmp=null;
	}

	/**
	*inserirFim - insere um elemento no fim da lista
	*@param Personagem elemento
	*/
	public void inserirFim(Personagem p){
		ultimo.prox = new Celula(p);
		ultimo.prox.ant=ultimo;
		ultimo=ultimo.prox;

	}

	/**
	*tamanho - retorna o tamanho da lista
	*@return tamanho int
	*/
	private int tamanho(){
		int resp = 0;
		for(Celula i=primeiro.prox; i!=null; i=i.prox){
			resp++;
		}
		return resp;
	}

	/**
	*inserir - insere um elemento em determinada posicao
	*@param Personagem elemento, int pos;
	*/
	public void inserir(Personagem p, int pos) throws Exception{
		int tamanho = tamanho();
		
		if (pos>tamanho || pos<0)
			throw new Exception ("Posicao Inexistente");
		else if (pos==tamanho)
			inserirFim(p);
		else if (pos==0)
			inserirInicio(p);
		else{
			Celula i=primeiro;
			for(int j=0; j<pos; j++, i=i.prox);
			
			Celula tmp = new Celula(p);
			tmp.prox = i.prox;
			tmp.ant=i;
			tmp.prox.ant=tmp;
			i.prox=tmp;
			i=tmp=null;
		}

	}

 //remover
	/**
	*removerInicio - remove um elemento do inicio da lista
	*@return Personagem elemento
	*/
	public Personagem removerInicio() throws Exception{
		if(primeiro==ultimo)
			throw new Exception("Lista Vazia");
		
		Celula tmp = primeiro;
		primeiro = primeiro.prox;
		tmp.prox=null;
		primeiro.ant=null;
		tmp=null;
		return (primeiro.elemento);
		
	}

	/*removerFim - remove um elemento do fim da lista
	*@return Personagem elemento
	*/
	public Personagem removerFim() throws Exception{
		if(primeiro==ultimo)
			throw new Exception("Lista Vazia");
		
		Personagem p=ultimo.elemento;
	
		ultimo=ultimo.ant;
		ultimo.prox.ant=null;
		ultimo.prox=null;		
	
		return p;
	}
	
	/*remover - remove um elemento da posicao
	*@param int posicao
	*@return Personagem p
	*/
	public Personagem remover(int pos) throws Exception{
		int tamanho = tamanho();
		Personagem p;

		if(pos<0 || pos>tamanho-1)
			throw new Exception("Posicao Inexistente");
		else if (pos==0)
			p=removerInicio();
		else if (pos==tamanho-1)
			p=removerFim();
		else{
			Celula i = primeiro.prox;
			for(int j=0; j<pos; j++, i=i.prox);
			
			p=i.elemento;

			i.prox.ant=i.ant;
			i.ant.prox=i.prox;
				
			i.ant=i.prox=null;
			i=null;
		}
		
		return p;
	}

 //mostrar
	/**
	*mostrar lista
	*/
	public void mostrar(){
		int j=0;
		for (Celula i=primeiro.prox; i!=null; i=i.prox, j++){
			MyIO.println("["+j+"] "+ i.elemento.ler());
		}
	}

	/**
	*mostrar lista sem posicao
	*/
	public void mostrar(char c){
		for(Celula i=primeiro.prox; i!=null; i=i.prox){
			MyIO.println(i.elemento.ler());
		}
	}

 //comandos
	/**
	*comandos - executa os comandos contidos em um string
	*@param String com comandos
	*/
	public void comandos(String s) throws Exception{
		String[] parsed = s.split(" ");
		
		if (parsed[0].equals("II")){
			this.inserirInicio(new Personagem(parsed[1]));
		}
		else if (parsed[0].equals("IF")){
			this.inserirFim(new Personagem(parsed[1]));
		}
		else if (parsed[0].equals("I*")){
			this.inserir(new Personagem(parsed[2]), Integer.parseInt(parsed[1]));
		}
		else if (parsed[0].equals("RI")){
			Personagem p = this.removerInicio();
			MyIO.println("(R) "+p.getNome());
		}
		else if (parsed[0].equals("RF")){
			Personagem p = this.removerFim();
			MyIO.println("(R) "+p.getNome());
		}		
		else if (parsed[0].equals("R*")){
			Personagem p = this.remover(Integer.parseInt(parsed[1]));
			MyIO.println("(R) "+p.getNome());

		}
	}
	
 //zerarPeso
	/**
	*zerarPeso - zera o peso dos elementos da lista
	*/
	public void zerarPeso(){
		for (Celula i=primeiro.prox; i!=null; i=i.prox){
			i.elemento.setPeso(0.0);
		}
	}
 
 //ordernar
	/**
	*swap - troca deois elementos da lista de posicao
	*@param Celula i, Celula j
	*/
	public void swap(Celula i, Celula j){
		Personagem buffer = i.elemento;
		i.elemento=j.elemento;
		j.elemento=buffer;
	}
	

	/**
	*ordernarQuickSort - ordena a lista pelo metodo QuickSort
	*@param int[] log para estatistica
	*/
	public void ordenarQuickSort(int[] log) throws Exception {
		if (primeiro==ultimo)
			throw new Exception ("Lista Vazia");
		quickSort(primeiro.prox, ultimo, log);
	}

	/**
	*goTo - retorna o ponteiro da celula entre outras duas
	*@param Celula i, Celula j
	*@return Celula meio;
	*/
	public Celula goTo (Celula i, Celula j){
		int tam = 0;
		Celula tmp;

		for (tmp=i; tmp!=j; tmp=tmp.prox, tam++);
		tmp=i;
		tam = tam/2;

		for (int k=0; k<tam; k++, tmp=tmp.prox);

		return tmp;
	}


	/**
	*quickSort - quickSort para lista flexivel duplamente encadeada
	*@param Celula esq, Celula dir, int[] log
	*/
	public void quickSort(Celula esq, Celula dir, int[] log){
		Personagem pivo = goTo(esq, dir).elemento;
		Celula i = esq;
		Celula j = dir;

		while (j.prox!=i && i.ant!=j && j.prox!=i.ant){
	
			log[0]+=2;
			while(i.elemento.compareTo(pivo, 3)<0){
				i=i.prox;
				log[0]++;
			}
			while(j.elemento.compareTo(pivo, 3)>0){
				j=j.ant;
				log[0]++;
			}
			
			if(j.prox!=i && i.ant!=j && j.prox!=i.ant){
				swap(i, j);
				i=i.prox;
				j=j.ant;
				log[1]+=3;
			}
		}

		if(i!=dir && i!=null){
			quickSort(i, dir, log);
		}
		if(j!=esq && j.prox!=esq){
			quickSort(esq, j, log);
		}
	}

}


/**
*Classe Main
*/
public class TP03Q07{
  		
	/**
	*tempo
	*@return long tempo
	*/
	public static long tempo(){
		return(new Date().getTime());
	}

				
	/**
	*Metodo main
	*/
	public static void main(String[] args) throws Exception{
		Lista list = new Lista();
		int[] log = new int[2];
		long inicio, fim;
		
		String input = MyIO.readLine();
		input = Personagem.toUtf(input);
		while(!Personagem.isFim(input)){
			list.inserirFim( new Personagem(input));
			input = MyIO.readLine();
			input = Personagem.toUtf(input);
		}
/*		
		int n = MyIO.readInt();
		
		for (int i=0; i<n; i++){
			input = MyIO.readLine();
			input = Personagem.toUtf(input);
			list.comandos(input);	
		}
*/
		inicio=tempo();
		list.ordenarQuickSort(log);
		fim=tempo();
		double segundos = ((double)(fim-inicio))/1000.0;
		
		//arquivo log
		Arq.openWrite("651230_quicksort3.txt");
		Arq.print("651230\t"+log[0]+"\t"+log[1]+"\t"+segundos);
		Arq.close();		

		list.mostrar('c');
	}	


}
