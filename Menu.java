package diogo.listatelefonica;

import java.util.Scanner;

public class Menu 
{
	Morada morada;
    ListaTelefonica lista;
    Contacto contacto;

    public Menu() 
    {
        lista = new ListaTelefonica();
    }

    public void apresentarMenu() 
    {	
    	int opcao;
    	while(true) 
        {
	    	Scanner teclado = new Scanner(System.in);
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	        System.out.println("1.Criar contacto");
	        System.out.println("2.Listar contactos");
	        System.out.println("3.Procurar contacto");
	        System.out.println("4.Apagar");
	        System.out.println("5.Sair");
	        opcao = teclado.nextInt();
	        
        	switch (opcao) 
            {
    			case 1: 
    			{
    				adicionarContacto();
    				break;
    			}
    			case 2:
    			{
    				listarContactos();
    				break;
    			}
    			case 3:
    			{
    				procuraContacto();
    				break;
    			}
    			case 4:
    			{
    				apagarContacto();
    				break;
    			}
    			case 5:
    			{
    				teclado.close();
    				return;
    			}
    			default:
    				System.out.println("Opcao invalida!");
    				System.out.println("Pressione a tecla ENTER para continuar...");
            		teclado.nextLine();
    		}
        }
    }
    
    public void adicionarContacto() 
    {
    	String nomeRua, nome, email;
        int numero, codigoPostal, telefone;
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Nome: ");
        nome = teclado.nextLine();
        System.out.println("Telefone: ");
        telefone = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Nome da Rua: ");
        nomeRua = teclado.nextLine();
        System.out.println("Numero da Porta/Andar: ");
        numero = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Codigo Postal: ");
        codigoPostal = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Email: ");
        email = teclado.nextLine();
  
        morada = new Morada(nomeRua, numero, codigoPostal);

        contacto = new Contacto(nome, telefone, morada, email);
        lista.adiciona(contacto);
    }

    public void listarContactos()
    {
    	System.out.println("Lista:");
    	lista.lista();
    }
    
    public void procuraContacto()
    {
    	lista.procura();
    }

    public void apagarContacto() 
    {
        lista.apagar();
    }
    
    public static void main(String args[])
    {
    	Menu menu = new Menu();
    	menu.apresentarMenu();
    }
}