#include <stdio.h>
#include <stdint.h>

void reverse_cipher(uint32_t* data_block, uint32_t* secret_key) {
    uint32_t magic_const1 = 0x9e3779b9;
    uint32_t magic_const2 = 0x28004;
    int block_part0 = data_block[0], block_part1 = data_block[1], 
        accumulator = magic_const1 * 34 + magic_const2 * 18, round;
    
    uint32_t key_part0 = secret_key[0], key_part1 = secret_key[1], 
             key_part2 = secret_key[2], key_part3 = secret_key[3];
    
    for (round = 0; round < 18; round++) {
        block_part1 -= ((block_part0 << 4) + key_part0) ^ (block_part0 + accumulator) ^ ((block_part0 >> 5) + key_part1);
        block_part0 -= ((block_part1 << 4) + key_part2) ^ (block_part1 + accumulator) ^ ((block_part1 >> 5) + key_part3);
        accumulator -= magic_const2;
    }
    
    for (round = 0; round < 17; round++) {
        block_part1 -= ((block_part0 << 4) + key_part0) ^ (block_part0 + accumulator) ^ ((block_part0 >> 5) + key_part1);
        block_part0 -= ((block_part1 << 4) + key_part2) ^ (block_part1 + accumulator) ^ ((block_part1 >> 5) + key_part3);
        accumulator -= magic_const1;
    }
    
    for (round = 0; round < 17; round++) {
        block_part1 -= ((block_part0 << 4) + key_part2) ^ (block_part0 + accumulator) ^ ((block_part0 >> 5) + key_part3);
        block_part0 -= ((block_part1 << 4) + key_part0) ^ (block_part1 + accumulator) ^ ((block_part1 >> 5) + key_part1);
        accumulator -= magic_const1;
    }
    
    data_block[0] = block_part0; data_block[1] = block_part1;
}

int main() {
    unsigned char encrypted_data[] = { 
        0x18, 0xe6, 0x95, 0x79, 0x05, 0x76, 0xf3, 0x15, 0xdd, 0xa5, 0x5c, 0x0f,
        0x80, 0x06, 0x26, 0x97, 0x3f, 0x88, 0x65, 0x38, 0x21, 0x83, 0x78, 0xef,
        0x69, 0x11, 0x93, 0x5a, 0x55, 0x32, 0xe1, 0xa9
    };
    
    uint32_t* data_blocks = (uint32_t*)encrypted_data;
    uint32_t secret_key[4] = { 0x12345678, 0x23456789, 0x34567890, 0x45678901 };
    
    // Process each 64-bit block (2x 32-bit words)
    for (int block_num = 0; block_num < 4; block_num++) {
        reverse_cipher(data_blocks + block_num * 2, secret_key);
    }
    
    unsigned char* decrypted_result = (unsigned char*)data_blocks;
    for (int byte_pos = 0; byte_pos < 32; byte_pos++) {
        printf("%c", decrypted_result[byte_pos]);
    }
    printf("\n");
    
    return 0;
}
