package medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/submissions/
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * @date 2020/12/2
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()<4 || s.length()>12){
            return result;
        }
        helper(s,0,0,result,new StringBuilder());
        return result;
    }

    private void helper(String s, int size, int index, List<String> result, StringBuilder stringBuilder) {
        if(size == 4 || index == s.length()){
            if(size == 4 && index == s.length()){
                result.add(stringBuilder.toString());
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if(index+i > s.length()){
                return;
            }
            if(s.charAt(index) == '0' &&  i!=1){
                return;
            }
            if(i == 3 && Integer.parseInt(s.substring(index,index+i)) > 255){
                return;
            }
            int start = stringBuilder.length();
            stringBuilder.append(s, index, index+i);
            if(size<3){
                stringBuilder.append(".");
            }
            helper(s,size+1,index+i,result,stringBuilder);
            stringBuilder.delete(start,start+i+1);
        }
    }

}
