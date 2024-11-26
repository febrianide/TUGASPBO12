/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class Buku implements Serializable {
    private String judul;
    private String pengarang;
    private int tahunTerbit;
    
    public Buku(String judul, String pengarang, int tahunTerbit){
     this.judul = judul;
     this.pengarang = pengarang;
     this.tahunTerbit = tahunTerbit;
    }
    
    public void informasi(){
        System.out.println("Judul Buku :" + judul);
        System.out.println("Pengarang :" + pengarang);
        System.out.println("Tahun Terbit : " + tahunTerbit);
    }  
}
    
