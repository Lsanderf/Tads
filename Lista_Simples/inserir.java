
public class inserir{

    public static class Lista{
        private Celula primeiro,ultimo;
        int tam;

        public void inserir_inicio(int x){
            primeiro.valor = x;
            Celula tmp = new Celula();
            tmp.prox = primeiro;
            primeiro = tmp;
            tmp = null;
            tam++;
        }

        public void inserir_fim(int x){
            Celula tmp = new Celula(x);
            ultimo.prox = tmp;
            ultimo = tmp;
            tmp = null;
            tam++;
        }

        public void inserir(int x, int pos) throws Exception{
            if(pos < 0 || pos >= tam) throw new Exception("Posição Inválida");
            
            else if(pos == 0) inserir_inicio(x);
            else if(pos == tam - 1) inserir_fim(x);

            else{
                Celula tmp = new Celula(x);
                Celula aux = primeiro;
                for(int i = 0; i < pos; i++, aux = aux.prox);
                tmp.prox = aux.prox;
                aux.prox = tmp;
                tmp = aux = null;
                tam++;
            }
        }

        public void sort(){

            for(Celula i = primeiro.prox; i != null; i = i.prox){
                Celula menor = i;
                for(Celula j = i.prox; j != null; j = j.prox){
                    if(j.valor < menor.valor) menor =j;
                }
                int temp = i.valor;
                i.valor = menor.valor;
                menor.valor = temp;
            }
        }

        public void mostrar(){
            Celula i = primeiro.prox;
            while(i != null){
                System.out.println(i.valor);
                i=i.prox;
            }
            i = null;
        }
    

        public Lista(){
            Celula i = new Celula();
            ultimo = primeiro = i;
            tam = 0;
            i = null;
        }
    

    private class Celula{
        int valor;
        Celula prox;

        Celula(){
            this(-1);
            
        }
        Celula(int x){
          valor = x;
          prox = null;
        }
    }
}
    public static void main(String[] args) throws Exception{
        Lista lista = new Lista();
        lista.inserir_fim(30);
        lista.inserir_fim(40);
        lista.inserir_inicio(200);
        lista.inserir(15,3);
        lista.sort();
        lista.mostrar();

        

    }
}
