package classes;

public class FileBlockSegment {
    public int index;
    public int size;

    public FileBlockSegment(int index, int size) {
        this.index = index;
        this.size = size;
    }

    @Override
    public String toString() {
        return "FileBlockSegment{" +
                "index=" + index +
                ", size=" + size +
                '}';
    }
}
