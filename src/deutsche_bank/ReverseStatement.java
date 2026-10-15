package deutsche_bank;

import java.util.*;

public class ReverseStatement {
    public static void main(String[] args) {
        // System.out.println("Problem 1: Reverse without using split, Input: I Love India, Output: aidnI evoL I");
        String str = "I Love India";
        // Output: "aidnI evoL I"

        // System.out.println("Problem 2: Calculate frequency , and ignore case, Input: I love lOve Love India india too, Output: love: 3, india: 2");
        String str2 = "I love lOve Love India india too";
        // Output: love: 3,
        // india: 2
        Map<String, Integer> freq = new HashMap<>();
        String[] str4 = str2.split(" ");
        for(String s: str4){
            freq.put(s.toLowerCase(), freq.getOrDefault(s.toLowerCase(), 0) + 1);
        }
        for(Map.Entry<String, Integer> freqEntry : freq.entrySet()){
            if(freqEntry.getValue() > 1){
                System.out.println(freqEntry.getKey() + " " + freqEntry.getValue());
            }
        }
        




        String str3 = "";
        for(int i = str.length() - 1; i >= 0; i--){
            str3 += str.charAt(i);
        }
        System.out.println(str3);
        /**
         * springBoot binder, they give us an opportunity to create an abstraction over queue, can be rabbitmq or kafka.
         * What is the name of queue
         * Exchange -> telephone exchange -> jaha pay sara telephone calls ata hain, 
         * configured in exchnage -> smart routing -> 
         * We have consumers, they know only queue
         * producers only knows exchange
         * relation between exchnage and queue ?? rabbit mq gives routing, an event that exchnage with a routing Key, and based on key
         * rabbitmq gives smart routing -> 
         * complexity is in routing
         * Kafka Consumtion is queue based + Huge scaling, then rabbit Mq -> 
         * In order processing 
         * routing key -> rabbitmq, onc consumed, and can be consumed only once by cosnumer, and done. it cant be be consumed again by other consumers.
         * Faiure management -> DLQ(Dead Letter Queue) Any fail messages, that was not consumed due to error, then its redirected to dlq using routing key
         * in kafka, both need to know topics
         * kafka is like a logs. In server there is a log, anyone can see the log, offset helps to track the last read message.
         * consumer group is me -> 
         */

        String s = "anagram";
        String t = "nagaram";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        if(s.length() != t.length()){
            // return false;
        }
        
            for(int i = 0; i < s.length(); i++){
                System.out.println(s.charAt(i));
                map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
                System.out.println(map1);
            }
            for(int i = 0; i < t.length(); i++){
                System.out.println(s.charAt(i));
                map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) - 1);
                System.out.println(map1);
            }
        System.out.println("map" + map1);

    }
}
