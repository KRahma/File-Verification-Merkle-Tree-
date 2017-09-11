package merkle.implementation;

import merkle.IMerkleTree;
import merkle.IServer;

import java.util.LinkedList;
import java.util.List;


/**
 * TASK 2
 * TODO: IMPLEMENT generateResponse
 *
 * @author Kazi Rahma
 * @pso 12
 * @loginID krahma
 * @date October 20, 2016
 */
public class Server extends IServer {

    /**
     * Given a node to verify identified by <i>blockToTest</i>
     * which corresponds to the node received by calling <i>merkleTree.getNode(blockToTest)</i>
     * this function generates the path siblings which are required for verification
     * The returned list should contains Nodes in order from node to the root, i.e. bottom up
     */
    public List<IMerkleTree.Node> generateResponse(int blockToTest) {
        List<IMerkleTree.Node> verificationList = new LinkedList<>();
        //TODO:implement
        IMerkleTree.Node[] newtree = this.merkleTree.getTree(); //is it correct? i did this to get the tree to begin with

        int index = blockToTest; //setting the index equal to blocktotest to begin with

        IMerkleTree.Node selected; //creating a node with the selected index

        verificationList.add(newtree[blockToTest]); //adding the node at blocktotest
        //verificationList.add(this.merkleTree.getNode(blockToTest));//tried in a different way

        IMerkleTree.Node sibling; //sibling node
        int siblingindex;
        int parentindex;

        while (index != 1){

            selected = newtree[index]; //make a node with the index first

            if(selected.getType() == IMerkleTree.NodeType.right){ //if the selected node is right child then sibling is left
                sibling = newtree[index-1]; //make the sibling node placed in the previous index of the selected node
                //sibling = this.merkleTree.getNode(index-1); //just tried it in a different way
                siblingindex = index-1; //record this index
            }
            else{
                sibling = newtree[index+1]; //if the selected node is the left child then the sibling is the right child
                siblingindex = index+1;
            }

            verificationList.add(sibling); //add the sibling to the verification list
            parentindex = (int) Math.floor(siblingindex / 2); //get the index of the parent
            index = parentindex; //then start checking with the parent
        }

        return verificationList;
    }
}
