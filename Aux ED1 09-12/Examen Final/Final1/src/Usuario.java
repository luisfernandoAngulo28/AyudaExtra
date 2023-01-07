/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pc
 */
public class Usuario {
    char Cliente;
    byte NFicha;
    public Usuario(){
        Cliente=' ';
        NFicha=0;        
    }
   public Usuario(char C, int Nf){
        Cliente=C;
        NFicha=(byte)Nf;        
    }
    public void SetCliente(String Cliente){
        if (Cliente=="C"){
            this.Cliente='C';
        }
        else{
            if (Cliente=="N"){
                this.Cliente='N';
            } else{
                if(Cliente=="T"){
                    this.Cliente='T';
                }else{
                System.out.println("Usuario::SetCliente: Error caracter incorrecto");                    
                }
            }
        }
    }
   

    public void SetFicha(byte F){
        if (F>0){
            NFicha=F;
        }
        
    }
    public char GetCliente() {
    return Cliente;
  }

 
   public String GetClienteSt(char T){
        if (T=='C'){
            return"C";
        }
        else{
            if (T=='T'){
            return"T";
            } else{
                if (T=='N'){
            return"N";
                }else{
            
                    System.out.println("Usuario::GetTransacciónSt: Error caracter incorrecto");
                    return "";
            }
        }
    }
}
  
  public byte GetNFicha() {
    return NFicha;
  }
    
}

