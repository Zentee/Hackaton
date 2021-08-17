package org.academiadecodigo.hackaton.service;


import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceImpl implements UserService {


    private User user;

    @Autowired
    private TransferImpl transferImpl;

    @Transactional
    @Override
    public void trade(User srcUser, Resource anotherResourceSrc, Resource resourceSrc, User dstUser, Resource resourceDst, Resource anotherResourceDst, Integer amount ) {

        double randomNumberGenerator = Math.random();
        System.out.println(randomNumberGenerator);

        if (randomNumberGenerator >= 0.8) {
            transferImpl.transfer(srcUser, anotherResourceSrc, resourceSrc, dstUser,resourceDst,anotherResourceDst,amount);
            System.out.println("Trade Successfully.");

        } else if (randomNumberGenerator >= 0.7) {
            transferImpl.loseAll(srcUser, anotherResourceDst, amount);
            System.out.println("oh no.. you got mugged.");



        } else if (randomNumberGenerator >= 0.5) {
            transferImpl.transferHaggle(srcUser, anotherResourceSrc, resourceSrc, dstUser,resourceDst,anotherResourceDst,amount);
            System.out.println("You managed to haggle your way into his wares.");


        } else if (randomNumberGenerator >= 0.3) {
            transferImpl.transferAllFromDst(srcUser, anotherResourceSrc, resourceSrc, dstUser,resourceDst,anotherResourceDst,amount);
            System.out.println("You killed the person and stole all his wares.");


        } else if (randomNumberGenerator >= 0.2) {
            System.out.println("You look around but no one seems to show up");


        } else if (randomNumberGenerator < 0.2) {
            System.out.println("You notice someone!!");
            System.err.println("*BOOM*");
            System.out.println("start...\nto...\nfeel..\ncold..\n you remember your parents" +
                    " you..");

            transferImpl.userDies();
            //insert you lose all your resources to dst user
            // delete user from database.
        }


    }


    public void setUser(User user) {
        this.user = user;
    }

    @Autowired
    public void setTransferImpl(TransferImpl transferImpl) {
        this.transferImpl = transferImpl;
    }
}
