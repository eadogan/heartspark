package uk.ltd.scimitar.heartspark.store.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.store.entity.PaymentType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PaymentTypeRepositoryTest {

    @Autowired
    PaymentTypeRepository underTest;

    @Test
    @DisplayName("Find all payment types")
    void shouldFindAllPaymentTypes() {
        List<PaymentType> paymentTypes = underTest.findAll();
        assertEquals(2, paymentTypes.size());
    }

}
