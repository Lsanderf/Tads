import java.util.*;
public class Main {

    public static class HashR{
        String tabela[];
        int tam;
        int tamR;
        int nitensReserva;

        int hash(String chave){
            int pos = 0;
            int i = 0;
            while(i < chave.length()){
                pos += ((int) chave.charAt(i));
                i++;
            }
            return pos % tam;
        }

        String pesquisa(String chave){
            String resp = null;
            int pos = hash(chave);
            if(!isLivre(pos)){
                if(tabela[pos].equals(chave)){
                    resp = tabela[pos];
                }else{
                    int i = tam;
                    while(resp == null && i < tam + nitensReserva){
                        if(tabela[i].equals(chave)) resp = tabela[i];
                    }
                }
            }
            return resp;
        }

        void inserir(String chave)throws Exception{
            int pos = hash(chave);
            if(isLivre(pos)){
                tabela[pos] = chave;
            }
            else if(tabela[pos].equals(chave)) throw new Exception("Chave dulpicada1");
            else{
                if(nitensReserva == tamR) throw new Exception("Tabela cheia");
                for(int i = 0; i < nitensReserva; i++){
                    if(tabela[tam+i].equals(chave)) throw new Exception("Chave duplicada");
                }
                tabela[tam + nitensReserva] = chave;
            }
        }

        void print(){
            for(int i = 0; i < tam + tamR; i++){
                if(tabela[i] != null){
                    System.out.println(tabela[i]);
                }
            }
        }
        
        boolean isLivre(int x){
            boolean livre;
            if(tabela[x] != null) livre = false;
            else livre = true;
            return livre;
        }   
        HashR(int tam, int tamR){
            this.tam = tam;
            this.tamR = tamR;
            nitensReserva = 0;
            tabela = new String[tam + tamR];
        }
    }

   public static void main(String[] args)throws Exception{
    Scanner sc = new Scanner(System.in);
    int tam = sc.nextInt();
    int tamR = sc.nextInt();
    HashR lista = new HashR(tam, tamR);
    
    while(sc.hasNext()){
        String temp = sc.nextLine();
        
        try{
            lista.inserir(temp);
        }
        catch(Exception e){
            System.out.println("Tentando inserir " + temp + ": " + e.getMessage());
        }
    }

    lista.print();
    

    sc.close();
   } 
}
