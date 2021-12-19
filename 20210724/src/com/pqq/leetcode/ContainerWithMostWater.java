package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-07-24 11:27
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int volume = 0, left = 0, right = height.length-1;
        for(left = 0; left<height.length;)
        {
            if(left>=right)
            {
                break;
            }
            int temp = 0;
            if(height[left]>height[right])
            {
                temp = height[right]*(right-left);
            }
            else{
                temp = height[left]*(right-left);
            }
            if(temp > volume)
            {
                volume = temp;
            }
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }

//            for(right = height.length-1;left < right; right--)
//            {
//                int temp = 0;
//                if(height[left]>height[right])
//                {
//                    temp = height[right]*(right-left);
//                }
//                else{
//                    temp = height[left]*(right-left);
//                }
//                if(temp > volume)
//                {
//                    volume = temp;
//                }
//            }
        }
        return volume;

    }

    public static void main(String[] args) {
        ContainerWithMostWater con = new ContainerWithMostWater();
        int[] arr = new int[]{2,3,4,5,18,17,6};
        System.out.println(con.maxArea(arr));

    }
}
