package uk.ltd.scimitar.heartspark.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ltd.scimitar.heartspark.profile.repository.ProfileRepository;

import java.io.Serializable;

@Service
public class ProfileService implements Serializable {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(final ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

}
