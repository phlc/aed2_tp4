/*
Ciencia da Computação - Pucminas
AEDs II
Pedro Henrique Lima Carvalho
Matricula: 651230
TP 4 - Q02
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
*Classe Node
*/
class Node{
 //atributos
	public int elemento;
	public Node esq;
	public Node dir;
	public NodeString raizString;

 //construtores
	public Node (int x, Node esq, Node dir, NodeString raizString){
		this.elemento = x;
		this.esq = esq;
		this.dir = dir;
		this.raizString = raizString;
	}
	public Node(int x){
		this(x, null, null, null) ;
	}
	
	public Node(){
		this(0);
	}
}

/**
Classe NodeString
*/
class NodeString{
 //atributos
	public String nome;
	public NodeString esq;
	public NodeString dir;
	
 //construtores
	public NodeString(String nome, NodeString esq, NodeString dir){
		this.nome = nome;
		this.esq = esq;
		this.dir = dir;
	}
	public NodeString(String nome){
		this(nome, null, null);
	}
}
/**
*Classe Arvore
*/
class Arvore{
 //atributos
	private Node raiz;

 //contrutotres
	public Arvore(int x){
		this.raiz = new Node(x);
	}
	public Arvore(){
		this.raiz=null;
	}

//inserir
	/**
	*inserir - insere um elemento int na arvore
	@param elemento int
	*/
	public void inserir(int x) throws Exception{
		this.raiz = inserir(x, this.raiz);
	}
	private Node inserir(int x, Node i) throws Exception{
		if (i==null)
			i = new Node(x);
		else if(x<i.elemento)
			i.esq=inserir(x, i.esq);
		else if(x>i.elemento)
			i.dir=inserir(x, i.dir);
		else
			throw new Exception ("Elemento existente");
		return i;
	}

	/**
	*inserir - Insere um elemento String na subarvore
	*@param Elemento Personagem
	*/
	public void inserir(Personagem p) throws Exception{
		inserir(p, this.raiz);
	}
	private void inserir(Personagem p, Node i) throws Exception{
		int key = p.getAltura()%15;
		if(i==null)
			throw new Exception ("Erro chave numerica");
		else if(key<i.elemento)
			inserir(p, i.esq);
		else if(key>i.elemento)
			inserir(p, i.dir);
		else
			i.raizString = inserir(p, i.raizString);
	}
	private NodeString inserir(Personagem p, NodeString i) throws Exception{
		if(i==null)
			i=new NodeString(p.getNome());
		else if(p.getNome().compareTo(i.nome)<0)
			i.esq=inserir(p, i.esq);
		else if(p.getNome().compareTo(i.nome)>0)
			i.dir=inserir(p, i.dir);
		else
			throw new Exception ("Nome existente");
		return i;
	}

 //pesquisar
	/**
	*pesquisar - Pesquisa se um elemento esta na arvore
	*@param String
	*@return boolean
	*/
	public boolean pesquisar(String nome, int[] log){
		MyIO.print(nome+" raiz ");
		return(pesquisar(nome, this.raiz, log));
	}
	private boolean pesquisar(String nome, Node i, int[] log){
		boolean resp = false;
		if(i==null)
			resp = false;
		else{
			resp = pesquisar(nome, i.raizString, log);
			if(!resp){
				MyIO.print("esq ");
				resp = pesquisar(nome, i.esq, log);
				if(!resp){
					MyIO.print("dir ");
					resp = pesquisar(nome, i.dir, log);
				}
			}
		}
		return resp; 
	}
	private boolean pesquisar(String nome, NodeString i, int[] log){
		boolean resp = false;
		if(i==null)
			resp = false;
else if (nome.compareTo(i.nome)!=0){
//			else if(nome.compareTo(i.nome)<0){
			log[0]++;
			MyIO.print("ESQ ");
			resp=pesquisar(nome, i.esq, log);
//		}
//		else if(nome.compareTo(i.nome)>0){
			log[0]++;
			MyIO.print("DIR ");
			resp=pesquisar(nome, i.dir, log);

		}
		else
			resp=true;
		return resp;
	}	
}

/**
*Classe Main
*/
public class TP04Q02{
  		
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
		Arvore arv = new Arvore();
		int[] log = new int[2];
		long inicio, fim; inicio = fim = 0;
		
		arv.inserir(7);
		arv.inserir(3);
		arv.inserir(11);
		arv.inserir(1);
		arv.inserir(5);
		arv.inserir(9);
		arv.inserir(12);
		arv.inserir(0);
		arv.inserir(2);
		arv.inserir(4);
		arv.inserir(6);
		arv.inserir(8);
		arv.inserir(10);
		arv.inserir(13);
		arv.inserir(14);


		String input = MyIO.readLine();
		input = Personagem.toUtf(input);
		while(!Personagem.isFim(input)){
			arv.inserir( new Personagem(input));
			input = MyIO.readLine();
			input = Personagem.toUtf(input);
		}
		inicio=tempo();
		input = MyIO.readLine();
//		input = Personagem.toUtf(input);
		while(!Personagem.isFim(input)){
			if(arv.pesquisar(input, log))
				MyIO.println("SIM");
			else
				MyIO.println("NÃO");
			input = MyIO.readLine();
//			input = Personagem.toUtf(input);
		}
		fim=tempo();
		double segundos = ((double)(fim-inicio))/1000.0;
		
		//arquivo log
		Arq.openWrite("651230_arvoreArvore.txt");
		Arq.print("651230\t"+segundos+"\t"+log[0]);
		Arq.close();		
	}	
}
