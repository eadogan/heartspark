package uk.ltd.scimitar.heartspark.messagestream.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.ltd.scimitar.heartspark.messagestream.entity.Message;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MessageRepositoryTest {

    @Autowired
    MessageRepository underTest;

    @Sql("create_messages.sql")
    @Test
    @DisplayName("Returns the first five messages for a profile.")
    void shouldReturnFirstFiveMessages() {
        final List<Message> messages = underTest.findAllBySender(1L, PageRequest.of(0, 5));
        assertThat(messages.size(), is(5));
    }

}
