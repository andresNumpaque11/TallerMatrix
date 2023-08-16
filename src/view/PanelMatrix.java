package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andres Numpaque
 */
public class PanelMatrix extends JPanel {

    private JLabel rows;
    private JLabel columns;
    private JLabel numbers;
    private JTextField txtFill;
    private JTextField txtRows;
    private JTextField txtColumns;
    private JButton btnShowMatrix;
    private JButton btnTrasMatrix;
    private JButton btnFill;
    private JButton btnok;

    private JTable matrix;
    private DefaultTableModel tableModel;

    private int numColumns;
    private int numRows;

    public PanelMatrix(ActionListener listener) {
        this.setLayout(null);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        rows = new JLabel("Filas: ");
        rows.setBounds(50, 0, 100, 25);
        add(rows);
        txtRows = new JTextField(10);
        txtRows.setBounds(90, 0, 50, 25);
        add(txtRows);
        columns = new JLabel("Columnas: ");
        columns.setBounds(210, 0, 100, 25);
        add(columns);
        txtColumns = new JTextField(10);
        txtColumns.setBounds(280, 0, 50, 25);
        add(txtColumns);
        btnok = new JButton("Crear Matriz");
        btnok.setBounds(350, 0, 50, 25);
        btnok.addActionListener(listener);
        btnok.setActionCommand("ok");
        add(btnok);
        numbers = new JLabel("Numeros: ");
        numbers.setBounds(50, 50, 100, 25);
        add(numbers);
        txtFill = new JTextField(10);
        txtFill.setBounds(110, 50, 50, 25);
        add(txtFill);
        btnFill = new JButton("Rellenar");
        btnFill.setBounds(170, 50, 150, 26);
        btnFill.addActionListener(listener);
        btnFill.setActionCommand("rellenar");
        add(btnFill);
        btnShowMatrix = new JButton("Mostrar Matriz");
        btnShowMatrix.setBounds(90, 90, 150, 26);
        btnShowMatrix.addActionListener(listener);
        btnShowMatrix.setActionCommand("mostrar");
        add(btnShowMatrix);
        btnTrasMatrix = new JButton("Transponer Matriz");
        btnTrasMatrix.setBounds(280, 90, 150, 25);
        btnTrasMatrix.addActionListener(listener);
        btnTrasMatrix.setActionCommand("transponer");
        add(btnTrasMatrix);

    }

    public void createTable(ArrayList<Integer> list) {
        String[] columnNames = new String[numColumns];
        for (int i = 0; i < numColumns; i++) {
            columnNames[i] = "Columna " + (i + 1);
        }
        matrix = new JTable(formatArray(list), columnNames);
        matrix.getTableHeader().setVisible(false);
        JScrollPane jScrollPane = new JScrollPane(matrix);
        jScrollPane.setBounds(0, 150, 200, 400);
        add(jScrollPane);
        ArrayList r = new ArrayList();
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColumnCount(); j++) {
                r.add(matrix.getModel().getValueAt(i, j));

            }

        }
        System.out.println("datos del jtable:"+ r);
        revalidate();
        repaint();
    }

    private Object[][] formatArray(ArrayList<Integer> list) {
        Object[][] matrixResult = new Object[numRows][numColumns];
        int aux = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(aux + " otro: " + (i - (aux * numRows)));
            matrixResult[aux][i - (aux * numRows)] = list.get(i);
            if (((i + 1) % numRows) == 0) {
                aux++;
            }
        }
        return matrixResult;
    }

    public JTextField getTxtFill() {
        return txtFill;
    }

    public JTextField getTxtColumns() {
        return txtColumns;
    }

    public JTextField getTxtRows() {
        return txtRows;
    }

    public JButton getBtnFill() {
        return btnFill;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

}
