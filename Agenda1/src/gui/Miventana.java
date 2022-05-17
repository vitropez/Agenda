package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import procesos.Contactos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.util.Collections;

public class Miventana extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textCiudad;
	private JButton btnBuscar;
	private JButton btnGuardar;
	private JLabel lblLetra;
	private JTextPane textLetra;
	private JTextPane txtContactos;
	private JButton btnLimpiar;
	ArrayList<Contactos> ct = new ArrayList<>();
	List<Contactos> lista = new ArrayList<>();

	public Miventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 800);
		setLocationRelativeTo(null);
		setTitle("Mi Agenda");
		setResizable(false);
		iniciarComponentes();

	}

	private void iniciarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblTitulo = new JLabel("A\u00D1ADIR CONTACTOS");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 25));
		lblTitulo.setBounds(0, 0, 746, 64);
		lblTitulo.setOpaque(true);
		panelPrincipal.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(39, 115, 148, 47);
		panelPrincipal.add(lblNombre);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setBounds(63, 173, 98, 31);
		panelPrincipal.add(lblTelefono);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblCiudad.setBounds(63, 215, 98, 31);
		panelPrincipal.add(lblCiudad);

		textNombre = new JTextField();
		textNombre.setBounds(173, 122, 357, 40);
		panelPrincipal.add(textNombre);
		textNombre.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setBounds(171, 173, 357, 40);
		panelPrincipal.add(textTelefono);
		textTelefono.setColumns(10);

		textCiudad = new JTextField();
		textCiudad.setBounds(171, 224, 357, 40);
		panelPrincipal.add(textCiudad);
		textCiudad.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setOpaque(true);
		btnGuardar.setBackground(UIManager.getColor("Button.background"));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnGuardar.setBounds(397, 328, 150, 53);
		btnGuardar.addActionListener(this);
		panelPrincipal.add(btnGuardar);

		btnBuscar = new JButton("Buscar Contacto");
		btnBuscar.setOpaque(true);
		btnBuscar.setBackground(UIManager.getColor("Button.background"));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnBuscar.setBounds(39, 328, 210, 53);
		btnBuscar.addActionListener(this);
		panelPrincipal.add(btnBuscar);

		lblLetra = new JLabel("Letra");
		lblLetra.setOpaque(true);
		lblLetra.setBackground(Color.LIGHT_GRAY);
		lblLetra.setToolTipText("");
		lblLetra.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetra.setBounds(63, 456, 78, 31);
		panelPrincipal.add(lblLetra);

		textLetra = new JTextPane();
		textLetra.setBounds(173, 456, 55, 31);
		panelPrincipal.add(textLetra);

		txtContactos = new JTextPane();
		txtContactos.setForeground(Color.BLUE);
		txtContactos.setBounds(328, 423, 334, 299);
		panelPrincipal.add(txtContactos);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			ingresarContacto();
		}
		if (e.getSource() == btnBuscar) {
			verContacto();

		}

	}

	private void verContacto() {
		// TODO Auto-generated method stub
		String letra = textLetra.getText();
		for (Contactos contacto : ct) {
			if (contacto.getNombre().startsWith(letra)) {
				lista.add(contacto);

				Collections.sort(lista);
				txtContactos.setText(lista.toString());
			}

		}
		lista.clear();

	}

	private void ingresarContacto() {
		String nombre = textNombre.getText();
		String ciudad = textCiudad.getText();
		try {
			int telefono = Integer.parseInt(textTelefono.getText());

			Contactos contacto = new Contactos(nombre, telefono, ciudad);
			ct.add(contacto);
			ct.toString();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha introducido un teléfono no válido");

		}
		System.out.println(ct);

	}

}