/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Roly
 */
public class CintaCaracter {

    Caracter cc;

    public CintaCaracter() {
        cc = new Caracter();
    }

    public void setCinta(String Cinta) throws Exception {
        int i = 1;
        while (i <= Cinta.length()) {
            cc.setCaracter(i, Cinta.charAt(i - 1));
            i++;
        }
    }

    public int contarPalb() throws Exception {
        int i = 1;
        int cont = 0;
        while (i <= cc.dim) {
            String S = "";
            while (i <= cc.dim && cc.getCaracter(i) != ' ') {
                S = S + cc.getCaracter(i);
                i++;
            }
            if (S.length() > 0) {
                cont++;
            }
            i++;
        }
        return cont;
    }

    public void elimPalb(String Palb) throws Exception {
        int i = 1, cont = 0;
        while (i <= cc.dim) {
            String S = "";
            int k = i;
            while (i <= cc.dim && cc.getCaracter(i) != ' ') {
                S = S + cc.getCaracter(i);
                i++;
            }

            if (S.toUpperCase().equals(Palb.toUpperCase())) {
                int j = k;
                while (j < i) {
                    cc.elimCaracter(k);
                    j++;
                }
            }
            i++;
        }
    }

    public String mostrarCinta() throws Exception {
        String S = "";
        for (int i = 1; i <= cc.dim; i++) {
            S = S + cc.getCaracter(i);
        }
        return S;
    }
}
