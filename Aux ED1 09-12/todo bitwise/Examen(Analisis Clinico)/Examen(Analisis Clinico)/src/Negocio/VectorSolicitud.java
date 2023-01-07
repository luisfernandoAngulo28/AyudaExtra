/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Administrador
 */
public class VectorSolicitud {   

    VectorBitGenerico vn,vx;
      int   dim;                     
    public VectorSolicitud(int CantSolicitud){
        vn=new VectorBitGenerico(19,CantSolicitud);
        vx=new VectorBitGenerico(32,CantSolicitud);  
        dim=0;
    }
    public void SetDAtos(SolicitudCliente SC,SolicitudAnalisis SA){
        dim++;   
        vn.Insertar(SA.GetEnteroN(), dim);
       vx.Insertar(SC.GetEnteroX(),dim);
    }
    public SolicitudAnalisis GetSolicitudAnalisis(int pos){
       SolicitudAnalisis sa;
       sa=new SolicitudAnalisis();
       sa.SetEntero(vn.Sacar(pos));
       return sa;
    }
    public SolicitudCliente GetSolicitudCliente(int pos){
        SolicitudCliente sc;
        sc=new SolicitudCliente();
        sc.SetEntero(vx.Sacar(pos));
        return sc;
    }

    @Override
    public String toString() {
     String Cad="Su Solicitud fue exitosamente Registrado : "+'\12';
        for (int i = 1; i <=dim; i++) {
            Cad=Cad+GetSolicitudCliente(i)+GetSolicitudAnalisis(i)+'\12';
        }
   
     return Cad;
    }
    
    
}
