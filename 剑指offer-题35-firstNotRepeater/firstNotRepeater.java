/*
@Author:   larryzhou
@Problem:  第一个只出现一次的字符
@Language: Java
@Datetime: 17-07-21 16:00
*/

public class firstNotRepeater {  
      
    public Character firstNotRepeater(String str){  
	
        if(str == null)  
            return null;  
		
        char[] strChar = str.toCharArray();  
		
		//主要是保存到hashmap的数据，必须有序，因此用LinkedHashMap
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();  
		
        for(char item:strChar){  
		
            if(hash.containsKey(item)){
				
				map.put(item, map.get(item) + 1);  
			}    
            else{
				
				map.put(item, 1);  
			}  
        }  
		
		//遍历此LinkedHashMap，找出第一个符合条件的key
        for(char key:map.keySet()){  
		
            if(map.get(key) == 1)  
                return key;  
        }  
        return null;  
    }  
	
} 
