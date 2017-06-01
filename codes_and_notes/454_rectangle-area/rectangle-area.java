/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/problem/rectangle-area
@Language: Java
@Datetime: 17-05-31 10:55
*/

public class Rectangle {
    /*
     * Define two public attributes width and height of type int.
     */
    // write your code here
    int width;
    int height;

    /*
     * Define a constructor which expects two parameters width and height here.
     */
    // write your code here
    
    //构造函数必须与类名相同;没有返回值类型，连void都没有;没有具体的返回值
    Rectangle(int width,int height){
        
        this.width = width;
        this.height = height;
    }
    
    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    // write your code here
    public int getArea(){
        int Area = 0;
        Area = width * height;
        return Area;
    }
    
}