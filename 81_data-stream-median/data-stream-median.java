/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/data-stream-median/
@Language: Java
@Datetime: 17-08-5 21:40
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        
        /*  数据流中位数 (剑指offer题64)
        
            数字是不断进入数组的，每次添加一个新的数进入数组的同时，返回当前新数组的中位数
            
            中位数的定义：
            中位数是排序后数组的中间值，如果数组中有n个数，则中位数为A[(n-1)/2]
            比如：数组A=[1,2,3]的中位数是2，数组A=[1,19]的中位数是1
            
            样例：
            持续进入数组的数的列表为：[1, 2, 3, 4, 5]，则返回[1, 1, 2, 2, 3]
            持续进入数组的数的列表为：[4, 5, 1, 3, 2, 6, 0]，则返回 [4, 4, 4, 3, 3, 3, 3]
            持续进入数组的数的列表为：[2, 20, 100]，则返回[2, 2, 20]
        */
        
        //利用最大最小堆
        //插入的时间复杂度O(logn)，得到中位数的时间复杂度O(1); 总时间O(nlogn)，空间O(n)
        /*
          思路:
            维护一个最大堆，一个最小堆
            最大堆存的是到目前为止较小的那一半数，最小堆存的是到目前为止较大的那一半数
            这样中位数只有可能是两个堆的堆顶
            
            而维护两个堆的技巧在于判断堆顶数和新来的数的大小关系：
            新数比最小堆中的最小数还要小时，将当前数添加到最大堆
            新数比最小堆中的最小数要大时，将当前数添加到最小堆
            
            还有两个堆的大小关系：将新数加入堆后，要保证两个堆的大小之差不超过1
            
            这样，每次新加进来一个数以后，如果两个堆一样大，则中位数是最大堆的堆顶值
            否则中位数是数据较多的那个堆的堆顶
        */
        
        //构造最小堆，保证堆顶元素始终是堆中的最小值，使用默认比较器
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        //构造最大堆，保证堆顶元素始终是堆中的最大值
        //默认初始堆的大小是10，Comparator实现compare方法时，用b-a来表示大的值在前面
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,
            new Comparator<Integer>(){
                
                public int compare(Integer a, Integer b) {
                         
                    return b - a;
                }
            });        
        
        int len = nums.length;
        int[] res = new int[len];
        
        res[0] = nums[0];
        minHeap.add(nums[0]);
        
        for(int i = 1; i < len; i++){
            
            int cur = nums[i];
            
            //保证最大堆中的所有数据，都要小于最小堆中的所有数据
            
            //当前数比最小堆中的最小数还要小时，将当前数添加到最大堆
            if(cur < minHeap.peek()){
                
                maxHeap.add(cur);
            }
            //当前数比最小堆中的最小数要大时，将当前数添加到最小堆
            else{
                minHeap.add(cur);
            }
            
            //保证数据平分到两个堆中，因此两个堆中数据数目之差不能超过1
            
            //最小堆数据偏多时
            if(minHeap.size() > maxHeap.size() + 1){
                
                //将最小堆的堆顶元素弹出，并添加到最大堆中
                maxHeap.add(minHeap.poll());
            }
            //最大堆数据偏多时
            if(maxHeap.size() > minHeap.size() + 1){
                
                //将最大堆的堆顶元素弹出，并添加到最小堆中
                minHeap.add(maxHeap.poll());
            }
            
            int minSize = minHeap.size();
            int maxSize = maxHeap.size();
            
            //最大、最小堆中数据一样多时，最大堆的堆顶元素，即为中位数
            if(minSize == maxSize){
                
                res[i] = maxHeap.peek();
            }
            else{
                
                //最大、最小堆中数据不一样多时，数据更多的那个堆，其堆顶元素即为中位数
                res[i] = minSize > maxSize ? minHeap.peek() : maxHeap.peek();
            }
            
        }
        
        return res;
    }
}

/* 
    特殊的队列PriorityQueue，即优先队列
    优先队列作用是能保证，每次取出的元素都是队列中权值最小的
    元素大小的评判可以通过元素本身的自然顺序，也可以通过构造时传入的比较器Comparator来指定

    队列queue的操作   
		
	add：    添加一个元素，如果队列已满，则抛出一个IIIegaISlabEepeplian异常
	offer：  添加一个元素并返回true，如果队列已满，则返回false
	put：    添加一个元素，如果队列满，则阻塞
			
	remove： 移除并返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
	poll：   移除并返问队列头部的元素，如果队列为空，则返回null
	take：   移除并返回队列头部的元素，如果队列为空，则阻塞
	
	element：返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
	peek：   返回队列头部的元素，如果队列为空，则返回null
*/

//剑指offer写法：思路与上述类似
/*
public class Solution {

    private PriorityQueue<Integer> maxHeap, minHeap;
    private int numOfElements = 0;

    public int[] medianII(int[] nums) {
        // write your code here
        
        Comparator<Integer> revCmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                
                return right.compareTo(left);
            }
        };
        
        int cnt = nums.length;
        int[] ans = new int[cnt];
        
        maxHeap = new PriorityQueue<Integer>(cnt, revCmp);
        minHeap = new PriorityQueue<Integer>(cnt);
        
        for(int i = 0; i < cnt; ++i){
            
            addNumber(nums[i]);
            ans[i] = getMedian();
        }
        return ans;
    }
    
    void addNumber(int value) {
        
        maxHeap.add(value);
        
        //数据的总数目是偶数时，把新数据插入到最小堆中
        if(numOfElements % 2 == 0){
            
            if(minHeap.isEmpty()){
                
                numOfElements++;
                return;
            }
            //保证最大堆中的所有数据，都要小于最小堆中的所有数据
            
            //最大堆堆顶元素大于最小堆堆顶元素，分别弹出，添加到对方堆中
            else if(maxHeap.peek() > minHeap.peek()){
                
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        }
        else{
            minHeap.add(maxHeap.poll());
        }
        
        numOfElements++;
    }
    
    int getMedian(){
        
        return maxHeap.peek();
    }
}
*/