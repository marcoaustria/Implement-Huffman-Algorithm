import java.io.File;

public class Project3 {

	public static void main(String[] args) throws Exception {

		HuffmanEncoder test = new HuffmanEncoder();

		File testFile = new File("randTest.txt");

		System.out.println("getFrequencies():\n" + test.getFrequencies(testFile));

		HuffTree testTree = test.buildTree(testFile);
		System.out.println("buildTree():\n" + testTree.root().weight());
		String testString = test.encodeFile(testFile, testTree);
		System.out.println("encodeFile():\n" + testString);
		System.out.println("decodeFile():\n" + test.decodeFile(testString, testTree));
		System.out.println("traverseHuffmanTree():\n" + test.traverseHuffmanTree(testTree));

	}

}
