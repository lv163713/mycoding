#include<stdio.h>
#include<math.h>
#include<stdbool.h>
#include<stdlib.h>
#include<string.h>
#define MAX  100010
int T=0,n=0;	//T��ʾ�ж��������ݣ�n��ʾһ���ж��ٵ���
int stop[MAX]={0};
int money=0;	//��¼�õ�����Ǯ 
int st[MAX]={0};	//��¼�ļҵ���ѡ���� 

int f[MAX]={0};		//dp

int mem[MAX]={0};	//mem[i]����Ǵӵ�i�� ���̿�ʼ֮���ܻ�õ����Ľ�� 


//���仯�����Ż���Ҫ����ִ�м��仯������dfs�еĲ���Ҫ�����ܵ��٣�
//��Ӧ�ð�û��Ӱ�쵽�߽�Ĳ����Ž����������Ĳ���һ���������һ���������������			 
//��Ҫ��֦������Ҫ���ܼ�֦�Ĳ������ӽ�ȥ 
int max(int a, int b) {
    return a > b ? a : b;
}

/*
void dfs(int x)//x��ʾ���̺� 
{
	if(x>n){
		int sum=0;
		for(int i=1;i<=n;i++){
			if(st[i]){
				sum+=stop[i];
			}
		}
		if(sum>money){
			money=sum;
		}
		return ;
	}		
	st[x]=1;
	dfs(x+2);
	st[x]=0;
	dfs(x+1);
	st[x]=0;
}
*/
/*
int dfs(int x){
	if(mem[x])	return mem[x];

	int sum=0;
	if(x>n){
		sum=0;
	}
	else{
		sum = max(dfs(x+1),dfs(x+2)+stop[x]);
	}
	mem[x]=sum;
	return sum;
}*/

//dfs ���仯���� ����dp ����dp �ռ��Ż� 
int main()
{
	scanf("%d",&T);
	while(T--){
		scanf("%d",&n);
		for(int j=1;j<=n;j++){
			scanf("%d",&stop[j]);
		}
		memset(f,0,sizeof(f));
		
		//dp��̬�滮
		/*
		for(int i=n;i>=1;i--){
			f[i]=max(f[i+1],f[i+2]+stop[i]);
		}
		printf("%d",f[1]);*/
		int newf=0,tmp1=0,tmp2=0; 
		for(int i=1;i<=n;i++){
			newf=max(tmp1,tmp2+stop[i]);
			tmp2=tmp1;
			tmp1=newf;
		}
		printf("%d",newf);
		
		
		/*memset(mem,0,sizeof(mem));
		money=dfs(1);
		printf("%d\n",money);*/
	}
	
	return 0;
}
