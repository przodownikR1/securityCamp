package pl.java.scalatech.repo;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestSelectorConfig;
import pl.java.scalatech.domain.Role;
import pl.java.scalatech.repository.RoleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestSelectorConfig.class)
@ActiveProfiles("jpaTest")
@Slf4j
@Transactional
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void shouldRepositoryWork() {
        roleRepository.save(new Role("test","USER"));
        log.info("+++ {}",roleRepository.findAll());
        Assertions.assertThat(roleRepository.count()).isEqualTo(1);
    }

}
