#include <stdio.h>

void generateOddMagicSquare(int n)
{
    int magicSquare[n][n];
    int row, col;
    int num = 1;

    // 初始化矩阵元素为0
    for (row = 0; row < n; row++)
    {
        for (col = 0; col < n; col++)
        {
            magicSquare[row][col] = 0;
        }
    }

    row = 0;
    col = n / 2;

    while (num <= n * n)
    {
        magicSquare[row][col] = num;
        num++;

        // 移动位置
        row--;
        col++;

        // 处理越界情况
        if (row < 0)
        {
            row = n - 1;
        }
        if (col == n)
        {
            col = 0;
        }
        if (magicSquare[row][col] != 0)
        {
            row += 2;
            col--;
            if (row >= n)
            {
                row -= n;
            }
            if (col < 0)
            {
                col = n - 1;
            }
        }
    }

    // 打印奇偶阵
    printf("生成的%d阶奇偶阵为：\n", n);
    for (row = 0; row < n; row++)
    {
        for (col = 0; col < n; col++)
        {
            printf("%-3d ", magicSquare[row][col]);
        }
        printf("\n");
    }
}

int main()
{
    int n;

    printf("请输入奇偶阵的阶数：");
    scanf("%d", &n);

    if (n % 2 != 0)
    {
        generateOddMagicSquare(n);
    }
    else
    {
        printf("请输入奇数阶数！\n");
    }

    return 0;
}

