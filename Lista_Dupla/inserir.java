public class inserir{

    public static class Lista{
        Celula primeiro, ultimo;
        int tam;

        Lista(){
            primeiro = ultimo = new Celula();
            tam = 0;
        }

        void inserir_inicio(int x){
            primeiro.ant = new Celula();
            primeiro.valor = x;
            primeiro.ant.prox = primeiro;
            primeiro = primeiro.ant;
            tam++;
        }

        void inserir_fim(int x){
            ultimo.prox = new Celula(x);
            ultimo.prox.ant = ultimo;
            ultimo = ultimo.prox;
            tam++;
        }


        void inserir(int x, int pos)throws Exception{
            if(pos > tam || pos < 0) throw new Exception("Erro!");
            else if(pos == 0) inserir_inicio(x);
            else if(pos == tam) inserir_fim(x);
            else{
                Celula aux = primeiro;
                for(int i = 0; i <= pos; i++, aux = aux.prox);
                Celula temp = new Celula(x);
                temp.ant = aux.ant;
                temp.prox = aux;
                aux.ant = temp;
                aux = temp = null;
                tam++;
            }

        }

        void mostrar(){
            Celula temp = primeiro.prox;
            for(int i = 0; i < tam; i++, temp = temp.prox){
                System.out.print(temp.valor + " ");
            }
        }



        private class Celula{
            private int valor;
            private Celula prox, ant;

            Celula(int x){
                valor = x;
                prox = ant = null;
            }
            Celula(){
                this(-1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Lista lista = new Lista();

        lista.inserir_inicio(1);
        lista.inserir_inicio(0);
        lista.inserir(-1, -1);
        lista.inserir(3, 3);
        lista.mostrar();

    }
}