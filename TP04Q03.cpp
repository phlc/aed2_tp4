/*
Ciencia da Computacao - Pucminas
Pedro Henrique Lima Carvalho
Matricula: 651230
AEDs 2

TP04 - Q03
*/

//dependencias
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// ----------------------------------- Personagem  ---------------------------------

/**
* Struct Personagem
*/
typedef struct Personagem{

//atributos
	char* nome;
	int altura;
	double peso;
	char* corDoCabelo;
	char* corDaPele;
	char* corDosOlhos;
	char* anoNascimento;
	char* genero;
	char* homeworld;

} Personagem;


//declaracoes

void mallocPerson (Personagem* p_person);

void preencherPersonagem(Personagem* p_person, char* s);


//construtores

/*
*constructor1
*@param todos atributos
*@return Personagem*
*/
Personagem* constructor1 (char* nome, int altura, double peso, char* corDoCabelo,
		   char* corDaPele, char* corDosOlhos, char* anoNascimento,
		   char* genero, char* homeworld){

	Personagem* p_person = (Personagem*) malloc(sizeof(Personagem)*1);
	p_person->nome = nome;
	p_person->altura = altura;
	p_person->peso = peso;
	p_person->corDoCabelo = corDoCabelo;
	p_person->corDaPele = corDaPele;
	p_person->corDosOlhos = corDosOlhos;
	p_person->anoNascimento = anoNascimento;
	p_person->genero = genero;
	p_person->homeworld = homeworld;

	return(p_person);
}

/*
*constructor2
*@param char* endereco arquivo
*@return Personagem
*/
Personagem* constructor2(char* endereco){
	//declaracoes
	FILE* arquivo = fopen(endereco, "r");
	Personagem* p_person = (Personagem*) malloc(sizeof(Personagem)*1);

	//teste
	if (arquivo==NULL)
		printf("%s\n", "Erro ao abrir arquivo");
	else{
		char* lida = (char*) malloc(sizeof(char)*1000);
		fgets(lida, 999, arquivo); 	
		lida[strlen(lida)-1]='\0';
		
		//alocar memoria
		mallocPerson(p_person);

		//preencher personagem			
		preencherPersonagem(p_person, lida);		
	}

	return (p_person);
}

/*
*removeChar
*@param char, char*
*/
void removeChar (char c, char* s){
	int pre = 0;
	int pos = 0;
		
	while (s[pre]!='\0'){
		if (s[pre]!=c){
			s[pos] = s[pre];
			pos++;
		}
		pre++;
	}
	s[pos]='\0';
}

/*
*mallocPerson
*@param Personagem*
*/
void mallocPerson (Personagem* p_person){
	p_person->nome = (char*) malloc(sizeof(char)*100);
	p_person->corDoCabelo = (char*) malloc(sizeof(char)*100);
	p_person->corDaPele = (char*) malloc(sizeof(char)*100);
	p_person->corDosOlhos = (char*) malloc(sizeof(char)*100);
	p_person->anoNascimento = (char*) malloc(sizeof(char)*100);
	p_person->genero = (char*) malloc(sizeof(char)*100);
	p_person->homeworld = (char*) malloc(sizeof(char)*100);
}

/*
*freePerson
*@param Personagem*
*/
void freePerson (Personagem* p_person){
	free(p_person->nome);
	free(p_person->corDoCabelo);
	free(p_person->corDaPele);
	free(p_person->corDosOlhos);
	free(p_person->anoNascimento);
	free(p_person->genero);
	free(p_person->homeworld);

}


