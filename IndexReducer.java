import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class IndexReducer extends Reducer<Text, Text, Text, DocSumWritable> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        HashMap<String, Integer> docCounts = new HashMap<>();
        
        for (Text value : values) {
            String docId = value.toString();
            docCounts.put(docId, docCounts.getOrDefault(docId, 0) + 1);
        }
        
        context.write(key, new DocSumWritable(docCounts));
    }
}
