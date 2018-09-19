package ch.bbw.manuel.coin;

import java.security.PublicKey;
import java.util.ArrayList;

public class Transaction {

    public String transactionId;//is also hash of the transaction
    public PublicKey sender; // senders address/public Key.
    public PublicKey recipient; // recipients address/public key
    public float value;
    public byte[] signature; // this is to prevent anybody else from speding in our Wallet;

    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    private static int sequence =0; // a rough count of how many tansactions have been generated

    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs){
        this.sender = from;
        this.recipient = from;
        this.value = value;
        this.inputs = inputs;
    }

    //calculates the transaction hash (which will be used as hash)
    private String calculateHash(){
        sequence++;
        return StringUtil.applySha256(StringUtil.getStringFromKey(sender)+StringUtil.getStringFromKey(recipient)+Float.toString(value)+sequence);
    }
}
