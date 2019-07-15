package uk.ltd.scimitar.heartspark.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ltd.scimitar.heartspark.profile.repository.ProfileRepository;
import uk.ltd.scimitar.heartspark.search.util.Indexer;

import java.io.IOException;
import java.io.Serializable;

@Service
public class ProfileService implements Serializable {

    private ProfileRepository profileRepository;
    private Indexer indexer;

    @Autowired
    public ProfileService(final ProfileRepository profileRepository,
                          final Indexer indexer) {
        this.profileRepository = profileRepository;
        this.indexer = indexer;
    }

    public void rebuildIndex() {
        profileRepository.findAll()
                .parallelStream()
                .forEach(profile -> indexer.index(String.valueOf(profile.getId()), profile));
    }

}
