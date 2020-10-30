package com.phonebookservice.model;

/**
 * social profile class.
 *
 * @author Marwa Saleh
 */
public class SocialProfile {
    public enum SocialMediaType {
        FACEBOOK, TWITTER, LINKEDIN, SKYPE, ZOOM;
    }

    private SocialMediaType socialMediaType;
    private String socialProfile;

    /**
     * Initialization of social profile.
     *
     * @param socialMediaType the social media type.
     * @param socialProfile   social profile.
     */
    public SocialProfile(final SocialMediaType socialMediaType,
            final String socialProfile) {
        this.socialMediaType = socialMediaType;
        this.socialProfile = socialProfile;
    }

}
