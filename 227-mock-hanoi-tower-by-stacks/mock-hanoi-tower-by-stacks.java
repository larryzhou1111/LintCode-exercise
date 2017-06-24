/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/mock-hanoi-tower-by-stacks/
@Language: Java
@Datetime: 17-06-24 19:30
*/

public class Tower {
    private Stack<Integer> disks;
    // create three towers (i from 0 to 2)
    public Tower(int i) {
        disks = new Stack<Integer>();
    }
    
    // Add a disk into this tower
    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }
    
    // @param t a tower
    // Move the top disk of this tower to the top of t.
    public void moveTopTo(Tower t) {
        // Write your code here
        
        if(t.disks.isEmpty() || (!disks.isEmpty() && t.disks.peek() >= disks.peek())){
            
            t.disks.push(disks.pop());
        }
    }
    
    // @param n an integer
    // @param destination a tower
    // @param buffer a tower
    // Move n Disks from this tower to destination by buffer tower
    public void moveDisks(int n, Tower destination, Tower buffer) {
        // Write your code here
        
        /*
            三个塔：A，B，C。需要把盘子从A中移动到C中。
            三个塔在每次移动时每个都有一个身份，分别为:
            “源塔”（最开始盘子最多的塔）、
            “目标塔”（最后要把所有的盘子堆起来的塔）、
            “辅助塔”（与前面两个相对而言），每个塔与身份并不固定。
            
            当只有一个盘子时：直接把A（源塔）中的盘子放到C（目标塔）中。结束！
            
            当有两个盘子的时候【目标：把A（源塔）的两个盘子放到C（目标塔）中】：只用三步：
            
            把A（源塔）中最小的盘子放到B（辅助塔）中
            再将A（源塔）中的第二个盘子放到C（目标塔）中
            最后再把B（辅助塔）中的最小的盘子放到C（目标塔）中
            结束！
            
            当有三个盘子的时候：用两个盘子时的思维，只用三步：
            
            将A（源塔）中的前两个盘子放到B（辅助塔）中
            再将A（源塔）中第三个盘子放到C（目标塔）中
            最后再把B（辅助塔）中的两个盘子放到C（目标塔）中
            
            结束
            
            因为还没考虑怎么将A的两个盘子放到B中，所以这时的目标就变了，变成了把A中的前两个盘子放到B中，这时只要把塔的身份变换一下，就和两个盘子时的操作一模一样了。
            之后第二步也很简单。
            到了第三步，这个时候，A没有盘子，B有两个盘子，C有一个最大的盘子，这时的目标是把B中的两个盘子放到C中。是的，和两个盘子时的目标又是类似，所以替换一下身份再来一次，问题就真的解决了！
            
            所以，当有N个盘子的时候，我们也只要三步：
            
            把A的N-1个盘子放到B中
            把A所剩下唯一的也是最大的盘子放到C中
            把B中所有的盘子都放到C中
            对于第一步，我们又可以转化为这三步：
            此时的目标是把盘子从A放到B中
            
            把A的N-2个盘子放到C中
            把A最大的盘子（对于那N-1个盘子来说）放到B中
            把C中所有的盘子都放到B中
            对于这个的第一步，我们又可以……
            
            So,递归吧
        */
        
        if(n <= 0){
            return;
        }
        
        else if(n == 1){
            
            moveTopTo(destination);
        } 
        
        else{
            
            //将源塔前几个盘子都放到辅助塔中
            moveDisks(n - 1, buffer, destination); 
            
            //此时源塔只剩下一个最大的盘子，将它放到目标塔中
            moveDisks(1, destination, buffer); 
            
            //最后再将辅助塔的全部盘子（因为此时目标塔上已经有了一个盘子，故辅助塔的盘子数为n-1）都放到目标塔上
            buffer.moveDisks(n - 1, destination, this); 
        }
    }
    
    
    public Stack<Integer> getDisks() {
        return disks;
    }
}
/**
 * Your Tower object will be instantiated and called as such:
 * Tower[] towers = new Tower[3];
 * for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
 * for (int i = n - 1; i >= 0; i--) towers[0].add(i);
 * towers[0].moveDisks(n, towers[2], towers[1]);
 * print towers[0], towers[1], towers[2]
*/