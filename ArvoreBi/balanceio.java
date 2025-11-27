import java.util.*;
public class balanceio {
    static class Arvore{
        No raiz;

        Arvore(){
            raiz = null;
        }

        void inserir(int x){
            raiz =  inserir(x, raiz);
        }
        No inserir(int x, No i){
            if(i == null) i = new No(x);
            else if(x > i.elemento) i.dir = inserir(x, i.dir);
            else i.esq = inserir(x, i.esq);
            return i;
        }
        public void balanceia(){
            if(raiz. dir != null && raiz.esq != null){
                System.out.println("Arvore Balanceada!");
            }
            else if(raiz.dir != null){
                if(raiz.dir.dir != null){
                    raiz = rotacionaEsq(raiz);
                }
                else{
                    raiz = rotacionaDirEsq(raiz);
                }
            }
            else{
                if(raiz.esq.esq != null){
                    raiz = rotacionaDir(raiz);
                }
                else{
                    raiz = rotaciona
                }
            }
        }
    }
  
    public static class No{
        No dir, esq;
        int elemento;
        public No(int elemento){
            this.elemento = elemento;
            dir = esq = null;
        }
    }
}
