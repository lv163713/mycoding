#include <stdio.h>
#include <stdlib.h>
#define _CRT_SECURE_NO_WARNINGS

//�Խṹ��������� �򻯴���
typedef struct student ss;
//ss==struct student

struct student
{
	char name[21];
	int age;
	char sex;
	int score[3];
	char addr[51];
};


//���ٶѿռ�洢�ṹ��
int main()
{
	//printf("%d\n", sizeof(struct student));

	struct student* p = (struct student*)malloc(sizeof(struct student) * 3);
	//ss* p = (ss*)malloc(sizeof(ss) * 3);
	
	for (int i = 0; i < 3; i++)
	{
		scanf_s("%s%d,%c%d%d%d%s", p[i].name, &p[i].age,
			&p[i].sex, &p[i].score[0], &p[i].score[1],
			&p[i].score[2], p[i].addr);
		/*scanf("%s ", p[i].name);
		scanf("%d ", &p[i].age);
		scanf("%c ", &p[i].sex);
		scanf("%d ", &p[i].score[0]);
		scanf("%d ", &p[i].score[1]);
		scanf("%d ", &p[i].score[2]);
		scanf("%s ", p[i].addr);*/

	}

	for (int i = 0; i < 3; i++)
	{
		printf("����:%s ", p[i].name);
		printf("����:%d ", p[i].age);
		printf("�Ա�:%s ", p[i].sex);
		printf("����1:%d ", p[i].score[0]);
		printf("����2:%d ", p[i].score[1]);
		printf("����3:%d ", p[i].score[2]);
		printf("��ַ:%s ", p[i].addr);
		printf("\n");
	}
	free(p);
	return 0;
}
