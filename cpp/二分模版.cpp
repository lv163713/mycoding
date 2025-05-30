#include<stdio.h>
#include<stdbool.h> 

int n, k, r, l;
int arr[100010];
int temp;

bool Isblue(int mid) {
    return arr[mid] >= temp; // �ж�arr[mid]�Ƿ���ڵ���temp
}

bool Israd(int mid) {
    return arr[mid] <= temp; // �ж�arr[mid]�Ƿ�С�ڵ���temp
}

void Is_inarr(int x) {
    r = -1;
    l = n;
    while (r + 1 < l) {
        int mid = (r + l) >> 1;
        if (Isblue(mid)) {
            l = mid;  // �����ұ߽�
        } else {
            r = mid;  // ������߽�
        }
    }
    printf("%d ", l);

    r = -1;
    l = n;
    while (r + 1 < l) {
        int mid = (r + l) >> 1;
        if (Israd(mid)) {
            r = mid;  // ������߽�
        } else {
            l = mid;  // �����ұ߽�
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

