#include <iostream>
#include <cstring>  // ���� strlen ����

using namespace std;

// ��������Զ����ַ���
char CUSTOM_ALPHABET[] = "0123456789!@#$%^&*;()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
char STANDARD_ALPHABET[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
// ��������ʵ�ʵļ��ܺ�ı�־����Ҫ�滻Ϊ��ʵֵ
char ENCRYPTED_FLAG[] = "svndq3TtocPLtta=";

int main() {
    int len = strlen(ENCRYPTED_FLAG);  // ��ȡ�ַ�������
    for (int i = 0; i < len; i++) {
        for (int k = 0; k < sizeof(CUSTOM_ALPHABET) - 1; k++) {  // �� 1 ���ų��ַ��������� '\0'
            if (CUSTOM_ALPHABET[k] == ENCRYPTED_FLAG[i]) {
                cout << STANDARD_ALPHABET[k];  // ʹ�� std::cout ���
            }
        }
    }
    cout << endl;  // ������з�
    return 0;
}
