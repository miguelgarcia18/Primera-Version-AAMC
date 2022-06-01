
package Biblioteca;
/**
 * @author AAMC♡
 */
public class Libro {
    int id;
    String nombreLibro;
    String autor;
    String publicacion;

    public Libro() {
        
    }
    public Libro(int id, String nombreLibro, String autor, String publicacion) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.publicacion = publicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }
    
}
