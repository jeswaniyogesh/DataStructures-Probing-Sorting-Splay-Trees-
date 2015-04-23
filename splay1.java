package project3;

import java.util.LinkedList;
import java.util.Queue;


public class splay1 {

	
	private node root;
	private node parent;
	
	//**** Create a node having its left and right nodes and value.*****
	private static class node{                                              
		private node left;
		private node right;
		int val;
		
		
		node(node lt,node rt,int val){
			left=lt;
			right=rt;
			this.val=val;
			
		}
		
	}
	
	
	// ******   Inserting a value in the tree ******
	
	public int add (int val){
		
		root= add(root,val);

	    splays(root,val);
		 try{
		 if(root!=null)
		 return (int) root.val;
		
		 } catch(Exception e){
			 e.printStackTrace();
		 }  return 0;
	
		
	}

	
	//*****   Find function will find the root if available and sends it to the top making it a new root and if not found, sends a last accessed node in the list to 
	//          the top making it a new root******   //
	
public boolean find(int val){
	
	
	return find(root,val);
}

public void display(){
	System.out.println(root.val);
}

private boolean find(node t,int val){
	
	if(t.val==val){
		splays(root,val);
		return true;
	}else if(t.left==null && t.right==null){
		splays(root,t.val);
		return false;
	}
	
	
	if(val<t.val){
		return find(t.left,val);
	}else if(val>t.val){
		return find(t.right,val);
	}else return true;
}

//  ********Give us the leaf count of the tree*******//


public int leafCount(){                        
	return leafCount(root);
}

private int leafCount(node t)
{
	if( t==null) { 
		return 0;
	}
	if(t.left==null && t.right==null) {
		return 1;
	}
	else{
	return leafCount(t.left)+leafCount(t.right);	 
	}
	
	
}

//******   Give us the summation of all the values present in the tree *****//

public int treeSum(){
	return treeSum(root);
}


public int treeSum(node t)
{
	int treeSum=0;
	if( t != null )
    {
        treeSum=treeSum+treeSum(t.left);
        treeSum=treeSum + t.val;
        treeSum=treeSum+treeSum(t.right);
        
    }
	return treeSum;
}


//****  Print the different levels of the tree having parent first following with left and right child******//

public void printlevels(){
	printLevels(root);
}

public void printLevels(node t)
{
	Queue<node> a = new LinkedList<>();
	
	a.add(t);
	printLevelValue(a, t);
}

public void printLevelValue(Queue a, node t)
{
	while(!a.isEmpty())
	{
		node node=(node) a.remove();
		System.out.print(node.val + " ");
		if(node.left!=null)
			a.add(node.left);
		if(node.right!=null)
			a.add(node.right);
		
	}
}


// Print the Splay tree in order having parent first followed by its left and right childs******//

public String toString(){
	
	return toString(root);
}

public String toString(node t)
{
	String treeSum="";
	if( t != null )
    {
	    treeSum = treeSum + " " + Integer.toString(t.val);
        treeSum = treeSum + toString(t.left);
        treeSum = treeSum + toString(t.right);
    }
	return treeSum;
}






// public function will call this private method where it actually inserts the value in the tree and returns the root *****//

private node add(node t, int val){
		
		if(t==null){
			return new node(null,null,val);
		}
		
		
		
		if(val<t.val){
			t.left=add(t.left,val);
		}else if(val>t.val){
			t.right=add(t.right,val);
		}else
			;
		return t;
	}
	

// ******   splays function will do all the basic functionalities in splay tree. it will rotate the inserted element and takes it to the root********//

	private void splays(node t, int val){
		try{
		
		 if( t.left!=null && t.left.left!=null && t.left.left.val==val){
			if(t.left.left.val==val){
				zigzigleft(t,t.left,val);
				
			}
		}else
		if(t.left!=null && t.left.val==val){
			if(t.left.val==val){
				zigleft(t);
				
			}
		}	else if( t.left!=null && t.left.right!=null && t.left.right.val==val  ){
			if(t.left.right.val==val)
				zigzagleft(t,val);	
			}
		
		
		
				
		 else if(  t.right!=null && t.right.right!=null && t.right.right.val==val){
			if(t.right.right.val==val){
				zigzigright(t,t.right,val);
				
			}
		}else if(t.right!=null && t.right.val==val){
			if(t.right.val==val){
				zigright(t);
				
			}
			
		
		
		} else if( t.right!=null && t.right.left!=null && t.right.left.val==val ){
			if(t.right.left.val==val){
				
				zigzagright(t,val);	
			}
		
		}
		
		
		else if(t.val>val){
			parent=t;
			splays(t.left,val);
		} else if(t.val<val){
			parent=t;
			splays(t.right,val);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//*****   Following are the different rotate methods which we use to take the element to the root ******//
	private void zigleft(node r){
		
		node t=r.left;
		r.left=t.right;
		t.right=r;
	    root=t;
	}
	
	private void zigright(node r){
		
		node t=r.right;
		r.right=t.left;
		t.left=r;
		root=t;
	}
	
	private void zigzigleft(node gp,node p,int val){
		
		node t=p.left;
		gp.left=p.right;
		p.left=t.right;
		p.right=gp;
		t.right=p;
		
		
		if (parent!=null){
			if (parent.val<val){
				parent.right=t;
				parent=null;
				splays(root,val);
			}else{
				parent.left=t;
				parent=null;
			splays(root,val);
			}
		}else
			root=t;
		}
	
	private void zigzigright(node gp,node p,int val){
		node t=p.right;
		gp.right=p.left;
		p.right=t.left;
		p.left=gp;
		t.left=p;
		
		
		if (parent!=null){
			if (parent.val<val){
				parent.right=t;
				parent=null;
				splays(root,val);
			}else{
				parent.left=t;
				parent=null;
				splays(root,val);
			}
		}else
			root=t;
}
	
private void zigzagleft(node gp,int val){
	node p1=gp.left.right.left;
	node p2=gp.left.right.right;
	node p3=gp.left.right;
	
	p3.left=gp.left;
	p3.right=gp;
	p3.left.right=p1;
	p3.right.left=p2;
	
	
	if (parent!=null){
		if (parent.val<val){
			parent.right=p3;
			parent=null;
			splays(root,val);
		}else{
			parent.left=p3;
			parent=null;
		splays(root,val);
		}
	}else
		root=p3;
}

private void zigzagright(node gp,int val){
	node p1=gp.right.left.right;
	node p2=gp.right.left.left;
	node p3=gp.right.left;
	
	p3.right=gp.right;
	p3.left=gp;
	p3.right.left=p1;
	p3.left.right=p2;
	
	
	if (parent!=null){
		if (parent.val<val){
			parent.right=p3;
			parent=null;
			splays(root,val);
		}else{
			parent.left=p3;
			parent=null;
		splays(root,val);
		}
	}else
		root=p3;
	
	
}	
	
}

