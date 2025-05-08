package pg_Objetos;


public class cls_Pregrado {
    private String Nombre;
    private String Apellido;
    private String CodigoEstudiante;
    private String Carrera;
    private String Facultad;
    private float PromedioSemestre;

    
    public cls_Pregrado(){
        this.Nombre = "";
        this.Apellido = "";
        this.CodigoEstudiante= "";
        this.Carrera = "";
        this.Facultad = "";
        this.PromedioSemestre = 0;
    }

    public cls_Pregrado(String Nombre, String Apellido, String CodigoEstudiante, String Carrera, String Facultad, float PromedioSemestre) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.CodigoEstudiante = CodigoEstudiante;
        this.Carrera = Carrera;
        this.Facultad = Facultad;
        this.PromedioSemestre = PromedioSemestre;
        
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCodigoEstudiante() {
        return CodigoEstudiante;
    }

    public void setCodigoEstudiante(String CodigoEstudiante) {
        this.CodigoEstudiante = CodigoEstudiante;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getFacultad() {
        return Facultad;
    }

    public void setFacultad(String Facultad) {
        this.Facultad = Facultad;
    }

    public float getPromedioSemestre() {
        return PromedioSemestre;
    }

    public void setPromedioSemestre(float PromedioSemestre) {
        this.PromedioSemestre = PromedioSemestre;
    }
    
}
