import java.util.Scanner;

public class DynamicStringArray {
    Scanner scanner = new Scanner(System.in);
    private String[] stringArr;

    public DynamicStringArray(String[] strings) {
        this.stringArr = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            stringArr[i] = strings[i];
        }
    }

    public DynamicStringArray() {
        this.stringArr = new String[10];
    }

    public DynamicStringArray(int size) {
        this.stringArr = new String[size];
    }

    public String[] getStringArr() {
        return stringArr;
    }

    void add(String string){
        String[] strings = new String[this.stringArr.length+1];
        System.arraycopy(stringArr, 0, strings, 0, stringArr.length);
        strings[strings.length-1] = string;
        stringArr = strings;
    }

    void remove(String string){
        for (int i = 0; i < stringArr.length; i++) {
            if(stringArr[i].equals(string)){
                String [] array = new String[stringArr.length-1];
                for (int j = 0; j < i; j++) {
                    array[j] = stringArr[j];
                }
                for (int j = i+1; j < stringArr.length; j++) {
                    array[j-1] = stringArr[j];
                }
                stringArr = array;
            }
        }
    }

    void remove(int index){
        String [] array = new String[stringArr.length-1];
        for (int j = 0; j < index; j++) {
            array[j] = stringArr[j];
        }
        for (int j = index+1; j < stringArr.length; j++) {
            array[j-1] = stringArr[j];
        }
        stringArr = array;
    }

    int size(){
        int count = 0;
        for (int i = 0; i < stringArr.length; i++) {
            if(stringArr[i] != null){
                count++;
            }
        }
        return count;
    }

    int indexOf(String string){
        for (int i = 0; i < stringArr.length; i++) {
            if(stringArr[i].equals(string)){
                return i;
            }
        }
        return  -1;
    }

    int lastIndexOf(String string){
        for (int i = stringArr.length-1; i >= 0; i--) {
            if(stringArr[i].equals(string)){
                return i;
            }
        }
        return  -1;
    }

    boolean contains(String string){
        for (int i = 0; i < stringArr.length; i++) {
            if(stringArr[i].equals(string)){
                return true;
            }
        }
        return  false;
    }

    void removeAll(String[]strings){
        for (int i = 0; i < strings.length; i++) {
            remove(strings[i]);
        }
    }

    void swap(int index1,int index2){
    String temp;
    if(index1<stringArr.length && index2<stringArr.length && index1 >=0 && index2 >=0){
        temp = stringArr[index1];
        stringArr[index1] = stringArr[index2];
        stringArr[index2] = temp;
    }else
        System.out.println("Wrong index entered");
    }

    void sort(Sort sort){
        if(sort == Sort.ASC){
            bubbleSort(stringArr);
        }else if(sort == Sort.DESC){
            reverseBubbleSort(stringArr);
        }
    }

    static void bubbleSort(String[] sr) {
        bubbleSort(sr,sr.length);
    }
    static void bubbleSort(String[] sr,int n) {
        if (n == 1)
            return;
        String  temp;
        for (int i = 0; i < sr.length-1; i++) {
            if(sr[i].compareTo(sr[i+1])>0){
                temp = sr[i];
                sr[i] = sr[i+1];
                sr[i+1] = temp;
            }
        }
        bubbleSort(sr,n+1);
    }

    static void reverseBubbleSort(String[] sr) {
        reverseBubbleSort(sr,0);
    }
    static void reverseBubbleSort(String[] sr,int n) {            //sr[i].compareTo(sr[i+1])<0)
       if(n == sr.length-1)
           return;
       String temp;
        for (int i = 0; i < sr.length-1; i++) {
            if(sr[i].compareTo(sr[i+1])<0){
                temp = sr[i];
                sr[i] = sr[i+1];
                sr[i+1] = temp;
            }
        }
        reverseBubbleSort(sr,n+1);
    }
}
