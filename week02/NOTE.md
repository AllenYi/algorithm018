学习笔记
一定要把算法公式死记硬背下来，碰到相关的题目直接套用公式解答，自己只是人类凑数的，直接套用大佬们的公式就行了
树的面试题解法一般都是递归，为什么？
个人觉得树其实不是那么好遍历，而递归又有三种实现形式前序后序中序，
每个子节点又具有相同的重复相似性，所以用递。

HashMap 总结
HashMap基于Map接口实现，元素以键值对的方式存储，并且允许使用null建和null值，因为key不允许重复（Set允许Key值重复但是value不能重复），因此只能有一个键为null,另外HashMap不能保证放入元素的顺序，它是无序的，
和放入的顺序并不能相同。HashMap是线程不安全的。Note：HashMap的扩容操作是一项很耗时的任务，所以如果能估算Map的容量，最好给它一个默认初始值，避免进行多次扩容。HashMap的线程是不安全的，多线程环境中推荐是ConcurrentHashMap。
HashMap采用Entry数组来存储key-value对，每一个键值对组成了一个Entry实体，Entry类实际上是一个单向的链表结构，它具有Next指针，可以连接下一个Entry实体，以此来解决Hash冲突的问题。
数组存储区间是连续的，占用内存严重，故空间复杂的很大。但数组的二分查找时间复杂度小，为O(1)；数组的特点是：寻址容易，插入和删除困难；
链表存储区间离散，占用内存比较宽松，故空间复杂度很小，但时间复杂度很大，达O（N）。链表的特点是：寻址困难，插入和删除容易。

Set总结：
Set继承于Collection接口，是一个不允许出现重复元素，并且无序的集合，主要有HashSet和TreeSet两大实现类。
在判断重复元素的时候，Set集合会调用hashCode()和equal()方法来实现。
HashSet是哈希表结构，主要利用HashMap的key来存储元素，计算插入元素的hashCode来获取元素在集合中的位置；
TreeSet是红黑树结构，每一个元素都是树中的一个节点，插入的元素都会进行排序;。
public interface Set<E> extends Collection<E> {

    A:添加功能
    boolean add(E e);
    boolean addAll(Collection<? extends E> c);

    B:删除功能
    boolean remove(Object o);
    boolean removeAll(Collection<?> c);
    void clear();

    C:长度功能
    int size();

    D:判断功能
    boolean isEmpty();
    boolean contains(Object o);
    boolean containsAll(Collection<?> c);
    boolean retainAll(Collection<?> c); 

    E:获取Set集合的迭代器：
    Iterator<E> iterator();

    F:把集合转换成数组
    Object[] toArray();
    <T> T[] toArray(T[] a);

    //判断元素是否重复，为子类提高重写方法
    boolean equals(Object o);
    int hashCode();
}
 HashSet
HashSet实现Set接口，底层由HashMap(后面讲解)来实现，为哈希表结构，新增元素相当于HashMap的key，value默认为一个固定的Object。在我看来，HashSet相当于一个阉割版的HashMap;
当有元素插入的时候，会计算元素的hashCode值，将元素插入到哈希表对应的位置中来；
它继承于AbstractSet，实现了Set, Cloneable, Serializable接口。
(1)HashSet继承AbstractSet类，获得了Set接口大部分的实现，减少了实现此接口所需的工作，实际上是又继承了AbstractCollection类；
(2)HashSet实现了Set接口，获取Set接口的方法，可以自定义具体实现，也可以继承AbstractSet类中的实现；
(3)HashSet实现Cloneable，得到了clone()方法，可以实现克隆功能；
(4)HashSet实现Serializable，表示可以被序列化，通过序列化去传输，典型的应用就是hessian协议。
具有如下特点：
不允许出现重复因素；
允许插入Null值；
元素无序（添加顺序和遍历顺序不一致）；
线程不安全，若2个线程同时操作HashSet，必须通过代码实现同步；
1.3 HashSet基本操作
HashSet底层由HashMap实现，插入的元素被当做是HashMap的key，根据hashCode值来确定集合中的位置，由于Set集合中并没有角标的概念，所以并没有像List一样提供get（）方法。当获取HashSet中某个元素时，只能通过遍历集合的方式进行equals()比较来实现；
public class HashSetTest {
    public static void main(String[] agrs){
        //创建HashSet集合：
        Set<String> hashSet = new HashSet<String>();
        System.out.println("HashSet初始容量大小："+hashSet.size());
        //元素添加：
        hashSet.add("my");
        hashSet.add("name");
        hashSet.add("is");
        hashSet.add("jiaboyan");
        hashSet.add(",");
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("!");
        System.out.println("HashSet容量大小："+hashSet.size());
        //迭代器遍历：
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
        //增强for循环
        for(String str:hashSet){
            if("jiaboyan".equals(str)){
                System.out.println("你就是我想要的元素:"+str);
            }
            System.out.println(str);
        }
        //元素删除：
        hashSet.remove("jiaboyan");
        System.out.println("HashSet元素大小：" + hashSet.size());
        hashSet.clear();
        System.out.println("HashSet元素大小：" + hashSet.size());
        //集合判断：
        boolean isEmpty = hashSet.isEmpty();
        System.out.println("HashSet是否为空：" + isEmpty);
        boolean isContains = hashSet.contains("hello");
        System.out.println("HashSet是否为空：" + isContains);
    }
}
在向HashMap中添加元素时，先判断key的hashCode值是否相同，如果相同，则调用equals()、==进行判断，若相同则覆盖原有元素；如果不同，则直接向Map中添加元素


