public class Principal
{
	public static void main(String[] args) 
	{
		Agenda a = new Agenda();
		a.load("Contatos.txt");
		a.listar();
		a.inserir("Fulano","77777777","Rua D","UFF");
		a.remover("Ciclano");
		a.listar();
		a.save();
	}
}
