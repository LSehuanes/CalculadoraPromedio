package pg_Metodos;
import javax.swing.JOptionPane;
public class cls_MetodosPosgrado {
    private Pilas.Pilas<pg_Objetos.cls_Posgrado> pilaPosgrado;
    private Pilas.Pilas<pg_Objetos.cls_Posgrado> auxPosgrado;
    private String Cadena;

    public cls_MetodosPosgrado () {
        pilaPosgrado = new Pilas.Pilas();
        auxPosgrado = new Pilas.Pilas();
        Cadena = "";
    }

    //CRUD
    public String CrearPosgradoo() {
        float promedio2 = PromedioPosgrado();
        int cat;
        pilaPosgrado.Apilar(new pg_Objetos.cls_Posgrado(
            JOptionPane.showInputDialog("Ingrese el nombre del estudiante"),
            JOptionPane.showInputDialog("Ingrese el apellido del estudiante"),
            JOptionPane.showInputDialog("Ingrese el codigo del estudiante"),
            JOptionPane.showInputDialog("Ingrese el nombre del titulo con el que cuenta"),
            JOptionPane.showInputDialog("Ingrese el nombre de la carrera actual de posgrado"),
            promedio2
        ));
        return "ESTUDIANTE REGISTRADO";
    }   
    
    public String MostrarPosgrado() {

        Cadena = "LISTADO DE ESTUDIANTES REGISTRADOS CON SUS PROMEDIOS\n";

        while (!pilaPosgrado.EstaVacia()) {
            pg_Objetos.cls_Posgrado objPosgrado = new pg_Objetos.cls_Posgrado();
            objPosgrado = pilaPosgrado.getElemento();
            Cadena += "NOMBRE: " + objPosgrado.getNombre() + "\n"
                    + "APELLIDO: " + objPosgrado.getApellido() + "\n"
                    + "CODIGO: " + objPosgrado.getCodigoEstudiante() + "\n"
                    + "TITULO: " + objPosgrado.getTitulo() + "\n"
                    + "CARRERA DE POSGRADO: " + objPosgrado.getCarreraPosgrado() + "\n" 
                    + "PROMEDIO DEL SEMESTRE: " + objPosgrado.getPromedioSemestre2() + "\n"
                    + "_________________________________________\n";
            auxPosgrado.Apilar(objPosgrado);
            pilaPosgrado.Desapilar();
        }
        DevolverPilaPosgrado();
        return Cadena;
    }
    
    private void DevolverPilaPosgrado() {
        while (!auxPosgrado.EstaVacia()) {
        pilaPosgrado.Apilar(auxPosgrado.getElemento());
        auxPosgrado.Desapilar();
    }
    }
    
    public String BuscarPosgrado(String CodigoEstudiante) {
        Cadena = "";
        boolean Banderita = false;
        while (!pilaPosgrado.EstaVacia()) {
            pg_Objetos.cls_Posgrado objPosgrado = new pg_Objetos.cls_Posgrado();
            objPosgrado = pilaPosgrado.getElemento();
            if (objPosgrado.getCodigoEstudiante().equalsIgnoreCase(CodigoEstudiante)) {
                Cadena = "ESTUDIANTE ENCONTRADO CON ÉXITO:\n"
                        + "NOMBRE: " + objPosgrado.getNombre() + "\n"
                        + "APELLIDO " + objPosgrado.getApellido() + "\n"
                        + "CODIGO: " + objPosgrado.getCodigoEstudiante() + "\n"
                        + "TITULO: " + objPosgrado.getTitulo() + "\n"
                        + "CARRERA DE POSGRADO: " + objPosgrado.getCarreraPosgrado() + "\n"
                        + "PROMEDIO DEL SEMESTRE: " + objPosgrado.getPromedioSemestre2() + "\n"
                        + "_________________________________________\n";
                Banderita = true;
            }

            auxPosgrado.Apilar(objPosgrado);
            pilaPosgrado.Desapilar();
        }
        DevolverPilaPosgrado();
        if (Banderita) {
            return Cadena;
        } else {
            return "EL ESTUDIANTE NO EXISTE";
        }
    } 
    
