class LRUCache {

    class DLLNode{
        DLLNode next;
        DLLNode prev;
        int key;
        int value;
        DLLNode(int key, int value)
        {
            this.key=key;
            this.value=value;
        }
    }

    DLLNode head;
    DLLNode tail;
    int capacity;
    int size;
    HashMap<Integer, DLLNode> map;

    public LRUCache(int capacity) {
        head=null;
        tail=null;
        size=0;
        this.capacity=capacity;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        //look for the value in the list
        DLLNode node=findKey(key);
        if(node == null){
            return -1;
        }

        // if the key is found make it the most recently used
        moveToEnd(node);
        return node.value;
    }
    
    public void addAtEnd(int key, int value){
        if(head == null){
            head= new DLLNode(key, value);
            tail=head;
        }
        else{
            DLLNode newNode= new DLLNode(key, value);
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }

    public void deleteHead(){
        if(head == null){
            return;
        }
        head=head.next;
        if(head == null)
        {
            tail=null;
        }
        else{
            head.prev=null;
        }

    }

    public void moveToEnd(DLLNode node)
    {
        //remove the node from the list and puts it in the end
        DLLNode next = node.next;
        DLLNode prev = node.prev;

        //if this is tail node it is already the the end
        if(node.key==tail.key)
        {
            return;
        }

        //if next and prev are both null
        if(next==null && prev==null)
        {
            //single node case
            return;
        }

        //discoonect node
        node.next=null;
        node.prev=null;

        //if next is null
        {
            if(next==null)
            {
                //this is the tail
            }
            else if(prev==null)
            {
                //this is the head node
                next.prev=null;
                head= next;
            }
            else
            {
                //both next and prev exist
                prev.next=next;
                next.prev=prev;
            }

            tail.next=node;
            node.prev=tail;
            tail=node;
        }

    }
    
    public DLLNode findKey(int key)
    {
        //looks for this key in the list
        //TODO:
        return map.get(key);
    }

    public void put(int key, int value) {
        //look for the value in the list
        DLLNode node=findKey(key);

        if(node != null)
        {
            //update the value
            node.value=value;
            //since this is MRU move it to the end
            moveToEnd(node);
        }
        //if entry with this key does not exist
        else
        {
            //if empty slot is available
            if(size<capacity)
            {
                //add a new node at the end with this key value pair
                addAtEnd(key, value);
                map.put(key, tail);

                //increment size
                size++;
            }
            //if empty slot not available
            else{
                //remove the LRU
                int removedKey=head.key;
                deleteHead();
                map.remove(removedKey);

                //add a new node at the end with this key value pair
                addAtEnd(key,value);
                map.put(key, tail);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */