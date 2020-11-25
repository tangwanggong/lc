package easy.string;

/**
 * @author tanghao
 * @date 2020/11/25
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder pre = new StringBuilder("1");
        StringBuilder cur = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            pre = cur;
            cur = new StringBuilder();
            int start = 0;
            int end = 0;
            while (end<pre.length()){
                while (end<pre.length() && pre.charAt(start) == pre.charAt(end)){
                    end++;
                }
                cur.append(end-start).append(pre.charAt(start));
                start = end;
            }
        }
        return cur.toString();
    }
}
