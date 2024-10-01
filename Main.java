import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageCompressorUI ui = new ImageCompressorUI();

        ui.addUploadListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(ui) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                ui.setImage(selectedFile);
            }
        });

        ui.addCompressListener(e -> {
            File file = ui.getSelectedFile();
            if (file == null) {
                ui.showMessage("Please upload an image first!");
                return;
            }
            try {
                float quality = 0.5f; // Adjust this value for desired quality (0.0 - 1.0)
                ImageCompressor.compressImage(file, quality);
                ui.showMessage("Image compressed and saved as: compressed_" + file.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                ui.showMessage("Error during compression: " + ex.getMessage());
            }
        });

        SwingUtilities.invokeLater(() -> ui.setVisible(true));
    }
}
