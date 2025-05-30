
#include <stdio.h>

void encrypt(char s[], int d) {
    int i = 0;
    while (s[i] != '\0') {
        if ((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z')) {
            if (d > 0) {
                if (s[i] >= 'A' && s[i] <= 'Z') {
                    s[i] = (s[i] - 'A' + d) % 26 + 'A';
                } else {
                    s[i] = (s[i] - 'a' + d) % 26 + 'a';
                }
            } else {
                if (s[i] >= 'A' && s[i] <= 'Z') {
                    s[i] = (s[i] - 'A' + 26 + d) % 26 + 'A';
                } else {
                    s[i] = (s[i] - 'a' + 26 + d) % 26 + 'a';
                }
            }
        }
        i++;
    }
}

int main() {
    char s[100];
    int d;

    printf("请输入字符串：");
    scanf("%s", s);
    printf("请输入d的值：");
    scanf("%d", &d);

    encrypt(s, d);
    printf("加密后的字符串：%s\n", s);

    d = -d;
    encrypt(s, d);
    printf("再次加密后的字符串：%s\n", s);

    return 0;
}

