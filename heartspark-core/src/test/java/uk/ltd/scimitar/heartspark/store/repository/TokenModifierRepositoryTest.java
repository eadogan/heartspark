package uk.ltd.scimitar.heartspark.store.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.store.entity.TokenModifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TokenModifierRepositoryTest {

    @Autowired
    TokenModifierRepository underTest;

    @Test
    @DisplayName("Find all token modifier types")
    void shouldFindAllTokenModifierTypes() {
        List<TokenModifier> modifiers = underTest.findAll();
        assertEquals(3, modifiers.size());
    }

}
