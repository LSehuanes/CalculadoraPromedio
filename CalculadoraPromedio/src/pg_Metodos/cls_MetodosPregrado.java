package pg_Metodos;
import javax.swing.JOptionPane;
public class cls_MetodosPregrado {
   
    private Pilas.Pilas<pg_Objetos.cls_Pregrado> pilaPregrado;
    private Pilas.Pilas<pg_Objetos.cls_Pregrado> auxPregrado;
    private String Cadena;

    public cls_MetodosPregrado () {
        pilaPregrado = new Pilas.Pilas();
        auxPregrado = new Pilas.Pilas();
        Cadena = "";
    }

    //CRUD
    public String CrearPregrado() {
        float promedio = PromedioPregrado();
        int cat;
        pilaPregrado.Apilar(new pg_Objetos.cls_Pregrado(
            JOptionPane.showInputDialog("Ingrese el nombre del estudiante"),
            JOptionPane.showInputDialog("Ingrese el apellido del estudiante"),
            JOptionPane.showInputDialog("Ingrese el codigo del estudiante"),
            JOptionPane.showInputDialog("Ingrese el nombre de la carrera del estudiante"),
            JOptionPane.showInputDialog("Ingrese el nombre de la facultad del estudiante"),
            promedio
        ));
        return "ESTUDIANTE REGISTRADO";
    }   
    
    public String ListadoPregrado() {
        Cadena = "LISTADO DE ESTUDIANTES REGISTRADOS CON SUS PROMEDIOS\n";

        while (!pilaPregrado.EstaVacia()) {
            pg_Objetos.cls_Pregrado objPregrado = new pg_Objetos.cls_Pregrado();
            objPregrado = pilaPregrado.getElemento();
            Cadena += "NOMBRE: " + objPregrado.getNombre() + "\n"
                    + "APELLIDO: " + objPregrado.getApellido() + "\n"
                    + "CODIGO: " + objPregrado.getCodigoEstudiante() + "\n"
                    + "CARRERA: " + objPregrado.getCarrera() + "\n"
                    + "FACULTAD: " + objPregrado.getFacultad() + "\n"
                    + "PROMEDIO DEL SEMESTRE: " + objPregrado.getPromedioSemestre() + "\n"
                    + "_________________________________________\n";
            auxPregrado.Apilar(objPregrado);
            pilaPregrado.Desapilar();
        }
        DevolverPilaPregrado();
        return Cadena;
    }
    
    private void DevolverPilaPregrado() {
        while (!auxPregrado.EstaVacia()) {
        pilaPregrado.Apilar(auxPregrado.getElemento());
        auxPregrado.Desapilar();
    }
    }
    
    public String BuscarPregrado(String CodigoEstudiante) {
        Cadena = "";
        boolean Banderita = false;
        while (!pilaPregrado.EstaVacia()) {
            pg_Objetos.cls_Pregrado objPregrado = new pg_Objetos.cls_Pregrado();
            objPregrado = pilaPregrado.getElemento();
            if (objPregrado.getCodigoEstudiante().equalsIgnoreCase(CodigoEstudiante)) {
                Cadena = "ESTUDIANTE ENCONTRADO CON ÉXITO:\n"
                        + "NOMBRE: " + objPregrado.getNombre() + "\n"
                        + "APELLIDO " + objPregrado.getApellido() + "\n"
                        + "CODIGO: " + objPregrado.getCodigoEstudiante() + "\n"
                        + "CARRERA: " + objPregrado.getCarrera() + "\n"
                        + "FACULTAD: " + objPregrado.getFacultad() + "\n"  
                        + "PROMEDIO DEL SEMESTRE: " + objPregrado.getPromedioSemestre() + "\n"
                        + "_________________________________________\n";
                Banderita = true;
            }

            auxPregrado.Apilar(objPregrado);
            pilaPregrado.Desapilar();
        }
        DevolverPilaPregrado();
        if (Banderita) {
            return Cadena;
        } else {
            return "EL ESTUDIANTE NO EXISTE";
        }
    } 
    
