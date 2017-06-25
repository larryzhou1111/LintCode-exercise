/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/word-count-map-reduce/
@Language: Java
@Datetime: 17-06-25 11:30
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class WordCount {

    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            
            //Map类负责对原始数据进行处理，将单词拆分成键值对后，输出到output
            
            String[] result = value.split(" ");
            
            for(int i = 0; i < result.length; i++){
                
                output.collect(result[i], 1);
            }
            
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            
            //Reduce类负责对Map输出的数据，把key值相同的进行计数，并返回结果
            
            int count = 0;
            
            while(values.hasNext()){
                
                count += values.next();
            }
            
            output.collect(key, count);
        }
    }
}
