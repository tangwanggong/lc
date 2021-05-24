package hard.string;

/**
 * https://leetcode-cn.com/problems/integer-to-english-words/273. 整数转换英文表示
 * 将非负整数 num 转换为其对应的英文表示。
 *
 * @date 2021/5/24
 */
public class IntegerToEnglishWords {
    private final String[] THOUSAND = {"", "Thousand", "Million", "Billion"};
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] HUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (num>0){
            if(num % 1_000 > 0){
                StringBuilder tmp = new StringBuilder();
                helper(num % 1_000 ,tmp);
                result.insert(0,tmp.append(THOUSAND[index]).append(" "));
            }
            index++;
            num /= 1_000;
        }
        return result.toString().trim();
    }

    private void helper(int num, StringBuilder tmp) {
        if(num==0){
            return;
        }
        if(num < 20){
            tmp.append(LESS_THAN_TWENTY[num]).append(" ");
        }else if(num<100){
            tmp.append(HUNDRED[num/10]).append(" ");
            helper(num%10,tmp);
        }else {
            tmp.append(LESS_THAN_TWENTY[num/100]).append(" Hundred").append(" ");
            helper(num%100,tmp);
        }
    }
}
