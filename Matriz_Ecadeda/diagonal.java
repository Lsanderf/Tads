public class diagonal{
    static class Matriz{
        int linha, coluna;
        Celula inicio;
    
        class Celula{
            int elemento;
            Celula sup, dir, esq, inf;
        }

        void printdiagonal(){
            Celula i = inicio;
            printa(i);
        }

        void printa(Celula i){
            if(i != null){
                System.out.println(i.elemento);
                if(i.inf != null){
                    if(i.inf.dir != null){
                        printa(i.inf.dir);
                    }
                }
            }
        }

        int somadiagonal(){
            Celula i = inicio;
            return somadiagonal(i, 0);
        }
        int somadiagonal(Celula i, int soma){
            if(i != null){
                soma += i.elemento;
                if(i.inf != null && i.inf.dir != null){
                   soma = somadiagonal(i.inf.dir, soma);
                }
            }
        return soma;
        }

        void printamatriz(){
            for(Celula i = inicio; i != null; i = i.inf){
                for(Celula j = i; j != null; j = j.dir){
                    System.out.println(j.elemento + " ");
                }
                System.out.println();
            }
        }
    }
}
