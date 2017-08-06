/*
@Copyright:LintCode
@Author:   larryzhou
@Problem:  http://www.lintcode.com/zh-cn/problem/sliding-window-maximum/
@Language: Java
@Datetime: 17-08-6 21:40
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        
        /*  滑动窗口的最大值 (剑指offer题65)
        
            给出一个可能包含重复的整数数组，和一个大小为 k 的滑动窗口,
            从左到右在数组中滑动这个窗口，找到数组中每个窗口内的最大值
            
            样例：给出数组 [1,2,7,7,8], 滑动窗口大小为 k = 3. 返回 [7,7,8]

            最开始，窗口的状态如下：[|1, 2 ,7| ,7 , 8], 最大值为 7
            
            然后窗口向右移动一位：[1, |2, 7, 7|, 8], 最大值为 7
            
            最后窗口再向右移动一位：[1, 2, |7, 7, 8|], 最大值为 8
        */
        
        /*  思路：采用双向队列，时间复杂度o(n)，空间复杂度O(k)
        
                双向队列中插入的是数的索引，而不是数的本身
                因为如果是数的本身，就无法判断窗口在移动时，窗口里的数是否被移出窗口

            　　使用双向队列，每次推入新值时，保证deque内长度小于等于k
                在peekLast移出比当前小的值，以此保证peekFirst一直是最大值
                
            　　如果队列中队首值(窗口中元素最大数的索引) 不在新窗口的范围里了
                那么队首元素也要移出
                
            　　如果将要插入索引对应的数大于队列末尾所对应的数，
                此时将要插入的数和队尾元素对应的数一定在同一窗口，且待插入数大于末尾数
                则队列末尾所对应的数一定不会成为窗口中的最大值，则移出队列的末尾元素

            步骤：1）将1添加到队列
                  2）2 > 1，1不可能是最大值，删除，并将2添加到队列
                  3）7 > 2，2不可能是最大值，删除，并将7添加到队列
                  4）7 = 7，7可能是最大值，保留，并将7添加到队列
                  5）8 > 7，前面的7不可能是最大值，删除，并将8添加到队列
        */
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //双向队列
        Deque<Integer> deque = new LinkedList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            
            //双向队列不为空，且队列中最大数的索引已经不在新窗口的范围里时
            while(!deque.isEmpty() && i - deque.peekFirst() >= k){
                
                deque.pollFirst();
            }
            
            //双向队列不为空，且队列中末尾数的值小于当前待插入的值
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){  
                
                deque.pollLast();  
            }  
            
            //不断移除队列中小于当前待插入值的末尾值后，将待插入值添加到队列中
            deque.offerLast(i); 
            
            //至少是第一个有效的窗口，索引从 0 -（k-1）
            if(i >= k - 1){  
                
                result.add(nums[deque.peekFirst()]);  
            }  
        }  
          
        return result;
    }
}

/* 队列 queue 
		
	add：    添加一个元素，如果队列已满，则抛出一个IIIegaISlabEepeplian异常
	offer：  添加一个元素并返回true，如果队列已满，则返回false
	put：    添加一个元素，如果队列满，则阻塞
			
	remove： 移除并返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
	poll：   移除并返问队列头部的元素，如果队列为空，则返回null
	take：   移除并返回队列头部的元素，如果队列为空，则阻塞
	
	element：返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
	peek：   返回队列头部的元素，如果队列为空，则返回null
	
	
	将双端队列用作队列时，将得到 FIFO（先进先出）行为
	将元素添加到双端队列的末尾，从双端队列的开头移除元素
	
	双向队列Deque的方法，类似于Queue中的方法：	    
	
    addLast()      add()
    offerLast()    offer()
    
   	removeFirst()   remove()
    pollFirst()     poll()	
    
    getFirst()      element()
    peekFirst()     peek()
    
    
    双端队列也可用作 LIFO（后进先出）堆栈，应优先使用此接口而不是遗留Stack 类
    在将双端队列用作堆栈时，元素被推入双端队列的开头并从双端队列开头弹出

    堆栈方法  等效   Deque 方法：
    
    push()	    addFirst()
    pop()	    removeFirst()
    peek()	    peekFirst()
*/ 