/*
*clone
*@param Personagem*
*@return Personagem*
*/
Personagem* clone(Personagem* p_person){
	//delcaracoes
	Personagem* p_clone = (Personagem*) malloc(sizeof(Personagem)*1);
	
	//alocar memoria para clone
	mallocPerson(p_clone);
	
	strcpy(p_clone->nome, p_person->nome);
	p_clone->altura = p_person->altura;	
	p_clone->peso = p_person->peso;
	strcpy(p_clone->corDoCabelo, p_person->corDoCabelo);
	strcpy(p_clone->corDaPele, p_person->corDaPele);
	strcpy(p_clone->corDosOlhos, p_person->corDosOlhos);
	strcpy(p_clone->anoNascimento, p_person->anoNascimento);
	strcpy(p_clone->genero, p_person->genero);
	strcpy(p_clone->homeworld, p_person->homeworld);
	
	return (p_clone);
}

/*
*imprimir
*/
void imprimir(Personagem* p_person){

	printf("%s%s", " ## ", p_person->nome);
	printf("%s%d", " ## ", p_person->altura);
	printf("%s%g", " ## ", p_person->peso);
	printf("%s%s", " ## ", p_person->corDoCabelo);
	printf("%s%s", " ## ", p_person->corDaPele);
	printf("%s%s", " ## ", p_person->corDosOlhos);
	printf("%s%s", " ## ", p_person->anoNascimento);
	printf("%s%s", " ## ", p_person->genero);
	printf("%s%s", " ## ", p_person->homeworld);
	printf(" ## \n");

	}


/*
*ler
*@param Personagem*
*@return char*
*/
char*  ler(Personagem* p_person){
	char buffer[50];
	char* lida = (char*) malloc(sizeof(char)*1000);
	
	strcat(lida, " ## ");
	strcat(lida, p_person->nome);
	
	strcat(lida, " ## ");
	sprintf(buffer, "%d", p_person->altura);
	strcat(lida, buffer);	
	
	strcat(lida, " ## ");
	strcat(lida, buffer);
	sprintf(buffer, "%g", p_person->peso);
	
	strcat(lida, " ## ");
	strcat(lida, p_person->corDoCabelo);

	strcat(lida, " ## ");
	strcat(lida, p_person->corDaPele);
	
	strcat(lida, " ## ");
	strcat(lida, p_person->corDosOlhos);
	
	strcat(lida, " ## ");
	strcat(lida, p_person->anoNascimento);
	
	strcat(lida, " ## ");
	strcat(lida, p_person->genero);
	
	strcat(lida, " ## ");
	strcat(lida, p_person->homeworld);

	strcat(lida, " ## ");
			
	return(lida);	
}

/**
*isFim - verifica FIM
*@param char*
*@return boolean
*/
bool isFim(char* s){
	return (strcmp(s, "FIM") == 0);
}


/**
*preencherPersonagem - Separa os atributos do personagem de uma String
*@param Personagem*, char*
*/
void preencherPersonagem(Personagem* p_person, char* s){
	char buffer[9][100];
	int c_buffer= 0;
	int c_s=0;
	int init = 0;
	int end = -1;
		
	for (int i=0; i<9; i++){
		init=end+1;
		while (s[init]!='\''){
			init++;
		}
		end=init+1;
		while (s[end]!='\''){
			end++;
		}
		init=end+1;
		while (s[init]!='\''){
			init++;
		}
		end=init+1;
		while (s[end]!='\''){
			end++;
		}
		
		c_s=init+1;
		while(c_s<end){
			buffer[i][c_buffer] = s[c_s];
			buffer[i][c_buffer+1]='\0';
			c_buffer++;
			c_s++;
		}
		c_buffer=0;
	}

	strcpy(p_person->nome, buffer[0]);
	
	if (0 == sscanf(buffer[1], "%d", &p_person->altura))//testar unknown
		p_person->altura=0;

	removeChar(',', buffer[2]); //retirar virgula do peso	
	if (0 == sscanf(buffer[2], "%lf", &p_person->peso))//testar unknown
		p_person->peso=0;

	strcpy(p_person->corDoCabelo, buffer[3]);
	strcpy(p_person->corDaPele, buffer[4]);
	strcpy(p_person->corDosOlhos, buffer[5]);
	strcpy(p_person->anoNascimento, buffer[6]);
	strcpy(p_person->genero, buffer[7]);
	strcpy(p_person->homeworld, buffer[8]);
		
}

