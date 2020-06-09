/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar;

/**
 *
 * @author User
 */

public class Notification {
    //overriding
    public void hapusGagal() {
        System.out.println("\nData Gagal Hapus");
    }
    
    //overloading
    public void inputGagal(String a, String b) {
        System.out.println(a + " " + b);
    }
    //Inheritance   
    public void suara() {
        System.out.println("\nData Berhasil di Input");
    }
}
