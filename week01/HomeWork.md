作业：看源码直接在google 或者浏览器地址输入想要查询的 语言+版本+类
普通队列(一端进另一端出):
Queue queue = new LinkedList()或Deque deque = new LinkedList()
双端队列(两端都可进出)
Deque deque = new LinkedList()
堆栈
Deque deque = new LinkedList()

deque.addFirst("1");
deque.addFirst("2");
deque.addFirst("3");
deque.addLast("3");
String first = deque.getFirst();
String last = deque.peekLast();
System.out.println(first);
System.out.println(last);

Class PriorityQueue java(10) 优先队列(优先级队列不允许空元素,依赖于自然顺序的优先级队列也不允许插入不可比较的对象(这样做可能会导致ClassCastException)。)

add()和offer()
add(E e)和offer(E e)的语义相同，都是向优先队列中插入元素，
只是Queue接口规定二者对插入失败时的处理不同，add()在插入失败时抛出异常，
offer()则会返回false。对于PriorityQueue这两个方法其实没什么差别。

public boolean offer(E e) {
    if (e == null)//不允许放入null元素
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);//自动扩容
    size = i + 1;
    if (i == 0)//队列原来为空，这是插入的第一个元素
        queue[0] = e;
    else
        siftUp(i, e);//调整
    return true;
}

//remove(Object o)
public boolean remove(Object o) {
    //通过遍历数组的方式找到第一个满足o.equals(queue[i])元素的下标
    int i = indexOf(o);
    if (i == -1)
        return false;
    int s = --size;
    if (s == i) //情况1
        queue[i] = null;
    else {
        E moved = (E) queue[s];
        queue[s] = null;
        siftDown(i, moved);//情况2
        ......
    }
    return true;
}

public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    E result = (E) queue[0];//0下标处的那个元素就是最小的那个
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        siftDown(0, x);//调整
    return result;
}
上述代码首先记录0下标处的元素，并用最后一个元素替换0下标位置的元素，之后调用siftDown()方法对堆进行调整，最后返回原来0下标处的那个元素（也就是最小的那个元素）。重点是siftDown(int k, E x)方法，该方法的作用是从k指定的位置开始，将x逐层向下与当前点的左右孩子中较小的那个交换，直到x小于或等于左右孩子中的任何一个为止。
//siftDown()
private void siftDown(int k, E x) {
    int half = size >>> 1;
    while (k < half) {
    	//首先找到左右孩子中较小的那个，记录到c里，并用child记录其下标
        int child = (k << 1) + 1;//leftNo = parentNo*2+1
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
        if (comparator.compare(x, (E) c) <= 0)
            break;
        queue[k] = c;//然后用c取代原来的值
        k = child;
    }
    queue[k] = x;
}

element()和peek()
element()和peek()的语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，二者唯一的区别是当方法失败时前者抛出异常，后者返回null。根据小顶堆的性质，堆顶那个元素就是全局最小的那个；由于堆用数组表示，根据下标关系，0下标处的那个元素既是堆顶元素。所以直接返回数组0下标处的那个元素即可。
peek()检索但不删除由该deque表示的队列的头(换句话说，该deque的第一个元素)，如果该deque为空，则返回null。方法等同于peekFirst()。
element:检索但不删除由该deque表示的队列的头(换句话说，该deque的第一个元素)。这个方法与peek的不同之处在于，如果这个deque是空的，它会抛出一个异常

