#include<stdio.h>
#include<math.h>
#include<stdbool.h>
#define MAX  100

//�����dfs --> ���仯���� --> ����(dp) 
//���仯����=����dfs+��¼��
//���ƵĹ�ʽ=dfs���µݹ�Ĺ�ʽ  ��������ĳ�ʼֵ = �ݹ�ı߽磬�ݹ�ĳ��� 

int n=0;
int f[MAX]={0};

int main()
{
	scanf("%d",&n);
	f[1]=1,f[2]=2;
	
	if(n==1||n==2){
		printf("%d",f[n]);
		return 0;
	}
	for(int i=3;i<=n;i++){
		f[i]=f[i-1]+f[i-2];		//������ƹ�ʽ����dfs��ת̬ת�ƹ�ʽ,���µݹ�Ĺ�ʽ 
		
	}

	printf("%d ",f[n]);
	return 0;
}
