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
    
    //���ѭ�����ڿ���ÿ�εݹ鶼ȥ���һ��st�е�ֵ�Ƿ�ʹ��
    //���û�о͸�ֵ��arr������ȥ
    for(int i=1;i<=n;i++)   
    {
        //st�е�ֵΪfalse��ʾû��ʹ�ù�
        if(!st[i])
        {
            //���Ϊʹ�ù�
            st[i]=true;
            arr[x]=i;
            //�ٴε��õݹ�
            dfs(x+1);
            //������ɺ�Ҫ��ԭ�ֳ�
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
