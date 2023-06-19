import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
}

class File {
    private String fileName;
    private long fileSize;

    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
    }
}

class Document extends File {
    private String documentType;

    public Document(String fileName, long fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

class Image extends File {
    private String resolution;

    public Image(String fileName, long fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

class Video extends File {
    private int duration;

    public Video(String fileName, long fileSize, int duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

class FileManagerImpl implements FileManager {
    private ArrayList<File> files = new ArrayList<>();
    private DefaultTableModel tableModel;

    public FileManagerImpl(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void addFile(File file) {
        files.add(file);
        Object[] rowData = {file.getFileName(), file.getFileSize()};
        tableModel.addRow(rowData);
    }

    public void deleteFile(String fileName) {
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            if (file.getFileName().equals(fileName)) {
                files.remove(i);
                tableModel.removeRow(i);
                break;
            }
        }
    }

    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    public void saveToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (File file : files) {
                writer.write(file.getFileName() + "," + file.getFileSize() + System.lineSeparator());
            }
            System.out.println("File details saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String fileNa = parts[0];
                    long fileSize = Long.parseLong(parts[1]);
                    File file = new File(fileNa, fileSize);
                    files.add(file);
                    Object[] rowData = {file.getFileName(), file.getFileSize()};
                    tableModel.addRow(rowData);
                }
            }
            System.out.println("File details loaded from " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileManagementSystemUI {
    private FileManager fileManager;
    private JFrame frame;
    private JTextField fileNameField;
    private JTextField fileSizeField;
    private JTextField documentTypeField;
    private JTextField resolutionField;
    private JTextField durationField;
    private JTable table;

    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl(createTableModel());

        frame = new JFrame("File Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        JPanel inputPanel = createInputPanel();
        panel.add(inputPanel, BorderLayout.NORTH);

        JPanel tablePanel = createTablePanel();
        panel.add(tablePanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        inputPanel.add(new JLabel("File Name:"));
        fileNameField = new JTextField();
        inputPanel.add(fileNameField);

        inputPanel.add(new JLabel("File Size:"));
        fileSizeField = new JTextField();
        inputPanel.add(fileSizeField);

        inputPanel.add(new JLabel("Document Type:"));
        documentTypeField = new JTextField();
        inputPanel.add(documentTypeField);

        inputPanel.add(new JLabel("Resolution:"));
        resolutionField = new JTextField();
        inputPanel.add(resolutionField);

        inputPanel.add(new JLabel("Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        return inputPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());

        table = new JTable(createTableModel());
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

        return tablePanel;
    }

    private DefaultTableModel createTableModel() {
        String[] columnNames = {"File Name", "File Size"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return model;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                long fileSize = Long.parseLong(fileSizeField.getText());

                if (documentTypeField.isEnabled()) {
                    String documentType = documentTypeField.getText();
                    Document document = new Document(fileName, fileSize, documentType);
                    fileManager.addFile(document);
                } else if (resolutionField.isEnabled()) {
                    String resolution = resolutionField.getText();
                    Image image = new Image(fileName, fileSize, resolution);
                    fileManager.addFile(image);
                } else if (durationField.isEnabled()) {
                    int duration = Integer.parseInt(durationField.getText());
                    Video video = new Video(fileName, fileSize, duration);
                    fileManager.addFile(video);
                }

                clearInputFields();
            }
        });
        buttonPanel.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) table.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                }
            }
        });
        buttonPanel.add(deleteButton);

        JButton displayButton = new JButton("Display All Files");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.displayAllFiles();
            }
        });
        buttonPanel.add(displayButton);

        JButton saveButton = new JButton("Save to File");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Enter file name:");
                if (fileName != null) {
                    fileManager.saveToFile(fileName);
                }
            }
        });
        buttonPanel.add(saveButton);

        JButton loadButton = new JButton("Load from File");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(frame, "Enter file name:");
                if (fileName != null) {
                    fileManager.loadFromFile(fileName);
                }
            }
        });
        buttonPanel.add(loadButton);

        return buttonPanel;
    }

    private void clearInputFields() {
        fileNameField.setText("");
        fileSizeField.setText("");
        documentTypeField.setText("");
        resolutionField.setText("");
        durationField.setText("");
    }
}

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}
