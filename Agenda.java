import java.io.*;

public class Agenda
{
    Contato a[] = new Contato[1000];
    int indiceF;
    
    public Agenda()
    {
        this.a[0] = null;
        this.indiceF = 0;
    }
    
    public void load(String arquivo)
    {
        String []contato;
        try 
        {
            FileInputStream entrada = new FileInputStream(arquivo);
            InputStreamReader entradaFormatada = new InputStreamReader(entrada);
            BufferedReader entradaString = new BufferedReader(entradaFormatada);
            
            String linha = entradaString.readLine();
            
            while(linha != null)
            {
                contato = linha.split(";");
                this.inserir(contato[0],contato[1],contato[2],contato[3]);
                linha = entradaString.readLine();
            }
            
        } catch(FileNotFoundException ex) {
            System.out.println("Erro ao abrir o arquivo.");
            
        } catch(IOException ex){
            System.out.println("Erro na leitura do arquivo.");
            
        }
    }
    
    public void save()
    {
        Writer buffer = null;
        
        try
        {
            
            buffer = new FileWriter("ContatosBackup.txt");
            
            for(int i = 0; i < this.indiceF; i++){
                buffer.write(this.a[i].getSave());
                buffer.write("\n");
            }
        
        } catch(FileNotFoundException ex) {
            System.out.println("Erro ao abrir o arquivo.");
            
        } catch(IOException ex){
            System.out.println("Erro na leitura do arquivo.");
            
        }finally{
            
            try {
                
                if(buffer != null){
                    buffer.close();
                }
                
            } catch(IOException ex) {
                System.out.println("Erro ao fechar o arquivo");
            }
        }
        
    }
    
    public Contato busca(String n)  // retorna o contato se achou, retorna null se ele não estiver na agenda.
    {
        if(this.a[0] != null){
            for( int i = 0 ; i< this.indiceF ; i ++)
            {
                if( this.a[i].achouNome(n) )
                {
                    return this.a[i];
                }
            }
        }
        return null;
    }
    
    public int indiceN(String n)  // retorna o indice do contato na agenda, ou retorna -1 caso o contato não esteja nela
    {
        if(this.a[0] != null){
            for( int i = 0 ; i< this.indiceF ; i ++)
            {
                if( this.a[i].achouNome(n) )
                {
                    return i;
                }
            }
            
        }
        return -1;
    }
    
    public void inserir(String n, String t, String e, String r)
    {
        if(this.busca(n) != null)
        {
            this.alterar( n, t, e, r);
        }
        else{
            if(this.indiceF < 1000)
            {
                this.a[indiceF] = new Contato( n, t, e, r);
                this.indiceF ++;
            }
            else
            {
                System.out.println("Não há espaço na agenda");
            }
        }
    }
    
    public void alterar(String n, String t, String e, String r)
    {
        int i = indiceN(n);
        this.a[i].set( n, t, e, r);
    }
    
    public void remover(String n)
    {
        if(this.a != null)
        {
            for(int i = indiceN(n); i < this.indiceF-1 ; i++ )
            {
                this.a[i].set(this.a[i+1]);
            }
            
            this.indiceF --;
            
            if(this.indiceF < 0)
            {
                this.indiceF = 0;
                this.a[0] = null;
            }
        }
    }
    
    public void listar()
    {
        for(int i= 0; i < this.indiceF; i++)
        {
            System.out.println(this.a[i].toString());
        }
        System.out.println("\n");
    }
}