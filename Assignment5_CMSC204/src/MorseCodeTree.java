import java.util.ArrayList;
/**
 * These program creates a morse code tree
 * @author Jiaxi Tang
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;
	
	/**
	 * default constructor, calls bulidTree() method, 
	 * Initialize the root to empty string
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	@Override
	/**
	 * Calls insert repetively to insert nodes
	 */
	public void buildTree() {
		String[] eT = {"e","i","a","s","u","r","w","h","v","f","","l","","p","j"};
		String[] tT = {"t","n","m","d","k","g","o","b","x","c","y","z","q","",""};
		String[] eTMorse = new String[eT.length];
		String[] tTMorse = new String[tT.length];
		eTMorse[0] = ".";
		tTMorse[0] = "-";
		for(int i = 0; i<=(eT.length-2)/2; i++) {
			if(eT[2*i+1].length() !=0 )
				eTMorse[2*i+1] = eTMorse[i]+".";
			if(eT[2*i+2].length() != 0)
				eTMorse[2*i+2] = eTMorse[i]+"-";
		}
		for(int i = 0; i<=(tT.length-2)/2; i++) {
			if(tT[2*i+1].length() !=0 )
				tTMorse[2*i+1] = tTMorse[i]+".";
			if(tT[2*i+2].length() != 0)
				tTMorse[2*i+2] = tTMorse[i]+"-";
		}
		int eTIndex = 0, tTIndex = 0;
		for(int level = 1; level < 5; level++) {
			int numNodes = (int)(Math.pow(2,level)/2);
			for(int e = 1; e <= numNodes; e++) {
				if(eT[eTIndex].length()!=0) {
					insert(eTMorse[eTIndex],eT[eTIndex]);
				}
				eTIndex++;
			}
			for(int t = 1; t <= numNodes; t++) {
				if(tT[tTIndex].length()!=0) {
					insert(tTMorse[tTIndex],tT[tTIndex]);
				}
				tTIndex++;
			}
		}
	}
	
	@Override
	/**
	 * returns the root
	 * @return the root node
	 */
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	/**
	 * set the root node
	 * @param newNode the new root node
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	@Override
	/**
	 * calls recursive method addNode to add nodes to correct position 
	 * @param code the corresponding morse code of the letter
	 */
	public LinkedConverterTreeInterface<String> insert(String code, String letter) {
		addNode(root,code,letter);
		return this;
	}

	@Override
	/**
	 * recursive method that add nodes
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length()==1) {
			//System.out.print(letter+":"+(code)+"  ");
			TreeNode<String> newNode = new TreeNode<String>(letter);
			if(code.equals("."))
				root.leftChild = newNode;
			else
				root.rightChild = newNode;
		}
		else {
			if(code.charAt(0)=='.')
				addNode(root.leftChild,code.substring(1),letter);
			else
				addNode(root.rightChild,code.substring(1),letter);
		}
	}

	@Override
	/**
	 * get the data by using the code
	 */
	public String fetch(String code) {
		String result = fetchNode(root,code);
		return result;
	}

	@Override
	/**
	 * recursive method that get the data by using the provided code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		String result = "";
		if(code.length()==1) {
			if(code.equals("."))
				result = root.leftChild.getData();
			else
				result = root.rightChild.getData();
		}
		else {
			if(code.charAt(0)=='.')
				result = fetchNode(root.leftChild,code.substring(1));
			else
				result = fetchNode(root.rightChild,code.substring(1));
		}
		return result;
	}

	@Override
	/**
	 * returns an arraylist containing the data in the tree in "in order" order
	 */
	public ArrayList<String> toArrayList() {
		ArrayList<String> array = new ArrayList<>();
		LNRoutputTraversal(root,array);
		return array;
	}

	@Override
	/**
	 * store the content in the arraylist in "in order" order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root.leftChild != null) {
			LNRoutputTraversal(root.leftChild,list);
		}
		//if(!root.getData().equals(""))
		list.add(root.getData());
		if(root.rightChild != null) {
			LNRoutputTraversal(root.rightChild, list);
		}
	}
	
	@Override
	/**
	 * not supported
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	/**
	 * not supported
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
