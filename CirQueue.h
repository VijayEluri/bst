#define QueueSize 10   //Ӧ���ݾ�����������ֵ

template <class Type> struct CirQueue
{               
	int front;  //ͷָ�룬�ӷǿ�ʱָ���ͷԪ��            
    int rear;  //βָ�룬�ӷǿ�ʱָ���βԪ�ص���һλ��             
	int count;  //����������¼����Ԫ������
    Type data[QueueSize];
};

template<class Type> int QueueEmpty(CirQueue<Type> *Q)
{
	return Q->count==0;  //������Ԫ��Ϊ��
}

void Error(char* message)
{
	cout<<message<<endl;
}

template<class Type> Type DeQueue(CirQueue<Type> *Q)
{
	Type temp;
    if(QueueEmpty(Q))
		Error("Queue underflow");     //�ӿ�����
	temp=Q->data[Q->front];
    Q->count--;                        //����Ԫ�ظ�����1
    Q->front=(Q->front+1)%QueueSize;   //ѭ�������µ�ͷָ���1
    return temp; 
}

//ȡ�ö���front����
template<class Type> int QueueFront(CirQueue<Type> *Q)
{
	if(QueueEmpty(Q))
		Error("Queue is empty.");
	return Q->data[Q->front];
}

template<class Type> void InitQueue(CirQueue<Type> *Q)
{
	Q->front=Q->rear=0;
    Q->count=0;     //��������0
}

template<class Type> int QueueFull(CirQueue<Type> *Q)
{
	return Q->count==QueueSize;  //����Ԫ�ظ�������QueueSizeʱ����
}


template<class Type> void EnQueue(CirQueue<Type> *Q,Type x)//�������
{
	if(QueueFull(Q))                   
	{
		cout<<"when try to input data:"<<x;
		Error("Queue overflow so shrow out");     //��������
		cout<<DeQueue(Q)<<endl;
	}
	Q->count++;                        //����Ԫ�ظ�����1
	Q->data[Q->rear]=x;                 //��Ԫ�ز����β
	Q->rear=(Q->rear+1)%QueueSize;      //ѭ�������½�βָ���1
}
