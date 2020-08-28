package com.techcret.tradcret;

import com.techcret.tradcret.model.Admin;
import com.techcret.tradcret.model.Person;
import com.techcret.tradcret.repository.AdminRepository;
import com.techcret.tradcret.repository.PersonRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Data
@Service
@Slf4j
public class Bootstrap implements InitializingBean {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void afterPropertiesSet() {
        if (personRepository.count() == 0) {
            IntStream.rangeClosed(1, 2).forEach(index -> {
                log.info("Creating Person with index => {}", index);
                Person person = new Person();
                person.setFirstName("Person");
                person.setMiddleName("#" + index);
                personRepository.save(person);
            });
        }
        if (adminRepository.count() == 0) {
            IntStream.rangeClosed(1, 2).forEach(index -> {
                log.info("Creating Admin with index => {}", index);
                Admin admin = new Admin();
                admin.setFirstName("Admin");
                admin.setMiddleName("#" + index);
                adminRepository.save(admin);
            });
        }
    }

}
