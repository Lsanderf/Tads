class Balanceamento{

    static class Arvore{
        No raiz;
        Arvore(){
            this.raiz = null;
        }

        void rotacionarEsq(){
            raiz = rotacionarEsq(raiz); 
        }

        No rotacionarEsq(No i){
            No iDir = i.dir;
            No iDirEsq = iDir.esq;
            iDir.esq = i; 
            i.dir = iDirEsq;

            return iDir;
        }

        void rotacionarDir(){
            raiz = rotacionarDir(raiz);
        }

        No rotacionarDir(No i){
            No iEsq = i.esq;
            No iEsqDir = iEsq.dir;

            iEsq.dir = i;
            i.esq = iEsqDir;

            return iEsq;
        }

        No rotariconarDirEsq(No i){
            i.dir = rotacionarDir(i);
            return rotacionarEsq(i);
        }

        No rotacioanrEsqDir(No i){
            i.esq = rotacionarEsq(i.esq);
            return rotacionarDir(i);
        }
    }
    class No{
        No esq, dir;
        int elemento;
        No(int elemento){
            this.elemento = elemento;
        }
    }
    public static void main(String[] args) {
        
    }
}