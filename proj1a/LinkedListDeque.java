public class LinkedListDeque<T> {
    //*node为泛型类*/
    public class node{
        public T item;
        public node next;
        public node prev;
        public node(node m,T i,node n) {
            this.prev=m;
            this.item=i;
            this.next=n;
        }
    }
    private node sentinel;//数据一般情况下设为私有
    private int size;

    public LinkedListDeque() {
        size=0;
        
        sentinel=new node(null,null,null);//此处的i值要为泛型T

        sentinel.prev=sentinel;
        sentinel.next=sentinel ;
    }

    public void addFirst(T x) {

        sentinel.next=new node(sentinel ,x,sentinel.next);
        sentinel.next.next.prev= sentinel.next ;
        size=size+1;
    }

    public void addLast(T x) {
        sentinel.prev=new node(sentinel.prev ,x,sentinel );//判断哪些指针发生改变
        sentinel.prev.prev.next=sentinel.prev;
        size++;
    }

    public T get(int index) {
        node p=sentinel;
        for(int i=0;i<=index;i++) {
            p=p.next;
        }
        return p.item;
    }

//    public T getRecursive(int index) {
//
//    }

    public boolean isEmpty() {

        return size==0;//判断是否是空列表
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        node p=sentinel;
        for(int i=0;i<=size-1;i++) {
            p=p.next;
            System.out.println(p.item);
        }
    }
    public T removeLast() {
        T moveLast=sentinel.prev.item;
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        size--;
        return moveLast;
    }

    public T removeFirst() {
        T moveFirst=sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.next.prev=sentinel;//主意删除前后指针（箭头）指向
        size++;
        return moveFirst ;

    }

    public static void main(String[] args) {
        LinkedListDeque L=new LinkedListDeque();
        L.addFirst(2);
        L.addFirst(1);
        L.addLast(8);
        L.addLast(9);
        L.printDeque();
        System.out.println(L.get(3));
    }
}
