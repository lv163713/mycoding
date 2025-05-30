#include <stdio.h>
#include <stdbool.h>

int n = 0;
int arr[30];
bool st[30];

void dfs(int x)
{
    if(x>n)
    {
        for(int i=1;i<=n;i++)
        {
            printf("%5d",arr[i]);
        }
        printf("\n");
        return ;
    }
    
    //这个循环用于控制每次递归都去检查一下st中的值是否被使用
    //如果没有就赋值到arr数组中去
    for(int i=1;i<=n;i++)   
    {
        //st中的值为false表示没有使用过
        if(!st[i])
        {
            //标记为使用过
            st[i]=true;
            arr[x]=i;
            //再次调用递归
            dfs(x+1);
            //调用完成后要还原现场
            st[i]=false;
            arr[x]=0;
        }
    }
}

int main()
{
    scanf("%d",&n);
    dfs(1);
    return 0;
}
