package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.zip.GZIPOutputStream;

import static java.awt.event.MouseEvent.*;

public class GUI_Presentacion extends JFrame {
    //atributostodo lo gráficos son privados
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos, panelMouse;
    private Titulos titulo;
    private JLabel labelImage;
    private Escucha escucha;
    private JTextArea textoExpectativas;

    //metodos
    public GUI_Presentacion() {
        initGUI();
        //Configuracion base de la ventana
        this.setTitle("Mi Presentación");
        this.setSize(800, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("¡Hi! Soy Alexis, para saber un poco más sobre mi presiona los botones de abajo", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);
        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco más de mí...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Calibri",
                        Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi hobbie");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelMouse = new JPanel();
        panelMouse.addMouseListener(escucha);
        panelMouse.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImage = new JLabel();
        textoExpectativas = new JTextArea(20, 50);

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha implements ActionListener, MouseListener, KeyListener {
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null,"Oprimiste un botón");
            panelDatos.removeAll();
            if (e.getSource() == miFoto) {
                image = new ImageIcon(getClass().getResource("/recursos/foto.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
                Image cambioTamano = image.getImage();
                Image tamano = cambioTamano.getScaledInstance(500, 800, Image.SCALE_SMOOTH);
                ImageIcon fin = new ImageIcon(tamano);
                labelImage.setIcon(fin);
            } else {
                if (e.getSource() == miHobby) {
                    image = new ImageIcon(getClass().getResource("/recursos/videojuegos.jpg"));
                    labelImage.setIcon(image);
                    panelDatos.add(labelImage);
                } else {
                    textoExpectativas.setText("No sé mucho de java,\nasí que en este curso espero aprender mucho del lenguaje.\n" +
                            "También quiero aprender a hacer interfaces de usuario para aplicarlo en otros ámbitos de la programación ");
                    textoExpectativas.setBackground(null);
                    textoExpectativas.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 12));
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == miFoto && e.getClickCount()==1){
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/foto.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
                Image cambioTamano = image.getImage();
                Image tamano = cambioTamano.getScaledInstance(500, 800, Image.SCALE_SMOOTH);
                ImageIcon fin = new ImageIcon(tamano);
                labelImage.setIcon(fin);
            } else if (e.getSource() == miHobby && e.getClickCount()==2){
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/videojuegos.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'M' || e.getKeyChar() == 'm'){
                panelDatos.removeAll();
                textoExpectativas.setText("No sé mucho de java,\nasí que en este curso espero aprender mucho del lenguaje.\n" +
                        "También quiero aprender a hacer interfaces de usuario para aplicarlo en otros ámbitos de la programación ");
                textoExpectativas.setBackground(null);
                textoExpectativas.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 12));
                panelDatos.add(textoExpectativas);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}



