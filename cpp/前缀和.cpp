#include <stdio.h>
const int MAX = 1000;

int n = 0;
int arr[MAX] = {0};
int s[MAX];  // 用来存前缀和
int left,right;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    scanf("%d %d",&left,&right);
    // 处理 s[0]
    s[0] = arr[0];
    for (int i = 1; i < n; i++) {
        s[i] = s[i - 1] + arr[i];
    }
    for (int i = 0; i < n; i++) {
        printf("%d ", s[i]);
    }
    printf("\n");
    int out=s[right]-s[left-1];
    printf("%d",out);
    return 0;
}
