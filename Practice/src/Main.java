import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static String reverseWord(String s){
        String[] arr = s.split("");
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start ++;
            end--;
        }
        return String.join("",arr);
    }
    public static String reverseWords(String s) {
        List<String> stringList = Arrays.stream(s.split("\\s")).toList();
        stringList = stringList.stream().map( word -> {
            StringBuilder sb = new StringBuilder(word);
            return sb.reverse().toString();
        }).collect(Collectors.toList());



        return String.join(" ",stringList);
    }

    public static void main(String[] args) {
        //System.out.println("Hello world!");
        String s = "My name is Harshit";
//        List<String> stringList = Arrays.stream(s.split(" ")).toList();
        String[] stringList = s.split(" ");
        //System.out.println(stringList.stream().map(word -> reverseWord(word)).collect(Collectors.toList()));

//        for(String word : stringList){
//
//        }
        List alist = new ArrayList();
        alist.add(1);
        alist.add("Hello");

        System.out.println(alist);

    }
}