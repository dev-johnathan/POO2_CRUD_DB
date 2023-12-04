package view;

import controller.RoomController;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.Room;

public class TavernaAppGUI extends JFrame {

    private RoomController roomController;
    private JList<Room> roomList;
    private final DefaultListModel<Room> listModel;

    public TavernaAppGUI() {
        // Inicialização do controlador
        roomController = new RoomController();

        // Configurações do JFrame
        setTitle("Taverna App");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Componentes
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel para os botões e a lista
        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel label = new JLabel("Lista de Quartos:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonsPanel.add(label, gbc);

        listModel = new DefaultListModel<>();
        roomList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(roomList);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        buttonsPanel.add(scrollPane, gbc);
        gbc.gridwidth = 1;

        JButton addButton = new JButton("Adicionar Quarto");
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonsPanel.add(addButton, gbc);

        JButton updateButton = new JButton("Atualizar Quarto");
        gbc.gridx = 1;
        gbc.gridy = 2;
        buttonsPanel.add(updateButton, gbc);

        JButton deleteButton = new JButton("Excluir Quarto");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        buttonsPanel.add(deleteButton, gbc);
        gbc.gridwidth = 1;

        // Adicionando bordas ao painel de botões
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Adicionando componentes ao painel principal
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        // Adicionando painel ao JFrame
        add(mainPanel);

        // Configurando ListModel para a JList
        updateRoomList();

        // Adicionando ActionListener aos botões
        addButton.addActionListener((ActionEvent e) -> {
            String roomType = promptForInput("Digite o tipo do quarto:");
            if (roomType != null && !roomType.isEmpty()) {
                Room newRoom = new Room(0, roomType);
                roomController.addRoom(newRoom);
                updateRoomList();
            }
        });

        updateButton.addActionListener((ActionEvent e) -> {
            Room selectedRoom = roomList.getSelectedValue();
            if (selectedRoom != null) {
                String newRoomType = promptForInput("Digite o novo tipo do quarto:");
                if (newRoomType != null && !newRoomType.isEmpty()) {
                    selectedRoom.setRoomType(newRoomType);
                    roomController.updateRoom(selectedRoom);
                    updateRoomList();
                }
            }
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            Room selectedRoom = roomList.getSelectedValue();
            if (selectedRoom != null) {
                roomController.deleteRoom(selectedRoom.getId());
                updateRoomList();
            }
        });
    }

    private String promptForInput(String prompt) {
        return javax.swing.JOptionPane.showInputDialog(this, prompt);
    }

    private void updateRoomList() {
        // Obtém a lista atualizada de quartos do controlador
        List<Room> rooms = roomController.getAllRooms();

        // Limpa o modelo da lista
        listModel.clear();

        // Adiciona os quartos ao modelo da lista
        for (Room room : rooms) {
            listModel.addElement(room);
        }
    }

    public static void main(String[] args) {
        // Executa a aplicação Swing na thread de despacho de eventos
        java.awt.EventQueue.invokeLater(() -> {
            new TavernaAppGUI().setVisible(true);
        });
    }
}
