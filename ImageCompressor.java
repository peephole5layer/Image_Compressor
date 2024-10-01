import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ImageCompressor {

    public static void compressImage(File file, float quality) throws IOException {
        BufferedImage originalImage = ImageIO.read(file);
        File compressedFile = new File("compressed_" + file.getName());

        // JPEG Compression
        try (ImageOutputStream ios = new MemoryCacheImageOutputStream(new FileOutputStream(compressedFile))) {
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
            ImageWriter writer = writers.next();
            ImageWriteParam param = writer.getDefaultWriteParam();

            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(quality);

            writer.setOutput(ios);
            writer.write(null, new IIOImage(originalImage, null, null), param);
            writer.dispose();
        }

        // Huffman Coding
        compressWithHuffman(originalImage);
    }

    private static void compressWithHuffman(BufferedImage image) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        // Calculate frequency of each pixel value
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixelValue = image.getRGB(x, y) & 0xFFFFFF; // Get the pixel value (RGB)
                frequencies.put(pixelValue, frequencies.getOrDefault(pixelValue, 0) + 1);
            }
        }

        // Build Huffman Tree and generate codes
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        huffmanCoding.buildHuffmanTree(frequencies);

        // Get the generated Huffman codes
        Map<Integer, String> codes = huffmanCoding.getHuffmanCodes();
        System.out.println("Huffman Codes: " + codes);

        // Additional steps for encoding and saving the Huffman-encoded data can be added here
    }
}
