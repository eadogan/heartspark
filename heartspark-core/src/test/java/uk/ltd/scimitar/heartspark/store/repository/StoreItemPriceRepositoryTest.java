package uk.ltd.scimitar.heartspark.store.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.store.entity.StoreItemPrice;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class StoreItemPriceRepositoryTest {

    @Autowired
    StoreItemPriceRepository underTest;

    @Test
    @DisplayName("Finds all store item prices by a store item id")
    void shouldFindAllStoreItemPricesByStoreItemId() {
        List<StoreItemPrice> storeItemPrices = underTest.findByStoreItemId(1L);
        assertEquals(1, storeItemPrices.size());
    }

}
