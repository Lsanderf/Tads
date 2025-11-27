public class pesquisa {
    class Arvore{
        No raiz;

        Arvore(){
            raiz = null;
        }

        void inserir(int x){
            raiz = inserir(x, raiz);
        }

        No inserir(int x, No i)throws Exception{
            if(i == null){
                i = new No(x);
            }
            else if(x < i.valor){
                i = inserir(x, i.esq);
            }
            else if(x > i.valor){
                i = inserir(x, i.dir);
            }
            else throw new Exception("ERRO");
        return i;
        }

        public boolean pesquisar(int x){
            boolean achou = false;
            
        }
    }

    class No{
        int valor;
        No dir, esq;

        No(int valor){
            this.valor = valor;
            dir = esq = null;
        }
    }
}
