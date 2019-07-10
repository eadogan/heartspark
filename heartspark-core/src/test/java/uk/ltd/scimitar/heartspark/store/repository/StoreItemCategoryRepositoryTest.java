package uk.ltd.scimitar.heartspark.store.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.store.entity.StoreItemCategory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class StoreItemCategoryRepositoryTest {

    @Autowired
    StoreItemCategoryRepository underTest;

    @Test
    @DisplayName("Finds all store categories for a store")
    void shouldFindAllStoreCategoriesByStoreId() {
        List<StoreItemCategory> allCategoriesForStore = underTest.findAllByStoreId(1L);
        assertEquals(2, allCategoriesForStore.size());
    }

}
