package promedios;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Promedios {

    public static void main(String[] args) throws IOException {
    	int opcion = 0;
    	
    	try {
			while(opcion != 3) {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione una opción: "
	        			+ "\n 1. Calcular Promedios "
	        			+ "\n 2. Ver profesores "
	        			+ "\n 3. Salir"));
				
				switch (opcion) {
					case 1: calcularPromedios(); break;
					case 2: JOptionPane.showMessageDialog(null, "En el momento no hay profesores en el sistema."); break;
					case 3: JOptionPane.showMessageDialog(null, "Saliendo del sistema"); break;
					default: JOptionPane.showMessageDialog(null, "Opción no valida, por favor seleccione nuevamente."); break;
				}
			}
		} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el sistema: " + e);
		}
    }
    
    private static void calcularPromedios() {
    	int numAlumnos = 0;
        int alumno = 1;
        int contGanaron = 0;
        int contPerdieron = 0;
        int materia;
        double nota;
        double promedioAlumno;
        double promedioGeneral;
        double acumuladorNotaAlumno;
        double acumuladorPromedios = 0;
        DecimalFormat df = new DecimalFormat("#.0");
        
        numAlumnos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de alumnos: "));
        
        while(alumno <= numAlumnos) {
            JOptionPane.showMessageDialog(null, "Alumno " + alumno);
            
            materia = 1;
            acumuladorNotaAlumno = 0;
            while(materia <= 5) {
                nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nota " + materia));
                acumuladorNotaAlumno = acumuladorNotaAlumno + nota;
                
                materia++;
            }
            
            promedioAlumno = acumuladorNotaAlumno / 5;
            JOptionPane.showMessageDialog(null, "El promedio del alumno " + alumno + " es: " + df.format(promedioAlumno));
            acumuladorPromedios = acumuladorPromedios + promedioAlumno;
            
            if(promedioAlumno >= 3) {
            	contGanaron++;
            }
            else {
            	contPerdieron++;
            }
            
            alumno++;
        }
        
        promedioGeneral = acumuladorPromedios / numAlumnos;
        
        JOptionPane.showMessageDialog(null, "El promedio general del grupo es: " + df.format(promedioGeneral)
                + "\n La cantidad de alumnos que aprobaron fue: " + contGanaron
                + "\n La cantidad de alumnos que reprobaron fue: " + contPerdieron);
    }
}