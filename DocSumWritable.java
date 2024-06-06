import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.Writable;

public class DocSumWritable implements Writable {
    private HashMap<String, Integer> map = new HashMap<>();

    public DocSumWritable() { }

    public DocSumWritable(HashMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        map.clear();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            String key = in.readUTF();
            int value = in.readInt();
            map.put(key, value);
        }
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(map.size());
        for (String key : map.keySet()) {
            out.writeUTF(key);
            out.writeInt(map.get(key));
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (String key : map.keySet()) {
            output.append(key).append("=>").append(map.get(key)).append(" ");
        }
        return output.toString();
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }
}
