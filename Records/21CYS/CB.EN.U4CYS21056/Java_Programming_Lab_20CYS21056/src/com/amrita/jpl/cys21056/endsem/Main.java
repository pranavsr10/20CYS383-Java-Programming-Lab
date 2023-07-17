import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

abstract class File {
    protected String fileName;
    protected long fileSize;

    public File(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public abstract void displayFileDetails();
}

class Document extends File {
    private String documentType;

    public Document(String fileName, long fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    @Override
    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
        System.out.println("Document Type: " + documentType);
    }
}

class Image extends File {
    private String resolution;

    public Image(String fileName, long fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    @Override
    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
        System.out.println("Resolution: " + resolution);
    }
}

class Video extends File {
    private String resolution;
    private int duration;

    public Video(String fileName, long fileSize, String resolution, int duration) {
        super(fileName, fileSize);
        this.resolution = resolution;
        this.duration = duration;
    }

    @Override
    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
        System.out.println("Resolution: " + resolution);
        System.out.println("Duration: " + duration);
    }
}

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile(String filename);
    void loadFromFile(String filename);
    List<File> getFiles();
}

class FileManagerImpl implements FileManager {
    private List<File> files;

    public FileManagerImpl() {
        this.files = new ArrayList<>();
    }

    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void deleteFile(String fileName) {
        files.removeIf(file -> file.fileName.equals(fileName));
    }

    @Override
    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
            System.out.println();
        }
    }

    @Override
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            files = (List<File>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<File> getFiles() {
        return files;
    }
}



class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private JTextField fileNameField, fileSizeField, docTypeField, resolutionField, durationField;
    private JButton addFileButton, deleteFileButton, refreshButton;
    private JTable fileTable;

    public FileManagementSystemUI(FileManager fileManager) {
        this.fileManager = fileManager;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("File Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create text fields
        fileNameField = new JTextField();
        fileSizeField = new JTextField();
        docTypeField = new JTextField();
        resolutionField = new JTextField();
        durationField = new JTextField();

        // Create buttons
        addFileButton = new JButton("Add File");
        deleteFileButton = new JButton("Delete File");
        refreshButton = new JButton("Refresh");

        // Create file table
        fileTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(fileTable);

        // Add components to the layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("File Name:"));
        inputPanel.add(fileNameField);
        inputPanel.add(new JLabel("File Size:"));
        inputPanel.add(fileSizeField);
        inputPanel.add(new JLabel("Document Type:"));
        inputPanel.add(docTypeField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addFileButton);
        buttonPanel.add(deleteFileButton);
        buttonPanel.add(refreshButton);

        add(inputPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                long fileSize = Long.parseLong(fileSizeField.getText());
                String docType = docTypeField.getText();

                File file = new Document(fileName, fileSize, docType);
                fileManager.addFile(file);
                displayFilesInTable();
            }
        });

        deleteFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = fileTable.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) fileTable.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    displayFilesInTable();
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFilesInTable();
            }
        });
    }

    public void displayFilesInTable() {
        List<File> files = fileManager.getFiles();
        Object[][] data = new Object[files.size()][3];

        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            data[i][0] = file.fileName;
            data[i][1] = file.fileSize;
            data[i][2] = file instanceof Document ? "Document" : (file instanceof Image ? "Image" : "Video");
        }

        fileTable.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{"File Name", "File Size", "File Type"}
        ));
    }
}

public class Main
{
    public static void main(String[] args) {
        FileManagerImpl fileManager = new FileManagerImpl();
        FileManagementSystemUI ui = new FileManagementSystemUI(fileManager);
        ui.setVisible(true);
    }
}
