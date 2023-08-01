import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

  static ArrayList<Escuela> listaEscuela = new ArrayList<>();

  public static void main(String[] args) {
    selecciarOpcion();
  }

  public static void inicarSesion() {
    String usuario, contraseña;
    int contraseñaInt, contadorIntentos = 0;
    boolean bandera = true;

    do {
      usuario = JOptionPane.showInputDialog("Usuario");
      contraseña = JOptionPane.showInputDialog("Contraseña");

      if (usuario.length() == 6 && contraseña.matches("\\d+")) {
        contraseñaInt = Integer.parseInt(contraseña);
        bandera = validarInicioSesion(usuario, contraseñaInt);
        if (bandera == true) {
          contadorIntentos = contadorIntentos + 1;
        }

      } else {
        contadorIntentos = contadorIntentos + 1;
        verificarLongitud(usuario, contraseña);
      }
    } while (bandera && contadorIntentos != 3);

    // se verifica si se cerro el ciclo por la cantidad de intentos o porque se
    // inicio sesion correctamente
    if (contadorIntentos == 3) {
      JOptionPane.showMessageDialog(null, "ya ah alcanzado el numero de intentos");
    } else {

    }

  }

  public static void verificarLongitud(String usuario, String contraseña) {
    if (usuario.length() != 6) { //
      JOptionPane.showMessageDialog(null, "la longitud del usuario debe de ser 6 digitos");
    }
    if (!contraseña.matches("\\d+")) {
      JOptionPane.showMessageDialog(null, "La contraseña solo debe de contener digitos numericos");
    }

  }

  public static boolean validarInicioSesion(String usuario, int contraseña) {
    String usuarioBd = "kirito";
    int contraseñaBd = 1234;
    if (usuarioBd.equals(usuario) && contraseñaBd == contraseña) {
      return false;
    } else {
      JOptionPane.showMessageDialog(null, "\"Error, al iniciar sesion");
      return true;
    }

  }

  public static void selecciarOpcion() {
    int selecciar;
    do {
      selecciar = Integer.parseInt(JOptionPane.showInputDialog("seleccione: " + "\n1. Agregar una escuela"
          + "\n2. Modificar Escuela" + "\n3. Ordenar por metodo de burbuja" +
          "\n4. Ordenar Metodo de insercón" + "\n5. Ordenar por el metodo Colleccions"));

      switch (selecciar) {
        case 1:
          agregarEscuelas();
          break;
        case 2:
          modificarEscuela();
          break;

        case 4:
          insertionSort();
          break;

        default:
          break;
      }

    } while (selecciar != 9);

  }

  // 3.2 Modificar una escuela, excepto su código. Debe notificar si existe el
  // código de la escuela está en la lista actual usando el método contains,
  public static void modificarEscuela() {
    String codigoModificar = JOptionPane.showInputDialog("Ingrese el código de la escuela que desea modificar:");

    for (Escuela escuela : listaEscuela) {
      if (escuela.getCodigoAlfaNumerico().equals(codigoModificar)) {
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre de la escuela:");
        String nuevaDireccion = JOptionPane.showInputDialog("Nueva dirección:");
        int seleccionar;
        do {
          seleccionar = Integer.parseInt(JOptionPane.showInputDialog("Nuevo tipo: "
              + "\n1. Prescolar" + "\n2. Primaria" + "\n3. Secundaria\n"));
          switch (seleccionar) {
            case 1:
              escuela.setTipo("Prescolar");
              break;

            case 2:
              escuela.setTipo("Primaria");
              break;

            case 3:
              escuela.setTipo("Secundaria");
              break;

            default:
              JOptionPane.showMessageDialog(null, "Error, elección no disponible");
              break;
          }
        } while (seleccionar <= 0 || seleccionar >= 4);

        escuela.setNombre(nuevoNombre);
        escuela.setDireccion(nuevaDireccion);
        JOptionPane.showMessageDialog(null, "Escuela modificada exitosamente!");
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró una escuela con el código proporcionado.");
  }

  public static void agregarEscuelas() {
    String escuela, tipo = "", direccion;
    int seleccionar;

    escuela = JOptionPane.showInputDialog("Nombre de la escuela: ");
    direccion = JOptionPane.showInputDialog("Direccion: ");

    do {
      seleccionar = Integer
          .parseInt(JOptionPane.showInputDialog("Tipo: " + "\n1. Prescolar" + "\n2. Primaria" + "\n3. Secundaria\n"));
      switch (seleccionar) {
        case 1:
          tipo = "Prescolar";
          break;

        case 2:
          tipo = "Primaria";
          break;

        case 3:
          tipo = "Secundaria";
          break;

        default:
          JOptionPane.showMessageDialog(null, "Error, eleccion no disponible");
          break;
      }

    } while (seleccionar <= 0 || seleccionar >= 4);

    Escuela obj = new Escuela(escuela, tipo, direccion);
    if (!listaEscuela.contains(obj)) {
      listaEscuela.add(obj);
    } else {
      JOptionPane.showMessageDialog(null, "El codigo ya esta en uso");
    }

    for (int i = 0; i < listaEscuela.size(); i++) {
      System.out.println(listaEscuela.get(i).toString());
    }
    System.out.println();

  }

  public static void insertionSort() {
    ArrayList<Escuela> copia = new ArrayList<>();
    copia.addAll(listaEscuela); // copio el arrayList

    for (int i = 0; i < copia.size(); i++) {
      String key = copia.get(i).getCodigoAlfaNumerico();
      int j = i - 1;
      while (j >= 0 && copia.get(j).getCodigoAlfaNumerico().compareTo(key) > 0) {

        copia.get(j + 1).setCodigoAlfaNumerico(copia.get(j).getCodigoAlfaNumerico());
        ;
        j--;
      }
      copia.get(j + 1).setCodigoAlfaNumerico(key);
    }

    System.out.println("=========== Datos Ordenados ===========");
    for (int i = 0; i < copia.size(); i++) {
      System.out.println(copia.get(i).getCodigoAlfaNumerico());
    }
    System.out.println("===========================");
  }

}
