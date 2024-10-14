package com.yzm.每日一题;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description:
 *
 * @author yzm
 * @date 2024/10/8
 */
public class DailySolution1436 {
    public String destCity(List<List<String>> paths) {
        String des = null;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            set.add(path.get(0));
        }
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            if (!set.contains(path.get(1))) {
                des = path.get(1);
                break;
            }
        }
        return des;
    }
}
