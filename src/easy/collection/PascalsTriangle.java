package easy.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Tang
 * @create: 2018/9/20 10:25
 **/
public class PascalsTriangle {
    /**
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     *
     *
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     *
     * Example:
     *
     * Input: 5
     * Output:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * 时间复杂度很高- -,还以为有更优解，结果类似
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        for (int i = 1;i<=numRows;i++){
            List<Integer> list = new ArrayList<>(i);
            if(i==1){
                list.add(1);
                lists.add(list);
                continue;
            }
            List<Integer> lastList = lists.get(i-2);
            for (int j = 0; j <lastList.size()+1 ; j++) {
                if(j==0||j==lastList.size()){
                    list.add(1);
                }else {
                    list.add(lastList.get(j-1)+lastList.get(j));
                }
            }
            lists.add(list);
        }
        return lists;
    }
}