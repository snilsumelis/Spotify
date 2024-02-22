public class HashMap {
    private class HashNode{
        private int key;
        private String value;
        private HashNode next;
        public HashNode(int key, String value){
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return this.key;
        }
        public String getValue(){
            return this.value;
        }
        public void setValue(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            HashNode temp =this;
            StringBuilder sb = new StringBuilder();
            while(temp!=null){
                sb.append(temp.key +" ->"+ temp.value+",");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
    private HashNode[] nodes;
    private int numOfNodes;
    private int size; //Number of hash nodes in a hashmap
    public HashMap(){
        this(10);
    }
    public HashMap(int capacity){
        this.numOfNodes=capacity;
        nodes = new HashNode[capacity];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public void put(Integer key, String value){
        if(key==null || value ==null){
            throw new IllegalArgumentException("Key or Value is null!!");
        }
        int nodeIndex = getNodeIndex(key);
        HashNode head = nodes[nodeIndex];
        while(head !=null){
            if(head.key ==key){
                int nodeKeys = key + 10;
                size++;
                put(nodeKeys,value);

                return;
            }
            head = head.next;
        }
        size++;
        head = nodes[nodeIndex];
        HashNode node = new HashNode(key,value); // (key,value) -> null
        node.next = head;
        nodes[nodeIndex] = node;
    }
    private int getNodeIndex(Integer key){
        return Math.abs(key.hashCode()% numOfNodes);
    }
    public String get(Integer key){
        if(key ==null){
            throw new IllegalArgumentException("Key is null");
        }
        int nodeIndex = getNodeIndex(key);
        HashNode head = nodes[nodeIndex];
        while(head !=null){
            if(head.getKey()==key){
                return head.getValue();
            }
            head = head.next;
        }
        return null;
    }
    public int get(Integer key, String value){
        if(key ==null){
            throw new IllegalArgumentException("Key is null");
        }
        int nodeIndex = getNodeIndex(key);
        HashNode head = nodes[nodeIndex];
        while(head !=null){
            if(head.getKey()==key){
                int newkey = key;
                while(newkey<101){
                    if(head.getValue().equals(value)){
                        size++;
                        return newkey;
                    }
                    newkey+=10;
                    get(newkey,value);
                }
            }
            head = head.next;
        }
        return -1;
    }
    public String getvalue(Integer key){
        if(key ==null){
            throw new IllegalArgumentException("Key is null");
        }
        int nodeIndex = key.hashCode()%10;
        StringBuilder newString = new StringBuilder();
        HashNode head = nodes[nodeIndex];
        while(head !=null){
            if(head.getKey()==key){
                int newkey = key;
                while(newkey<101){
                    newString.append(head.getValue());
                    newkey+=10;
                    getvalue(newkey);
                }
                return newString.toString();
            }
            head = head.next;

        }
        return null;
    }
    public String remove(Integer key){
        if(key ==null){
            throw new IllegalArgumentException("Key is null");
        }
        int nodeIndex = getNodeIndex(key);
        HashNode head = nodes[nodeIndex]; //(0,Nilsu) -> (5, "Melis") -> ( 6- "İrem") -> null
        HashNode prev = null;
        while(head !=null){
            if(head.getKey() == key){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head==null){
            return null;
        }
        //size--;
        if(prev!=null){
            prev.next = head.next;
        }
        else{
            nodes[nodeIndex] = head.next;
        }
        return null;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
            if(nodes[i]!=null){
                sb.append(i).append(" ").append(nodes[i]).append("\n");
            }
            else{
                sb.append(i).append(" ").append("null").append("\n");
            }
        }
        return sb.toString();
    }
}