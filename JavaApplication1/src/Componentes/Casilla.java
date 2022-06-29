package Componentes;

import javax.swing.*;
import java.awt.*;
public class Casilla extends JPanel{
    
    private JButton casilla;
    private JLabel tipo;
    private JButton[]jugadores;
    private JPanel sur,norte,este,oeste;
    private final Color COLOR=Color.LIGHT_GRAY;
    
    
    public Casilla(){
        casilla=new JButton();
        tipo=new JLabel("");
        sur=new JPanel();
        sur=new JPanel();
        norte=new JPanel();
        este=new JPanel();
        oeste=new JPanel();
        tipo=new JLabel();
        hazInterfaz();
    }
    
    public void hazInterfaz(){
        setLayout(new BorderLayout());
        
        este.setBackground(Color.WHITE);
        oeste.setBackground(Color.WHITE);
        norte.setBackground(Color.BLACK);
        sur.setLayout(new GridLayout(0,5));
        

        
        norte.add(tipo);
        add(este,BorderLayout.EAST);
        add(oeste,BorderLayout.WEST);
        add(sur,BorderLayout.SOUTH);
        add(norte,BorderLayout.NORTH);
        add(casilla,BorderLayout.CENTER);
    }
    public void asignaJugadoresACasillas(int totJugadores){        
        jugadores=new JButton[totJugadores];
        for(int i=0;i<jugadores.length;i++){
            jugadores[i]=new JButton();
            jugadores[i].setBackground(COLOR);
                sur.add(jugadores[i]);
        }
    }
    
    public JButton getCasilla(){
        return casilla;
    }
    public JButton[] getJugadores(){
        return jugadores;
    }
    public JLabel getTipo(){
            return tipo;
    }
    public Color getColorDefault(){
        return COLOR;
    }
}