TreeSet：
与HashSet集合类似，TreeSet也是基于Map来实现，具体实现TreeMap(后面讲解)，其底层结构为红黑树（特殊的二叉查找树）；
与HashSet不同的是，TreeSet具有排序功能，分为自然排序(123456)和自定义排序两类，默认是自然排序；在程序中，我们可以按照任意顺序将元素插入到集合中，等到遍历时TreeSet会按照一定顺序输出--倒序或者升序；
它继承AbstractSet，实现NavigableSet, Cloneable, Serializable接口。
（1）与HashSet同理，TreeSet继承AbstractSet类，获得了Set集合基础实现操作；
（2）TreeSet实现NavigableSet接口，而NavigableSet又扩展了SortedSet接口。这两个接口主要定义了搜索元素的能力，例如给定某个元素，查找该集合中比给定元素大于、小于、等于的元素集合，或者比给定元素大于、小于、等于的元素个数；简单地说，实现NavigableSet接口使得TreeSet具备了元素搜索功能；
（3）TreeSet实现Cloneable接口，意味着它也可以被克隆；
（4）TreeSet实现了Serializable接口，可以被序列化，可以使用hessian协议来传输；
具有如下特点：
对插入的元素进行排序，是一个有序的集合（主要与HashSet的区别）;
底层使用红黑树结构，而不是哈希表结构；
允许插入Null值；
不允许插入重复元素；
线程不安全；

TreeSet基本操作
public class TreeSetTest {
    public static void main(String[] agrs){
        TreeSet<String> treeSet = new TreeSet<String>();
        System.out.println("TreeSet初始化容量大小："+treeSet.size());

        //元素添加：
        treeSet.add("my");
        treeSet.add("name");
        treeSet.add("jiaboyan");
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        System.out.println("TreeSet容量大小：" + treeSet.size());
        System.out.println("TreeSet元素顺序为：" + treeSet.toString());

        //增加for循环遍历：
        for(String str:treeSet){
            System.out.println("遍历元素："+str);
        }

        //迭代器遍历：升序
        Iterator<String> iteratorAesc = treeSet.iterator();
        while(iteratorAesc.hasNext()){
            String str = iteratorAesc.next();
            System.out.println("遍历元素升序："+str);
        }

        //迭代器遍历：降序
        Iterator<String> iteratorDesc = treeSet.descendingIterator();
        while(iteratorDesc.hasNext()){
            String str = iteratorDesc.next();
            System.out.println("遍历元素降序："+str);
        }

        //元素获取:实现NavigableSet接口
        String firstEle = treeSet.first();//获取TreeSet头节点：
        System.out.println("TreeSet头节点为：" + firstEle);

        // 获取指定元素之前的所有元素集合：(不包含指定元素)
        SortedSet<String> headSet = treeSet.headSet("jiaboyan");
        System.out.println("jiaboyan节点之前的元素为："+headSet.toString());

        //获取给定元素之间的集合：（包含头，不包含尾）
        SortedSet subSet = treeSet.subSet("1","world");
        System.out.println("1--jiaboan之间节点元素为："+subSet.toString());

        //集合判断：
        boolean isEmpty = treeSet.isEmpty();
        System.out.println("TreeSet是否为空："+isEmpty);
        boolean isContain = treeSet.contains("who");
        System.out.println("TreeSet是否包含who元素："+isContain);

        //元素删除：
        boolean jiaboyanRemove = treeSet.remove("jiaboyan");
        System.out.println("jiaboyan元素是否被删除"+jiaboyanRemove);

        //集合中不存在的元素，删除返回false
        boolean whoRemove = treeSet.remove("who");
        System.out.println("who元素是否被删除"+whoRemove);

       //删除并返回第一个元素：如果set集合不存在元素，则返回null
        String pollFirst = treeSet.pollFirst();
        System.out.println("删除的第一个元素："+pollFirst);

        //删除并返回最后一个元素：如果set集合不存在元素，则返回null
        String pollLast = treeSet.pollLast();
        System.out.println("删除的最后一个元素："+pollLast);

        treeSet.clear();//清空集合:
    }
}

