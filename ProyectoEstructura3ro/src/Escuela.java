import java.util.Random;

public class Escuela implements Comparable<Escuela> {
    private String nombre, tipo, direccion, codigoAlfaNumerico;

    public Escuela(String nombre, String tipo, String direcccion) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.direccion = direcccion;
        this.codigoAlfaNumerico = generateAlphanumericCode(8);
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoAlfaNumerico() {
        return codigoAlfaNumerico;
    }

    public void setCodigoAlfaNumerico(String codigoAlfaNumerico) {
        this.codigoAlfaNumerico = codigoAlfaNumerico;
    }

    @Override
    public int compareTo(Escuela otraEscuela) {
        return this.codigoAlfaNumerico.compareTo(otraEscuela.codigoAlfaNumerico);
    }

    public static String generateAlphanumericCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Escuela [nombre=" + nombre + ", tipo=" + tipo + ", direccion=" + direccion + ", codigoAlfaNumerico="
                + codigoAlfaNumerico + "]";
    }

    // implementacion equals para usar el metodo contains
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoAlfaNumerico == null) ? 0 : codigoAlfaNumerico.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Escuela other = (Escuela) obj;
        if (codigoAlfaNumerico == null) {
            if (other.codigoAlfaNumerico != null)
                return false;
        } else if (!codigoAlfaNumerico.equals(other.codigoAlfaNumerico))
            return false;
        return true;
    }

}