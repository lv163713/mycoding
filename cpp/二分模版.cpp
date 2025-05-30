#include<stdio.h>
#include<stdbool.h> 

int n, k, r, l;
int arr[100010];
int temp;

bool Isblue(int mid) {
    return arr[mid] >= temp; // 判断arr[mid]是否大于等于temp
}

bool Israd(int mid) {
    return arr[mid] <= temp; // 判断arr[mid]是否小于等于temp
}

void Is_inarr(int x) {
    r = -1;
    l = n;
    while (r + 1 < l) {
        int mid = (r + l) >> 1;
        if (Isblue(mid)) {
            l = mid;  // 收缩右边界
        } else {
            r = mid;  // 收缩左边界
        }
    }
    printf("%d ", l);

    r = -1;
    l = n;
    while (r + 1 < l) {
        int mid = (r + l) >> 1;
        if (Israd(mid)) {
            r = mid;  // 收缩左边界
        } else {
            l = mid;  // 收缩右边界
        }
    }
    printf("%d", r);
}

int main() {
    scanf("%d %d", &n, &k);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    for (int i = 0; i < k; i++) {
        scanf("%d", &temp);
        Is_inarr(temp);
        printf("\n");
    }
    return 0;
}

