package negocio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author iniedu
 */
public class Ficha {

    VectorBitGenerico v;
    int cant;

    public Ficha() {
        v = new VectorBitGenerico(28, 100);
        cant = 0;
    }

    public void InsFicha(String tipo, int numero, String user) {
        int valor = 0;
        int t = 3;
        if (tipo.toUpperCase().equals("CJ")) {
            t = 0;
        } else {
            if (tipo.toUpperCase().equals("RN")) {
                t = 1;
            } else {
                if (tipo.toUpperCase().equals("PF")) {
                    t = 2;
                }
            }
        }
        valor = valor | t;
        valor = valor << 7;
        valor = valor | numero;
        valor = valor << 2;
        int u = 3;
        if (user.toUpperCase().equals("NM")) {
            u = 0;
        } else {
            if (user.toUpperCase().equals("3RA")) {
                u = 1;
            } else {
                if (user.toUpperCase().equals("DC")) {
                    u = 2;
                }
            }
        }
        valor = valor | u;
        cant++;
        v.Insertar(valor, cant);
    }

    public String getTipo(int pos) {
        int aux = v.Sacar(pos);
        aux = aux >>> 9;
        int mask = (int) Math.pow(2, 2) - 1;
        mask = mask & aux;
        if (mask == 0) {
            return "Caja";
        } else {
            if (mask == 1) {
                return "Renta";
            } else {
                if (mask == 2) {
                    return "Plataforma";
                } else {
                    return "Error:: Ingrese CJ para Caja - RN para Renta - PF para platadorma";
                }
            }
        }
    }

    public int getNumero(int pos) {
        int aux = v.Sacar(pos);
        aux = aux >>> 2;
        int mask = (int) Math.pow(2, 7) - 1;
        mask = mask & aux;
        return mask;
    }

    public String getUser(int pos) {
        int aux = v.Sacar(pos);
        int mask = (int) Math.pow(2, 2) - 1;
        mask = mask & aux;
        if (mask == 0) {
            return "Normal";
        } else {
            if (mask == 1) {
                return "3ra edad";
            } else {
                if (mask == 2) {
                    return "Discapacitado";
                } else {
                    return "Error::Ingrese NM para Normal - 3RA para 3ra edad - DC para Discapacitado";
                }
            }
        }
    }

    public int getCant() {
        return cant;
    }

    public String toString(int pos) {
        String s = "Ficha:";

        s = s + "\n" + "Tipo: " + getTipo(cant)
                + "\n" + "Numero: " + getNumero(cant)
                + "\n" + "Usuario: " + getUser(cant);
        return s;
    }

    public String ver(int pos) {
        String s = "";
        
            s = s + "\n" + "Tipo: " + getTipo(pos)
                    + "\n" + "Numero: " + getNumero(pos)
                    + "\n" + "Usuario: " + getUser(pos);
        
        return s;
    }

    @Override
    public String toString() {
        String s = "Ficha:";
        for (int i = 1; i <= cant; i++) {
            s = s + "\n" + "Tipo: " + getTipo(i)
                    + "\n" + "Numero: " + getNumero(i)
                    + "\n" + "Usuario: " + getUser(i);
        }
        return s;
    }

}
