package diogo.listatelefonica;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ListaTelefonicaTeste 
{
	private Map<String, TreeMap<Integer, Contacto>> treeMapContactos;
	private TreeMap<Integer, Contacto> treeMapAux;
	private Collection<TreeMap<Integer, Contacto>> contactos;
	public static int conta = 0;
    
    public ListaTelefonicaTeste()
    {
    	treeMapContactos = new TreeMap<>();
        contactos = treeMapContactos.values();
    }
    //adiciona contactos
    public void adiciona(Contacto contacto) 
    {
    	Scanner teclado = new Scanner(System.in);

    	TreeMap<Integer, Contacto> treeMapAux = treeMapContactos.get(contacto.getNome());
    	
    	if (treeMapAux == null) 
    	{
    		treeMapAux = new TreeMap<>();
    		treeMapContactos.put(contacto.getNome(), treeMapAux);
        }
    	treeMapAux.put(contacto.getMorada().getCodigoPostal(), contacto);
    	conta++;
        System.out.println("O contacto foi adicionado com sucesso!");
        System.out.println("Pressione a tecla ENTER para continuar...");
    	teclado.nextLine();
    }

    public void lista()
    {
    	Scanner teclado = new Scanner(System.in);
    	
    	for(TreeMap<Integer, Contacto> treeValuesMap : treeMapContactos.values())
		{
    		for (Contacto treeKey : treeValuesMap.values())
        	{
        		System.out.println("Nome: " + treeKey.getNome());
        		System.out.println("Telefone: " + treeKey.getTelefone());
        		System.out.println("Morada: " + treeKey.getMorada().getMoradaCompleta());
        		System.out.println("Email: " + treeKey.getEmail());
        		System.out.println("-------------------------------");
        	}
		}
		
		if (conta == 0)
		{
			System.out.println("Nao existem contactos na lista telefonica!");
		}
    	teclado.nextLine();
    }
    //procura um contacto
    public void procura(Contacto contacto)
    {
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("Introduza o nome: ");
		String procura = teclado.nextLine();
		
		TreeMap<Integer, Contacto> treeMapAux = treeMapContactos.get(contacto.getNome());
		
		if (treeMapAux == null) 
		{
	        // Nenhum TreeMap secundário encontrado para o nome fornecido
	        System.out.println("O contacto nao foi encontrado!");
		}
		else if (treeMapContactos.get(procura).values().size() > 1) 
		{
			System.out.println("Existem mais do que um contacto com esse nome:");
			
			for(TreeMap<Integer, Contacto> treeValuesMap : treeMapContactos.values())
			{
	    		for (Contacto treeKey : treeValuesMap.values())
	        	{
	    			if (procura.equals(treeKey.getNome())) 
	    			{
	    				System.out.println("Nome: " + treeKey.getNome());
		        		System.out.println("Telefone: " + treeKey.getTelefone());
		        		System.out.println("Morada: " + treeKey.getMorada().getMoradaCompleta());
		        		System.out.println("Email: " + treeKey.getEmail());
		        		System.out.println("-------------------------------");
	    			}
	    			else 
	    			{
	    				continue;
	    			}
	        	}
			}
			System.out.println("Pressione a tecla ENTER para continuar...");
			teclado.nextLine();
			return;
		}
		if (treeMapAux != null) 
		{
			System.out.println("Nome: " + treeMapAux.get(contacto.getMorada().getCodigoPostal()).getNome());
			System.out.println("Telefone: " + treeMapAux.get(contacto.getMorada().getCodigoPostal()).getTelefone());
			System.out.println("Morada: " + treeMapAux.get(contacto.getMorada().getCodigoPostal()).getMorada().getMoradaCompleta());
			System.out.println("Email: " + treeMapAux.get(contacto.getMorada().getCodigoPostal()).getEmail());
		}
		else 
		{
			return;
		}
		System.out.println("Pressione a tecla ENTER para continuar...");
		teclado.nextLine();
    }
    
    public void apagar(Contacto contacto) 
    {
    	String remove;
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("Introduza o nome que pretende eliminar: ");
		String elimina = teclado.nextLine();
		int cp;
		
		TreeMap<Integer, Contacto> treeMapAux = treeMapContactos.get(contacto.getNome());
		
		if (treeMapAux == null) 
		{
	        return;
	    }
		
		if (treeMapAux.get(contacto.getMorada().getCodigoPostal()).getNome().equals(elimina)) 
		{
			if (treeMapContactos.get(elimina).values().size() > 1) 
			{
				System.out.println("Existem mais do que um contacto com esse nome:");
				
				for(TreeMap<Integer, Contacto> treeValuesMap : treeMapContactos.values())
				{
		    		for (Contacto treeKey : treeValuesMap.values())
		        	{
		    			if (elimina.equals(treeKey.getNome())) 
		    			{
		    				System.out.println("Nome: " + treeKey.getNome());
			        		System.out.println("Telefone: " + treeKey.getTelefone());
			        		System.out.println("Morada: " + treeKey.getMorada().getMoradaCompleta());
			        		System.out.println("Email: " + treeKey.getEmail());
			        		System.out.println("-------------------------------");
						}
		    			else 
		    			{
		    				continue;
						}
		        	}
				}
				System.out.println("Qual destes contactos pretende eliminar?(Introduza o codigo postal do mesmo)");
				cp = teclado.nextInt();
				
				treeMapAux.remove(cp);
				//?
				System.out.println("O contacto foi removido com sucesso!");
				System.out.println("Pressione a tecla ENTER para continuar...");
	    		teclado.nextLine();
	    		teclado.nextLine();
	    		
	    		if (treeMapAux.isEmpty())
	    		{
	    				treeMapContactos.remove(treeMapAux.get(cp).getNome());
	    	    }
	    		conta--;
			}
			return;
		}
		else 
		{
			System.out.println("O nome introduzido nao estao na lista");
			System.out.println("Pressione a tecla ENTER para continuar...");
	    	teclado.nextLine();
		}
    }
}