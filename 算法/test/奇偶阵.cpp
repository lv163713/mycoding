#include <stdio.h>

void generateOddMagicSquare(int n)
{
    int magicSquare[n][n];
    int row, col;
    int num = 1;

    // ��ʼ������Ԫ��Ϊ0
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

        // �ƶ�λ��
        row--;
        col++;

        // ����Խ�����
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

    // ��ӡ��ż��
    printf("���ɵ�%d����ż��Ϊ��\n", n);
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

    printf("��������ż��Ľ�����");
    scanf("%d", &n);

    if (n % 2 != 0)
    {
        generateOddMagicSquare(n);
    }
    else
    {
        printf("����������������\n");
    }

    return 0;
}

