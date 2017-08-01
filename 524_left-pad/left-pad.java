/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/left-pad
@Language: Java
@Datetime: 17-06-10 13:02
*/

public class StringUtils {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        
        /*  左填充: 实现一个leftpad库
            
            样例:
                leftpad("foo", 5)
                >> "  foo"
                
                leftpad("foobar", 6)
                >> "foobar"
                
                leftpad("1", 2, "0")
                >> "01"
        */
        int len = originalStr.length();
        
        if(len < size){
            
            String addstring = new String();
            
            for(int i = 0; i < size - len; i++){
                
                addstring = addstring + ' ';
            }
            
            originalStr = addstring + originalStr;
        }
        
        return originalStr;
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        
        int len = originalStr.length();
        
        if(len < size){
            
            String addstring = new String();
            
            for(int i = 0; i < size - len; i++){
                
                addstring = addstring + padChar;
            }
            
            originalStr = addstring + originalStr;
        }
        
        return originalStr;        
    }
}