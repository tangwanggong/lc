package easy.array;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(strs));
        int max = 0;
        List<String> maxList = new ArrayList<>();
        for (String str : strs) {
            int length = str.length();
            if(length == 1){
                continue;
            }
            String strTemp = str;
            boolean flag = true;
            strTemp = strTemp.substring(0,strTemp.length()-1);
            while (strTemp.length() > 0){
                if(!set.contains(strTemp)){
                    flag = false;
                    break;
                }
                strTemp = strTemp.substring(0,strTemp.length()-1);
            }
            if(flag){
                if(length == max){
                    maxList.add(str);
                }else if(length > max){
                    maxList.clear();
                    maxList.add(str);
                    max = length;
                }
            }
        }
        Collections.sort(maxList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                for (int i = 0; i < Math.min(chars1.length,chars2.length); i++) {
                    if(chars1[i] != chars2[i]){
                        return chars1[i] - chars2[i];
                    }
                }
                return 1;
            }
        });
        if(maxList.size() > 0){
            System.out.println(maxList.get(0));
        }else {
            System.out.println("");
        }
    }
}
