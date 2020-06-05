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
//superclass
public class Notification {
    //overriding
    public void tugas() {
        System.out.println("Tugas Besar PBO");
    }
    public void nim() {
        System.out.println("NIM : 201910370311336");
    }
    //overloading
    public void dev(String a) {
        System.out.println(a);
    }
    public void dev(String a, String b) {
        System.out.println(a + " " + b);
    }
    //Inheritance   
    public void suara() {
        System.out.println("\nData Berhasil di Input");
    }
}
