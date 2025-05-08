package pg_Objetos;


public class cls_Posgrado {

    private String Nombre;
    private String Apellido;
    private String CodigoEstudiante;
    private String Titulo;
    private String CarreraPosgrado;
    private float PromedioSemestre2;
    
    public cls_Posgrado(){
        this.Nombre = "";
        this.Apellido = "";
        this.CodigoEstudiante= "";
        this.Titulo = "";
        this.CarreraPosgrado = "";
        this.PromedioSemestre2 = 0;
    }

    public cls_Posgrado(String Nombre, String Apellido, String CodigoEstudiante, String Titulo, String CarreraPosgrado, float PromedioSemestre2) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.CodigoEstudiante = CodigoEstudiante;
        this.Titulo = Titulo;
        this.CarreraPosgrado = CarreraPosgrado;
        this.PromedioSemestre2 = PromedioSemestre2;
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

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getCarreraPosgrado() {
        return CarreraPosgrado;
    }

    public void setCarreraPosgrado(String CarreraPosgrado) {
        this.CarreraPosgrado = CarreraPosgrado;
    }

    public float getPromedioSemestre2() {
        return PromedioSemestre2;
    }

    public void setPromedioSemestre2(float PromedioSemestre2) {
        this.PromedioSemestre2 = PromedioSemestre2;
    }

}


