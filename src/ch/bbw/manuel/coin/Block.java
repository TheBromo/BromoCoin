package ch.bbw.manuel.coin;

import java.util.Date;

public class Block {

    public String hash, previousHash;
    private String data; //data is a simple message
    private long timestamp;//as number of milliseconds since 1/1/1970.
    private int nonce;

    public Block( String data,String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }


    public String calculateHash() {
        return StringUtil.applySha256(previousHash + Long.toString(timestamp) + Integer.toString(nonce) + data);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');//create string with difficukty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
