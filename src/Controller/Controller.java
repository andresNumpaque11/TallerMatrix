package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Matrix;
import view.MainWindow;

/**
 *
 * @author Andres Numpaque
 */
public class Controller implements ActionListener {

    private Matrix matrix;
    private MainWindow mainWindow;

    public Controller() {
        mainWindow = new MainWindow(this);

    }

    private void createMatrix() {
        mainWindow.getPanelMatrix().setNumRows(matrix.getRows());
        mainWindow.getPanelMatrix().setNumColumns(matrix.getColumns());
        mainWindow.getPanelMatrix().createTable(matrix.getNumbers());
    }

    private void startMatrix() {
        int rows = Integer.parseInt(mainWindow.getPanelMatrix().getTxtRows().getText());
        int columns = Integer.parseInt(mainWindow.getPanelMatrix().getTxtColumns().getText());
        matrix = new Matrix(rows, columns);
        System.out.println("filas: " + rows + "=" + matrix.getRows());
        System.out.println("columnas: " + columns + "=" + matrix.getRows());
    }

    private void getdatas() {

        int limit = matrix.getRows() * matrix.getColumns();
        System.out.println("limit=" + limit);
        int number = 0;
        if (matrix.getNumbers().size() <= limit) {
            number = Integer.parseInt(mainWindow.getPanelMatrix().getTxtFill().getText());
            matrix.add(number);
            System.out.println("la matriz es: " + matrix.getNumbers());
            System.out.println("size" + matrix.getNumbers().size());
        }
        if (matrix.getNumbers().size() > (limit - 1)) {
            mainWindow.getPanelMatrix().getBtnFill().setEnabled(false);
        }
        mainWindow.getPanelMatrix().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "mostrar":
                createMatrix();
                System.out.println("*procede a Mostrar la matriz");
                break;
            case "transponer":
                System.out.println("*procede a transponer la matriz");
                System.out.println(matrix.transposeMatrix());
                break;
            case "rellenar":
                System.out.println("rellenar");
                getdatas();
                break;
            case "ok":
                startMatrix();
                break;
        }
    }

    public static void main(String[] args) {
        new Controller();
    }

}
