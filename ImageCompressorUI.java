import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageCompressorUI extends JFrame {
    private JButton uploadButton, compressButton;
    private JLabel imageLabel;
    private File selectedFile;

    public ImageCompressorUI() {
        setTitle("Image Compressor");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Image Compressor", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Center Panel for Image
        JPanel centerPanel = new JPanel();
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(500, 400));
        centerPanel.add(imageLabel);
        add(centerPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        uploadButton = new JButton("Upload Image");
        compressButton = new JButton("Compress Image");
        buttonPanel.add(uploadButton);
        buttonPanel.add(compressButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setImage(File file) {
        selectedFile = file;
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        imageLabel.setIcon(icon);
        imageLabel.setText(""); // Clear the text if any
    }

    public void addUploadListener(ActionListener listener) {
        uploadButton.addActionListener(listener);
    }

    public void addCompressListener(ActionListener listener) {
        compressButton.addActionListener(listener);
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

