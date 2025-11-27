public class main {
    
    public static class Celula{
        Celula sup, dir, esq, inf;
        int valor;

        Celula(int valor){
            sup = dir = esq = inf = null;
            this.valor = valor;
        }
    }

    public static class Matriz{
        Celula inicio;
        int comprimento, largura;

        Matriz(int comprimento, int largura){
            this.comprimento = comprimento;
            this.largura = largura;
        }
        Matriz(){
            this(3,3);
        }

        public void inserir(int x){
            Celula nova = new Celula(x);
            if(inicio == null){
                inicio = nova;
            }
        }
    }
}
