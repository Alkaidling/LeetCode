package leetcode.editor.cn.acwing.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.2020.2.3
 *
 * @Auther: Alkaid
 * @Date: 2021-10-27 16:36
 * @ClassName Discrete
 * @Description: 离散化
 */

public class Discrete {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n次操作
        int m = sc.nextInt(); //m次询问
        int N = 300010; //因为需要将所有x，l，r存在数组中，这样就是n + 2m <= 300000
        int[] a = new int[N]; //从1开始，需要通过x找到离散量，然后+1，
        int[] s = new int[N]; //前缀和来做，所以需要从1开始记录a

        List<Integer> alls = new ArrayList<>(); //将所有的使用到的数存在alls中，比如x，l，r
        //但其中会有先后顺序的差别，以及重复，所以需要排序和去重
        List<Pairs> add = new ArrayList<>(); //用来存n次操作
        List<Pairs> query = new ArrayList<>(); //用来存m次询问

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            add.add(new Pairs(x, c));
            alls.add(x); //存入alls中，为后续操作做准备
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            query.add(new Pairs(l, r));
            alls.add(l);
            alls.add(r);
        }
        //到此为止，alls中存好了所有会被用到的数轴上的点，可以进行离散化操作
        // 1. 排序 2. 去重
        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique); //将去重后的List保存下来，或者此处也可以将unique作为最后一个数，用r作为二分

        for (Pairs item:add) {
            int index = find(item.first, alls);
            a[index] += item.second;
        }

        //求前缀和
        for (int i = 1; i <= alls.size(); i++) s[i] = s[i - 1] + a[i];

        for (Pairs item:query) {
            int l = find(item.first, alls);
            int r = find(item.second, alls);
            System.out.println(s[r] - s[l - 1]);
        }
    }

    //去重
    static int unique(List<Integer> list) {
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                list.set(j, list.get(i));
                j++;
            }
        }
        return j;
    }

    static int find(int x, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1; //因为要考虑到前缀和
    }
}

class Pairs {
    int first;
    int second;
    public Pairs(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
