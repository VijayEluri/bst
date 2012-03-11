class BinaryTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.leftHeight = tree.rightHeight = 0;
		/*
		 * tree.Insert(tree.root,53); tree.Insert(tree.root,17);
		 * tree.Insert(tree.root,78); tree.Insert(tree.root,9);
		 * tree.Insert(tree.root,45); tree.Insert(tree.root,65);
		 * tree.Insert(tree.root,87); tree.Insert(tree.root,23);
		 * tree.Insert(tree.root,81);
		 */

		/*
		 * tree.Insert(tree.root,53); tree.Insert(tree.root,17);
		 * tree.Insert(tree.root,78); tree.Insert(tree.root,9);
		 * tree.Insert(tree.root,45); tree.Insert(tree.root,65);
		 * tree.Insert(tree.root,87); tree.Insert(tree.root,23);
		 */

		/*
		 * tree.Insert(tree.root,53); tree.Insert(tree.root,17);
		 * tree.Insert(tree.root,78); tree.Insert(tree.root,9);
		 * tree.Insert(tree.root,23); tree.Insert(tree.root,94);
		 * tree.Insert(tree.root,88);
		 */

		tree.Insert(tree.root, 53);
		tree.Insert(tree.root, 17);
		tree.Insert(tree.root, 78);
		tree.Insert(tree.root, 9);
		tree.Insert(tree.root, 45);
		tree.Insert(tree.root, 65);
		tree.Insert(tree.root, 94);
		tree.Insert(tree.root, 23);
		tree.Insert(tree.root, 81);
		tree.Insert(tree.root, 88);

		tree.currentHeight = 0;
		tree.SetHeight(tree.root, 0);
		// cout<<"before remove:"<<endl;
		tree.PrintBSTVer(tree.root);
		tree.Remove(78, tree.root);
		// cout<<"after remove:"<<endl;
		tree.currentHeight = 0;
		tree.SetHeight(tree.root, 0);
		tree.PrintBSTVer(tree.root);
	}

	private int currentHeight;
	private int deep;
	private int leftHeight;
	private int RefValue;
	private int rightHeight;
	private BinTreeNode root;
	private int sumDeep;

	void destroy(BinTreeNode current) {
	}

	void Insert(BinTreeNode current, int item) {
		if (current == null) {
			current = new BinTreeNode(item, null, null);
			if (root == null)
				root = current;
			return;
		}
		if (item < current.data) {
			Insert(current.leftChild, item);
		} else {
			Insert(current.rightChild, item);
		}
	}

	int IsEmpty() {
		return root == null ? 1 : 0;
	}

	BinTreeNode LeftChild(BinTreeNode current) {
		return root != null ? current.leftChild : null;
	}

	BinTreeNode Min(BinTreeNode ptr) {
		if (null != ptr) {
			if (null != ptr.leftChild) {
				Min(ptr.leftChild);
			}
		}
		return ptr;
	}

	BinTreeNode Parent(BinTreeNode current) {
		return root == null || root == current ? null : Parent(current);
	}

	// int PrintBSTHor(BinTreeNode current) {
	// Queue<BinTreeNode > Q;
	// Q.InitQueue();
	// if(null!=current) {
	// Q.EnQueue(current);
	// while(!Q.QueueEmpty()) {
	// current=Q.DeQueue();
	// if(currentHeight<current.deep) {
	// currentHeight=current.deep;
	// out<<endl;
	// }
	// out<<current.data<<",";
	// if(null!=current.leftChild) {
	// Q.EnQueue(current.leftChild);
	// }
	// if(null!=current.rightChild) {
	// Q.EnQueue(current.rightChild);
	// }
	// }
	// }
	// return 0;
	// }

	int PrintBSTVer(BinTreeNode aa) {
		deep += 1;
		sumDeep += deep;
		for (int i = 0; i < deep; i++)
			// cout<<"\t";
			// cout<<aa.data<<endl;
			if (null != aa.leftChild) {
				PrintBSTVer(aa.leftChild);
			}
		if (null != aa.rightChild) {
			PrintBSTVer(aa.rightChild);
		}
		deep -= 1;
		return deep;
	}

	void Remove(int x, BinTreeNode ptr) {
		BinTreeNode temp;
		if (null != ptr) {
			if (x < ptr.data) {
				Remove(x, ptr.leftChild);
			} else if (x > ptr.data) {
				Remove(x, ptr.rightChild);
			} else if (ptr.leftChild != null && ptr.rightChild != null) {
				temp = Min(ptr.rightChild);
				ptr.data = temp.data;
				Remove(ptr.data, ptr.rightChild);
			} else {
				temp = ptr;
				if (ptr.leftChild == null) {
					ptr = ptr.rightChild;
					SetHeight(ptr, temp.deep);
				} else if (ptr.rightChild == null) {
					ptr = ptr.leftChild;
					SetHeight(ptr, temp.deep);
				}
			}
		}
	}

	BinTreeNode RightChild(BinTreeNode current) {
		return root != null ? current.rightChild : null;
	}

	void SetHeight(BinTreeNode ptr, int height) {
		if (null != ptr) {
			ptr.deep = height;
			if (null != ptr.leftChild) {
				SetHeight(ptr.leftChild, ptr.deep + 1);
			}
			if (null != ptr.rightChild) {
				SetHeight(ptr.rightChild, ptr.deep + 1);
			}
		}
	}

	// istream &operator >>(istream& in ,BinaryTree& Tree) {
	// int item;
	// //cout<<"construct binary tree:"<<endl;
	// //cout<<"input data(end with"<<Tree.RefValue<<"):";
	// in >>item;
	// while(item!=Tree.RefValue) {
	// Tree.Insert(Tree.root,item);
	// //cout<<"input data(end with"<<Tree.RefValue <<"):";
	// in >>item;
	// }
	// return in;
	// }

	// ostream & operator<<(ostream &out,BinaryTree&Tree) {
	// out<<"preorder traversal of bianry tree"<<endl;
	// Tree.Traverse(Tree.root,out);
	// out<<endl;
	// return out;
	// }

	void Traverse(BinTreeNode current) {
		if (current != null) {
			Traverse(current.leftChild);
			System.out.print(current.data + ",");
			Traverse(current.rightChild);
		}
	}
}
