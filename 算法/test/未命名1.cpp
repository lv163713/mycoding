#include <stdio.h>
#include <stdlib.h>


int main()
{
	FILE* fp = fopen("D:/Filetext/b.txt", "r");
	if (!fp)
	{
		printf("���ļ�ʧ��");
		return -1;
	}

	fclose(fp);
	return 0;
}