    public String ActualizarPregrado(String CodigoEstudiante) {
        Cadena = "";
        boolean Banderita = false;
        int opcion = 0;
        while (!pilaPregrado.EstaVacia()) {
            pg_Objetos.cls_Pregrado objPregrado = new pg_Objetos.cls_Pregrado();
            objPregrado = pilaPregrado.getElemento();
            if (objPregrado.getCodigoEstudiante().equalsIgnoreCase(CodigoEstudiante)) {
                while (JOptionPane.showConfirmDialog(null, "¿Desea "
                        + "modificar un campo del estudiante?") == JOptionPane.YES_NO_OPTION) {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué"
                            + "campo del estudiante desea modificar?\n"
                            + "1. NOMBRE\n"
                            + "2. APELLIDO\n"
                            + "3. CODIGO\n "
                            + "4. CARRERA\n"
                            + "5. FACULTAD\n"        
                    ));
                    switch (opcion) {
                        case 1:
                            objPregrado.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre"));
                            JOptionPane.showMessageDialog(null, "Nombre modificado con éxito");
                            break;

                        case 2:
                            objPregrado.setApellido(JOptionPane.showInputDialog("Ingrese el nuevo apellido"));
                            JOptionPane.showMessageDialog(null, "Apellido modificado con éxito");
                            break;

                        case 3:
                            objPregrado.setCodigoEstudiante(JOptionPane.showInputDialog("Ingrese el nuevo codigo"));
                            JOptionPane.showMessageDialog(null, "Codigo modificado con éxito");
                            break;
                        case 4:
                            objPregrado.setCarrera(JOptionPane.showInputDialog("Ingrese el nombre de la nueva carrera"));
                            JOptionPane.showMessageDialog(null, "Nombre de la carrera modificado con éxito");
                            break;
                        case 5:
                            objPregrado.setFacultad(JOptionPane.showInputDialog("Ingrese el nuevo nombre de la facultad"));
                            JOptionPane.showMessageDialog(null, "Nombre de la facultad modificado con éxito");
                            break;     
                        default:
                            JOptionPane.showMessageDialog(null, "Opción incorrecta");
                    }
                }
                Banderita = true;
            }

            auxPregrado.Apilar(objPregrado);
            pilaPregrado.Desapilar();
    }
        DevolverPilaPregrado();
            if (Banderita) {
                return "Dato del estudiante modificado con éxito";
            } else {
                return "El estudiante con ese codigo no existe en el sistema";
            }
    }

    public String BorrarPregrado(String CodigoEstudiante) {
        Cadena = "";
        boolean Banderita = false;
        while (!pilaPregrado.EstaVacia()) {
            pg_Objetos.cls_Pregrado objPregrado = new pg_Objetos.cls_Pregrado();
            objPregrado = pilaPregrado.getElemento();
            if (objPregrado.getCodigoEstudiante().equalsIgnoreCase(CodigoEstudiante)) {
                objPregrado = null;
                Banderita = true;
                Cadena = "Estudiante encontrado y eliminado con éxito";
                pilaPregrado.Desapilar();
            } else {
                auxPregrado.Apilar(objPregrado);
                pilaPregrado.Desapilar();
            }

        }
        DevolverPilaPregrado();
        if (Banderita) {
            return Cadena;
        } else {
            return "El estudiante no existe";
        }
    }
    public float PromedioPregrado(){
        int NumeroMaterias = 0;
        float Resultado;
        float Suma = 0;
        /*NumeroMaterias = Integer.parseInt(JOptionPane.showInputDialog(null, "¿CUANTAS MATERIAS CURSO ESTE SEMESTRE?"));
        float Notas[] = new float[NumeroMaterias];
        for (int i = 0; i < NumeroMaterias; i++) {
            
            while(true){
                Notas[i] =  Float.parseFloat(JOptionPane.showInputDialog(null, "INGRESE LA NOTA DE LA MATERIA " + (i+1) + " (0.0 - 5.0)"));
                if (Notas[i]<0 || Notas[i]>5) {
                   JOptionPane.showMessageDialog(null, "LA NOTA INGRESADA NO ES VALIDAD EN NUESTRO SISTEMA");
                } else {
                    break;
                }
            }
            Suma += Notas[i];
        }
        Resultado = Suma/NumeroMaterias;
        return Resultado;*/

        while (true) {
            try {
                NumeroMaterias = Integer.parseInt(JOptionPane.showInputDialog(null, "¿CUÁNTAS MATERIAS CURSÓ ESTE SEMESTRE 2024 - 1?"));
                if (NumeroMaterias <= 0) {
                JOptionPane.showMessageDialog(null, "EL NUMERO DE MATERIAS DEBE SER UN NUMERO POSITIVO");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UN NUMERO");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR");
                return 0; 
            }
        }

        try {
            float[] Notas = new float[NumeroMaterias];
            for (int i = 0; i < NumeroMaterias; i++) {
            while (true) {
                try {
                    Notas[i] = Float.parseFloat(JOptionPane.showInputDialog(null, "INGRESE LA NOTA DE LA MATERIA " + (i + 1)));
                    if (Notas[i] < 0 || Notas[i] > 5) {
                        JOptionPane.showMessageDialog(null, "LA NOTA INGRESADA NO ES VÁLIDA EN NUESTRO SISTEMA  (0.0 - 5.0)");
                    } else {
                        break; 
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UNA NOTA VALIDA");
                }
            }
            Suma += Notas[i];
            }

            Resultado = Suma / NumeroMaterias;
        } catch (NegativeArraySizeException e) {
            JOptionPane.showMessageDialog(null, "EL NUMERO DE MATERIAS DEBE SER POSITIVO");
            return 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            return 0;
    }
    return Resultado;
    } 
}
    


