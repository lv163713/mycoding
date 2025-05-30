#include <iostream>
#include <cstring>  // 引入 strlen 函数

using namespace std;

// 修正后的自定义字符集
char CUSTOM_ALPHABET[] = "0123456789!@#$%^&*;()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
char STANDARD_ALPHABET[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
// 假设这是实际的加密后的标志，需要替换为真实值
char ENCRYPTED_FLAG[] = "svndq3TtocPLtta=";

int main() {
    int len = strlen(ENCRYPTED_FLAG);  // 获取字符串长度
    for (int i = 0; i < len; i++) {
        for (int k = 0; k < sizeof(CUSTOM_ALPHABET) - 1; k++) {  // 减 1 以排除字符串结束符 '\0'
            if (CUSTOM_ALPHABET[k] == ENCRYPTED_FLAG[i]) {
                cout << STANDARD_ALPHABET[k];  // 使用 std::cout 输出
            }
        }
    }
    cout << endl;  // 输出换行符
    return 0;
}
