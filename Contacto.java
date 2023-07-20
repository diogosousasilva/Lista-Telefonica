package diogo.listatelefonica;

import java.util.Objects;

public class Contacto
{
	private String nome;
	private int telefone;
	private String email;
	private Morada morada;
	
	public Contacto(String nome, int telefone, Morada morada, String email)
	{
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.morada = morada;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public int getTelefone() 
	{
		return telefone;
	}
	
	public void setTelefone(int telefone)
	{
		this.telefone = telefone;
	}
	
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public Morada getMorada()
	{
		return morada;
	}
	
	public void setMorada(Morada morada)
	{
		this.morada = morada;
	}
	public boolean isEqual(Object obj) 
	{
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Contacto other = (Contacto) obj;
        return Objects.equals(getNome(), other.getNome());
    }
}