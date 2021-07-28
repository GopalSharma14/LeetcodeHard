class Solution {
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        double median=0.0;
        
        int length1 = nums1.length==0?0: nums1.length;
        int length2 = nums2.length==0?0: nums2.length;
        
        for(int i=0;i<length1;i++)
            put(nums1[i]);
        
        for(int i=0;i<length2;i++)
            put(nums2[i]);       
        
        if(minHeap.size()>maxHeap.size())
            median= minHeap.peek();
            
        else
            median= (minHeap.peek()+maxHeap.peek())/2.0;
        return median;
        
    }
    public void put(int val){
        if(minHeap.size()==maxHeap.size()){
                maxHeap.offer(val);
                minHeap.offer(maxHeap.poll());
            }
        else{
                minHeap.offer(val);
                maxHeap.offer(minHeap.poll());
            }
        }
}