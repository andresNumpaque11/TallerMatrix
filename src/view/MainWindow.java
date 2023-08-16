package view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Andres Numpaque
 */
public class MainWindow extends JFrame{
    
    private PanelMatrix panelMatrix;

    public MainWindow(ActionListener listener){
        super("Trasponer Matriz");
        initComponents(listener);
        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    private void initComponents(ActionListener listener) {
        panelMatrix = new PanelMatrix(listener);
        add(panelMatrix);
    }

    public PanelMatrix getPanelMatrix() {
        return panelMatrix;
    }
    
    
    
    
}
