public class Lian2 {
    //练习2：将数组拼接成一个字符串,使用StringBuffer实现(定义功能方法)
    public static void main(String[] args) {
        int[] arr = {18, 35, 93, 70, 65} ;
        StringBuffer buffer=new StringBuffer();
        buffer.append("[");
        for (int i = 0; i <arr.length ; i++) {
            if (i==arr.length-1){
                buffer.append(arr[i]).append("]");
            }else {
                buffer.append(arr[i]).append("，");
            }
        }
        System.out.println(buffer);
    }
}
