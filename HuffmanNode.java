class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    int value; // Pixel value
    HuffmanNode left, right;

    public HuffmanNode(int frequency, int value) {
        this.frequency = frequency;
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}
