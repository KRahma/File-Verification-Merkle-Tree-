package merkle.implementation;

import merkle.hash.HashFunction;

/**
 * TASK 3
 * TODO: IMPLEMENT hash
 *
 * @author Kazi Rahma
 * @pso 12
 * @loginID krahma
 * @date October 20, 2016
 */
public class SumHash implements HashFunction {

    /**
     * This function returns an integer (cast to a string) which is
     * the sum of all the bytes in the <i>input</i> String
     * You can cast bytes to integer using <i>(int)</i>
     * You can cast integers to String using <i>String.valueOf</i>
     */
    @Override
    public String hashBlock(String input) throws Exception {
        //System.out.println("let's try here");
        int hash = 0;
        //TODO:implement

        byte[] array = input.getBytes();

        for(int i = 0; i < array.length; i++){
            hash += (int)array[i];
        }

        return String.valueOf(hash);
    }

    @Override
    public String concatenateHash(MerkleTree.Node leftNode, MerkleTree.Node rightNode) throws Exception {
        return String.valueOf(Integer.parseInt(leftNode.getHash()) + Integer.parseInt(rightNode.getHash()));
    }
}
