package cajero;

import javax.swing.JOptionPane;

public class Transacciones {
    
    private int saldo = 500000; //Valor por defecto
    private int retiro;
    private int deposito;

    public void consultar() {
        JOptionPane.showMessageDialog(null, "Su saldo actual es: " + saldo);
    }

    public void retirar() {
        retiro = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto desea retirar?"));
        
        if(retiro > saldo) {
            JOptionPane.showMessageDialog(null, "Fondos insuficientes.");
        } else {
            saldo = saldo - retiro;
            JOptionPane.showMessageDialog(null, "Retiro exitoso por " + retiro + "\n Su saldo actual es: " + saldo);
        }
    }

    public void depositar() {
        deposito = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto desea depositar?"));
        saldo = saldo + deposito;
        JOptionPane.showMessageDialog(null, "Deposito realizado con exito \n Su saldo actual es: " + saldo);
    }
}
