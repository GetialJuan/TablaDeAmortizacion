/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabladeamortizacion;

import java.util.Scanner;

/**
 *
 * @author invitado
 */
public class EmpresaBancaria {
    private float monto;
    private int meses;
    private float tasa;
    private float cuota;
    private float saldo;
    
    public EmpresaBancaria(){
        monto = 0;
        meses = 0;
        tasa = 0;
        cuota = 0;
        saldo = 0;
    }
    
    public void setMonto(){
        Scanner sc = new Scanner(System.in);
        try{
            monto = Float.parseFloat(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Introduce un valor valido.");
            setMonto();
        }
    }
    
    public void setMeses(){
        Scanner sc = new Scanner(System.in);
        while(Integer.parseInt(sc.nextLine()) < 1){
            System.out.println("Introduce un valor mayor o igual a 1");
            sc = new Scanner(System.in);
        }
        try{
            meses = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Introduce un valor valido mayor o igual a 1.");
            setMeses();
        }
    }
    
    public void setTasa(){
        if(monto < 1500000 && meses < 12){
            tasa = (float)(2.5/100);
        }
    }
    
    public void generarTabla(){
        System.out.println("Mes\tSaldo\tIntereses\tCuota\tAbono\tSaldoFinal");
        
        for(int i = 0; i<meses; i++){
            float interes = saldo*tasa;
            float abono = (cuota-interes);
            float saldoFinal = saldo - abono; 
            System.out.println((i+1)+"\t"+saldo+"\t"+interes+"\t"+cuota+"\t"
                    +abono+"\t"+saldoFinal);
            saldo = saldoFinal;
        }
    }
}
