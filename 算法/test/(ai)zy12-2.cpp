#include <stdio.h>
#include <stdlib.h>

// �����鼮��Ϣ�ṹ��
struct book {
    char number[11];
    char name[21];
    float price;
    struct book *next;
};

// ����������
struct book *CreateLink(int n) {
    struct book *head, *p, *q;
    head = (struct book *)malloc(sizeof(struct book));
    head->next = NULL;
    q = head;
    for (int i = 0; i < n; i++) {
        p = (struct book *)malloc(sizeof(struct book));
        scanf("%s %s %f", p->number, p->name, &p->price);
        p->next = NULL;
        q->next = p;
        q = p;
    }
    return head;
}

// ���������Ϣ����
void PrintLink(struct book *h) {
    struct book *p = h->next;
    while (p) {
        printf("%s %s %.2f\n", p->number, p->name, p->price);
        p = p->next;
    }
}

int main() {
    int n;
    scanf("%d", &n);
    struct book *head = CreateLink(n);
    PrintLink(head);
    return 0;
}

