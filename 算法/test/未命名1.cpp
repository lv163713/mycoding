#include <stdio.h>
#include <stdlib.h>


int main()
{
	FILE* fp = fopen("D:/Filetext/b.txt", "r");
	if (!fp)
	{
		printf("打开文件失败");
		return -1;
	}

	fclose(fp);
	return 0;
}
