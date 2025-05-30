#include<stdio.h>

int n;  //用于记录dfs深度 
int st[100];  //标记选用的状态 

//st[]为状态数组，x表示当前递归的深度，n表示总深度 
void dfs(int x,int n){
	//退出递归 
	if(x>n){
		for(int i=1;i<=n;i++){
			//st[i]表示当前位置选到了 
			if(st[i]==1){
				printf("%d ",i);
			}
		} 
		printf("\n");
		return ;
	}
	st[x]=1;	//标记选中 
	dfs((x+1),n);         
	st[x]=0;	//恢复现场，标记当前位置没有选 
	dfs((x+1),n);
	st[x]=0;	//标记没选 
	
}

int main()
{
	scanf("%d",&n);
	dfs(1,n); 
	return 0;	
} 

