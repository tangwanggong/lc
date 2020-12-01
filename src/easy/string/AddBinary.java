package easy.string;

/**
 * https://leetcode-cn.com/problems/add-binary/
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * @date 2020/12/1
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int max = Math.max(aLength,bLength);
        int[] arr = new int[max+1];
        int temp = max;
        for (int i = aLength-1; i >= 0; i--) {
            arr[temp--] = a.charAt(i) - '0';
        }
        temp = max;
        for (int i = bLength-1; i >= 0; i--) {
            arr[temp--] += b.charAt(i) - '0';
        }
        StringBuilder result = new StringBuilder();
        for (int i = max; i >= 0; i--) {
            if(arr[i] >= 2){
                arr[i] %= 2;
                arr[i-1] += 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(i!=0 || arr[i]!=0){
                result.append(arr[i]);
            }
        }
        return result.toString();
    }
}
