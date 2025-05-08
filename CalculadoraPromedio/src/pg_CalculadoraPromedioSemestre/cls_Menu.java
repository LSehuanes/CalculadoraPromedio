package pg_CalculadoraPromedioSemestre;

import javax.swing.JOptionPane;

import pg_Metodos.cls_MetodosPregrado;
import pg_Metodos.cls_MetodosPosgrado;
import pg_Objetos.cls_Pregrado;
import pg_Objetos.cls_Posgrado;

public class cls_Menu {

    public static void main(String[] args) {

        int Opcion1 = 0;
        int Opcion2 = 0;
        boolean Boton1 = true;

        String respuesta = "";
        String Menu = "";
        cls_MetodosPregrado ObjPre = new cls_MetodosPregrado();
        cls_MetodosPosgrado ObjPos = new cls_MetodosPosgrado();
        
        JOptionPane.showMessageDialog(null, "BIENVENIDO AL SISTEMA CALCULADORA DE PROMEDIOS 2024 - 1"
                + "");
        JOptionPane.showMessageDialog(null, "FELICITACIONES POR CULMINAR EL SEMESTRE DE MANERA SATISFATORIA");

        while (Boton1) {
            Boton1 = true;
            boolean Boton2 = true;
            boolean Boton3 = true;
            
            Opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null, "SELECCIONE UN ROL\n"
                + "1. ESTUDIANTE DE PREGRADO \n"
                + "2. ESTUDIANTE DE POSGRADO \n"
                + "3. SALIR DE SISTEMA"));
            while(Boton2){
                switch (Opcion1) {
                    case 1:
                        Menu = "PREGRADO";
                        Opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, "ESCOJA UNA ACCION A REALIZAR\n"
                                + "===================================== \n"
                                + "1. HALLAR PROMEDIO Y REGISTRAR \n"
                                + "2. LISTADO DE ESTUDIANTES CON SU PROMEDIO \n"
                                + "3. ACTUALIZAR UN DATO PERSONAL DE UN ESTUDIANTE \n"
                                + "4. ELIMINAR ESTUDIANTE CON SUS DATOS \n"));
                        switch (Opcion2) {
                            case 1:
                                JOptionPane.showMessageDialog(null, ObjPre.CrearPregrado());
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, ObjPre.ListadoPregrado());
                                break;
                            case 3:
                JOptionPane.showMessageDialog(null, ObjPre.ActualizarPregrado( JOptionPane.showInputDialog("INGRESE EL CODIGO DEL ESTUDAINTE QUE QUIERE MODIFICAR")));
                                break;
                            case 4:
                JOptionPane.showMessageDialog(null, ObjPre.BorrarPregrado( JOptionPane.showInputDialog("INGRESE EL CODIGO DEL ESTUDAINTE QUE QUIERE MODIFICAR")));                                
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                                break;
                        }
                        break;
                    case 2:
                        Menu = "POSGRADO";
                        Opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, "ESCOJA UNA ACCION A REALIZAR\n"
                                + "===================================== \n"
                                + "1. HALLAR PROMEDIO Y REGISTRAR \n"
                                + "2. LISTADO DE ESTUDIANTES CON SU PROMEDIO \n"
                                + "3. ACTUALIZAR UN DATO PERSONAL DE UN ESTUDIANTE \n"
                                + "4. ELIMINAR ESTUDIANTE CON SUS DATOS \n"));
                        switch (Opcion2) {
                            case 1:
                                JOptionPane.showMessageDialog(null, ObjPos.CrearPosgradoo());
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, ObjPos.MostrarPosgrado());
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, ObjPos.ActualizarPosgrado(JOptionPane.showInputDialog("INGRESE EL CODIGO DEL ESTUDAINTE QUE QUIERE MODIFICAR")));
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, ObjPos.BorrarPosgrado(JOptionPane.showInputDialog("INGRESE EL CODIGO DEL ESTUDAINTE QUE QUIERE MODIFICAR")));                                
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                                break;
                        }
                        break;

                    case 3:
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                        Boton3 = false;
                        Boton2 = false;
                        break;
                }
                while (Boton3) {
                    respuesta = JOptionPane.showInputDialog("¿QUIERES VOLVER AL MENU DE " + Menu + "? " + "(si/no)");
                    if (respuesta.equalsIgnoreCase("si")) {
                        break;
                    } else if (respuesta.equalsIgnoreCase("no")) {
                        Boton2 = false;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "ESA RESPUESTA NO ES VALIDA");
                    }
                }
            }

        }
    }
}
