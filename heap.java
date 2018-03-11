import java.util.ArrayList;

public class Heap {
	static ArrayList<Integer> heaplist = new ArrayList<Integer>();
	public static void main(String [] args){
		int [] A = {2,7,26,25,19,17,1 , 90,3,36};
		//
		for(int i = 0 ; i < A.length ; i++){
			insert(A[i]);
		}
		
		System.out.println(extractMax());
		
		int [] KMax = new int[3];
		KMax = extractKMax(3);
		System.out.println(KMax[0] + " " + KMax[1] + " " + KMax[2]);
		System.out.println(extractMax());
		printlist();
		delete(3);
		printlist();
	}
	public static void printlist(){
		for(Integer i : heaplist){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void insert(int n){
		heaplist.add(n);
		int i = heaplist.size() - 1;
		while(i > 0 && heaplist.get(parent(i)) < heaplist.get(i) ){	
			int temp = heaplist.get(i) ;
			heaplist.set(i, heaplist.get(parent(i)));
			heaplist.set(parent(i) , temp);
			i = parent(i);
		}
	}
	
	public static int extractMax(){
		int x = heaplist.get(0);
		heaplist.set(0 , heaplist.get(heaplist.size() - 1));
		heaplist.remove(heaplist.size() - 1);

		heapify(0);
		
		
		return x;
	}
	public static void delete(int n){
		int x = heaplist.indexOf(n);
		heaplist.set(x,heaplist.get(heaplist.size() - 1));
		heaplist.remove(heaplist.size() - 1);
		heapify(x);
	}
	public static void heapify(int i){
		while(2 * i + 2 < heaplist.size()){
			int childl = 2 * i + 1;
			int childr = 2 * i + 2;
			int swapindex;
			if(heaplist.get(childl) < heaplist.get(childr)){
				swapindex = childr;
			}
			else{
				swapindex = childl;
			}
			int temp = heaplist.get(i) ;
			heaplist.set(i, heaplist.get(swapindex));
			heaplist.set(swapindex , temp);
			
			i = swapindex;
			
		}
	}
	public static int[] extractKMax(int k){
		int [] A = new int[k];
		for(int i = 0 ; i < k ; i++){
			A[i] = extractMax();
		}
		return A;
	}
	public static int parent(int i){
		return (i - 1)/ 2;
	}
}