/**
*compare - compara dois Personagens de acordo com a operacao. Nome como desempate
*@param Lista*, Persongem* 1, Personagem* 2, int operacao
*@return double <0 se 1 menor que 2, 0 se iguais, >0 se 1 maior que 2
*/
double compare(Personagem* p_person1, Personagem* p_person2, int op){
	double resp = 0;
	
	switch(op){
		case 1:
		 resp = p_person1->altura - p_person2->altura;
		 break;
		case 2:
		 resp = p_person1->peso - p_person2->peso;
		 break;
		case 3:
		 resp = strcmp(p_person1->corDoCabelo, p_person2->corDoCabelo);
		 break;
		case 4:
		 resp = strcmp(p_person1->corDaPele, p_person2->corDaPele);
		 break;
		case 5:
		 resp = strcmp(p_person1->corDosOlhos, p_person2->corDosOlhos);
		 break;
		case 6:
		 resp = strcmp(p_person1->anoNascimento, p_person2->anoNascimento);
		 break;
		case 7:
		 resp = strcmp(p_person1->genero, p_person2->genero);
		 break;
		case 8:
		 resp = strcmp(p_person1->homeworld, p_person2->homeworld);
		 break;
		default:
		 resp = strcmp(p_person1->nome, p_person2->nome);

	}
	
	if (resp == 0){
		resp = strcmp(p_person1->nome, p_person2->nome);
	}

	return resp;
} 


//----------------------------------- Node AVL ----------------------------------------------

/**
*struct Node AVL
*/
typedef struct Node{
 
 //atributos
	Personagem* elemento;
	Node* esq;
	Node* dir;
	int nivel;

}Node;

 //construtor
	Node* construtorNode (Personagem* p){
		Node* p_no = (Node*) malloc(sizeof(Node));
		
		p_no->elemento = p;
		p_no->esq = NULL;
		p_no->dir = NULL;
		p_no->nivel = 1;
		
		return p_no;
	}

//----------------------------------- Arvore AVL -------------------------------------------

/**
*struct Arvore
*/
typedef struct Arvore{
 
//atributos
	Node* raiz;

}Arvore;

//construtor
/**
*construtorArvore - inicializa uma Arvore
*@return Arvore*
*/
Arvore* construtorArvore (){

	Arvore* p_arvore;
	p_arvore = (Arvore*) malloc (sizeof(Arvore));
	p_arvore->raiz = NULL;
	
	return p_arvore;
}

//metodos

//inserir ----------------------------------

//declaracoes
Node* inserirRec(Node* p_no, Personagem* p_person);

/**
*inserir - Insere um elemento na arvore
*@param Arvore* Personagem*
*/
void inserir(Arvore* p_arvore, Personagem* p_person){
	p_arvore->raiz = inserirRec(p_arvore->raiz, p_person);  
} 

/**
*inserirRec - Insere um elemnento na arvore recursivamente
*@param Node* e Personagem*
*@return Node*
*/
Node* inserirRec(Node* p_no, Personagem* p_person){
	if (p_no==NULL)
		p_no = construtorNode(p_person);
	else{
		if (compare(p_person, p_no->elemento, 0)<0.0)
			p_no->esq = inserirRec(p_no->esq, p_person);
		else{
			if (compare(p_person, p_no->elemento, 0)>0.0)
				p_no->dir = inserirRec(p_no->dir, p_person);
			else
				printf("%s\n", "Elemento existente");
		}
	}
	return p_no;
}


//remover ----------------------------------

//declaracoes
Node* removerRec(Node* p_no, Personagem* p_person);
Node* anterior(Node* p_i, Node* p_j); 

