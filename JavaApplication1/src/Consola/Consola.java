
package JavaApplication1.consola;

import JavaApplication1.datos.EscribirDatosConsola;
import JavaApplication1.datos.LeerDatos;
import JavaApplication1.datos.RankingDatos;
import JavaApplication1.tablero.TableroConsola;
import java.util.Random;

/**
 * 
 * Clase donde se maneja y procesa los datos a mostrar por la Consola 
 * (interfaz del usuario)
 *
 */
public class Consola {
    private InterfazConsola pregunta = new InterfazConsola();
    private int tableroDatos[] = new int[4];
    private int serpientesDatos[][];
    private int numSerpientes;
    private int escalerasDatos[][];
    private String jugadoresNombres[];
    private int numEscaleras;
    private int numJugadores;
    private InterfazConsola interfaz = new InterfazConsola();
    private TableroConsola tablero;
    
    /**
     * Clase principal de la aplicacion
     */
    public void iniciarJuego() {
       menu();
    }
    
    /**
     * Clase que ordena los metodos de la aplicacion para obtener
     * los datos del archivo de texto
     */
    private void obtenerDatos() {
        LeerDatos datos = new LeerDatos();
        if(datos.existeArchivo()) {
            try {
                this.serpientesDatos = datos.getDatosSerpientes();
                this.numSerpientes = serpientesDatos.length;
                this.escalerasDatos = datos.getDatosEscalera();
                this.numEscaleras = escalerasDatos.length;
                this.tableroDatos = datos.getDatosTablero();
            } catch(Exception e) {
                interfaz.mostrarError("El archivo de datos esta corrupto tendras que crearlo denuevo");
                pedirDatos();
                obtenerDatos();
            }
        } else {
            interfaz.mostrarError("El archivo de guardado no existe");
            pedirDatos();
            obtenerDatos();
        }
    }
    
    /**
     * Metodo que pide el nombre de cada jugador y valida si este es igual
     */
    private void pedirJugadores() {
        jugadoresNombres = new String[numJugadores];
        boolean nombreValido = true;
        for (int i = 0; i < numJugadores; i++) {
            do {
                nombreValido = true;
                jugadoresNombres[i] = pregunta.preguntarCadena("Ingrese el nombre del jugador("+(i+1)+")");
                for (int j = 0; j < i; j++) {
                    if(jugadoresNombres[i].equals(jugadoresNombres[j])) {
                        nombreValido = false;
                        interfaz.mostrarError("El nombre ingresado ya existe lo usa otro jugador");
                    }
                }
            } while(!nombreValido);
            tablero.agregarJugador(jugadoresNombres[i], i);
        }
    }
    
    /**
     * Metodo que carga los datos obtenidos hacia el tablero
     */
    private void cargarDatos() {
        for (int i = 0; i < numSerpientes; i++) {
            tablero.agregarSerpiente(serpientesDatos[i][0], 
                                    serpientesDatos[i][1], 
                                    serpientesDatos[i][2], 
                                    serpientesDatos[i][3], i);    
        }
        for (int i = 0; i < numEscaleras; i++) {
            tablero.agregarEscalera(escalerasDatos[i][0], 
                                    escalerasDatos[i][1], 
                                    escalerasDatos[i][2], 
                                    escalerasDatos[i][3], i);
        }
    }
    
    /**
     * Metodo menu principal de la aplicacion
     */
    private void menu() {
        int opcion;
        interfaz.mostrarTitulo();
        interfaz.mostrarFase("Menu del juego");
        interfaz.mostrarOpcionMenu("Inicia el juego con los datos guardados anteriormente", 1);
        interfaz.mostrarOpcionMenu("Crear tablero del juego", 2);
        interfaz.mostrarOpcionMenu("Ver reglas del juego", 3);
        interfaz.mostrarOpcionMenu("Ver los 3 mejores jugadores", 4);
        System.out.println();
        opcion = interfaz.preguntarNumero("Insertar opcion");
        procesarMenu(opcion);
    }
    
    /**
     * Procesa los datos insertados por el usuario mediante el menu
     * @param opcion Dato insertado por el usuario
     */
    private void procesarMenu(int opcion) {
        switch(opcion) {
            case 1:
                iniciarJuegoConsola();
                break;
            case 2:
                pedirDatos();
                iniciarJuegoConsola();
                break;
            case 3:
                mostrarReglas();
                menu();
                break;
            case 4:
                mostrarRanking();
                menu();
                break;
            default:
                break;
        }
    }