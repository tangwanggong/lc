package easy.string;

/**
 * @author tanghao
 * @date 2020/11/25
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length(),nLen = needle.length();
        if(nLen==0){
            return 0;
        }
        int hn = 0;
        while (hn < (hLen-nLen+1)){
            while (hn<(hLen-nLen+1) && haystack.charAt(hn) != needle.charAt(0)) hn++;
            int curLen = 0,nn = 0;
            while (nn<nLen && hn<hLen && needle.charAt(nn) == haystack.charAt(hn)){
                nn++;
                hn++;
                curLen++;
            }
            if(curLen == nLen){
                return hn-curLen;
            }
            hn = hn - curLen +1;
        }
        return -1;
    }
}