    public String ActualizarPosgrado(String CodigoEstudiante) {
        Cadena = "";
        boolean Banderita = false;
        int opcion = 0;
        while (!pilaPosgrado.EstaVacia()) {
            pg_Objetos.cls_Posgrado objPosgrado = new pg_Objetos.cls_Posgrado();
            objPosgrado = pilaPosgrado.getElemento();
            if (objPosgrado.getCodigoEstudiante().equalsIgnoreCase(CodigoEstudiante)) {
                while (JOptionPane.showConfirmDialog(null, "¿Desea "
                        + "modificar un campo del estudiante?") == JOptionPane.YES_NO_OPTION) {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué"
                            + "campo del estudiante desea modificar?\n"
                            + "1. NOMBRE\n"
                            + "2. APELLIDO\n"
                            + "3. CODIGO\n "
                            + "4. TITULO\n"
                            + "5. CARRERA DE POSGRADO\n"        
                    ));
                    switch (opcion) {
                        case 1:
                            objPosgrado.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre"));
                            JOptionPane.showMessageDialog(null, "Nombre modificado con éxito");
                            break;

                        case 2:
                            objPosgrado.setApellido(JOptionPane.showInputDialog("Ingrese el nuevo apellido"));
                            JOptionPane.showMessageDialog(null, "Apellido modificado con éxito");
                            break;

                        case 3:
                            objPosgrado.setCodigoEstudiante(JOptionPane.showInputDialog("Ingrese el nuevo codigo"));
                            JOptionPane.showMessageDialog(null, "Codigo modificado con éxito");
                            break;
                        case 4:
                            objPosgrado.setTitulo(JOptionPane.showInputDialog("Ingrese el nombre del titulo obtenido"));
                            JOptionPane.showMessageDialog(null, "Nombre de la carrera modificado con éxito");
                            break;
                        case 5:
                            objPosgrado.setCarreraPosgrado(JOptionPane.showInputDialog("Ingrese el nuevo nombre de la facultad"));
                            JOptionPane.showMessageDialog(null, "Nombre de la carrera posgrado modificado con exito");
                            break;     
                        default:
                            JOptionPane.showMessageDialog(null, "Opción incorrecta");
                    }
                }
                Banderita = true;
            }

            auxPosgrado.Apilar(objPosgrado);
            pilaPosgrado.Desapilar();
    }
        DevolverPilaPosgrado();
            if (Banderita) {
                return "Dato del estudiante modificado con éxito";
            } else {
                return "El estudiante con ese codigo no existe en el sistema";
            }
    }

    public String BorrarPosgrado(String CodigoEstudiante) {
        Cadena = "";
        boolean Banderita = false;
        while (!pilaPosgrado.EstaVacia()) {
            pg_Objetos.cls_Posgrado objPosgrado = new pg_Objetos.cls_Posgrado();
            objPosgrado = pilaPosgrado.getElemento();
            if (objPosgrado.getCodigoEstudiante().equalsIgnoreCase(CodigoEstudiante)) {
                objPosgrado = null;
                Banderita = true;
                Cadena = "Estudiante encontrado y eliminado con éxito";
                pilaPosgrado.Desapilar();
            } else {
                auxPosgrado.Apilar(objPosgrado);
                pilaPosgrado.Desapilar();
            }

        }
        DevolverPilaPosgrado();
        if (Banderita) {
            return Cadena;
        } else {
            return "El estudiante no existe";
        }
    }
    
    public float PromedioPosgrado(){
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
        return Resultado; */
        
        while (true) {
            try {
                NumeroMaterias = Integer.parseInt(JOptionPane.showInputDialog(null, "¿CUÁNTAS MATERIAS CURSÓ ESTE SEMESTRE?"));
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
                            JOptionPane.showMessageDialog(null, "LA NOTA INGRESADA NO ES VÁLIDA EN NUESTRO SISTEMA, RECUERDE (0.0 - 5.0)");
                        } else {
                           break;
                        }
                    } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UNA NOTA QUE SEA VALIDAD");
                    }
                }
            Suma += Notas[i];
        }

            Resultado = Suma / NumeroMaterias;
        } catch (NegativeArraySizeException e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            return 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
            return 0;
        }
    return Resultado;
    }
}