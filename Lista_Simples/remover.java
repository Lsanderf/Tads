public class remover {
        public static class Lista{
            private Celula primeiro,ultimo;

            public int gettam(){
                int tam = 0;
                Celula i = primeiro;
                while(i != null){
                    tam++;
                    i = i.prox;
                }
                return tam;
            }
            public int remover_inicio() throws Exception{
                if(primeiro == ultimo) throw new Exception("Lista Vazia");
                Celula tmp = primeiro.prox;
                int elemento = tmp.valor;
                primeiro.prox = tmp.prox;
                tmp.prox = null;
                tmp = null;
                return elemento;
            }

            public int remover_fim() throws Exception{
                if(primeiro == ultimo) throw new Exception("LIsta vazia");
                Celula i;
                for(i = primeiro; i.prox != ultimo; i=i.prox);
                int elemento = ultimo.valor;

                i.prox = ultimo.prox = null;
                ultimo = i;

                i = null;
                return elemento;
            }
            
            public int remover(int pos)throws Exception{
                int tam = gettam();int elemento;
                if(pos < 0 || pos > tam){
                    throw new Exception("Posição Inválida");
                }
                else if(pos == 0) elemento = remover_inicio();
                else if(pos == tam) elemento = remover_fim();
                Celula tmp = primeiro;
                for(int i = 0; i < pos; i++) tmp = tmp.prox;
                Celula remover = tmp.prox;
                elemento = remover.valor;
                tmp.prox = remover.prox;
                remover.prox = null;
                tmp = remover = null;
                
                return elemento;
            }

            public void mostrar(){
            Celula i = primeiro.prox;
            while(i != null){
                System.out.println(i.valor);
                i=i.prox;
            }
        }
    

            public Lista(){
                Celula i = new Celula();
                Celula c1 = new Celula(1);
                Celula c2 = new Celula(2);
                Celula c3 = new Celula(3);
                i.prox = c1;
                c1.prox = c2;
                c2.prox = c3;
                primeiro = i;
                ultimo = c3;
            }

            private class Celula{
                int valor;
                Celula prox;

                Celula(){
                    this(-1);
                }
                Celula(int valor){
                    this.valor = valor;
                    prox = null;
                }
            }
        }

        public static void main(String[] args)throws Exception{
            Lista lista = new Lista();
            lista.remover(1);
            lista.mostrar();
        }
}
