#include<stdio.h>

int n;  //���ڼ�¼dfs��� 
int st[100];  //���ѡ�õ�״̬ 

//st[]Ϊ״̬���飬x��ʾ��ǰ�ݹ����ȣ�n��ʾ����� 
void dfs(int x,int n){
	//�˳��ݹ� 
	if(x>n){
		for(int i=1;i<=n;i++){
			//st[i]��ʾ��ǰλ��ѡ���� 
			if(st[i]==1){
				printf("%d ",i);
			}
		} 
		printf("\n");
		return ;
	}
	st[x]=1;	//���ѡ�� 
	dfs((x+1),n);         
	st[x]=0;	//�ָ��ֳ�����ǵ�ǰλ��û��ѡ 
	dfs((x+1),n);
	st[x]=0;	//���ûѡ 
	
}

int main()
{
	scanf("%d",&n);
	dfs(1,n); 
	return 0;	
} 

