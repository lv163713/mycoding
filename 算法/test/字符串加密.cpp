#include <stdio.h>
#include <string.h>

// 函数：将字符串中的每个字母用其之后（或之前）的第d个字母替换
void encrypt(char s[], int d) {
    int length = strlen(s);
    for (int i = 0; i < length; i++) {
        // 判断字符是否为字母
        if ((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z')) {
            // 判断字符的大小写
            char base = (s[i] >= 'a' && s[i] <= 'z') ? 'a' : 'A';
            // 将字符转换为相对于基准字母的偏移量
            int offset = s[i] - base;
            // 将偏移量加上d并求模，得到新的偏移量
            int newOffset = (offset + d) % 26;
            // 如果新的偏移量为负数，则加上26得到正数偏移量
            if (newOffset < 0) {
                newOffset += 26;
            }
            // 将新的偏移量加上基准字母得到替换后的字符
            s[i] = base + newOffset;
        }
    }
}

int main() {
    char s[100];
    int d;

    // 输入字符串s和d
    printf("请输入一个字符串：");
    scanf("%s", s);
    printf("请输入一个整数d：");
    scanf("%d", &d);

    // 调用encrypt函数加密字符串s
    encrypt(s, d);

    // 输出加密后的字符串
    printf("加密后的字符串：%s\n", s);

    // 翻转d的符号
    d = -d;

    // 再次调用encrypt函数加密字符串s
    encrypt(s, d);

    // 输出再次加密后的字符串
    printf("再次加密后的字符串：%s\n", s);

    return 0;
}

