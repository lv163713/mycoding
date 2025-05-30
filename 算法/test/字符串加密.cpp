#include <stdio.h>
#include <string.h>

// ���������ַ����е�ÿ����ĸ����֮�󣨻�֮ǰ���ĵ�d����ĸ�滻
void encrypt(char s[], int d) {
    int length = strlen(s);
    for (int i = 0; i < length; i++) {
        // �ж��ַ��Ƿ�Ϊ��ĸ
        if ((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z')) {
            // �ж��ַ��Ĵ�Сд
            char base = (s[i] >= 'a' && s[i] <= 'z') ? 'a' : 'A';
            // ���ַ�ת��Ϊ����ڻ�׼��ĸ��ƫ����
            int offset = s[i] - base;
            // ��ƫ��������d����ģ���õ��µ�ƫ����
            int newOffset = (offset + d) % 26;
            // ����µ�ƫ����Ϊ�����������26�õ�����ƫ����
            if (newOffset < 0) {
                newOffset += 26;
            }
            // ���µ�ƫ�������ϻ�׼��ĸ�õ��滻����ַ�
            s[i] = base + newOffset;
        }
    }
}

int main() {
    char s[100];
    int d;

    // �����ַ���s��d
    printf("������һ���ַ�����");
    scanf("%s", s);
    printf("������һ������d��");
    scanf("%d", &d);

    // ����encrypt���������ַ���s
    encrypt(s, d);

    // ������ܺ���ַ���
    printf("���ܺ���ַ�����%s\n", s);

    // ��תd�ķ���
    d = -d;

    // �ٴε���encrypt���������ַ���s
    encrypt(s, d);

    // ����ٴμ��ܺ���ַ���
    printf("�ٴμ��ܺ���ַ�����%s\n", s);

    return 0;
}

