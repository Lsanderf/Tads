public class ordenacao {
    
    public static class Lista{
        Cell primeiro,ultimo;
        int tam;

        Lista(){
            Cell cell = new Cell();
            primeiro = ultimo = cell;
            tam = 0;
        }
        public void inserir(int x){
            Cell temp = new Cell(x);
            if(tam == 0){
                primeiro.prox = temp;
                ultimo = temp;
            }else{
                Cell i = primeiro;
                while(i.prox != null && i.prox.valor < temp.valor){
                    i = i.prox;
                }
                if(i.prox == null) ultimo = temp;

                else temp.prox = i.prox;
                
                i.prox = temp;
                i = null;
            }
            temp = null;
            tam++;
        }

        public int remover(int x)throws Exception{
            if(primeiro == ultimo) throw new Exception("Lista vazia");
            Cell i = primeiro;
            while( i.prox.valor != x){
                i = i.prox;
                if(i == null) throw new Exception("Numero não encontrado");
            }
            Cell remover = i.prox;
            int elemento = remover.valor;
            if(remover == ultimo) ultimo = i;
            i.prox = remover.prox;
            remover.prox = null;
            i = remover = null;
            tam--;
            return elemento;
        }

        public void mostrar(){
            Cell aux = primeiro.prox;
            for(int i = 0; i < tam; i++){
                System.out.println(aux.valor);
                aux = aux.prox;
            }
        }
        private class Cell{
            int valor;
            Cell prox;

            Cell(){
                this(-1);
            }
            Cell(int valor){
                this.valor = valor;
                prox = null;
            }
        }
    }

    public static void main(String[] args) throws Exception {
    Lista lista = new Lista();
    lista.inserir(50);
    lista.inserir(10);
    lista.inserir(40);
    lista.inserir(30);
    lista.inserir(20);
 
    System.out.println("Elementos da lista em ordem:");
    lista.mostrar();
}

}
