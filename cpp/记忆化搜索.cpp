#include<stdio.h>

int n=0;
int mem[100]={0};	//用与存已经算过的数 
int dfs(int x)
{
	if(mem[x]){
		return mem[x];
	}
	int sum=0;
	if(x==1||x==2){
		sum=1;
	}
	else{
		sum=dfs(x-1)+dfs(x-2);
	}
	mem[x]=sum;
	return sum;
}
int main()
{
	scanf("%d",&n);	
	//实现斐波那契数列
	printf("%d",dfs(n)); 
	
	return 0;
}
