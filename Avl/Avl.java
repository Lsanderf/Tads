public class Avl{

    static class Arvore {
        No raiz;

        Arvore() {
            raiz = null;
        }

       No balanciaEsq(No i){
        No iDir = i.dir;
        No iDirEsq = iDir.esq;

        iDir.esq = i;
        i.dir = iDirEsq;
        return iDir;
       }

       No balanciaDir(No i){
        No iEsq = i.esq;
        No iEsqDir = iEsq.dir;

        iEsq.dir = i;
        iEsq.esq = iEsqDir; 
        return iEsq;
       }

       No rotacionarDirEsq(No i){
            i.dir = balanciaDir(i.dir);
            return balanciaEsq(i);
       }

       No rotacionarEsqDir(No i){
        i.esq = balanciaEsq(i.esq);
        return balanciaDir(i);
       }

       No balancear(No i){
        if(i.dir != null && i.esq != null){
            
        }
       }
       

        void printaCentral(){
            printaCentral(raiz);
        }
        
        void printaCentral(No i){
            if(i != null){
                printaCentral(i.esq);
                System.out.print(i.valor + "(" + i.nivel + ")" + "(fb =" + i.getFatorBalanceamento() + ") ");
                printaCentral(i.dir);
            }
        }

        void inserir(int x) {
            try {
                raiz = inserir(x, raiz);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        No inserir(int x, No i) throws Exception {
            if (i == null) {
                i = new No(x);
            } else if (x < i.valor) {
                i.esq = inserir(x, i.esq);
            } else if (x > i.valor) {
                i.dir = inserir(x, i.dir);
            } else {
                throw new Exception("ERRO");
            }
            i.setNivel();
            return i;
        }

        public boolean pesquisar(int x) {
            return pesquisar(raiz, x);
        }

        public boolean pesquisar(No i, int x) {
            boolean achou = false;

            if (i == null) {
                achou = false;
            } 
            else if (i.valor == x) {
                achou = true;
            } 
            else if (x < i.valor) {
                achou = pesquisar(i.esq, x);
            } 
            else {
                achou = pesquisar(i.dir, x);
            }

            return achou;
        }
    }

    static class No {
        int valor;
        No dir, esq;
        int nivel;

        No(int valor) {
            this.valor = valor;
            dir = esq = null;
            nivel = 0;
        }

        int getFatorBalanceamento(){
            return getNivelDir(dir) - getNivelEsq(esq);
        }

        void setNivel(){
            int nivelDir = getNivelDir(dir);
            int nivelEsq = getNivelEsq(esq);
            int maior;
            if(nivelEsq > nivelDir) maior = nivelEsq;
            else maior = nivelDir;
            nivel = 1 + maior;
        }

        int getNivelDir(No i){
            int nivel = 0;
            if(i != null){
                nivel = getNivelDir(i.dir) + 1;
            }
            return nivel;
        }

        int getNivelEsq(No i){
            int nivel = 0;
            if(i != null){
                nivel = getNivelEsq(i.esq) + 1;
            }
            return nivel;
        }


    }


    public static void main(String[] args) {
        Arvore a1 = new Arvore();
        int arr[] = {20, 10, 30, 5, 25, 40, 50};
        for(int i = 0; i < arr.length; i++){
            a1.inserir(arr[i]);
        }
        a1.printaCentral();


    }
}
