package calculadora;

import javax.swing.JOptionPane;

public class Menu {

    private int op = 0;
    
    public void menu() {
        try {
            while(op != 5) {
                op = Integer.parseInt(JOptionPane.showInputDialog("Calculadora"
                        + "\n 1. Suma "
                        + "\n 2. Resta "
                        + "\n 3. Multiplicación "
                        + "\n 4. División "
                        + "\n 5. Salir"));
                
                switch(op) {
                    case 1:
                        Suma sum = new Suma();
                        sum.Leer();
                        sum.sumar();
                        sum.Mostrar();
                        break;
                        
                    case 2:
                        Resta res = new Resta();
                        res.Leer();
                        res.restar();
                        res.Mostrar();
                        break;
                        
                    case 3:
                        Multiplicacion mult = new Multiplicacion();
                        mult.Leer();
                        mult.multiplicar();
                        mult.Mostrar();
                        break;
                        
                    case 4:
                        Division div = new Division();
                        div.Leer();
                        div.dividir();
                        div.Mostrar();
                        break;
                        
                    case 5: JOptionPane.showMessageDialog(null, "Saliendo del sistema"); break;
                    default: JOptionPane.showMessageDialog(null, "Opción no valida, por favor seleccione nuevamente"); break;
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "¡ERROR! Ha ocurrido un error en el sistema: " + e);
        }
    }
}