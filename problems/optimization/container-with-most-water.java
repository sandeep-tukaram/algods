class maxContainer {
    public int maxArea(int[] height) {
        // sol 1 -> Timedout 58/65
        // return fullScan(height);

        //  sol 2   -> Timedout 58/65
        // memoize = new int[height.length];
        // return dp(height, height.length-1);


        // sol3 
        return twoPointer(height);
    }


    // Approach 1
    // Full scan solution
    // For every i, say pivot, scan left and right. Find the container with i column fixed.
    // Store the maximum area container. 
    // T(n) = n (pivots) * n (scans) = O(n^2)
    // S(n) = O(1)
    int fullScan(int[] height) {
        int max_container = 0;

        for (int i = 0; i<height.length; i++) {
            for (int j =0; j< height.length; j++) {
                max_container = 
                        Math.max(max_container, 
                            Math.abs(j-i) * Math.min(height[j], height[i])
                        );
            }
        }

        return max_container;
    }


    /*  Approach 2
        1. DP (recursion + memoization)
        2. prefix subproblem: C(i) -> Maximum container between o and i
        3. C(0) = 0
        4. Recursive relation: 

                C(i) = Max {
                                C(i-1), 
                                fix 'i' as pivot and obtain container size with the pivot
                                (j-i) * min (H[j], H[i]) for 0<= j < i;
                        }

        5. topological order i 0 -> n; Number of prefix subproblems = n.
        6. Analysis, assumes memoization
            Time
            a) T(i) = T(i-1) + O(i);
            b) Memoize T(i) to avoid repeated calculation;
            c) T(n) = O(n) + O(n-1) + ... + O(1) = O(n^2);
            Space
            a) S(n) = O(n) to store values of C(i) for 0<= i < n
    */
    /*
        While the above approach looks great, it's flawed. There is no need for memoization. 
        The recursion is linear. Have commented out the memoization code.
    */
    int[] memoize;
    int dp(int[] height, int pivot) {
        // base
        if (pivot == 0) {
            return 0;
        }

        // use memoization (Wrong) - kept for the reference purposes 
        // if (memoize[pivot] != 0) {
        //     System.out.println("Memoized return - " + pivot);
        //     return memoize[pivot];
        // }

        // max container with the pivot
        int max_container_pivot = 0;
        for(int j = 0; j < pivot; j++) {
            max_container_pivot = Math.max (max_container_pivot, 
                        (pivot-j) * Math.min(height[pivot], height[j])
                    );
        }

        // memoize (wrong) 
        // memoize[pivot] = Math.max(max_container_pivot, dp(height, pivot-1));
        // return memoize[pivot];

        // recursive relation
        return Math.max(max_container_pivot, dp(height, pivot-1));
    }

    // DP and Full scan both clock T(n) = O(n^2). In fact DP uses additonal space, S(n) = O(n)
    // In either of the cases, T(n) is O(n^2) because of the repeated scans. 
    // a) in full scans -> for every pivot, one full scan = n^2
    // b) in DP -> for every pivot, 0 to pivot scan = n (n-1)/2
    // Time optimization -> how can the repeated scans be avoided? 
    // Lets look at he problem in different ways other than Recursion and pivot scans.


    // The function we have to optimize 
    //      (j-i)*min(H[i], H[i]) for 0<=i, j< n
    // to maximize the function
    // a) we have to maximie (j-i) and 
    // b) maximize (min heights for j and i)

    // Approach 3.
    // For a given set of heights, 
    //      if H[j] >= H[i] then min(H[j], H[i]) = H[i] or
    //      if H[j] < H[i] then min(H[i], H[j]) = H[j]
    // So, for any i, the maximum of min height = H[i]; 
    // a) Maintain a datastructure, that is sorted by height and returns all j such that H[j] > H[i]
    //        record -> (j, H[j])
    //          
    //        sort the records by H[j],  (nlgn) // merge sort List. Not dynamic.
    //        greater(i) -> return a all j with H[j] > H[i]     LIST(i).next;       O(1)
    // B) Worst case, increasing order of heights. 
    //      No of scans = n + (n-1) + ... + 1; = O(n^2)
    // 
    // We end with O(n^2) but then we have kind of reduced the number of scanned items for each i.
    // We only search all the heights greater than H[i]. Sounds similar to DP approach above. But then
    // we have a different structure/model to work with. And it is a model that helps further optimize 
    // - not apparent at first, I write this post lot of thinking. 
    // 
    // First optimization 
    // What is the extra effort here. Say we have an increasing set of heights. 
    // for i = 0, H[j] > H[i] for all j > i. so min(H[j], H[i]) = H[i] for all values of i, j since 
    // its increasing in order. So container size reduces to the formula 
    //      (j-i) * min(H[j], H[i]) = (j-i) * H(i). 
    // to maximize we need to maximize (j-i) given that H(i) is already set. 
    // Take a moment to think. What can be the maximum value of (j-i) in an increasing set of heights? 
    // The answer is j = n. If we generalize, the problem is find the farthest height H[j] > H[i]. 
    // Don't have to worry about nearby heights, just the farthest.  
    // Big Question ..  How ?? 
    // Lets go back to the scan approach. 
    //  a) For any i scan left and right, starting from i, to find the farthest Height greater than i 
    //          O(n^2) = n (pivots) * n (scan) 
    //  b) Probably a better approach start from the farthest points. For a given i, set left = 0, 
    //      right = n. Move left++ until Height[left] >= Height[i] and similarly move right-- 
    //      until Height[right] >= Height[i]. At this point, we have farthest left and farthest right. 
    //      The farthest between these two would be the farthest height overall.
    //      We use two-pointers here. Let's call it two-pointer approach.
    //  c) Following b), we do that for all i's.  
    //       Complexity is still O(n^2)
    //  d) However, we notice something.  For every i, we start from the left = 0 and right = n-1 and 
    //      move the pointers inwards. If we call this move contraction (instead of scan). It's n contractions. 
    //  e) Can we optimize on the number of contractions ? 
    //  f) Lets start from left = 0 and right = n-1, without worry about pivot. Since this is the common start for all pivots
    //  g) The max size of the container containing both left and right is then
    //          maxContianer = (right - left) * min(H[left], H[right])
    //  f) We want to contract to find the next max size. How can we do that ? 
    //  h) From the above formulae, any contraction means (right-left) reduces invariably. It's a decreasing component. In order for the product to increase, the min(H[left], H[right) should increase. This is the clue for us. To increase the min, we move the minimum height pointer between left and right. For example, lets say H[right] < H[left], min(H[right], H[left]) = H[right]. We can increase the min() component only if we contract right pointer to find a H[right_new] > H[right]. No point moving the left pointer since even if you find a greater high, the min remains H[right] and if you find a lesser high, then min () reduces. This is in contradiction to what we want to achieve. 
    //  i) With new set of left and right, find maxContainer - repeat (g) and compare with the previous value and store the maximum. 
    //  j)  Repeat step (g) to (i) until left < right. 
    //  h) return the maxContainer value.
    //  Time T(n) = O(n). 
    //  Space S(n)  = O(1). 

    int twoPointer(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int maxContainer = 0;
        while(left < right) {
            int container = (right - left) * Math.min(heights[left], heights[right]);
            maxContainer = Math.max(maxContainer, container);

            // move the pointers
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxContainer;
    }


}