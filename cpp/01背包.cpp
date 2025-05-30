#include<stdio.h>
#include<string.h>
#define N 1010

int n=0,back=0;
int v[N]={0},w[N]={0};

int main()
{
    scanf("%d %d",&n,&back);
    for(int i=1;i<=n;i++){
        scanf("%d %d",&v[i],&w[i]);
    }
    
    return 0;
}
