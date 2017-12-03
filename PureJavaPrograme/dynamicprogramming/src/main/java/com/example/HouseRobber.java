package com.example;

/**
 * Created by Administrator on 2017/11/19.
 */

public class HouseRobber {
    /**
     * 题：一小偷找到一个新的偷盗点，这个地区的房子组成了一个环，如果小偷同时偷窃了两个相邻的房子，就会触发报警器。在不触发报警器的情况下，求小偷最多偷盗的money？
     * 分析：dp[i]表示前i个房子能获得的最大价值，dp[i] = max(dp[i-2]+num[i], dp[i-1]).本题难点，在于房子成一个环。对于环的问题，有一个技巧：拆环，把环展成一条直线。
     * 本题中，可以先假设房子排成一条直线，从0到n-1，那么如果用原来的动态规划算法求得最优解可能同时取到房子号为0和房子n-1号，而因为0和n-1在本题中是连在一起的，不能同时取。
     * 我们分两组情况，对不含0号的房子的组做一次动态规划，对不含n-1号的房子组做一次动态规划，再取两组中的较大值。
     */


        // public int compareTo(T o){
        //
        //}

        public int rob(int[] nums){//nums为每个房间的money数
            if(nums.length == 0){
                return 0;//无money可偷
            }
            if(nums.length == 1){
                return nums[0];
            }
            //分两组情况，对不含0号的房子的组做一次动态规划，对不含n-1号的房子组做一次动态规划，再取两组中的较大值。
            return Max(robber1(nums, 0, nums.length -2), robber1(nums, 1, nums.length -1));
        }
        private int robber1(int[] nums, int start, int end){
            int[] res = new int[2];
            if(start == end){ //终止条件
                return nums[start];
            }
            if(start +1 == end){
                return Max(nums[start], nums[end]);
            }
            res[start%2] = nums[start];
            res[(start +1)%2] = Max(nums[start], nums[start +1]);

            for(int i = start +2; i<=end; i++){
                res[i%2] = Max(res[(i-1)%2], res[(i-2)%2] +nums[i]);
            }
            return res[end%2];

        }


        //返回较大的T类型值
        private <T extends Comparable<T>>T Max(T a, T b){
            if(a.compareTo(b) >=0)return a;//T  extends Comparable<T>，便可以使用a.compareTo(b)进行大小比较了，class T extends Comparable时，必须重载compareTo方法。
            else return b;
        }

        //  private int Max(int a, int b){
        //      return a>b? a:b;
        //  }
        //测试用例
        public static void main(String[] args){
            System.out.println("start ====================");
            //Robber_House rh = new Robber_House();
            //int[] A = new int[]{10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0};
            int result = 0;
            //        result = rh.rob(A);
            //System.out.println(result);
        }
    }

