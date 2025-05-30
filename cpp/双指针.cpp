#include <stdio.h>
#include <math.h>
#include <stdbool.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int n;
int arr[10010];
int temp = 1; // 用来临时记录当前最长的子序列
int cnt = 1;  // 用来记录答案

// 检查子序列 [left, right) 是否存在重复元素
bool check(int left, int right) {
    for (int i = left; i < right; i++) {
        for (int j = i + 1; j < right; j++) {
            if (arr[i] == arr[j]) {
                return false;
            }
        }
    }
    return true;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (check(i, j + 1)) {
                cnt = MAX(cnt, j - i + 1);
            }
        }
    }
    printf("%d", cnt);

    return 0;
}
