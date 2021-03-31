/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author Dionisius
 */
import java.util.Arrays;

class Recursion{
    
    public static int a[] = {1, 4, 2, 3, 5, 4, 6, 4, 3, 4, 5, 6, 1, 2, 3, 4, 2, 3};
    // note: kalau tidak mau dibuat global variable, buat void Rmode dengan 4 parameter: (i, a, m, f)
    // dan deklarasi array a dibuat di main
    // Saya mengikuti parameter di slides, jadi saya tetap buat 3 parameter, dan a dibuat global
        
    public static void Rmode(int i, int[] m, int[] f){
        // m[0] and f[0] are single element array, to make a pass-by-ref scenario on primitive values in Java
        // parameter harus dibuat tipe array untuk skenario pass-by-ref

        if(i == 1){ // stopping condition
            System.out.println("Masuk kondisi stopping!!");
            m[0] = a[0];
            f[0] = 1;
            System.out.println("Hasil stopping.......");
            System.out.println("Mode rec saat stopping: " + m[0]);
            System.out.println("Freq rec saat stopping: " + f[0]);
        }else{ // recursion algorithm
            System.out.println("Panggil fungsi RMode........");
            System.out.println("i saat masuk RMode: " + i);
            Rmode(i-1, m, f);
            if(a[i] == a[i-f[0]]){
                System.out.println("--------------------------------------------------");
                System.out.println("Masuk kondisi rekursif..........");
                System.out.println("i: " + i);
                System.out.println("a[" + i + "]" + "=" + a[i]);
                System.out.println("a[" + i + "-f[0]]" + "=" + a[i-f[0]]);
                
                System.out.println("Set modus m[0] = a[i]");
                m[0] = a[i];
                
                System.out.println("m[0]" + "=" + m[0]);
                
                System.out.println("Menambah frekuensi data di m, f[0] = f[0] + 1");
                f[0] = f[0] + 1;
                
                System.out.println("f[0]" + "=" + f[0]);
            }
        }
    }

    public static void NRmode(int i){
        int modes = a[0]; // asumsi a[0] adalah modus <sesuai slide>
        int frek = 1;
        int temp = 1;
        
        for(int n = 1; n < i; i++){
            if(a[n-1] != a[n]){
                temp = 1;
            }else{
                temp = temp + 1;

                if(temp > frek){
                    frek = temp; 
                    modes = a[n];
                }
            } 
        }   
    }

    public static void main (String [] args){
        Arrays.sort(a); // array harus dalam keadaan sorted untuk kasus ini

        // initialisasi single-element array untuk mode dan freq
        // Java tidak bisa pass by ref tanpa object, maka untuk primitive values,
        // salah satu caranya adalah membuat single-element array untuk value
        // yang akan dipassing
        int mode[] = { a[0] }; // asumsi a[0] adalah modus <sesuai slide>
        int freq[] = { 1 };

        System.out.println("======================================================================");
        // initialization result
        int i = a.length-1;
        System.out.println("Array length - 1: " + i);
        System.out.println("Mode init: " + mode[0]);
        System.out.println("Freq init: " + freq[0]);

        // Solution rec dan nonrec mengikuti slide rekursif di Classroom
        
        System.out.println("======================================================================");

        // recursive solution
        Rmode(i, mode, freq);
        System.out.println("Mode rec: " + mode[0]);
        System.out.println("Freq rec: " + freq[0]);

        // non-recursive solution
        NRmode(i);
        System.out.println("Mode non rec: " + mode[0]);
        System.out.println("Freq non rec: " + freq[0]);
    } 
}
