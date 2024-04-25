public class ArrayDeque<Item> {
    private int size;
    private Item[] items;
    public ArrayDeque(){
        items=(Item[]) new Object[100] ;//泛型数组不被java允许
        size=0;
    }

    public void addLast(Item x) {
        if(size==items.length ) {
            resize();
        }
        items[size]=x;
        size++;
    }

    public Item getLast() {
        return items[size-1];
    }

    public Item get(int index) {
        return items[index];

    }

    public void addFirst(Item x) {
        for(int i=0;i<size-1;i++) {
            items[i+1]=items[i];
            items[0]=x;
        }
        size++;
    }

    public Item removeFirst() {
        Item moveF=items[0];
        for(int i=1;i<=size-1;i++) {
           items[i-1]=items[i];
        }
        size=size-1;
        return moveF;
    }

    public Item removeLast() {
        Item moveL=items[size-1];
        items[size]=null;
        size=size-1;
        return moveL;
    }

    public void resize() {
        Item[] a = (Item[]) new Object[size + 1];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }


}
