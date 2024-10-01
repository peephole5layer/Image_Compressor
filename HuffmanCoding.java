import java.util.*;

public class HuffmanCoding {
    private Map<Integer, String> huffmanCodes = new HashMap<>();
    private PriorityQueue<HuffmanNode> priorityQueue;

    public void buildHuffmanTree(Map<Integer, Integer> frequencies) {
        priorityQueue = new PriorityQueue<>();

        // Create leaf nodes for each pixel value
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getValue(), entry.getKey()));
        }

        // Build the Huffman tree
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency, -1);
            parent.left = left;
            parent.right = right;
            priorityQueue.add(parent);
        }

        // Generate codes
        generateCodes(priorityQueue.peek(), "");
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;
        if (node.value != -1) {
            huffmanCodes.put(node.value, code);
        }
        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    public Map<Integer, String> getHuffmanCodes() {
        return huffmanCodes;
    }
}

