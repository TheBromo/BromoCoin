package ch.bbw.manuel.coin;

import java.util.Date;

public class Block {

    public String hash, previousHash;
    private String data; //data is a simple message
    private long timestamp;//as number of milliseconds since 1/1/1970.

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }


    public String calculateHash() {
        return StringUtil.applySha256(previousHash + Long.toString(timestamp) + data);
    }
}
