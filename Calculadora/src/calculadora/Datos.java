package calculadora;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Datos {
    
    protected double num1, num2, resultado;
    
    public void Leer() {
        num1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el primer numero: "));
        num2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el segundo numero: "));
    }
    
    public void Mostrar() {
    	DecimalFormat df = new DecimalFormat("#.0"); //Funcion para limitar la cantidad de decimales
        JOptionPane.showMessageDialog(null, "Resultado: " + df.format(resultado));
    }
}