/**
*remover - remove um elemento da arvore
*@param Arvore* Personagem*
*/
void remover(Arvore* p_arvore, Personagem* p_person){
	p_arvore->raiz = removerRec(p_arvore->raiz, p_person);
}

/**
*removerRec - Remove um personagem da arvore recursivamente
*@param Node* Personagem*
*@return Node*
*/
Node* removerRec(Node* p_no, Personagem* p_person){
	if (p_no == NULL)
		printf("%s\n", "Elemento inexistente");
	else{
		if(compare(p_person, p_no->elemento, 0)<0.0)
			p_no->esq = removerRec(p_no->esq, p_person);
		else{
			if(compare(p_person, p_no->elemento, 0)>0.0)
				p_no->dir = removerRec(p_no->dir, p_person);
			else{
				if(p_no->esq==NULL)
					p_no = p_no->dir;
				else{
					if(p_no->dir==NULL)
						p_no = p_no->esq;	
					else
						p_no->esq = anterior(p_no, p_no->esq);
				}
			}
		}
	}
	return p_no;
}

/**
*anterior - Remove um personagem da arvore recusivamente quando seus filhos != NULL
*@param Node* e Node*
*@return Node*
*/
Node* anterior (Node* i, Node* j){
		if(j->dir!=NULL)
			j->dir = anterior(i, j->dir);
		else{
			i->elemento = j->elemento;
			j = j->esq;
		}
		return j;
}


//pesquisar -------------------
//declaracoes
int pesquisarRec (Node* p_no, char* nome, int log[]); 

/**
*pesquisar - Pesquisa se um elemento esta na arvore
*@param Arvore* char* Nome int log[]
*@return int (0-false, 1-true)
*/
int pesquisar (Arvore* p_arvore, char* nome, int log[]){
	printf("%s %s", nome, "raiz ");
	return (pesquisarRec(p_arvore->raiz, nome, log));
}

/**
*pesquisarRec - Pesquisa se um elemento esta na arvore
*@param Node*, char* nome, int log[]
*@return int(0-false, 1-true)
*/
int pesquisarRec (Node* p_no, char* nome, int log[]){
	int resp = 0;
	if (p_no==NULL)
		resp = 0;
	else{
		if(strcmp(nome, p_no->elemento->nome)<0){
			log[0]++;
			printf("%s", "esq ");
			resp = pesquisarRec(p_no->esq, nome, log);
		}
		else{
			if(strcmp(nome, p_no->elemento->nome)>0){
				log[0]++;
				printf("%s", "dir ");
				resp = pesquisarRec(p_no->dir, nome, log);
			}
			else
				resp = 1;
		}
	}
	return resp;
}

//--------------------------------------- Main ---------------------------------------------


/**
*Metodo main
*/
int  main(void){
        
	Arvore* p_arvore = construtorArvore();
	int log[] = {0,0};
	Personagem* p;
	char* input = (char*) malloc(sizeof(char) * 100);

	fgets(input, 99, stdin);
	input[strlen(input)-1]='\0';
		
	while(!isFim(input)){
		p = constructor2(input);
		inserir(p_arvore, p);
		fgets(input, 99, stdin);
		input[strlen(input)-1]='\0';
	}	
	clock_t inicio = clock();
	fgets(input, 99, stdin);
	input[strlen(input)-1]='\0';
		
	while(!isFim(input)){
		if(pesquisar(p_arvore, input, log))
			printf("%s\n", "SIM");
		else
			printf("%s\n", "NÃO");
		fgets(input, 99, stdin);
		input[strlen(input)-1]='\0';
	}
	clock_t fim = clock();

	double segundos = (fim - inicio) / (double)CLOCKS_PER_SEC / 1000.0;

	//arquivo log
	FILE* arq = fopen("651230_avl.txt", "wt");
	fprintf (arq, "%s\t%d\t%d\t%lf","651230", log[0], log[1], segundos);
	fclose(arq);

//	freeArvore(p_lista);
}	


