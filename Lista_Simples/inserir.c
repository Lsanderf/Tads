#include <stdio.h>
#include <stdlib.h>

typedef struct Celula{
    int valor;
    struct Celula* prox;
}Celula;

typedef struct Lista{
    Celula* primeiro;
    Celula* ultimo;
    int tam;
}Lista;


Lista* newlista(){
    Lista* lista = malloc(sizeof(Lista));
    Celula* sentinela = malloc(sizeof(Celula));
    sentinela->prox = NULL;
    lista->primeiro = lista->ultimo = sentinela;
    lista->tam = 0;
    sentinela = NULL;
    return lista;
}

void newcelula(Lista* lista, int x){
    Celula* nova = malloc(sizeof(Celula));
    lista->ultimo->prox = nova;
    nova->prox = NULL;
    lista->ultimo = nova;
    nova->valor = x;
    nova = NULL;
    lista->tam++;
}

void Delete(Lista* lista){
    Celula* aux = lista->primeiro;
    lista->primeiro = lista->primeiro->prox;
    aux->prox = NULL;
    free(aux);
    lista->tam--;
}

void print(Lista* lista){
    Celula* aux = lista->primeiro->prox;
    while(aux != NULL){
        printf("%d ",aux->valor);
        aux = aux->prox;
    }
}

int main(){
    Lista* lista = newlista();
    newcelula(lista, 1);
    newcelula(lista, 2);
    newcelula(lista, 3);
    Delete(lista);
    print(lista);
    
}