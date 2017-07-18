## Algorithm
### 一、冒泡排序
#### 基本思想：
         1、比较相邻的元素，若前者大于后者则二者交换
         2、针对所有元素重复以上步骤
#### 时间复杂度
         冒泡排序总的平均时间复杂度为 O(n^2)
#### 优缺点
         优点：稳定 缺点：慢 每次只能移动相邻两个数据

### 二、插入排序
#### 基本思想：
         1、将n个元素的数列分为已有序和无序两个部分
         2、每次处理就是将无序数列的第一个元素与有序数列的元素从后往前逐个进行比较，找出插入位置并进行插入。
#### 时间复杂度
         插入排序总的平均时间复杂度为 O(n^2)
#### 算法实现
          for (int i = 1; i < ints.length; i++) {
                     int temp = ints[i];
                     int j = i - 1;
                     while (j > -1 && temp < ints[j]) {
                         ints[j + 1] = ints[j];
                         j--;
                     }
                     ints[j + 1] = temp;
                 }
#### 优缺点
         优点：稳定 缺点：比较次数不一定，比较次数越少，插入点后的数据移动越多，特别是当数据总量庞大的时候，

### 三、堆排序
#### 堆分为大根堆和小根堆，是完全二叉树
#### 基本思想：
         1、构建大或者小根堆
         2、将堆顶结点与最后一个最后一个结点进行比较
#### 时间复杂度
         堆排序总的平均时间复杂度为 O(n*logn)。
#### 算法实现
         for (int i = root * 2 + 1; i < length; i++) {
                //若左子结点 root*2+1 小于右子节点 root*2+2 则值交换
                swap(ints, i, i + 1);
                // 父节点与左子节点比较 并进行直接换
                swap(ints, root, i);
             }
         for (int i = 0; i < ints.length / 2; i++) heapAdjust(ints, i, ints.length - 1);
         for (int i = ints.length - 1; i > 0; --i) {
               //将堆顶结点与最后一个最后一个结点进行比较
               swap(ints, i, 0);
               //调整后可能违反堆的性质，需要对堆进行调整
               heapAdjust(ints, 0, i - 1);
             }
#### 优缺点
         优点：稳定 堆排序的效率与快排、归并相同，都达到了基于比较的排序算法效率的峰值（时间复杂度为O(nlogn)）
         缺点：对于待排序序列的每次更新（增，删，改），我们都要重新做一遍堆的维护，以保证其特性，
### 四、归并排序
         归并排序（Merge）是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。

         归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用
#### 基本思想
         1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列

         2、设定两个指针，最初位置分别为两个已经排序序列的起始位置

         3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置

         4、重复步骤3直到某一指针达到序列尾

         5、将另一序列剩下的所有元素直接复制到合并序列尾
#### 时间复杂度
         归并算法时间复杂度为O(nlog(n))
#### 优缺点
         优点：稳定，效率高
         缺点：归并排序需要O(n)的辅助空间，而与之效率相同的快排和堆排分别需要O(logn)和O(1)的辅助空间，在同类算法中归并排序的空间复杂度略高
### 五、快速排序
         快速排序（Quicksort）是对冒泡排序的一种改进。采用分治策略
#### 基本思想
         快速排序使用分治的思想，通过一趟排序将待排序列分割成两部分，其中一部分记录的关键字均比另一部分记录的关键字小。
         之后分别对这两部分记录继续进行排序，以达到整个序列有序的目的。
#### 实现步骤
        (1)选择基准：在待排序列中，按照某种方式挑出一个元素，作为 "基准"（pivot）

        (2)分割操作：以该基准在序列中的实际位置，把序列分成两个子序列。此时，在基准左边的元素都比该基准小，在基准右边的元素都比基准大

        (3)递归地对两个序列进行快速排序，直到序列为空或者只有一个元素。
#### 时间复杂度
        快速排序的平均时间复杂度为O(nlogn)
#### 算法实现
        //获取基准数
        fun partition(ints: IntArray, low: Int, high: Int): Int {
            var low = low
            var high = high
            val key = ints[low]
            while (low < high) {
                while (ints[high] >= key && high > low) {//从后半部分向前扫描
                    high--
                }
                ints[low] = ints[high]
                while (ints[low] <= key && high > low) { //从前半部分向后扫描
                    low++
                }
                ints[high] = ints[low]
            }
            ints[high] = key
            return high
        }

        fun sort(ints: IntArray, low: Int, high: Int) {
            if (low >= high) {
                return
            }
            val index = partition(ints, low, high)
            sort(ints, low, index - 1)
            sort(ints, index + 1, high)
        }
#### 优缺点
        优点：数据移动少 速度快 缺点：不稳定
### 六、选择排序
#### 基本思想
            在一个长度为N的无序数组中，在第一趟遍历N个数据，找出其中最小的数值与第一个元素交换，第二趟遍历剩下的N-1个数据，
        找出其中最小的数值与第二个元素交换......第N-1趟遍历剩下的2个数据，找出其中最小的数值与第N-1个元素交换，至此选择排序完成。
#### 算法实现
        fun selectSort(ints: IntArray) {
            for (i in ints.indices) {
                var index = i
                (i..ints.size - 1)
                        .asSequence()
                        .filter { ints[index] > ints[it] }
                        .forEach { index = it }
                val temp = ints[i]
                ints[i] = ints[index]
                ints[index] = temp
            }
        }

#### 时间复杂度
        选择排序的平均时间复杂度为O(n^2)
#### 空间复杂度
        O(1) (用于交换和记录索引)
#### 优缺点
        稳定性：不稳定 （比如序列[5， 5， 3]第一趟就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）
### 七、希尔排序
        希尔排序(Shell Sort)是插入排序的一种。也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法。