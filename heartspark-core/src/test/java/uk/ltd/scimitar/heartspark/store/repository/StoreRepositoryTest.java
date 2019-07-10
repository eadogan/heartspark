package uk.ltd.scimitar.heartspark.store.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.store.entity.Store;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class StoreRepositoryTest {

    @Autowired
    StoreRepository underTest;

    @Test
    @DisplayName("Find a store by id")
    void shouldFindStoreById() throws Throwable {
        final Store store = underTest.findById(1L)
                .orElseThrow(() -> Assertions.fail("Expected a Store but none found."));
        assertEquals("HeartSpark Store", store.getName());
    }

}
