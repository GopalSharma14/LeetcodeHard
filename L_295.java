class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if(minHeap.size()== maxHeap.size()){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        double median;
        if(minHeap.size()>maxHeap.size()){
            median = minHeap.peek();
            // return median;
        }else {
            median = (minHeap.peek() + maxHeap.peek())/2.0;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */