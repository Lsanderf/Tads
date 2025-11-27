public class remover{
    public static class Lista{

        private int tam;
        private Celula primeiro, ultimo;

        public int gettam(){
            return tam;
        }
        public Lista(){
            tam = 0;
            primeiro = ultimo = new Celula();
        }
        public int remover(int pos)throws Exception{
            if(pos < 0 || pos >= tam || primeiro == ultimo) throw new Exception ("Erro");
            int elemento;
            else if (pos == 0) elemento = remover_inicio();
            else if (pos == tam - 1) elemento = remover_fim();
            else{
                Celula aux;
                for(int i = 0; i <= pos; i++, aux = aux.prox);
                    elemento = aux.valor;

                    aux.ant.prox = aux.prox;
                    aux.prox.ant = aux.ant;
                    aux = aux.prox = aux.ant = null;
                    tam--;
            }
            return elemento;
        }

        public int remover_inicio(){
            int elemento = primeiro.prox.valor;
            Celula i = primeiro;
            primeiro = primeiro.prox;
            primeiro.ant = i = i.prox = null;
            tam--;
            return elemento;
        }

        public int remover_fim(){
            int elemento = ultimo.valor;
            Celula i = ultimo;
            ultimo = ultimo.ant;
            ultimo.prox = i = i.prox = i.ant = null;
            tam--;
            return elemento;
        }

        private class Celula{
            int valor;
            Celula prox, ant;

            Celula(int valor){
                this.valor = valor;
                prox = ant = null;
            }
            Celula(){
                this(-1);
            }
        }
    }
}