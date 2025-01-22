package com.extra_startup_exercise.service;

import com.extra_startup_exercise.entity.UserAccount;
import com.extra_startup_exercise.repository.UserAccountRepository;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl
        implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    // Create operation
//    @Cacheable
    @Override
    public UserAccount createUserAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    // Load operation
//    @Cacheable
    @Override
    public List<UserAccount> loadUserAccountList() {
        return (List<UserAccount>) userAccountRepository.findAll();
    }

    // Update operation
//    @Cacheable
    @Override
    public UserAccount updateUserAccount(UserAccount detailsToUpdate, Integer userAccountIdInDB) {
        UserAccount userAccountInDB = userAccountRepository.findById(userAccountIdInDB).get();

        if (Objects.nonNull(detailsToUpdate.getFirstName())
                && !"".equalsIgnoreCase(
                detailsToUpdate.getFirstName())) {
            userAccountInDB.setFirstName(
                    detailsToUpdate.getFirstName());
        }

        if (Objects.nonNull(
                detailsToUpdate.getSurename())
                && !"".equalsIgnoreCase(
                detailsToUpdate.getSurename())) {
            userAccountInDB.setSurename(
                    detailsToUpdate.getSurename());
        }

        if (Objects.nonNull(detailsToUpdate.getUserName())
                && !"".equalsIgnoreCase(
                detailsToUpdate.getUserName())) {
            userAccountInDB.setUserName(
                    detailsToUpdate.getUserName());
        }

        if (Objects.nonNull(detailsToUpdate.getPassword())
                && !"".equalsIgnoreCase(
                detailsToUpdate.getPassword())) {
            userAccountInDB.setPassword(
                    detailsToUpdate.getPassword());
        }

//        // Using Lombok:
//        if (Objects.nonNull(detailsToUpdate.getUserAccountFirstName())
//                && !"".equalsIgnoreCase(
//                detailsToUpdate.getUserAccountFirstName())) {
//            userAccountInDB.setUserAccountFirstName(
//                    detailsToUpdate.getUserAccountFirstName());
//        }
//
//        if (Objects.nonNull(
//                detailsToUpdate.getUserAccountSurename())
//                && !"".equalsIgnoreCase(
//                detailsToUpdate.getUserAccountSurename())) {
//            userAccountInDB.setUserAccountSurename(
//                    detailsToUpdate.getUserAccountSurename());
//        }
//
//        if (Objects.nonNull(detailsToUpdate.getUserAccountUserName())
//                && !"".equalsIgnoreCase(
//                detailsToUpdate.getUserAccountUserName())) {
//            userAccountInDB.setUserAccountUserName(
//                    detailsToUpdate.getUserAccountUserName());
//        }
//
//        if (Objects.nonNull(detailsToUpdate.getUserAccountPassword())
//                && !"".equalsIgnoreCase(
//                detailsToUpdate.getUserAccountPassword())) {
//            userAccountInDB.setUserAccountPassword(
//                    detailsToUpdate.getUserAccountPassword());
//        }

        return userAccountRepository.save(userAccountInDB);
    }

    // Delete operation
//    @CacheEvict(key = "#userAccountId")
    @Override
    public String deleteUserAccountById(Integer userAccountId) {
        userAccountRepository.deleteById(userAccountId);
        return "Deleted successfully";
    }
}