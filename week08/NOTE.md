学习笔记
位运算：
位运算主要针对二进制：它包括了：“与”、“非”、“或”、“异或”。从表面上看似乎有点像逻辑运算符，但逻辑
运算符是针对两个关系运算符来进行逻辑运算，而位运算符主要针对两个二进制数的位进行逻辑运算。

布隆过滤器 HashTable + 拉练存储重复元素
一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。
优点：空间效率和查询的时候远远超过一般的算法。
缺点：有一定的误识别率和删除困难
（查询不在则一定不在，可能在->查询数据库判断是否一定存在）

排序：
public static void main(String[] args) {
   //冒泡：
	int[] arr1 = new int[] {9, 4, 5, 9, 7, 3, 9, 2, 0};
	bubbleSort(arr1);
	System.out.println(Arrays.toString(arr1));
	//快速排序：
	System.out.println(Arrays.toString(arr1));
	QuickSort(arr1, 0, arr1.length - 1);
	System.out.println(Arrays.toString(arr1));
	//插入排序：
	insertSort(arr1);
	System.out.println(Arrays.toString(arr1));
	//选择排序
	System.out.println(Arrays.toString(arr1));
	selectionSort(arr1);
	System.out.println(Arrays.toString(arr1));
	//归并排序：
	sort(arr1, 0, arr1.length-1);  
    System.out.println(Arrays.toString(arr1));  
}

冒泡排序：
public static void bubbleSort(int[] arr) {
	for(int i = 0; i < arr.length-1; i++) {
		for(int j = 0; j < arr.length - 1 - i; j++) {
			if(arr[j] > arr[j + 1]){
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}

快速排序：
public static void QuickSort(int[] arr,int start, int end){
	if(start < end){
		int low = start;
		int high = end;
		int standard = arr[low];
		while(low < high){
			while(low < high && standard < arr[high])high--;
			if(low < high) arr[low++] = arr[high];
			while(low < high && standard > arr[low])low++;
			if(low < high) arr[high--] = arr[low];
		}
		arr[low] = standard;
		QuickSort(arr, start, low - 1);
		QuickSort(arr, low + 1, end);
	}
}

插入排序：
public static void insertSort(int[] arr) {
	for(int i = 1; i < arr.length; i++) {
		if(arr[i] < arr[i - 1]) {
			int temp = arr[i];
			int j;
			for(j = i - 1; j >= 0 && temp < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}
		
}

选择排序：
public static String selectionSort(int[] arr) {
	for(int i=0; i<arr.length; i++) {
		
		//最小数的索引
		int minIndex = i;
		for(int j=i; j<arr.length; j++) {
			
			//找到最小数，并记录最小数的索引
			if(arr[j] < arr[minIndex]) {
				minIndex = j;
			}
		}
		
		//交换符合条件的数
		int tmp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = tmp;
	}
	
	return Arrays.toString(arr);
}

归并排序：
 public static int[] sort(int[] nums, int low, int high) {  
        int mid = (low + high) / 2;  
        if (low < high) {  
            // 左边  
            sort(nums, low, mid);  
            // 右边  
            sort(nums, mid + 1, high);  
            // 左右归并  
            merge(nums, low, mid, high);  
        }  
        return nums;  
    }  
  
    public static void merge(int[] nums, int low, int mid, int high) {  
        int[] temp = new int[high - low + 1];  
        int i = low;// 左指针  
        int j = mid + 1;// 右指针  
        int k = 0;  
  
        // 把较小的数先移到新数组中  
        while (i <= mid && j <= high) {  
            if (nums[i] <= nums[j]) {  
                temp[k++] = nums[i++];  
            } else {  
                temp[k++] = nums[j++];  
            }  
        }  
  
        // 把左边剩余的数移入数组  
        while (i <= mid) {  
            temp[k++] = nums[i++];  
        }  
  
        // 把右边边剩余的数移入数组  
        while (j <= high) {  
            temp[k++] = nums[j++];  
        }  
  
        // 把新数组中的数覆盖nums数组  
        for (int k2 = 0; k2 < temp.length; k2++) {  
            nums[k2 + low] = temp[k2];  
        }  
    }  

