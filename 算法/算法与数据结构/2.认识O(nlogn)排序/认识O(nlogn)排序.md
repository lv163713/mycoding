## O(nlogn)排序


# master公式
![](image-1.png)
+ 适用条件: 当递归满足子问题等规模
+ O(n) 带入a,b,c计算
![Alt text](<屏幕截图 2024-01-27 124146-1.png>)
+ a指代的是process执行两次
+ b指代的是n数据被分成两半
+ d指代的是除去递归过程剩余的算法的时间复杂度
![Alt text](image.png)

# 归并排序
![alt text](<屏幕截图 2024-03-11 221543-1.png>)
![alt text](<屏幕截图 2024-03-11 221615-1.png>)
![alt text](<屏幕截图 2024-03-11 221615-1-1.png>)
* 这就是O(Nlogn)排序
用到了分治的思想

# 两道题目
## 荷兰国旗问题(开三个区域)
-----

![alt text](<屏幕截图 2024-03-11 223317-1.png>)
+ 荷兰国旗升级版,左下于,中等于,右大于
![alt text](image-2.png)

+ 快速排序3.0版本
+ ![alt text](image-4.png)
 ![alt text](image-3.png)