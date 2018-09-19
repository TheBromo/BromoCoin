package ch.bbw.manuel.coin;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
    public PrivateKey privateKey;//is used to sign transactions, needs to be kept secret
    public PublicKey publicKey;//Acts as address

    public Wallet(){
        generateKeyPair();
    }

    private void generateKeyPair() {
        try{
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            //init the jey generator and generate pair
            keyGen.initialize(ecSpec,random);//256 provides an acceptable security level
            KeyPair keyPair = keyGen.generateKeyPair();
            //set the private and public key from the pair
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
