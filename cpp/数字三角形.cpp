#include <stdio.h>
#define MAX 1010

int max(int a, int b) {
    return a > b ? a : b;
}

int arr[MAX][MAX] = {0};
int mem[MAX][MAX] = {0};
//int f[MAX][MAX]={0};
int f[MAX]={0};
int n;
int max_sum = 0;

/*
//i, j ��ʾ��ǰλ�� ,i�䵱��x�Ĺ��� 
int dfs(int i, int j) {
	if(mem[i][j]){
		return mem[i][j];
	}
    int sum=0;
    if (i>n||j>n) {
    	return 0;
    }
    //�������������ʱ����   dfs(x)=max(dfs(x+1),dfs(x+2))
	//������������ĺ͵�ʱ����+��dfs(x)=dfs(x+1)+dfs(x+2) 
	sum=max(dfs(i+1,j),dfs(i+1,j+1))+arr[i][j];
    mem[i][j]=sum;
	return sum;
	
}
*/

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            scanf("%d", &arr[i][j]);
        }
    }
    //������
    for(int i=n;i>=1;i--){
        for(int j=1;j<=i;j++){
            //f[i][j]=max(f[i+1][j],f[i+1][j+1])+arr[i][j];
            f[j]=max(f[j],f[j+1])+arr[i][j];
        }
    }
    
    /*
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            //f[i][j]=max(f[i-1][j],f[i-1][j-1])+arr[i][j];
        }
    }
    int ans = 0;
    for (int j = 1; j <= n; j++) {
        ans = max(ans, f[n][j]);
    }
    printf("%d",ans);
    */
    printf("%d\n",f[1]);
}
