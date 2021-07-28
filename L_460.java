class LFUCache {
     HashMap<Integer, Integer> vals;//cache K and V
    HashMap<Integer, Integer> counts;//K and counters
    HashMap<Integer, LinkedHashSet<Integer>> lists;//Counter and item list
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
        
    }
    
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key,count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0){
            min++;
        }
        if(!lists.containsKey(count+1)){
            lists.put(count+1, new LinkedHashSet<>());
            // lists.get(count+1).add(key);
        }
        lists.get(count+1).add(key);
        return vals.get(key);
        
    }
    
    public void put(int key, int value) {
        if(cap<=0)
            return;
        
        //If the key is present already
        if(vals.containsKey(key)){
            vals.put(key,value);
            get(key);
            return;
        }
        if(vals.size()>=cap){
            int evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            vals.remove(evict);
            counts.remove(evict);
        }
        //If the key is not already present
        vals.put(key,value);
        counts.put(key,1);
        min=1;
        lists.get(1).add(key);      
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */