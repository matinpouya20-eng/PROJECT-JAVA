
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainSwing extends JFrame {

    private final JTextField txtName = new JTextField(15);
    private final JTextField txtFamily = new JTextField(15);

    private final DefaultTableModel model =
            new DefaultTableModel(
                    new String[]{"نام", "نام خانوادگی"}, 0
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

    private final JTable table = new JTable(model);

    public MainSwing() {
        setTitle("فرم ورود اطلاعات");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new FlowLayout());

        form.add(new JLabel("نام:"));
        form.add(txtName);

        form.add(new JLabel("نام خانوادگی:"));
        form.add(txtFamily);

        JButton btnAdd = new JButton("افزودن");
        JButton btnDelete = new JButton("حذف");

        form.add(btnAdd);
        form.add(btnDelete);

        btnAdd.addActionListener(e -> addRecord());
        btnDelete.addActionListener(e -> deleteRecord());

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void addRecord() {
        String name = txtName.getText().trim();
        String family = txtFamily.getText().trim();

        if (name.isEmpty() || family.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this, "نام و نام خانوادگی الزامی است."
            );
            return;
        }

        model.addRow(new Object[]{name, family});

        txtName.setText("");
        txtFamily.setText("");
        txtName.requestFocus();
    }

    private void deleteRecord() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(
                    this, "ابتدا یک ردیف را انتخاب کنید."
            );
            return;
        }

        model.removeRow(table.convertRowIndexToModel(row));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new MainSwing().setVisible(true)
        );
    }
}
