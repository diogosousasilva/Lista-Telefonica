package diogo.listatelefonica;

public class Morada 
{
    private String nomeRua;
    private int numero;
    private int codigoPostal;

    public Morada(String nomeRua, int numero, int codigoPostal)
    {
        this.nomeRua = nomeRua;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    public String getNomeRua() 
    {
        return nomeRua;
    }
    
    public void setNomeRua(String nomeRua)
    {
        this.nomeRua = nomeRua;
    }
    
    public int getNumero() 
    {
        return numero;
    }
    
    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    
    public int getCodigoPostal() 
    {
        return codigoPostal;
    }
    
    public void setCodigoPostal(int codigoPostal)
    {
        this.codigoPostal = codigoPostal;
    }
    public StringBuilder constroiCodigoPosta(int codigoPostal)
    {
    	String tempCodigoPostal = Integer.toString(codigoPostal);
    	int [] codigoPostalFinal = new int [tempCodigoPostal.length()];
    	StringBuilder sb1 = new StringBuilder();
    	
    	for (int i = 0; i < tempCodigoPostal.length(); i++) 
    	{
            codigoPostalFinal[i] =  Character.getNumericValue(tempCodigoPostal.charAt(i));
        }
    	
    	sb1.append(codigoPostalFinal[0]).append(codigoPostalFinal[1]).append(codigoPostalFinal[2]).append(codigoPostalFinal[3]).append("-").append(codigoPostalFinal[4]).append(codigoPostalFinal[5]).append(codigoPostalFinal[6]);
    	return sb1;
    }
    
    public StringBuilder getMoradaCompleta() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(nomeRua).append(" N: ").append(numero).append(" Codigo Postal: ").append(constroiCodigoPosta(codigoPostal));
        return sb;
    }
}
