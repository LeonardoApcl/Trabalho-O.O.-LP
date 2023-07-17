public class Contato
{
    private String nome, telefone, endereco, relacao;
    
    public Contato(String n, String t, String e, String r)
    {
        this.nome = n;
        this.telefone = t;
        this.endereco = e;
        this.relacao = r;
    }
    public boolean achouNome(String s)
    {
        return (this.nome).contains(s);
    }
    
    public String getSave()
    {
        String s = this.nome + ";" + this.telefone + ";" + this.endereco + ";" + this.relacao;
        return s;
    }
    
    public void set(String n, String t, String e, String r)
    {
        this.nome = nome.replace( nome, n);
        this.telefone = telefone.replace( telefone, t);
        this.endereco = endereco.replace( endereco, e);
        this.relacao = relacao.replace( relacao, r); 
    }
    public void set( Contato c)
    {
        this.nome = c.nome;
        this.telefone = c.telefone;
        this.endereco = c.endereco;
        this.relacao = c.relacao;
    }
    public String toString()
    {
        String saida = "Nome: " + this.nome + " Telefone: " + this.telefone + " Endereço: " + this.endereco + " Relação: " + this.relacao;
        return saida;
    }
}