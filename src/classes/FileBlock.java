package classes;

public class FileBlock {
    public Integer id;
    public long position;

    public FileBlock(Integer id, long position) {
        this.id = id;
        this.position = position;
    }

    public long getValueByPos() {
        return id == null ? 0 : id * position;
    }

    @Override
    public String toString() {
        return id == null ? "." : String.valueOf(id);
    }
}
